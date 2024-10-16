package fr.projet.kitcinq.user;

import org.springframework.beans.factory.annotation.Autowired;
import fr.projet.kitcinq.model.TokenEntity;
import fr.projet.kitcinq.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    private final TokenRepository tokenRepository;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
    }
    
    public record CreateUserRequestBody(String label, String password) {}
    
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
        UserEntity user = userRepository.findByLabel(body.label());
        if (user != null && passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = jwtTokenUtil.generateToken(user.getLabel());
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUser(user);
            tokenEntity.setCreatedAt(LocalDateTime.now());
            tokenEntity.setToken(token);
            tokenRepository.save(tokenEntity);

            DataTransfertObject tokenResponse = new DataTransfertObject(token,"role");
            return ResponseEntity.status(HttpStatus.OK).body(tokenResponse);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

}
