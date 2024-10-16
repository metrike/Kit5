package fr.projet.kitcinq.course;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryCourseService implements CourseService {

    record Course(int id, String name, LocalDateTime courseAt, int formationId) {
    }

    private final Map<Integer, Course> courses = new HashMap<>();
    private final AtomicInteger id = new AtomicInteger(0);

    @PostConstruct
    void onConstruct() {
        create("nike", LocalDateTime.now(),0);
        create("adidas", LocalDateTime.now().minusDays(1),1);
        create("puma", LocalDateTime.now().minusDays(2),2);
        create("reebok", LocalDateTime.now().minusDays(3),3);
        create("fila", LocalDateTime.now().minusDays(4),4);
        create("asics", LocalDateTime.now().minusDays(5),5);
        create("new balance", LocalDateTime.now().minusDays(6),6);
        create("under armour", LocalDateTime.now().minusDays(7),7);
        create("converse", LocalDateTime.now().minusDays(8),8);
    }

    @Override
    public fr.projet.kitcinq.course.Course create(String name, LocalDateTime courseAt, int formationId) {
        int id = this.id.getAndIncrement();
        courses.put(id, new Course(id, name, courseAt, formationId));
        return new fr.projet.kitcinq.course.Course(id, name, courseAt, formationId);
    }

    @Override
    public void modify(int id, Optional<String> name, Optional<LocalDateTime> courseAt, Optional<Integer> formationId) {
        Course course = courses.get(id);
        if (course == null) {
            throw new RuntimeException("Course not found");
        }

        courses.put(id,
                new Course(
                        id,
                        name.orElse(course.name()),
                        courseAt.orElse(course.courseAt()),
                        formationId.orElse(course.formationId)
                )
        );
    }

    @Override
    public void delete(int id) {
        System.out.println(courses);
        if (!courses.containsKey(id)) {
            throw new RuntimeException("Course not found");
        }

        courses.remove(id);
    }

    @Override
    public fr.projet.kitcinq.course.Course get(int id) {
        Course course = courses.get(id);
        if (course == null) {
            throw new RuntimeException("Course not found");
        }

        return new fr.projet.kitcinq.course.Course(course.id(), course.name(), course.courseAt(), course.formationId);
    }

    @Override
    public List<fr.projet.kitcinq.course.Course> list(Optional<FormationFilter> formationFilter, Optional<DateFilter> dateFilter) {
        return courses
                .values()
                .stream()
                .filter(course -> filter(course, formationFilter, dateFilter))
                .map(course -> new fr.projet.kitcinq.course.Course(course.id(), course.name(), course.courseAt(), course.formationId))
                .toList();
    }

    static boolean filter(Course course, Optional<FormationFilter> formationFilter, Optional<DateFilter> dateFilter) {
        boolean isFormationFilter = true;
        boolean isDateFilter = true;

        if (formationFilter.isPresent()) {
            String formationFilterValue = formationFilter.get().value();
            isFormationFilter = course.name.toLowerCase().contains(formationFilterValue.toLowerCase());
        }

        if (dateFilter.isPresent()) {
            DateFilter dateFilterValue = dateFilter.get();
            isDateFilter = course.courseAt.isAfter(dateFilterValue.start()) && course.courseAt.isBefore(dateFilterValue.end());
        }

        return isFormationFilter && isDateFilter;
    }
}
