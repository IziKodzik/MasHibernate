import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Laboratory {


    private int id;
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy
            = "increment")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private List<Storage> storages = new ArrayList<>();
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    public List<Storage> getStorages() {
        return storages;
    }
    public void setStorages(List<Storage> storages) {
        this.storages = storages;
    }
    public void addStorage(Storage storage) {
        getStorages().add(storage);
        storage.setLab(this);
    }
    public void removeActor(Storage storage) {
        getStorages().remove(storage);
        storage.setLab(null);
    }

    @Override
    public String toString() {
        return "Laboratory{" +
                "id=" + id +
                ", storages=" + storages +
                '}';
    }
}
