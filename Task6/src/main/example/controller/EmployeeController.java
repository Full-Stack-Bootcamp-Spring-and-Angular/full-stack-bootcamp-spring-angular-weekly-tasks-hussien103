package main.example.controller;

import main.example.DAO.EmployeeDAO;
import main.example.models.Employee;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private EmployeeDAO dao = new EmployeeDAO();

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "register";
    }

    @PostMapping("/register")
    public String submitForm(
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult result) {

        if (result.hasErrors()) {
            return "register";
        }

        dao.save(employee);
        return "home";
    }
}