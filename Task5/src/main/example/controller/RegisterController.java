package main.example.controller;


import main.example.DAO.UserDao;
import main.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Controller
public class RegisterController {


    @Autowired
    public UserDao userDao;
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @PostMapping("/submitRegisteration")
    public String submitRegisteration(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("email")  String email, @RequestParam("dob")String dob,@RequestParam("city") String city ,Model model) throws SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate dobDate = LocalDate.parse(dob, formatter);
        model.addAttribute("firstName",firstName);
        model.addAttribute("lastName",lastName);
        model.addAttribute("email",email);
        model.addAttribute("dob",dobDate);
        model.addAttribute("city",city);
        User user = new User(firstName,lastName,email,dobDate,city);
        userDao.addUser(user);
        return "home";
    }
}
