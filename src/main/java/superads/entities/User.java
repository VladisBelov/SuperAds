package superads.entities;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.DigestUtils;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;

import org.springframework.web.bind.annotation.RequestParam;
import superads.entities.Advertisment;
import superads.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import superads.repositories.AdvertismentRepository;
import superads.repositories.UserRepository;

import javax.validation.Valid;
import java.util.logging.Level;
import java.util.logging.Logger;

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
