package fr.projet.kitcinq.student;

import fr.projet.kitcinq.model.StudentEntity;
import fr.projet.kitcinq.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    boolean existsByUserId(Long userId);
}
