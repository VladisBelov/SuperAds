package superads.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "public", name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="cats_gen")
    @SequenceGenerator(name="cats_gen", sequenceName="cats_id_seq")
    private Integer id;

    @Column
    private String title;

    @Column
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="CategoryAdvertisment")
    private List<Advertisment> advertisments = new ArrayList<Advertisment>();

    public Category() {}

    public Category(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Advertisment> getAdvertisments() {
        return advertisments;
    }

    public void setAdvertisments(List<Advertisment> advertisments) {
        this.advertisments = advertisments;
    }
}
