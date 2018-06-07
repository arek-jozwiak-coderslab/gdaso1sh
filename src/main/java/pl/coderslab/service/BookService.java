package pl.coderslab.service;


import org.springframework.stereotype.Component;
import pl.coderslab.entity.Book;
import pl.coderslab.dao.BookDao;

@Component
public class BookService {

    private final BookDao bookDao;
    private final EmailService emailService;

    public BookService(BookDao bookDao, EmailService emailService) {
        this.bookDao = bookDao;
        this.emailService = emailService;
    }

    public void addBook(Book book){
        bookDao.save(book);
        emailService.sendEmail();
    }
}
