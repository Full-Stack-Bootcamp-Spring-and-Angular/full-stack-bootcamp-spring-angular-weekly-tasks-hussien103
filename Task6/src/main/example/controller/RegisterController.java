package main.example.controller;


import main.example.DAO.UserDao;
import main.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    @RequestMapping("/form")
    public String showFormPage(Model model){

        User user = new User();
        model.addAttribute("user",user);
        return "formPage";
    }
    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("user") User user, Model model) throws SQLException {
        model.addAttribute("user", user);
        userDao.addUser(user);
        return "user-result";
    }
}
