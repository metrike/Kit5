package fr.projet.kitcinq.professor;

import fr.projet.kitcinq.model.ProfessorEntity;
import fr.projet.kitcinq.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {
    boolean existsByUserId(Long userId);
}
