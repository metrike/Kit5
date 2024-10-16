package fr.projet.kitcinq.studentcall;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student-call")
public class StudentCallController {

    private final StudentCallService studentCallService;

    public StudentCallController(StudentCallService studentCallService) {
        this.studentCallService = studentCallService;
    }

    // Route pour lancer l'appel d'un cours
    @PostMapping(value = "/launch/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void launchCall(@PathVariable int courseId) {
        System.out.println("Launching call for course " + courseId);
        studentCallService.launch(courseId);
    }

    // Route pour marquer un étudiant comme présent
    @PostMapping(value = "/mark-present/{courseId}/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void markStudentPresent(@PathVariable int courseId, @PathVariable int studentId) {
        System.out.println("Marking student " + studentId + " as present for course " + courseId);
        studentCallService.setStudentPresent(courseId, studentId);
    }

    // Route pour marquer un étudiant comme absent
    @PostMapping(value = "/mark-absent/{courseId}/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void markStudentAbsent(@PathVariable int courseId, @PathVariable int studentId) {
        System.out.println("Marking student " + studentId + " as absent for course " + courseId);
        studentCallService.setStudentAbsent(courseId, studentId);
    }
}
