package fr.projet.kitcinq.studentcall;

import fr.projet.kitcinq.model.StudentCourseEntity;
import fr.projet.kitcinq.model.StudentCourseId;
import fr.projet.kitcinq.model.StudentEntity;
import fr.projet.kitcinq.model.CourseEntity;
import fr.projet.kitcinq.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataBaseStudentCallService implements StudentCallService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Méthode pour marquer la présence d'un étudiant
    @Override
    public void setStudentPresent(int courseId, int studentId) {
        StudentCourseId id = new StudentCourseId((long) studentId, (long) courseId);
        Optional<StudentCourseEntity> studentCourseOpt = studentCourseRepository.findById(id);
        if (studentCourseOpt.isPresent()) {
            StudentCourseEntity studentCourse = studentCourseOpt.get();
            studentCourse.setPresence(true);  // Marque comme présent
            studentCourseRepository.save(studentCourse);
        }
    }

    // Méthode pour marquer l'absence d'un étudiant
    @Override
    public void setStudentAbsent(int courseId, int studentId) {
        StudentCourseId id = new StudentCourseId((long) studentId, (long) courseId);
        Optional<StudentCourseEntity> studentCourseOpt = studentCourseRepository.findById(id);
        if (studentCourseOpt.isPresent()) {
            StudentCourseEntity studentCourse = studentCourseOpt.get();
            studentCourse.setPresence(false);  // Marque comme absent
            studentCourseRepository.save(studentCourse);
        }
    }

    // Implémentation de la méthode launch pour lancer l'appel d'un cours
    @Override
    public void launch(int courseId) {
        // Vous pouvez récupérer le cours par son ID
        Optional<CourseEntity> courseOpt = courseRepository.findById((long) courseId);
        if (courseOpt.isPresent()) {
            CourseEntity course = courseOpt.get();

            // Récupère la liste des étudiants inscrits à ce cours
            List<StudentCourseEntity> studentsInCourse = course.getStudents().stream().toList();

            // Vous pouvez marquer que l'appel de présence est en cours
            course.setCallPresence(true);
            courseRepository.save(course);

            // Logique supplémentaire si nécessaire (ex. envoyer des notifications)
            System.out.println("Appel lancé pour le cours: " + course.getName());
            System.out.println("Étudiants inscrits: ");
            studentsInCourse.forEach(sc -> System.out.println(sc.getStudent().getFirstName() + " " + sc.getStudent().getLastName()));
        } else {
            System.out.println("Le cours avec l'ID " + courseId + " n'existe pas.");
        }
    }
}
