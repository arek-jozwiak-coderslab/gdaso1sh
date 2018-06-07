package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.pl.coderslab.repositories.BookRepository;
import pl.coderslab.pl.coderslab.repositories.CategoryRepository;

@Controller
public class SampleRepositoryController {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public SampleRepositoryController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/sample-repo")
    @ResponseBody
    public String samples(){
        Category c = categoryRepository.findOne(1L);
        Book b = bookRepository.findByCategoryLimitOrderBy(c);
        return b.toString();
    }
}
