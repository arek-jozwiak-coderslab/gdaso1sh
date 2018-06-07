package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Author;
import pl.coderslab.dao.AuthorDao;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorDao authorDao;


    @Override
    public Author convert(String s) {
        return authorDao.findById(Long.parseLong(s));
    }

}
