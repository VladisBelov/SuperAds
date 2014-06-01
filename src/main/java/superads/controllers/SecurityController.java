package superads.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import superads.entities.User;
import superads.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableWebMvcSecurity
public class SecurityController extends WebSecurityConfigurerAdapter{

    @Autowired
    UserRepository userRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index", "/about")
                .permitAll()
                .anyRequest()
                .authenticated();

        http.formLogin()
            .loginPage("/login")
            .permitAll().and().logout().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws  Exception {

        auth.userDetailsService(new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

                User u = userRepository.findOneByEmail(s);
                if (u == null) {
                    throw new UsernameNotFoundException("not found");
                }


                org.springframework.security.core.userdetails.User user =
                        new org.springframework.security.core.userdetails.User(u.getEmail(), u.getPassword(), new ArrayList<GrantedAuthority>() );

                return user;
            }

        });


    }
}
