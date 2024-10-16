package fr.projet.kitcinq.formation;

import fr.projet.kitcinq.model.FormationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<FormationEntity, Long> {
}
