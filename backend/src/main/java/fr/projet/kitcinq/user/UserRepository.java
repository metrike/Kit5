package fr.projet.kitcinq.user;

import fr.projet.kitcinq.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByLabel(String label);  // Correction de findyByLabel en findByLabel
    String findByPassword(String password);  // Correction de findyByPassword en findByPassword
}
