package pl.coderslab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;

import java.util.Arrays;


@Controller
public class BookController {

    private final BookDao bookDao;
    private final AuthorDao authorDao;

    public BookController(BookDao bookDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    @GetMapping("/add-book")
    @ResponseBody
    public String addBook() {
        Book b = new Book();
        b.setTitle("Thinking in Java");
        bookDao.save(b);
        return "added";
    }

    @GetMapping("/add-book-with-author")
    @ResponseBody
    public String addBookWithAutor() {
        Book b = new Book();
        Author author = authorDao.findById(1l);

        b.setAuthors(Arrays.asList(author));

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
