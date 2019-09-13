package pl.coderslab.service;

import pl.coderslab.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(long id);
    Book update(Book book);
    Book create(Book book);
    boolean delete(Book book);
}
