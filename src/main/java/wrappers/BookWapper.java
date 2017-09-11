package wrappers;

import java.util.List;

import entities.Author;
import entities.Theme;

public class BookWapper {

    private int id;

    private String title;

    private List<Author> authorList;

    private List<Theme> themeList;

    public BookWapper(int id, String title, List<Author> authorList, List<Theme> themeList) {
        super();
        this.id = id;
        this.title = title;
        this.authorList = authorList;
        this.themeList = themeList;
    }

    public BookWapper() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public List<Theme> getThemeList() {
        return themeList;
    }

    public void setThemeList(List<Theme> themeList) {
        this.themeList = themeList;
    }

    @Override
    public String toString() {
        return "BookWapper [id=" + id + ", title=" + title + ", authorList=" + authorList + ", themeList=" + themeList + "]";
    }

}
