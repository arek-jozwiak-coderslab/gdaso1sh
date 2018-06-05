package pl.coderslab.pl.coderslab.dao;


import org.springframework.stereotype.Component;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Publisher> getAll(){
        Query q = entityManager.createQuery("SELECT b from Publisher b");
        return q.getResultList();
    }



}
