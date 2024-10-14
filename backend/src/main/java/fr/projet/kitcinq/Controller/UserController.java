package fr.projet.kitcinq.Controller;

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User register(User user) {
        return userRepository.save(user);
    }
}
