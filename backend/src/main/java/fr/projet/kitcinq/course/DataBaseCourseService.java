package fr.projet.kitcinq.course;

import fr.projet.kitcinq.model.CourseEntity;
import fr.projet.kitcinq.model.FormationEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DataBaseCourseService implements CourseService {
    
    private final CourseRepository courseRepository;

    public DataBaseCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    @PostConstruct
    public void a() {
//        create("Math", LocalDateTime.now(), 3);
    }

    @Override
    public Course create(String name, LocalDateTime courseAt, int formationId) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(name);
        courseEntity.setCourseAt(courseAt);
        
        FormationEntity formationEntity = new FormationEntity();
        formationEntity.setFormationId((long) formationId);
        
        courseEntity.setFormation(formationEntity);
        
//        courseRepository.save(courseEntity);
        
        return new Course(courseEntity.getCourseId().intValue(), courseEntity.getName(), courseEntity.getCourseAt(), courseEntity.getFormation().getFormationId().intValue());
    }

    @Override
    public void modify(int id, Optional<String> name, Optional<LocalDateTime> courseAt, Optional<Integer> formationId) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Course get(int id) {
        return null;
    }

    @Override
    public List<Course> list(Optional<FormationFilter> formationFilter, Optional<DateFilter> dateFilter) {
        return List.of();
    }
}
