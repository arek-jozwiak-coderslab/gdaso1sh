package pl.coderslab.pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
