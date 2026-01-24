package main.example.models;

import main.example.models.Employee;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Employee> {

    @Override
    public boolean isValid(Employee emp, ConstraintValidatorContext context) {
        if (emp.getPassword() == null || emp.getConfirmPassword() == null)
            return false;

        return emp.getPassword().equals(emp.getConfirmPassword());
    }


}