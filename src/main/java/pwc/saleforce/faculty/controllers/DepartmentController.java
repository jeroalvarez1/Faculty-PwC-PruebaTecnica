package pwc.saleforce.faculty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwc.saleforce.faculty.entities.Department;
import pwc.saleforce.faculty.services.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/departments")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        try {
            return new ResponseEntity<>(departmentService.addDepartment(department), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
