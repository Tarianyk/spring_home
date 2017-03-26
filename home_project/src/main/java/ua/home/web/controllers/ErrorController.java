package ua.home.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ErrorController {

    @RequestMapping(value = "404", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleNotFoundResource() {
        return "error404";
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleAllException(Exception e) {
        return "error500";
    }

}
