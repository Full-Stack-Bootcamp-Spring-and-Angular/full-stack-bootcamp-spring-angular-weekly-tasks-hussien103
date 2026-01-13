package main.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.Period;

@Controller
public class CalculatorController {


    @RequestMapping("/")
    public String index() {

        return "index";
    }

    @RequestMapping("/calculateAge")
    public String calculateAge(
            @RequestParam("year") int year,
            @RequestParam("month") int month,
            @RequestParam("day") int day,
            Model model) {

        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();

        int age = Period.between(birthDate, today).getYears();

        model.addAttribute("age", age);
        return "displayAge";
    }
}
