package fr.projet.kitcinq.admin;

import fr.projet.kitcinq.admin.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class UserAdminController {

    public final AdminService userAdminService;

    public UserAdminController(AdminService userAdminService) {
        this.userAdminService = userAdminService;
    }
    @RequestMapping(value = "/addProfCourse", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addProfessorCourse() {
        System.out.println("addProfessorCourse");
        userAdminService.addProfessorCourse(Long.parseLong("1"), Long.parseLong("3"));
    }

    @RequestMapping(value = "/addStudentCourse", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudentCourse() {
        System.out.println("studentCourse");
        userAdminService.addStudentCourse(Long.parseLong("4"), Long.parseLong("1"));
    }


}
