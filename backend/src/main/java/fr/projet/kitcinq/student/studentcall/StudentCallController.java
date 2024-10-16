package fr.projet.kitcinq.student.studentcall;

import ch.qos.logback.core.net.SyslogOutputStream;
import fr.projet.kitcinq.student.studentcall.StudentCallService;
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

    @PostMapping(value = "/launch/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void launchCall(@PathVariable long courseId) {
        studentCallService.launch(courseId);
    }

    @PostMapping(value = "/mark-present/{courseId}/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void markStudentPresent(@PathVariable long courseId, @PathVariable long studentId) {
        studentCallService.setStudentPresent(courseId, studentId);
    }

    @PostMapping(value = "/mark-absent/{courseId}/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void markStudentAbsent(@PathVariable long courseId, @PathVariable long studentId) {
        studentCallService.setStudentAbsent(courseId, studentId);
    }
}
