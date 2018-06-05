package pl.coderslab.pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import pl.coderslab.entity.Author;
import pl.coderslab.pl.coderslab.dao.AuthorDao;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorDao authorDao;


    @Override
    public Author convert(String s) {
        return authorDao.findById(Long.parseLong(s));
    }

}
