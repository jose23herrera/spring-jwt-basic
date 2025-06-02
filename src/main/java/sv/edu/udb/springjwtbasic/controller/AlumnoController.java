package sv.edu.udb.springjwtbasic.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.springjwtbasic.dto.AlumnoDto;
import sv.edu.udb.springjwtbasic.model.Alumno;
import sv.edu.udb.springjwtbasic.repository.AlumnoRepository;
import sv.edu.udb.springjwtbasic.repository.MateriaRepository;
import sv.edu.udb.springjwtbasic.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoRepository alumnoRepository;
    private final MateriaRepository materiaRepository;
    private final UserRepository userRepository;

    // CREAR alumno
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Alumno> createAlumno(@RequestBody AlumnoDto alumnoDto) {
        Alumno alumno = new Alumno();
        alumno.setNombre(alumnoDto.getNombre());
        alumno.setApellido(alumnoDto.getApellido());
        alumno.setMateria(materiaRepository.findById(alumnoDto.getIdMateria()).orElse(null));
        alumno.setUser(userRepository.findById(alumnoDto.getIdUser()).orElseThrow());

        return ResponseEntity.ok(alumnoRepository.save(alumno));
    }

    // LISTAR alumnos por ID de usuario
    @GetMapping("/user/{idUser}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<AlumnoDto>> getAlumnosByUser(@PathVariable Integer idUser) {
        List<Alumno> alumnos = alumnoRepository.findByUserIdUser(idUser);

        List<AlumnoDto> dtos = alumnos.stream().map(alumno -> {
            AlumnoDto dto = new AlumnoDto();
            dto.setId(alumno.getId());
            dto.setNombre(alumno.getNombre());
            dto.setApellido(alumno.getApellido());
            dto.setIdMateria(alumno.getMateria() != null ? alumno.getMateria().getId() : null);
            dto.setNombreMateria(alumno.getMateria() != null ? alumno.getMateria().getNombre() : null);
            dto.setIdUser(alumno.getUser().getIdUser());
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    // LISTAR todos los alumnos
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<AlumnoDto>> getAllAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();

        List<AlumnoDto> dtos = alumnos.stream().map(alumno -> {
            AlumnoDto dto = new AlumnoDto();
            dto.setId(alumno.getId());
            dto.setNombre(alumno.getNombre());
            dto.setApellido(alumno.getApellido());
            dto.setIdMateria(alumno.getMateria() != null ? alumno.getMateria().getId() : null);
            dto.setNombreMateria(alumno.getMateria() != null ? alumno.getMateria().getNombre() : null);
            dto.setIdUser(alumno.getUser().getIdUser());
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    // ACTUALIZAR alumno por ID
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<AlumnoDto> updateAlumno(@PathVariable Integer id, @RequestBody AlumnoDto alumnoDto) {
        Alumno alumno = alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        alumno.setNombre(alumnoDto.getNombre());
        alumno.setApellido(alumnoDto.getApellido());

        if (alumnoDto.getIdMateria() != null) {
            alumno.setMateria(materiaRepository.findById(alumnoDto.getIdMateria()).orElse(null));
        }

        Alumno actualizado = alumnoRepository.save(alumno);

        AlumnoDto dto = new AlumnoDto();
        dto.setId(actualizado.getId());
        dto.setNombre(actualizado.getNombre());
        dto.setApellido(actualizado.getApellido());
        dto.setIdMateria(actualizado.getMateria() != null ? actualizado.getMateria().getId() : null);
        dto.setNombreMateria(actualizado.getMateria() != null ? actualizado.getMateria().getNombre() : null);
        dto.setIdUser(actualizado.getUser().getIdUser());

        return ResponseEntity.ok(dto);
    }

    // ELIMINAR alumno por ID
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Void> deleteAlumno(@PathVariable Integer id) {
        if (!alumnoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        alumnoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
