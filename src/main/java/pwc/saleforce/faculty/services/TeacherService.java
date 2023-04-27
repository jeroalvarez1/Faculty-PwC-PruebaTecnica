package pwc.saleforce.faculty.services;

import pwc.saleforce.faculty.entities.Department;
import pwc.saleforce.faculty.entities.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher getTeacher(long teacher_id) throws Exception;

    Department changeTeacherOfDepartment(long department_id, long teacher_id) throws Exception;

    List<Teacher> getTeachersOfDepartment(long department_id) throws Exception;

    Teacher addTeacher(Teacher teacher) throws Exception;

}
