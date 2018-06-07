package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepoCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void resetRating(int rating) {
        entityManager.createQuery("UPDATE Book SET rating = " + rating).executeUpdate();
    }
}
