package pl.coderslab.pl.coderslab.dao;


import org.springframework.stereotype.Component;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Person student) {
        entityManager.persist(student);
    }


}
