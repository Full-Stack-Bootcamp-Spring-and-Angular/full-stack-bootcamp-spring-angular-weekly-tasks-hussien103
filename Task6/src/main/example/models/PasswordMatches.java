package main.example.models;

import javax.validation.*;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
public @interface PasswordMatches {

    String message() default "The password fields must match";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}