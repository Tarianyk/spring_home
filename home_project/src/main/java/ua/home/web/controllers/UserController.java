package ua.home.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.home.models.User;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addUserDataIntoDatabase(@ModelAttribute("user") User user) {
        System.err.println("------>" + user.getUsername() + " " + user.getPassword());
        return null;
    }
}
