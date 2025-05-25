package sv.edu.udb.springjwtbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<MateriaDto> createMateria(@RequestBody MateriaDto materiaDto) {
        Materia materia = new Materia();
        materia.setNombre(materiaDto.getNombre());

        Materia savedMateria = materiaRepository.save(materia);

        MateriaDto responseDto = new MateriaDto();
        responseDto.setId(savedMateria.getId());
        responseDto.setNombre(savedMateria.getNombre());

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
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
}