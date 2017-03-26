package ua.home.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.home.exception.ServerException;

@ControllerAdvice
public class ErrorController {

    @RequestMapping(value = "404", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleNotFoundResource() {
        return "error404";
    }

    @ExceptionHandler(value = ServerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleAllException(ServerException e) {
        ModelMap model = new ModelMap();
        model.addAttribute("error", e.getMessage());

        return "redirect:/error500";
    }

}
