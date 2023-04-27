package pwc.saleforce.faculty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwc.saleforce.faculty.entities.Course;
import pwc.saleforce.faculty.entities.Student;
import pwc.saleforce.faculty.services.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses/{course_id}")
    public ResponseEntity<Course> getById(@PathVariable long course_id) {
        try {
            return new ResponseEntity<>(courseService.getCourse(course_id), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/courses/{course_id}/students")
    public ResponseEntity<List<Student>> getStudentsToCourse(@PathVariable long course_id) throws Exception {
        try {
            return new ResponseEntity<>(courseService.getStudentsToCourse(course_id), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        try {
            return new ResponseEntity<>(courseService.addCourse(course), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/courses/add/{course_id}/student/{student_id}")
    public ResponseEntity<Course> addStudentToCourse(@PathVariable long course_id, @PathVariable long student_id) {
        try {
            return new ResponseEntity<>(courseService.addStudentToCourse(course_id, student_id), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/courses/remove/{course_id}")
    public ResponseEntity<Course> removeStudentsToCourse(@PathVariable long course_id) {
        try {
            return new ResponseEntity<>(courseService.removeStudentsToCourse(course_id), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/courses/remove/{course_id}/student/{student_id}")
    public ResponseEntity<Course> removeStudentToCourse(@PathVariable long course_id, @PathVariable long student_id) {
        try {
            return new ResponseEntity<>(courseService.removeStudentToCourse(course_id, student_id), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
