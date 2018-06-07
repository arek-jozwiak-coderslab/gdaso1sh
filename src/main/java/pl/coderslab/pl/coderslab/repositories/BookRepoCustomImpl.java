package pl.coderslab.pl.coderslab.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BookRepoCustomImpl implements BookRepoCustom{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void resetRating(int rating) {

    }
}
