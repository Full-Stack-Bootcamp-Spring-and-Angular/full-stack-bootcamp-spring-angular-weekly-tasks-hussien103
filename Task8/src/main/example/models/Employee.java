package main.example.models;

import main.example.models.PasswordMatches;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;


@Setter
@Getter
@PasswordMatches
public class Employee {

    @NotBlank(message = "this field cannot empty or null")
    private String username;

    @NotBlank
    @Email(message = "please enter a valid email address")
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    @NotBlank
    private String confirmPassword;

}