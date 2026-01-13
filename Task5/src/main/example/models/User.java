package main.example.models;

import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    private String city;

    public User(String firstName, String lastName, String email, LocalDate dob, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.city = city;
    }
}
