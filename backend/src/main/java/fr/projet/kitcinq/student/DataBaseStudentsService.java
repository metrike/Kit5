package fr.projet.kitcinq.student;

import fr.projet.kitcinq.model.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataBaseStudentsService implements StudentsService {

    public final StudentRepository studentsRepository;

    public DataBaseStudentsService(StudentRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public List<StudentEntity> getAllStudents() {
     return studentsRepository.findAll();
    }
}
