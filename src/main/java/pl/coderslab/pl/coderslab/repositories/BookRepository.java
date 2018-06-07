package pl.coderslab.pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;

public interface BookRepository extends JpaRepository<Book, Long>{

    @Query(value="SELECT * FROM book WHERE category_id = ?1 LIMIT 1", nativeQuery = true)
    Book findByCategoryLimitOrderBy(Category category);
}
