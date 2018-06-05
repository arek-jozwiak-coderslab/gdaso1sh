package pl.coderslab.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.Student;
import pl.coderslab.pl.coderslab.dao.PersonDao;

@Controller
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/person-add")
    public String addPersonForm(){
        return "person/form";
    }

    @PostMapping("/person-add")
    @ResponseBody
    public String addPersonPerform(@RequestParam String login, @RequestParam String password,
                                   @RequestParam String email){
        Person person = new Person();
        person.setEmail(email);
        person.setLogin(login);
        person.setPassword(password);
        personDao.save(person);
        return "added";
    }

    @GetMapping("/person-add-model")
    public String addPersonFormModel(Model model){
        model.addAttribute("person", new Person());
        return "person/form-model";
    }

    @PostMapping("/person-add-model")
    @ResponseBody
    public String addPersonPerform(@ModelAttribute Person person){
        personDao.save(person);
        return "added";
    }
}
