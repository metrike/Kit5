package fr.projet.kitcinq.controllers;

import fr.projet.kitcinq.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    
    public static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public record GetAllUserResponse(Long id) {}
    
    @GetMapping(value = "/", produces = "application/json")
    public List<GetAllUserResponse> getAll() {
        return userRepository
                .findAll()
                .stream()
                .map(user -> new GetAllUserResponse(user.getId()))
                .toList();
    }

}
