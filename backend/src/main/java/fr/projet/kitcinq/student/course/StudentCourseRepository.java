package fr.projet.kitcinq.student.course;

import fr.projet.kitcinq.model.StudentCourseEntity;
import fr.projet.kitcinq.model.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourseEntity, StudentCourseId> {
    Optional<StudentCourseEntity> findById(StudentCourseId id);
}