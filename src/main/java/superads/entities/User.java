package superads.entities;

import javax.persistence.*;

@Entity
@Table(schema="public", name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq")
    private Integer id;

    @Column(name="`email`", nullable = false, length = 40)
    private String email;

    @Column
    private String password;

    public User() {}

    public User(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("User[%s, %s]", id, email);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
