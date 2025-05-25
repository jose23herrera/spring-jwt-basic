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
}