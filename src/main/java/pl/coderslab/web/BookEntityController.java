package pl.coderslab.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.service.BookService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookEntityController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final BookService bookService;

    public BookEntityController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao, BookService bookService) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String toString(Model model) {
        model.addAttribute("books", bookDao.getAll());
        return "book/list";
    }

    @ModelAttribute("publishers")
    List<Publisher> getPublishers() {
        return publisherDao.getAll();
    }

    @ModelAttribute("authors")
    List<Author> getAuthors() {
        return authorDao.getAll();
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping("/add")
    public String perform(@ModelAttribute @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book/add";
        }
        bookService.addBook(book);
        return "redirect:/book/list";
    }

    @GetMapping("/update/{id}")
    public String showForm(Model model, @PathVariable long id) {
        Book b = bookDao.findByIdWithAuthors(id);
        model.addAttribute("book", b);
        return "book/update";
    }

    @GetMapping("/show/{id}")
    public String show(Model model, @PathVariable long id) {
        Book b = bookDao.findByIdWithAuthors(id);
        model.addAttribute("book", b);
        return "book/show";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute Book book) {
        bookDao.update(book);
        return "redirect:/book/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        bookDao.delete(bookDao.findById(id));
        return "redirect:/book/list";
    }
}
