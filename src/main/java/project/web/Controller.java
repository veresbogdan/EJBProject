package project.web;

import project.model.Book;
import project.service.Service;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class Controller {

    @EJB
    private Service service;

    public String getText() {
        return service.getText();
    }

    public List<Book> getAllBooks() {
        return service.findAllBooks();
    }
}
