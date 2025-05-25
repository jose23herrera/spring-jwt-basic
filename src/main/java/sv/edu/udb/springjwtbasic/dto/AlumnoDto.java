package sv.edu.udb.springjwtbasic.dto;

import lombok.Data;

@Data
public class AlumnoDto {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer idMateria;
    private String nombreMateria; // Opcional: para mostrar en respuestas
    private Integer idUser;
}