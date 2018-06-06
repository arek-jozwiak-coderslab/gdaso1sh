package pl.coderslab.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Person;
import pl.coderslab.pl.coderslab.dao.AuthorDao;
import pl.coderslab.pl.coderslab.dao.PersonDao;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/add")
    public String addPersonFormModel(Model model) {
        model.addAttribute("author", new Author());
        return "author/add";
    }

    @PostMapping("/add")
    public String addPersonPerform(@ModelAttribute @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author/add";
        }
        authorDao.save(author);
        return "added";
    }
}
