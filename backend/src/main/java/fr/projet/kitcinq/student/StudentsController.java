package fr.projet.kitcinq.student;

import fr.projet.kitcinq.model.StudentEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentsController {

    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/all-students")
    public List<StudentEntity> getAllStudents() {
        return studentsService.getAllStudents();
    }

}
