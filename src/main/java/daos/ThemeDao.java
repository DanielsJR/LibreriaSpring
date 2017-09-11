package daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Theme;

public interface ThemeDao extends JpaRepository<Theme,Integer>{
	
	List<String> findByName(String name);

}
