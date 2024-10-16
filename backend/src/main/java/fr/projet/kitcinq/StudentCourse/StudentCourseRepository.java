package fr.projet.kitcinq.StudentCourse;

import fr.projet.kitcinq.model.StudentCourseEntity;
import fr.projet.kitcinq.model.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourseEntity, Long> {
//    Optional<Object> findyByStudentIdAndCourseId(Long studentId, Long courseId);
    StudentCourseEntity findById (StudentCourseId id);

    Optional<StudentCourseEntity> findByIdStudentIdAndIdCourseId(Long studentId, Long courseId);

//    ScopedValue<Object> findById(StudentCourseId id);

//    ScopedValue<Object> findById(StudentCourseId id);
}
