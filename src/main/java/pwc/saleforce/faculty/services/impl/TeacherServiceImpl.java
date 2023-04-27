package pwc.saleforce.faculty.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwc.saleforce.faculty.entities.Department;
import pwc.saleforce.faculty.entities.Teacher;
import pwc.saleforce.faculty.repositories.TeacherRepository;
import pwc.saleforce.faculty.services.DepartmentService;
import pwc.saleforce.faculty.services.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    DepartmentService departmentService;

    @Override
    public Teacher getTeacher(long teacher_id) throws Exception {
        return  teacherRepository.findById(teacher_id).orElseThrow(() -> new Exception("Error al intentar obtener el recurso"));
    }

    @Override
    public Department changeTeacherOfDepartment(long department_id, long teacher_id) throws Exception {
        Teacher teacher = null;
        Department department = null;
        try {
            department = departmentService.getDepartment(department_id);
            teacher = getTeacher(teacher_id);
        } catch (Exception e) {
            throw new Exception("Error al intentar obtener el recurso" + e);
        }
        try {
            teacher.setDepartment(department);
            teacher = teacherRepository.save(teacher);
            return teacher.getDepartment();
        } catch (Exception e) {
            throw new Exception("Error al intentar guardar el recurso" + e);
        }
    }

    @Override
    public List<Teacher> getTeachersOfDepartment(long department_id) throws Exception {
        try {
            Department department = departmentService.getDepartment(department_id);
            return department.getTeachers();
        } catch (Exception e) {
            throw new Exception("Error al intentar obtener los recurso" + e);
        }

    }

    @Override
    public Teacher addTeacher(Teacher teacher) throws Exception {
        try {
            return teacherRepository.save(teacher);
        } catch (Exception e) {
            throw new Exception("Error al intentar guardar el recurso -> " + e);
        }
    }

}
