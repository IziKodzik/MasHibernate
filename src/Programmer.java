import javax.persistence.Entity;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class Programmer extends Employee {

    public enum ProgrammingLanguage {JAVA, CSharp, CPLUSPLUS, PYTHON}

    public Programmer(){}
    private ProgrammingLanguage programmingLanguage;

    @Enumerated
    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public Programmer(ProgrammingLanguage programmingLanguage) {
        setProgrammingLanguage(programmingLanguage);
    }

    public Programmer(String firstName, String lastName, LocalDate since, ProgrammingLanguage programmingLanguage) {
        super(firstName, lastName, since);
        setProgrammingLanguage(programmingLanguage);
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "programmingLanguage=" + programmingLanguage +
                '}';
    }
}
