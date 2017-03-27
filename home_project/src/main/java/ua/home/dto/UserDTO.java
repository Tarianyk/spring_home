package ua.home.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

@Data
public class UserDTO {

    @NotEmpty(message = "Please enter your username.")
    private String username;
    @NotEmpty(message = "Please enter your password.")
    @Size(min = 6, max = 15)
    private String password;
    @NotEmpty(message = "Please enter your email.")
    @Email
    private String email;
}
