package fr.projet.kitcinq.professor;

public interface ProfessorService {
    
    record CreateProfessorResult(long id, String firstName, String lastName) {}
    
    CreateProfessorResult create(long userId, String firstName, String lastName);
}
