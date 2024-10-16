package fr.projet.kitcinq.student;

import fr.projet.kitcinq.model.StudentEntity;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
