package fr.projet.kitcinq.studentcall;

import fr.projet.kitcinq.model.StudentCourseEntity;
import fr.projet.kitcinq.model.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentCourseRepository extends JpaRepository<StudentCourseEntity, StudentCourseId> {

    // Méthodes pour trouver un StudentCourse par son ID composite
    Optional<StudentCourseEntity> findById(StudentCourseId id);
}
