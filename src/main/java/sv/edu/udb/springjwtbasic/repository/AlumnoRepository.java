package sv.edu.udb.springjwtbasic.repository;

import sv.edu.udb.springjwtbasic.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    List<Alumno> findByUserIdUser(Integer idUser); // Busca alumnos por ID de usuario
}