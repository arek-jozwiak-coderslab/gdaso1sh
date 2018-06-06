package pl.coderslab.pl.coderslab.dao;


import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }


    public List<Author> getAll(){
        Query q = entityManager.createQuery("SELECT b from Author b");
        return q.getResultList();
    }


    public void save(Author author) {
        entityManager.persist(author);
    }


}
