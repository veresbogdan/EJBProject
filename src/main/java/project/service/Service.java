package project.service;

import project.dao.Dao;
import project.model.Book;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class Service {

    @EJB
    private Dao dao;

    public String getText() {
        return "Hello World!";
    }

    public List<Book> findAllBooks() {
        return dao.findAll(Book.class);
    }
}
