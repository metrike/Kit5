package fr.projet.kitcinq.student;

import fr.projet.kitcinq.model.StudentEntity;
import fr.projet.kitcinq.model.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class DataBaseStudentService implements StudentService {
    
    private final StudentRepository studentRepository;
    
    public DataBaseStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentService.CreateStudentResult create(long userId, String firstName, String lastName) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(firstName);
        studentEntity.setLastName(lastName);

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        studentEntity.setUser(userEntity);

        studentRepository.save(studentEntity);
        return new StudentService.CreateStudentResult(studentEntity.getStudentId(), studentEntity.getFirstName(), studentEntity.getLastName());
    }
}
