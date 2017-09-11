package api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import controllers.BookController;
import wrappers.BookWapper;

@RestController
@RequestMapping(Uris.VERSION + Uris.BOOKS)
public class BookResource {

    private BookController bookController;
    
    
    @Autowired
	public void setBookController(BookController bookController) {
        this.bookController = bookController;
    }


    @RequestMapping(method = RequestMethod.GET)
	public List<BookWapper> bookList(String param) {
        return bookController.allBooks() ;
		
	}

}
