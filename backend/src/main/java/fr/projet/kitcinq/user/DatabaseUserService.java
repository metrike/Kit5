package fr.projet.kitcinq.user;

import fr.projet.kitcinq.model.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DatabaseUserService implements UserService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DatabaseUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public CreateUserResult create(String username, String password, LocalDateTime localDateTime) {
        var user = new UserEntity();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setCreatedAt(localDateTime);
        
        userRepository.save(user);
        
        return new CreateUserResult(user.getId(), user.getUsername(), user.getCreatedAt());
    }

    @Override
    public List<GetAllUserResult> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> new GetAllUserResult(user.getId(), user.getUsername(), user.getCreatedAt()))
                .toList();
    }
}
