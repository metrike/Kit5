package fr.projet.kitcinq.subject;

import fr.projet.kitcinq.model.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<SubjectEntity, Long> {
}
