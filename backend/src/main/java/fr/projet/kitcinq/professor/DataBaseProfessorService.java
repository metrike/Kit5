package fr.projet.kitcinq.professor;

import fr.projet.kitcinq.model.ProfessorEntity;
import fr.projet.kitcinq.model.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class DataBaseProfessorService implements ProfessorService {
    
    private final ProfessorRepository professorRepository;
    
    public DataBaseProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public CreateProfessorResult create(long userId, String firstName, String lastName) {
        ProfessorEntity professorEntity = new ProfessorEntity();
        professorEntity.setFirstName(firstName);
        professorEntity.setLastName(lastName);

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        professorEntity.setUser(userEntity);

        professorRepository.save(professorEntity);
        return new CreateProfessorResult(professorEntity.getProfessorId(), professorEntity.getFirstName(), professorEntity.getLastName());
    }
}
