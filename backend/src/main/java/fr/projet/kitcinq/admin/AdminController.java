package fr.projet.kitcinq.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    public final AdminService userAdminService;

    public AdminController(AdminService userAdminService) {
        this.userAdminService = userAdminService;
    }

    @PostMapping(value = "/professor-course", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addProfessorCourse() {
        userAdminService.addProfessorCourse(1L, 1L);
    }

    @PostMapping(value = "/student-course", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void addStudentCourse() {
        userAdminService.addStudentCourse(1L, 1L);
    }
}
