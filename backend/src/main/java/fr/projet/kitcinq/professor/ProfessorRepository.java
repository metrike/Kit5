package fr.projet.kitcinq.professor;

import fr.projet.kitcinq.model.ProfessorEntity;
<<<<<<< HEAD
=======
import fr.projet.kitcinq.model.UserEntity;
>>>>>>> main
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {
    boolean existsByUserId(Long userId);
}
