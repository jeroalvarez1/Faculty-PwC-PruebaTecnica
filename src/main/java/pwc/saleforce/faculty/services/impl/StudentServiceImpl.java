package pwc.saleforce.faculty.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwc.saleforce.faculty.entities.Student;
import pwc.saleforce.faculty.repositories.StudentRepository;
import pwc.saleforce.faculty.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student getStudent(long id) throws Exception {
        return studentRepository.findById(id).orElseThrow(() -> new Exception("Error al intentar obtener el recurso")); // Personalizar errores
    }

    @Override
    public Student addStudent(Student student) throws Exception {
        try {
            return studentRepository.save(student);
        } catch (Exception e) {
            throw new Exception("Error al intentar guardar el recurso -> " + e);
        }
    }

}
