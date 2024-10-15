package fr.projet.kitcinq.course;

import fr.projet.kitcinq.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<UserEntity, Long> {
    
    
}
