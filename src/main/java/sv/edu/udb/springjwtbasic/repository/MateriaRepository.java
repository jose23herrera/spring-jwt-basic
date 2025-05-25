package sv.edu.udb.springjwtbasic.repository;

import sv.edu.udb.springjwtbasic.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {
}