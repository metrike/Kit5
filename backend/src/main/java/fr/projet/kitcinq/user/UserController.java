package fr.projet.kitcinq.user;

import fr.projet.kitcinq.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public record CreateUserRequestBody(String label, String password) {}

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void create(@RequestBody CreateUserRequestBody body) {
        var user = new UserEntity();
        user.setLabel(body.label());
        user.setPassword(body.password());
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

    @PostMapping(value = "/connect", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public ResponseEntity<?> connect(@RequestBody CreateUserRequestBody body) {
        JwtService jwtTokenUtil = new JwtService();
        // Find user by label
        UserEntity user = userRepository.findByLabel(body.label());

        if (user != null && user.getPassword().trim().equals(body.password().trim())) {
            // Generate JWT token if authentication is successful
            String token = jwtTokenUtil.generateToken(user.getLabel());
            user.setToken(token);
            userRepository.save(user);
            return ResponseEntity.ok(token);
        }

        // Return unauthorized status if credentials are invalid
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}
