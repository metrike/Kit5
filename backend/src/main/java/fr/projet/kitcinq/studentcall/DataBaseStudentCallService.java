package fr.projet.kitcinq.studentcall;

import fr.projet.kitcinq.course.CourseRepository;
import org.springframework.transaction.annotation.Transactional;

public class DataBaseStudentCallService implements StudentCallService {
    
    private final CourseRepository courseRepository;

    public DataBaseStudentCallService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public void launch(int courseId) {
        
    }

    @Override
    public void setStudentPresent(int courseId, int studentId) {

    }

    @Override
    public void setStudentAbsent(int courseId, int studentId) {

    }
}
