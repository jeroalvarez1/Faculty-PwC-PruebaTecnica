package pwc.saleforce.faculty.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends Person {
    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Student() {

    }

    public Student(String firstName, String lastNames, String dni, CivilStatus civilStatus, List<Course> courses) {
        super(firstName, lastNames, dni, civilStatus);
        this.courses = courses;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("courses=").append(courses);
        sb.append('}');
        return sb.toString();
    }
}
