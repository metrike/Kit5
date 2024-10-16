package fr.projet.kitcinq.student.studentcall;

import fr.projet.kitcinq.StudentCourse.StudentCourseRepository;
import fr.projet.kitcinq.course.CourseRepository;
import fr.projet.kitcinq.model.CourseEntity;
import fr.projet.kitcinq.model.StudentCourseEntity;
import fr.projet.kitcinq.model.StudentCourseId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataBaseStudentCallService implements StudentCallService {

    private final CourseRepository courseRepository;

    private final StudentCourseRepository studentCourseRepository;

    public DataBaseStudentCallService(StudentCourseRepository studentCourseRepository, CourseRepository courseRepository) {
        this.studentCourseRepository = studentCourseRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public void setStudentPresent(long courseId, long studentId) {
        StudentCourseId id = new StudentCourseId(studentId, courseId);
        StudentCourseEntity studentCourse = studentCourseRepository.findById(id);
        studentCourse.setPresence(true);
        studentCourseRepository.save(studentCourse);
    }

    @Override
    @Transactional
    public void setStudentAbsent(long courseId, long studentId) {
        StudentCourseId id = new StudentCourseId(studentId, courseId);
        StudentCourseEntity studentCourse = studentCourseRepository.findById(id);
        studentCourse.setPresence(false);
        studentCourseRepository.save(studentCourse);
    }

    @Override
    @Transactional
    public void launch(long courseId) {
        CourseEntity course = courseRepository.findById(courseId).orElseThrow();
        course.setCallPresence(true);
        courseRepository.save(course);
    }
}
