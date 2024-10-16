package fr.projet.kitcinq;

import fr.projet.kitcinq.course.CourseService;
import fr.projet.kitcinq.formation.FormationRepository;
import fr.projet.kitcinq.model.FormationEntity;
import fr.projet.kitcinq.model.SubjectEntity;
import fr.projet.kitcinq.subject.SubjectRepository;
import fr.projet.kitcinq.user.UserRepository;
import fr.projet.kitcinq.user.UserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {
    
    private final FormationRepository formationRepository;
    private final SubjectRepository subjectRepository;
    private final CourseService courseService;
    private final UserService userService;

    public ApplicationReadyListener(FormationRepository formationRepository, SubjectRepository subjectRepository, CourseService courseService, UserService userService) {
        this.formationRepository = formationRepository;
        this.subjectRepository = subjectRepository;
        this.courseService = courseService;
        this.userService = userService;
    }

    private void pushSubject(String name) {
        SubjectEntity subjectEntity = new SubjectEntity();
        subjectEntity.setName(name);
        subjectRepository.save(subjectEntity);
    }
    
    private void pushFormation(String name) {
        FormationEntity formationEntity = new FormationEntity();
        formationEntity.setName(name);
        formationRepository.save(formationEntity);
    }
    
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        pushFormation("Informatique");
        pushFormation("Mathématiques");
        pushFormation("Physique");
        
        pushSubject("Algorithmique");
        pushSubject("Programmation");
        pushSubject("Analyse");
        
        courseService.create("Cours 1", LocalDateTime.now(), 1, 1);
        courseService.create("Cours 2", LocalDateTime.now().minusDays(1), 2, 2);
        courseService.create("Cours 3", LocalDateTime.now().plusDays(1), 3, 3);
        courseService.create("Cours 4", LocalDateTime.now().plusDays(2), 1, 2);
        courseService.create("Cours 5", LocalDateTime.now().plusDays(3), 2, 3);
        
        userService.create("livio", "livio", LocalDateTime.now());
    }
}
