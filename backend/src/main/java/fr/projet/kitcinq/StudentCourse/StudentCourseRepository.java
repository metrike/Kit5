package fr.projet.kitcinq.StudentCourse;

import fr.projet.kitcinq.model.StudentCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourseEntity, Long> {
//    Optional<Object> findyByStudentIdAndCourseId(Long studentId, Long courseId);

    Optional<StudentCourseEntity> findByIdStudentIdAndIdCourseId(Long studentId, Long courseId);
}
