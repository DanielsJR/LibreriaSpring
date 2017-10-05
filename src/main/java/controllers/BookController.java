package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import daos.BookDao;
import entities.Book;
import wrappers.BookWapper;

@Controller
public class BookController {

    private BookDao bookDao;

    @Autowired
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<BookWapper> allBooks() {
        List<BookWapper> booksList = new ArrayList<>();

        for (Book book : bookDao.findAll()) {
            booksList.add(new BookWapper(book.getId(), book.getTitle(), book.getAuthor(), book.getTheme()));
        }
        return booksList;
    }

}
