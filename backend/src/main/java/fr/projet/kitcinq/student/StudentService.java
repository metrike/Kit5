package fr.projet.kitcinq.student;

public interface StudentService {
    
    record CreateStudentResult(long id, String firstName, String lastName) {}
    
    CreateStudentResult create(String firstName, String lastName);
}
