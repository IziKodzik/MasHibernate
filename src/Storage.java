import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Storage {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy
            = "increment")
    private int id;

    public Storage(Laboratory laboratory){
        laboratory.addStorage(this);
    }
    public Storage(){}



    @ManyToOne
    private Laboratory laboratory;
    public Laboratory getLab(){
        return laboratory;
    }

    public void setLab(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", laboratory=" + laboratory.getId() +
                '}';
    }
}
