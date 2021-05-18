import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(strategy = "increment", name="inrement" )
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate since;

    public Employee(){}

    public Employee( String firstName, String lastName, LocalDate since) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.since = since;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", since=" + since +
                '}';
    }
}
