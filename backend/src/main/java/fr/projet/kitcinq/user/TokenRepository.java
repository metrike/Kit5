package fr.projet.kitcinq.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.projet.kitcinq.model.TokenEntity;
@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, Long> {
}
