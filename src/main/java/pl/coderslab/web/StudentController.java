package pl.coderslab.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Student;

public class StudentController {

    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    public String simple() {
        return "form/registerSimple";
    }
    @RequestMapping(value = "/simple", method = RequestMethod.POST)
    public String processSimple(@RequestParam String firstName,
                                @RequestParam String lastName, Model model) {
        Student student = new Student(firstName, lastName);
        model.addAttribute("student", student);
        return "form/success";
    }
}
