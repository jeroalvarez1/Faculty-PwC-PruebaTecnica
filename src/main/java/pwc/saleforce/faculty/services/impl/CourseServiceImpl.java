package pwc.saleforce.faculty.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pwc.saleforce.faculty.entities.Course;
import pwc.saleforce.faculty.entities.Student;
import pwc.saleforce.faculty.repositories.CourseRepository;
import pwc.saleforce.faculty.services.CourseService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import pwc.saleforce.faculty.services.StudentService;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentService studentService;

    @Override
    public Course getCourse(long course_id) throws Exception {
        return courseRepository.findById(course_id).orElseThrow(() -> new Exception("Error al intentar obtener el recurso ->")); // Personalizar errores
    }

    @Override
    public List<Student> getStudentsToCourse(long course_id) throws Exception {
        Course course = null;
        try {
             course = getCourse(course_id);
             return course.getStudents();
        } catch (Exception e) {
            throw new Exception("Erro al intentar obtener el recurso -> " + e);
        }
    }

    @Override
    public Course addCourse(Course course) throws Exception {
        try {
            return courseRepository.save(course);
        } catch (Exception e) {
            throw new Exception("Error al intentar guardar el recurso -> " + e);
        }
    }

    @Override
    public Course addStudentToCourse(long course_id, long student_id) throws Exception {
        Course course = null;
        Student student = null;
        try {
            course = getCourse(course_id);
            student = studentService.getStudent(student_id);
        } catch (Exception e) {
            throw new Exception("Error al intentar obtener el recurso -> " + e);
        }
        try {
            Student finalStudent = student;
            List<Student> students = course.getStudents().stream().filter(student1 -> student1 == finalStudent).collect(Collectors.toList());
            if (students.isEmpty()) {
                course.getStudents().add(student);
            }
            return courseRepository.save(course);
        } catch (Exception e) {
            throw new Exception("Error al intentar guardar el recurso -> " + e);
        }
    }

    @Override
    public Course removeStudentsToCourse(long course_id) throws Exception {
        Course course = null;
        try {
            course = getCourse(course_id);
        } catch (Exception e) {
            throw new Exception("Error al intentar obtener el recurso -> " + e);
        }
        try {
            course.getStudents().clear();
            return courseRepository.save(course);
        } catch (Exception e) {
            throw new Exception("Error al intentar guardar el recurso -> " + e);
        }
    }

    @Override
    public Course removeStudentToCourse(long course_id, long student_id) throws Exception {
        Course course = null;
        Student student = null;
        try {
            course = getCourse(course_id);
            student = studentService.getStudent(student_id);
        } catch (Exception e) {
            throw new Exception("Error al intentar obtener el recurso -> " + e);
        }
        try {
            course.getStudents().remove(student);
            return courseRepository.save(course);
        } catch (Exception e) {
            throw new Exception("Error al intentar guardar el recurso -> " + e);
        }
    }


}
