package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Student;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.StudentDao;

import java.util.List;

@Controller
public class StudentBindController {

    private final StudentDao studentDao;
    private final AuthorDao authorDao;

    public StudentBindController(StudentDao studentDao, AuthorDao authorDao) {
        this.studentDao = studentDao;
        this.authorDao = authorDao;
    }

    @RequestMapping(value = "/simple-bind", method = RequestMethod.GET)
    public String simple(Model model) {
        model.addAttribute("student", new Student());
        return "form/registerSimpleBind";
    }

    @RequestMapping(value = "/simple-bind-edit/{id}", method = RequestMethod.GET)
    public String simpleBindEdit(Model model, @PathVariable long id) {
        model.addAttribute("student", studentDao.findById(id));
        return "form/registerSimpleBind";
    }


    @ModelAttribute("authors")
    public List<Author> allAuthors(){
        return authorDao.getAll();
    }

    @RequestMapping(value = "/simple-bind", method = RequestMethod.POST)
    public String processSimple(@ModelAttribute Student student, Model model) {
        studentDao.save(student);
        return "form/success";
    }
}
