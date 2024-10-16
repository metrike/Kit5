package fr.projet.kitcinq.course;

import fr.projet.kitcinq.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    
}
