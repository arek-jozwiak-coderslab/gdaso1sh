package pl.coderslab.pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Person;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

    Author findByFirstName(String firstName);

    List<Author> findAllByLastName(String lastName);
    List<Author> findAllByLastNameAndFirstName(String lastName, String firstName);


    @Query("select u from Author u where u.firstName = ?1")
    Author findBySomething(String firstName);


    @Query("select u from Author u where u.firstName = :firstname or            u.lastName = :lastname")
    Author findByLastnameOrFirstname(@Param("lastname") String lastname,   @Param("firstname") String firstname);

}
