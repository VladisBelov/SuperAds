package superads.controllers;

import superads.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import superads.repositories.UserRepository;

import javax.validation.Valid;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class WelcomeController {

    /**
     * Logger
     */
    private static Logger log = Logger.getLogger("WelcomeController");

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/")
    public String index() {


         return "index";
    }

    /**
     * Welcome page
     */
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public String index(Model model) {

        log.log(Level.WARNING, "DADADADADA");

        model.addAttribute("user", new User());
        return "form";
    }

    /**
     * Welcome page
     */
    @RequestMapping(value="/users", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("user") User form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        System.out.println(form);

        return "index";
    }

}
