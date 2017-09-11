package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import entities.Author;
import entities.Style;


public interface AuthorDao extends JpaRepository<Author,Integer> {

	//por nombre de metodos (consutas y borrados)
    List<Author> findByStyle(Style style);

   // @Query("select author.name from Author author where author.style.name = ?1")
      @Query("select a.name from Author a where a.style.name = ?1")
    List<String> findNameByStyleName(String styleName);
    
        //("select distinct author.name from Book book join book.authorList author")
    @Query("select distinct a.name from Book b join b.authorList a")  //donde   a=(Author)b.authorList
    List<String> findDistinctNameByAnyBook();
        
        //("select author.name from Book book join book.authorList author join book.themeList theme where theme.name = ?1")
    @Query("select a.name from Book b join b.authorList a join b.themeList t where t.name = ?1") // donde b=Book y a=(Author)b.authorList
    List<String> findNameByThemeName(String themeName);

	

	
}
