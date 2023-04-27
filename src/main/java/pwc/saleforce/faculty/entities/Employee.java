package pwc.saleforce.faculty.entities;

import javax.persistence.*;

@Entity
public class Employee extends Person {
    private int yearIncorporation;
    private int officeNumber;

    public int getYearIncorporation() {
        return yearIncorporation;
    }

    public void setYearIncorporation(int yearIncorporation) {
        this.yearIncorporation = yearIncorporation;
    }

    public int getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    }

    public Employee() {

    }

    public Employee(String firstName, String lastNames, String dni, CivilStatus civilStatus, int yearIncorporation, int officeNumber) {
        super(firstName, lastNames, dni, civilStatus);
        this.yearIncorporation = yearIncorporation;
        this.officeNumber = officeNumber;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("yearIncorporation=").append(yearIncorporation);
        sb.append(", officeNumber=").append(officeNumber);
        sb.append('}');
        return sb.toString();
    }
}
