package fr.projet.kitcinq.student.course;

import fr.projet.kitcinq.model.CourseEntity;
import fr.projet.kitcinq.model.StudentCourseEntity;
import fr.projet.kitcinq.model.StudentCourseId;
import fr.projet.kitcinq.model.StudentEntity;
import fr.projet.kitcinq.student.StudentRepository;
import fr.projet.kitcinq.course.CourseRepository;
import fr.projet.kitcinq.student.call.StudentCourseRepository;
import org.springframework.stereotype.Service;

@Service
public class DataBaseStudentCourseService implements StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public DataBaseStudentCourseService(StudentCourseRepository studentCourseRepository,
                                        StudentRepository studentRepository,
                                        CourseRepository courseRepository) {
        this.studentCourseRepository = studentCourseRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public StudentCourseService.CreateStudentCourseResut create(long studentId, long courseId) {
        // Récupérer l'entité StudentEntity
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        // Récupérer l'entité CourseEntity
        CourseEntity course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        // Créer une instance de StudentCourseId pour la clé composite
        StudentCourseId studentCourseId = new StudentCourseId(student.getStudentId(), course.getCourseId());

        // Créer l'entité StudentCourseEntity
        StudentCourseEntity studentCourseEntity = new StudentCourseEntity();
        studentCourseEntity.setId(studentCourseId);  // Assigner la clé composite
        studentCourseEntity.setStudent(student);  // Associer l'étudiant
        studentCourseEntity.setCourse(course);    // Associer le cours

        // Sauvegarder l'association dans la base de données
        studentCourseRepository.save(studentCourseEntity);

        // Retourner le résultat
        return new StudentCourseService.CreateStudentCourseResut(studentCourseId.getCourseId(), studentCourseId.getStudentId());
    }
}
