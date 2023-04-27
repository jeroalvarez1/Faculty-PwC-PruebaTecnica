package pwc.saleforce.faculty.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwc.saleforce.faculty.entities.Department;
import pwc.saleforce.faculty.repositories.DepartmentRepository;
import pwc.saleforce.faculty.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department getDepartment(long department_id) throws Exception {
        return departmentRepository.findById(department_id).orElseThrow(() -> new Exception("Error al intentar obtener el recurso"));
    }

    @Override
    public Department addDepartment(Department department) throws Exception {
        try {
            return departmentRepository.save(department);
        } catch (Exception e) {
            throw new Exception("Error al intentar guardar el recurso -> " + e);
        }
    }

}
