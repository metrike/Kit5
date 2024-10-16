package fr.projet.kitcinq;

import fr.projet.kitcinq.studentcall.StudentCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentCallTestRunner implements CommandLineRunner {

    @Autowired
    private StudentCallService studentCallService;

    @Override
    public void run(String... args) throws Exception {
        // Test lancement de l'appel pour un cours
        int courseId = 1; // Remplacez par l'ID réel du cours que vous souhaitez tester
        studentCallService.launch(courseId);

        // Test marquer un étudiant comme présent
        int studentId = 1; // Remplacez par l'ID réel de l'étudiant
        studentCallService.setStudentPresent(courseId, studentId);

        // Test marquer un étudiant comme absent
        int anotherStudentId = 2; // Remplacez par un autre ID d'étudiant
        studentCallService.setStudentAbsent(courseId, anotherStudentId);
    }
}
