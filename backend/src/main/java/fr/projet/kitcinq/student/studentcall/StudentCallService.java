package fr.projet.kitcinq.student.studentcall;

public interface StudentCallService {
    
    void launch(int courseId);
    
    void setStudentPresent(int courseId, int studentId);
    
    void setStudentAbsent(int courseId, int studentId);
    
    
}
