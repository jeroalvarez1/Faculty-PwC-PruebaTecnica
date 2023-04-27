package pwc.saleforce.faculty.services;

import pwc.saleforce.faculty.entities.Course;
import pwc.saleforce.faculty.entities.Student;

import java.util.List;

public interface CourseService {

    Course getCourse(long id) throws Exception;

    List<Student> getStudentsToCourse(long course_id) throws Exception;

    Course addCourse(Course course) throws Exception;

    Course addStudentToCourse(long course_id, long student_id) throws Exception;

    Course removeStudentsToCourse(long course_id) throws Exception;

    Course removeStudentToCourse(long course_id, long student_id) throws Exception;
}
