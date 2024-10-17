package fr.projet.kitcinq.admin;

import fr.projet.kitcinq.model.AdminEntity;
import fr.projet.kitcinq.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<AdminEntity, Long> {
    
    boolean existsByUserId(Long userId);
}
