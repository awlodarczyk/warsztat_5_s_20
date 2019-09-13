package pl.coderslab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.domain.Book;
import pl.coderslab.exceptions.ServiceException;
import pl.coderslab.repository.BookDao;
import pl.coderslab.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao dao;

    @Autowired
    public BookServiceImpl(BookDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Book> findAll() {
        return dao.getList();
    }

    @Override
    public Book findById(long id) {
        Book book = dao.getList().stream().filter(item->item.getId()==id).findFirst().orElse(null);
        if(book==null){
            throw new ServiceException("Book is not found");
        }
        return book;
    }

    @Override
    public Book update(Book book) {
        for(int i=0;i<dao.getList().size();i++){
            if(dao.getList().get(i).getId().equals(book.getId())){
                dao.getList().set(i,book);
                break;
            }
        }
        return book;
    }

    @Override
    public Book create(Book book) {
        book.setId((long)dao.getList().size()+1);
        dao.getList().add(book);
        return book;
    }

    @Override
    public boolean delete(Book book) {
        return dao.getList().remove(book);
    }
}
