package fr.projet.kitcinq.admin;

import fr.projet.kitcinq.user.UserController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/admin")
public class AdminController {

    public final AdminService userAdminService;

    public AdminController(AdminService userAdminService) {
        this.userAdminService = userAdminService;
    }

    public record addStudentCourse(Long studentId, Long courseId) {}

    @PostMapping(value = "/professor-course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addProfessorCourse() {
        userAdminService.addProfessorCourse(1L, 1L);
    }

    @PostMapping(value = "/student-course/{studentId}/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addStudentCourse( @PathVariable long studentId, @PathVariable long  courseId) {
//        System.out.println("addStudentCourse" + addStudentCourse);
        userAdminService.addStudentCourse(studentId, courseId);
    }
}
