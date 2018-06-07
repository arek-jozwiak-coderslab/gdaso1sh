package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.repositories.BookRepository;
import pl.coderslab.repositories.CategoryRepository;
import pl.coderslab.repositories.PersonRepository;

@Controller
public class SampleRepositoryController {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;


    public SampleRepositoryController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;

    }

    @GetMapping("/sample-repo1")
    @ResponseBody
    public String sample1(){
        Category c = categoryRepository.findOne(1L);
        Book b = bookRepository.findByCategoryLimitOrderBy(c);
        return b.toString();
    }

    @GetMapping("/sample-repo2")
    @ResponseBody
    public String samples2(){
        bookRepository.resetRating(0);
        return "changed";
    }
}
