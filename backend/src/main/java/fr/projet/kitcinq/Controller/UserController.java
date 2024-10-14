package fr.projet.kitcinq.Controller;

import fr.projet.kitcinq.models.User;
import fr.projet.kitcinq.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User register(User user) {
        return userRepository.save(user);
    }
}
