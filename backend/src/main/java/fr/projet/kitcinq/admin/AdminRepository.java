package fr.projet.kitcinq.admin;

import fr.projet.kitcinq.model.AdminEntity;
import fr.projet.kitcinq.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
    
    boolean existsByUserId(Long userId);
}
