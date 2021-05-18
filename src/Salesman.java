import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Salesman
    extends Employee{

    private Double revenue;

    public Salesman(){}

    public Salesman(Double revenue) {
        this.revenue = revenue;
    }

    public Salesman( String firstName, String lastName, LocalDate since, Double revenue) {
        super(firstName, lastName, since);
        this.revenue = revenue;
    }

    public Double getRevenue() {
        return revenue;
    }

    public void setRevenue(Double revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "revenue=" + revenue +
                '}';
    }
}
