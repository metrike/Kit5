package fr.projet.kitcinq.course;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CourseService {
    
    Course create(String name, LocalDateTime courseAt, long formationId, long subjectId);
    
    void modify(long id, Optional<String> name, Optional<LocalDateTime> courseAt, Optional<Long> formationId, Optional<Long> subjectId);
    
    void delete(long id);
    
    Course get(long id);
    
    List<Course> list(Optional<FormationFilter> formationFilter, Optional<DateFilter> dateFilter);
}
