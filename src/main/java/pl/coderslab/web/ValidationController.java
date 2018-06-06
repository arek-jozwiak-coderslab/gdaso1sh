package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {

    @Autowired
    Validator validator;

    @GetMapping("/validate-book")
    public void validateBook() {
        Book b = new Book();
        b.setTitle("1");
        b.setPages(0);
        Set<ConstraintViolation<Book>> violations = validator.validate(b);

        if (violations.isEmpty()) {
            // wszystko ok można zapisać
        } else {
            // nie jest ok - i co teraz
            for (ConstraintViolation<Book> constraintViolation : violations) {
                System.out.println(constraintViolation.getPropertyPath() + " "
                        + constraintViolation.getMessage());
            }
        }

    }
}
