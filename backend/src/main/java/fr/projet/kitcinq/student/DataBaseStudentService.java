package fr.projet.kitcinq.student;

import fr.projet.kitcinq.model.StudentEntity;
import org.springframework.stereotype.Service;

@Service
public class DataBaseStudentService {
    
    private final StudentRepository studentRepository;
    
    public DataBaseStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentService.CreateStudentResult create(String firstName, String lastName) {
        StudentEntity student = new StudentEntity();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        studentRepository.save(student);
        return new StudentService.CreateStudentResult(student.getStudentId(), student.getFirstName(), student.getLastName());
    }
}
