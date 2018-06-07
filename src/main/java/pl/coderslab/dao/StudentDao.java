package pl.coderslab.dao;


import org.springframework.stereotype.Component;
import pl.coderslab.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student) {
        entityManager.persist(student);
    }

    public Student findById(long id) {
        return entityManager.find(Student.class, id);
    }

}
