package pwc.saleforce.faculty.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Teacher extends Employee {

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public Teacher() {

    }

    public Teacher(String firstName, String lastNames, String dni, CivilStatus civilStatus, int yearIncorporation, int officeNumber, Department department) {
        super(firstName, lastNames, dni, civilStatus, yearIncorporation, officeNumber);
        this.department = department;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Teacher{");
        sb.append("department=").append(department);
        sb.append('}');
        return sb.toString();
    }
}
