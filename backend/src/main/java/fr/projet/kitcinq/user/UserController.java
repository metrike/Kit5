package fr.projet.kitcinq.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public record CreateUserRequestBody(String username, String password) {}
    public record CreateUserResponseBody(Long id, String username, LocalDateTime createdAt) {}

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public CreateUserResponseBody create(@RequestBody CreateUserRequestBody body) {
        var result = userService.create(body.username(), body.password(), LocalDateTime.now());
        return new CreateUserResponseBody(result.id(), result.username(), result.createdAt());
    }

    public record GetAllUserResponse(Long id, String username, LocalDateTime createdAt) {}

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<GetAllUserResponse> getAll() {
        return userService
                .getAll()
                .stream()
                .map(user -> new GetAllUserResponse(user.id(), user.username(), user.createdAt()))
                .toList();
    }
}
