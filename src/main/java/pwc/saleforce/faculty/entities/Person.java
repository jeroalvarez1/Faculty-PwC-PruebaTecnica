package pwc.saleforce.faculty.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "dni")
})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastNames;

    @Column(unique = true)
    private String dni;

    @ManyToOne
    private CivilStatus civilStatus;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }
    public Person() {

    }

    public Person(String firstName, String lastNames, String dni, CivilStatus civilStatus) {
        this.firstName = firstName;
        this.lastNames = lastNames;
        this.dni = dni;
        this.civilStatus = civilStatus;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastNames='").append(lastNames).append('\'');
        sb.append(", dni='").append(dni).append('\'');
        sb.append(", civil_status='").append(civilStatus).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
