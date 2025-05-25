package sv.edu.udb.springjwtbasic.dto;

import lombok.Data;

@Data
public class MateriaDto {
    private Integer id;
    private String nombre;

    // Constructor opcional si necesitas mapear desde la entidad
    public MateriaDto() {}
}