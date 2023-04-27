package pwc.saleforce.faculty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwc.saleforce.faculty.entities.Department;
import pwc.saleforce.faculty.entities.Teacher;
import pwc.saleforce.faculty.services.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/teachers/{teacher_id}/changedepartment/{department_id}")
    public ResponseEntity<Department> changeTeacherOfDepartment(@PathVariable long teacher_id, @PathVariable long department_id) throws Exception {
        try {
            return new ResponseEntity<>(teacherService.changeTeacherOfDepartment(department_id, teacher_id), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/teachers/department/{department_id}")
    public ResponseEntity<List<Teacher>> getTeachersOfDepartment(@PathVariable long department_id) throws Exception {
        try {
            return new ResponseEntity<>(teacherService.getTeachersOfDepartment(department_id), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/teachers")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        try {
            return new ResponseEntity<>(teacherService.addTeacher(teacher), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
