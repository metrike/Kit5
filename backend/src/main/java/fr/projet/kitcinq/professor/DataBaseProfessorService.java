package fr.projet.kitcinq.professor;

import fr.projet.kitcinq.model.ProfessorEntity;

public class DataBaseProfessorService implements ProfessorService {
    
    private final ProfessorRepository professorRepository;
    
    public DataBaseProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public CreateProfessorResult create(String firstName, String lastName) {
        ProfessorEntity professor = new ProfessorEntity();
        professor.setFirstName(firstName);
        professor.setLastName(lastName);
        professorRepository.save(professor);
        return new CreateProfessorResult(professor.getProfessorId(), professor.getFirstName(), professor.getLastName());
    }
}
