package fr.projet.kitcinq.user;

import fr.projet.kitcinq.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    
    public static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    public record CreateUserRequestBody(String username, String password) {}

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody CreateUserRequestBody body) {
        var user = new UserEntity();
        user.setUsername(body.username());
        user.setPassword(passwordEncoder.encode(body.password()));
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);
    }
    
    public record GetAllUserResponse(Long id) {}
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GetAllUserResponse> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> new GetAllUserResponse(user.getId()))
                .toList();
    }

//    @PostMapping(value = "/connect", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.CREATED)
//    @Transactional
//    public ResponseEntity<?> connect(@RequestBody CreateUserRequestBody body) {
//        JwtService jwtTokenUtil = new JwtService();
//        // Find user by username
//        UserEntity user = userRepository.findByLabel(body.username());
//
//        // Check if user exists and password is correct
//        System.out.println(user.getPassword());
//
//        if (user != null && passwordEncoder.matches(body.password(), user.getPassword())) {
//            // Generate JWT token if authentication is successful
//            String token = jwtTokenUtil.generateToken(user.getUsername());
//            user.setToken(token);
//            userRepository.save(user);
//            return ResponseEntity.ok(token);
//        }
//
//        // Return unauthorized status if credentials are invalid
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//    }
}
