package fr.projet.kitcinq.course;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    public record CreateCourseRequestBody(String name, LocalDateTime courseAt, long formationId, long subjectId) {
        public CreateCourseRequestBody {
            if (name.isBlank()) {
                throw new IllegalArgumentException("name is blank");
            }
            if (courseAt == null) {
                throw new IllegalArgumentException("courseAt is null");
            }
        }
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Course create(@RequestBody CreateCourseRequestBody body) {
        return courseService.create(body.name, body.courseAt, body.formationId, body.subjectId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        courseService.delete(id);
    }

    public record GetCourseByIdResponseBody(int id, String name, LocalDateTime courseAt, long formationId, String formationName, long subjectId, String subjectName) {
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetCourseByIdResponseBody getById(@PathVariable int id) {
        Course course = courseService.get(id);
        return new GetCourseByIdResponseBody(course.id(), course.name(), course.courseAt(), course.formationId(), course.formationName(), course.subjectId(), course.subjectName());
    }
    
    public record ListCourseResponseBody(int id, String name, LocalDateTime courseAt, long formationId, String formationName, long subjectId, String subjectName) {
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ListCourseResponseBody> list(@RequestParam @Nullable String formation, @RequestParam @Nullable String start, @RequestParam @Nullable String end) {
        Optional<FormationFilter> formationFilter = Optional.ofNullable(formation).map(FormationFilter::new);
        LocalDateTime filterStart = Optional.ofNullable(start).map(LocalDateTime::parse).orElse(LocalDateTime.MIN);
        LocalDateTime filterEnd = Optional.ofNullable(end).map(LocalDateTime::parse).orElse(LocalDateTime.MAX);
        
        Optional<DateFilter> dateFilter = Optional.of(new DateFilter(filterStart, filterEnd));

        return courseService
                .list(formationFilter, dateFilter)
                .stream()
                .map(course -> new ListCourseResponseBody(course.id(), course.name(), course.courseAt(), course.formationId(), course.formationName(), course.subjectId(), course.subjectName()))
                .toList();
    }

    @GetMapping(value = "/AllCourse", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<ListCourseResponseBody> getAllCourses() {
        return courseService
                .getAllCourses()
                .stream()
                .map(courseEntity -> new ListCourseResponseBody(
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
}
