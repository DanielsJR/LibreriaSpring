package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Book {

	@Id
	@GeneratedValue
	private int id;
	
	private String isbn;
	
	private String title;
	
	@ManyToMany(fetch = FetchType.EAGER)
    private List<Author> authorList;
	
	@ManyToMany(fetch = FetchType.EAGER)
    private List<Theme> themeList;

	
	
	public Book(String isbn, String title, List<Author> authorList, List<Theme> themeList) {
		this.isbn = isbn;
		this.title = title;
		this.authorList = authorList;
		this.themeList = themeList;
	}

	public Book() {

	}

	public int getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public List<Author> getAuthor() {
		return authorList;
	}

	public void setAutor(List<Author> authorList) {
		this.authorList = authorList;
	}

	public List<Theme> getTheme() {
		return themeList;
	}

	public void setTheme(List<Theme> themeList) {
		this.themeList = themeList;
	}

    
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", authorList=" + authorList + ", themeList=" + themeList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
