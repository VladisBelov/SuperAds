package superads.entities;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.DigestUtils;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;


@Entity
@Table(schema="public", name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq")
    private Integer id;

    @NotEmpty
    @Column(name="email", nullable = false, length = 40)
    private String email;

    @NotEmpty
    @Column(name="password", nullable = false, length = 16)
    private String password;

    public User() {}


    public User(String email, String password) {
        this.email = email;
        this.password = password;

    }


    @Override
    public String toString() {
        return String.format("User[%s, %s, %s]", id, email, password);
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
