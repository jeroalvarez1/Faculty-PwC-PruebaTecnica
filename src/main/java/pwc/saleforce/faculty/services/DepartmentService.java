package pwc.saleforce.faculty.services;

import pwc.saleforce.faculty.entities.Department;
import pwc.saleforce.faculty.entities.Teacher;

import java.util.List;

public interface DepartmentService {

    Department getDepartment(long department_id) throws Exception;

    Department addDepartment(Department department) throws Exception;

}
