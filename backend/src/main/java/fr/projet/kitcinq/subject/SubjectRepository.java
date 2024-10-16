package fr.projet.kitcinq.subject;

import fr.projet.kitcinq.model.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
