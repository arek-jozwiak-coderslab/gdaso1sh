package pl.coderslab.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Person;
import pl.coderslab.pl.coderslab.dao.AuthorDao;
import pl.coderslab.pl.coderslab.dao.PersonDao;
import pl.coderslab.pl.coderslab.repositories.AuthorRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @GetMapping("/test")
    @ResponseBody
    public String test(Model model) {
        Author a1 = authorRepository.findOne(1L);
        Author a2 = authorRepository.findByFirstName("arek");
        return "test";
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
        authorRepository.save(author);
        return "added";
    }
}
