package fr.projet.kitcinq.user;

import java.time.LocalDateTime;

public interface UserService {
    
    record CreateUserResult(Long id, String username, LocalDateTime localDateTime) {}

    CreateUserResult create(String username, String password, LocalDateTime localDateTime);
}
