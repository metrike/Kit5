package fr.projet.kitcinq.course;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CourseService {
    
    Course create(String name, LocalDateTime courseAt, int formationId);
    
    void modify(int id, Optional<String> name, Optional<LocalDateTime> courseAt, Optional<Integer> formationId);
    
    void delete(int id);
    
    Course get(int id);
    
    List<Course> list(Optional<FormationFilter> formationFilter, Optional<DateFilter> dateFilter);
    
    
}
