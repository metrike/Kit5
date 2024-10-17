package fr.projet.kitcinq.professor;

import fr.projet.kitcinq.model.ProfessorEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends CrudRepository<ProfessorEntity, Long> {
    boolean existsByUserId(Long userId);
}
