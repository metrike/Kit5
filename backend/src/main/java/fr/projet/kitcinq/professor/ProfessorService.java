package fr.projet.kitcinq.professor;

public interface ProfessorService {
    
    record CreateProfessorResult(long id, String firstName, String lastName) {}
    
    CreateProfessorResult create(String firstName, String lastName);
}
