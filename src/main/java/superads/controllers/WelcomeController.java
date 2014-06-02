package superads.controllers;

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

@Controller
public class WelcomeController {

    /**
     * Logger
     */
    private static Logger log = Logger.getLogger("WelcomeController");

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdvertismentRepository advertismentRepository;

    @RequestMapping(value="/about")
    public String about() {
        return "about";
    }

    @RequestMapping(value="/")
    public String welcome(Model model) {

        model.addAttribute("ads", advertismentRepository.findAll());

         return "index";
    }

    /**
     * Welcome page
     */
    @RequestMapping(value="/add_advertisment", method = RequestMethod.GET)
    public String newAdvertisment(Model model) {

        model.addAttribute("ad", new Advertisment());
        return "advertismentForm";
    }


    @RequestMapping(value="/add_advertisment", method = RequestMethod.POST)
    public String newAdvertisment(@Valid @ModelAttribute("ad") Advertisment ad, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "advertismentForm";
        }

        advertismentRepository.save(ad);

        return "redirect:/";
    }

    @RequestMapping(value="/delete_advertisment", method = RequestMethod.GET)
    public String deleteAdvertisment(@RequestParam("id") Long id) {

        advertismentRepository.delete(id);

        return "redirect:/";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value="/reg", method = RequestMethod.GET)
    public String newUser(Model model) {

        model.addAttribute("reg", new User());
        return "reg";
    }


    @RequestMapping(value="/reg", method = RequestMethod.POST)
    public String newUser(@Valid @ModelAttribute("reg") User reg, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "reg";
        }

        userRepository.save(reg);

        return "redirect:/";
    }


}
