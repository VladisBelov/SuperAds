package superads.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "public", name = "advertisments")
@Inheritance(strategy = InheritanceType.JOINED)
public class Advertisment {


    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="ads_gen")
    @SequenceGenerator(name="ads_gen", sequenceName="ads_id_seq",allocationSize = 1)
    private Long id;

    @NotEmpty
    @Column
    private String title;

    @NotEmpty
    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private Date date = new Date();

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

/*    @ManyToMany(mappedBy = "advertisments", cascade = CascadeType.ALL)
    private List<Category> categories = new ArrayList<>();*/


    public Advertisment() {}

    public Advertisment(String title) {
        this.title = title;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /*public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }*/
}
