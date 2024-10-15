package fr.projet.kitcinq.Controller;

import fr.projet.kitcinq.models.User;
import fr.projet.kitcinq.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/getAll.json", produces = "application/json")
    public List<User> getAll() {
        return userRepository.findAll();

    }

}
