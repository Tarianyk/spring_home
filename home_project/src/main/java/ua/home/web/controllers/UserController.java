package ua.home.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.home.domain.User;
import ua.home.dto.UserDTO;
import ua.home.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity addUserDataIntoDatabase(@ModelAttribute("user") @Valid UserDTO userDTO) {
        User addUser = userService.addUser(exctractToUser(userDTO));

        return new ResponseEntity(addUser.getId(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "get", method = RequestMethod.GET, produces = "application/json")
    public User getuserById(@RequestParam("id") String id) {
        User user = userService.getUser(id);

        return user;
    }

    private User exctractToUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());

        return user;
    }
}
