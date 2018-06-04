package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;
import pl.coderslab.pl.coderslab.dao.BookDao;


@Controller
public class BookController {

    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/add-book")
    @ResponseBody
    public String addBook() {
        Book b = new Book("Thinking in Java", "Bruce Eckel",
                "123321", "hard");

        bookDao.save(b);
        return "added";
    }

    @GetMapping("/update-book/{id}")
    @ResponseBody
    public String updateBook(@PathVariable long id) {
        Book b = bookDao.findById(id);
        b.setTitle("New title");
        bookDao.update(b);
        return "updated";
    }
}