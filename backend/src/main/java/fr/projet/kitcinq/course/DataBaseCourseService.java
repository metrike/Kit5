package fr.projet.kitcinq.course;

import fr.projet.kitcinq.model.CourseEntity;
import fr.projet.kitcinq.model.FormationEntity;
import fr.projet.kitcinq.model.SubjectEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DataBaseCourseService implements CourseService {

    private final CourseRepository courseRepository;

    public DataBaseCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public Course create(String name, LocalDateTime courseAt, long formationId, long subjectId) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setName(name);
        courseEntity.setCourseAt(courseAt);

        FormationEntity formationEntity = new FormationEntity();
        formationEntity.setFormationId(formationId);
        courseEntity.setFormation(formationEntity);

        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setSubjectId(subjectId);
        courseEntity.setSubject(subjectEntity);

        courseRepository.save(courseEntity);

        CourseEntity newCourseEntity = courseRepository.findById(courseEntity.getCourseId()).orElseThrow();

        return new Course(
                courseEntity.getCourseId().intValue(),
                courseEntity.getName(),
                courseEntity.getCourseAt(),
                newCourseEntity.getFormation().getFormationId(),
                newCourseEntity.getFormation().getName(),
                newCourseEntity.getSubject().getSubjectId(),
                newCourseEntity.getSubject().getName()
        );
    }

    @Override
    @Transactional
    public void modify(long id, Optional<String> opName, Optional<LocalDateTime> opCourseAt, Optional<Long> opFormationId, Optional<Long> opSubjectId) {
        CourseEntity courseEntity = courseRepository.findById(id).orElseThrow();

        opName.ifPresent(courseEntity::setName);
        opCourseAt.ifPresent(courseEntity::setCourseAt);
        opFormationId.ifPresent(formationId -> {
            FormationEntity formationEntity = new FormationEntity();
            formationEntity.setFormationId(formationId);
            courseEntity.setFormation(formationEntity);
        });
        opSubjectId.ifPresent(subjectId -> {
            SubjectEntity subjectEntity = new SubjectEntity();
            subjectEntity.setSubjectId(subjectId);
            courseEntity.setSubject(subjectEntity);
        });

        courseRepository.save(courseEntity);
    }

    @Override
    public void delete(long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course get(long id) {
        CourseEntity courseEntity = courseRepository.findById(id).orElseThrow();
        return new Course(
                courseEntity.getCourseId().intValue(),
                courseEntity.getName(),
                courseEntity.getCourseAt(),
                courseEntity.getFormation().getFormationId(),
                courseEntity.getFormation().getName(),
                courseEntity.getSubject().getSubjectId(),
                courseEntity.getSubject().getName()
        );
    }

    @Override
    public List<Course> list(Optional<FormationFilter> formationFilter, Optional<DateFilter> dateFilter) {
        return courseRepository
                .findAll()
                .stream()
                .filter(courseEntity -> filter(courseEntity, formationFilter, dateFilter))
                .map(courseEntity -> new Course(
                        courseEntity.getCourseId().intValue(),
                        courseEntity.getName(),
                        courseEntity.getCourseAt(),
                        courseEntity.getFormation().getFormationId(),
                        courseEntity.getFormation().getName(),
                        courseEntity.getSubject().getSubjectId(),
                        courseEntity.getSubject().getName()
                ))
                .toList();
    }

    static boolean filter(CourseEntity entity, Optional<FormationFilter> formationFilter, Optional<DateFilter> dateFilter) {
        boolean isFormationFilter = true;
        boolean isDateFilter = true;

        if (formationFilter.isPresent()) {
            String formationFilterValue = formationFilter.get().value();
            isFormationFilter = entity.getFormation().getName().toLowerCase().contains(formationFilterValue.toLowerCase());
        }

        if (dateFilter.isPresent()) {
            DateFilter dateFilterValue = dateFilter.get();
            isDateFilter = entity.getCourseAt().isAfter(dateFilterValue.start()) && entity.getCourseAt().isBefore(dateFilterValue.end());
        }

        return isFormationFilter && isDateFilter;
    }
}
