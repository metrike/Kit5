package fr.projet.kitcinq.student.call;

import fr.projet.kitcinq.model.StudentCourseEntity;
import fr.projet.kitcinq.model.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentCourseRepository extends CrudRepository<StudentCourseEntity, StudentCourseId> {

    // Méthodes pour trouver un StudentCourse par son ID composite
    Optional<StudentCourseEntity> findById(StudentCourseId id);
}
