package fr.projet.kitcinq.user;

import java.time.LocalDateTime;
import java.util.List;

public interface UserService {

    record CreateUserResult(Long id, String username, LocalDateTime createdAt) {}

    CreateUserResult create(String username, String password, LocalDateTime createdAt);

    record GetAllUserResult(Long id, String username, LocalDateTime createdAt) {}

    List<GetAllUserResult> getAll();

    boolean connect(String username, String password);
}
