package sv.edu.udb.springjwtbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.springjwtbasic.dto.MateriaDto;
import sv.edu.udb.springjwtbasic.model.Materia;
import sv.edu.udb.springjwtbasic.repository.MateriaRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    private MateriaRepository materiaRepository;

    // CREAR materia
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<MateriaDto> createMateria(@RequestBody MateriaDto materiaDto) {
        Materia materia = new Materia();
        materia.setNombre(materiaDto.getNombre());

        Materia savedMateria = materiaRepository.save(materia);

        MateriaDto responseDto = new MateriaDto();
        responseDto.setId(savedMateria.getId());
        responseDto.setNombre(savedMateria.getNombre());

        return ResponseEntity.ok(responseDto);
    }

    // LISTAR todas las materias
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<MateriaDto>> getAllMaterias() {
        List<Materia> materias = materiaRepository.findAll();
        List<MateriaDto> dtos = materias.stream().map(m -> {
            MateriaDto dto = new MateriaDto();
            dto.setId(m.getId());
            dto.setNombre(m.getNombre());
            return dto;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(dtos);
    }

    // ACTUALIZAR materia por ID
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<MateriaDto> updateMateria(@PathVariable Integer id, @RequestBody MateriaDto materiaDto) {
        Materia materia = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        materia.setNombre(materiaDto.getNombre());
        Materia updated = materiaRepository.save(materia);

        MateriaDto dto = new MateriaDto();
        dto.setId(updated.getId());
        dto.setNombre(updated.getNombre());

        return ResponseEntity.ok(dto);
    }

    // ELIMINAR materia por ID
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Void> deleteMateria(@PathVariable Integer id) {
        if (!materiaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        materiaRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
