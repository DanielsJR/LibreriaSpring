package daos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Style;

public interface StyleDao extends JpaRepository<Style,Integer>{

	Style findByNameIgnoreCase(String name);
	
	@Query("select s.name from Style s where s.name like ?1%")
	List<String> findByNameStartingWith(String prefix);
	
	 
	
}
