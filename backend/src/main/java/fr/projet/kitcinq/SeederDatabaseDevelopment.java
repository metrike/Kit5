package fr.projet.kitcinq;

import fr.projet.kitcinq.admin.AdminService;
import fr.projet.kitcinq.course.Course;
import fr.projet.kitcinq.course.CourseService;
import fr.projet.kitcinq.formation.FormationRepository;
import fr.projet.kitcinq.model.FormationEntity;
import fr.projet.kitcinq.model.SubjectEntity;
import fr.projet.kitcinq.professor.ProfessorService;
import fr.projet.kitcinq.student.StudentService;
import fr.projet.kitcinq.student.course.StudentCourseService;
import fr.projet.kitcinq.subject.SubjectRepository;
import fr.projet.kitcinq.user.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;

@Component
public class SeederDatabaseDevelopment implements ApplicationListener<ApplicationReadyEvent> {
    
    private final Environment environment;
    private final FormationRepository formationRepository;
    private final SubjectRepository subjectRepository;
    private final CourseService courseService;
    private final UserService userService;
    private final AdminService adminService;
    private final StudentService studentService;
    private final ProfessorService professorService;
    private final StudentCourseService studentCourseService;

    public SeederDatabaseDevelopment(Environment environment, FormationRepository formationRepository, SubjectRepository subjectRepository, CourseService courseService, UserService userService, AdminService adminService, StudentService studentService, ProfessorService professorService, StudentCourseService studentCourseService) {
        this.environment = environment;
        this.formationRepository = formationRepository;
        this.subjectRepository = subjectRepository;
        this.courseService = courseService;
        this.userService = userService;
        this.adminService = adminService;
        this.studentService = studentService;
        this.professorService = professorService;
        this.studentCourseService = studentCourseService;
    }

    private SubjectEntity pushSubject(String name) {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setName(name);
        subjectRepository.save(subjectEntity);
        return subjectEntity;
    }
    
    private FormationEntity pushFormation(String name) {
        FormationEntity formationEntity = new FormationEntity();
        formationEntity.setName(name);
        formationRepository.save(formationEntity);
        return formationEntity;
    }
    
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (! Set.of(environment.getActiveProfiles()).contains("dev")) {
            return;
        }
        System.out.println("SeederDatabaseDevelopment.onApplicationEvent");
        
        FormationEntity formation1 = pushFormation("Informatique");
        FormationEntity formation2 = pushFormation("Mathématiques");
        FormationEntity formation3 = pushFormation("Physique");

        SubjectEntity subject1 = pushSubject("Algorithmique");
        SubjectEntity subject2 = pushSubject("Programmation");
        SubjectEntity subject3 = pushSubject("Analyse");

        Course course1 = courseService.create("Cours 1", LocalDateTime.now(), 1, 1);
        Course course2 = courseService.create("Cours 2", LocalDateTime.now().minusDays(1), 2, 2);
        Course course3 = courseService.create("Cours 3", LocalDateTime.now().plusDays(1), 3, 3);
        Course course4 = courseService.create("Cours 4", LocalDateTime.now().plusDays(2), 1, 2);
        Course course5 = courseService.create("Cours 5", LocalDateTime.now().plusDays(3), 2, 3);

        UserService.CreateUserResult user1 = userService.create("livio", "livio", LocalDateTime.now());
        UserService.CreateUserResult user2 =userService.create("kevin", "kevin", LocalDateTime.now());
        UserService.CreateUserResult user3 =userService.create("antho", "antho", LocalDateTime.now());
        UserService.CreateUserResult user4 =userService.create("yass", "yass", LocalDateTime.now());
        UserService.CreateUserResult user5 = userService.create("abou", "abou", LocalDateTime.now());

        adminService.create(user1.id());

        professorService.create(user2.id(), "kevin", "metri");

        StudentService.CreateStudentResult student1 = studentService.create(user3.id(),"antho", "lala");
        StudentService.CreateStudentResult student2 = studentService.create(user4.id(),"yass", "haff");
        StudentService.CreateStudentResult student3 = studentService.create(user5.id(),"abou", "abou");

        studentCourseService.create(student1.id(), course1.id());
        studentCourseService.create(student2.id(), course1.id());
        studentCourseService.create(student3.id(), course1.id());
    }
}
