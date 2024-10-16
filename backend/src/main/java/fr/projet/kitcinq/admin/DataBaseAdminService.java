package fr.projet.kitcinq.admin;

import fr.projet.kitcinq.StudentCourse.StudentCourseRepository;
import fr.projet.kitcinq.course.CourseRepository;
import fr.projet.kitcinq.model.CourseEntity;
import fr.projet.kitcinq.model.StudentCourseEntity;
import fr.projet.kitcinq.model.StudentCourseId;
import fr.projet.kitcinq.model.StudentEntity;
import fr.projet.kitcinq.professor.ProfessorRepository;
import fr.projet.kitcinq.student.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class DataBaseAdminService implements AdminService {

    private final ProfessorRepository professorRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;

    public DataBaseAdminService(ProfessorRepository professorRepository, CourseRepository courseRepository, StudentRepository studentRepository, StudentCourseRepository studentCourseRepository) {
        this.professorRepository = professorRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
    }

    @Override
    public void addProfessorCourse(Long professorId, Long courseId) {
        professorRepository.findById(professorId).ifPresent(professor -> {
            courseRepository.findById(courseId).ifPresent(course -> {
                professor.getCourses().add(course);
                professorRepository.save(professor);
            });
        });
    }

    @Override
    public void addStudentCourse(Long studentId, Long courseId) {
        // Vérification si l'étudiant est déjà inscrit au cours
        studentCourseRepository.findByIdStudentIdAndIdCourseId(studentId, courseId).ifPresentOrElse(
                // Si l'étudiant est déjà inscrit, pas besoin de faire d'autre action
                studentCourse-> {
                    System.out.println("Student is already registered to the course");

                    // Peut-être mettre à jour la présence ou d'autres informations si nécessaire
                    studentCourseRepository.save(studentCourse);
                },
                // Si l'étudiant n'est pas encore inscrit, on crée une nouvelle association
                () -> {
                    System.out.println("Student is already registered to the course");

                    // Récupérer l'étudiant et le cours depuis leurs repositories
                    StudentEntity student = studentRepository.findById(Long.parseLong("4"))
                            .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + studentId));
                    CourseEntity course = courseRepository.findById(Long.parseLong("1"))
                            .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + courseId));

                    // Créer une nouvelle entité StudentCourseEntity
                    StudentCourseEntity newStudentCourse = new StudentCourseEntity();
                    StudentCourseId studentCourseId = new StudentCourseId(studentId, courseId);

                    newStudentCourse.setId(studentCourseId);
                    newStudentCourse.setStudent(student);
                    newStudentCourse.setCourse(course);
                    newStudentCourse.setPresence(false); // Initialiser la présence

                    // Sauvegarder la nouvelle relation dans la base de données
                    studentCourseRepository.save(newStudentCourse);
                }
        );
    }
}
