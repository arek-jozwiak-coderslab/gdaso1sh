package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.dao.BookRepoCustom;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepoCustom {

    //1.1
    List<Book> findByTitleEquals(String title);
    //1.2
    List<Book> findBooksByCategory(Category category);

    @Query(value="SELECT * FROM book WHERE category_id = ?1 LIMIT 1", nativeQuery = true)
    Book findByCategoryLimitOrderBy(Category category);


}
