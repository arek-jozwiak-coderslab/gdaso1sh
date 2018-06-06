package pl.coderslab.pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class YearOfBirthValidator implements ConstraintValidator<YearOfBirthWith, String> {

    @Override
    public void initialize(YearOfBirthWith constraintAnnotation) {

    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        LocalDate today = LocalDate.now();
        LocalDate bday = LocalDate.of(Integer.parseInt(value), Month.JANUARY, 1);
        Period age = Period.between(bday, today);
        int years = age.getYears();
        if (years > 18) {
            return true;
        }
        return false;
    }
}
