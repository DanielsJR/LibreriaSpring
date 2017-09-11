package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Book;
import entities.Theme;


public interface BookDao extends JpaRepository<Book,Integer>{
	
	
 
	
	//Consulta: SQL
	//@Query(value ="select title from Book where title like ?1", nativeQuery = true)
	 List<String> findByTitle(String title);
	 
		
	 @Query("select b.title from Book b where b.title like ?1%")
	 List<String> findByTitleStartingWith(String title);
	 
	 @Query("select b.title from Book b where b.id > ?1 and b.id < ?2")
	 List<String> findTitleByIdBetween(int initial, int end);
	 
	 

}
