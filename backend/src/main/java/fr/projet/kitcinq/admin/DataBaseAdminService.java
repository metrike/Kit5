package fr.projet.kitcinq.admin;

import fr.projet.kitcinq.student.call.StudentCourseRepository;
import fr.projet.kitcinq.course.CourseRepository;
import fr.projet.kitcinq.model.*;
import fr.projet.kitcinq.professor.ProfessorRepository;
import fr.projet.kitcinq.student.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataBaseAdminService implements AdminService {

    private final ProfessorRepository professorRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;
    private final AdminRepository adminRepository;

    public DataBaseAdminService(ProfessorRepository professorRepository, CourseRepository courseRepository, StudentRepository studentRepository, StudentCourseRepository studentCourseRepository, AdminRepository adminRepository) {
        this.professorRepository = professorRepository;
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.studentCourseRepository = studentCourseRepository;
        this.adminRepository = adminRepository;
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
        // Créer l'ID composé
        StudentCourseId studentCourseId = new StudentCourseId(studentId, courseId);

        // Vérification si l'étudiant est déjà inscrit au cours
        studentCourseRepository.findById(studentCourseId).ifPresentOrElse(
                // Si l'étudiant est déjà inscrit, pas besoin de faire d'autre action
                studentCourse -> {
                    System.out.println("Student is already registered to the course");
                    // Peut-être mettre à jour la présence ou d'autres informations si nécessaire
                    studentCourseRepository.save(studentCourse);
                },
                // Si l'étudiant n'est pas encore inscrit, on crée une nouvelle association
                () -> {
                    System.out.println("Student is not yet registered to the course");

                    // Récupérer l'étudiant et le cours depuis leurs repositories
                    StudentEntity student = studentRepository.findById(studentId)
                            .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + studentId));
                    CourseEntity course = courseRepository.findById(courseId)
                            .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + courseId));

                    // Créer une nouvelle entité StudentCourseEntity
                    StudentCourseEntity newStudentCourse = new StudentCourseEntity();
                    newStudentCourse.setId(studentCourseId);
                    newStudentCourse.setStudent(student);
                    newStudentCourse.setCourse(course);
                    newStudentCourse.setPresence(false); // Initialiser la présence

                    // Sauvegarder la nouvelle relation dans la base de données
                    studentCourseRepository.save(newStudentCourse);
                }
        );
    }

    @Transactional
    public CreateAdminResult create(long userId) {
        AdminEntity adminEntity = new AdminEntity();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        adminEntity.setUser(userEntity);

        adminRepository.save(adminEntity);
        return new CreateAdminResult(adminEntity.getAdminId(), userId);
    }
}
