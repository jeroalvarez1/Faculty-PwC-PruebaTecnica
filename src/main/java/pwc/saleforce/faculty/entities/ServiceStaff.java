package pwc.saleforce.faculty.entities;


import javax.persistence.*;

@Entity
public class ServiceStaff extends Employee {
    @ManyToOne
    private Section section;

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public ServiceStaff() {

    }

    public ServiceStaff(String firstName, String lastNames, String dni, CivilStatus civilStatus, int yearIncorporation, int officeNumber, Section section) {
        super(firstName, lastNames, dni, civilStatus, yearIncorporation, officeNumber);
        this.section = section;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ServiceStaff{");
        sb.append("section=").append(section);
        sb.append('}');
        return sb.toString();
    }
}
