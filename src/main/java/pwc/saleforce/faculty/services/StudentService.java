package pwc.saleforce.faculty.services;

import pwc.saleforce.faculty.entities.Student;

public interface StudentService {
    Student getStudent(long id) throws Exception;

    Student addStudent(Student student) throws Exception;

}
