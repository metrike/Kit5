package fr.projet.kitcinq.formation;

import fr.projet.kitcinq.model.FormationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FormationRepository extends CrudRepository<FormationEntity, Long> {
}
