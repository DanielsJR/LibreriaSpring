package services;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import config.ResourceNames;
import daos.AuthorDao;
import daos.BookDao;
import daos.StyleDao;
import daos.ThemeDao;
import daos.users.AuthorizationDao;
import daos.users.UserDao;
import entities.Author;
import entities.Book;
import entities.Contact;
import entities.Style;
import entities.Theme;
import entities.users.Authorization;
import entities.users.Role;
import entities.users.User;

@Service
@Transactional
@PropertySource(ResourceNames.PROPERTIES)
public class Populate {

    private String adminUsername;

    private String adminEmail;

    private String adminPassword;

    private long adminMobile;
    
    
    @Autowired
    private Environment environment;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthorizationDao authorizationDao;
    
    
    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private StyleDao styleDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private ThemeDao themeDao;

    @PostConstruct
    public void readAdmin() {
        adminMobile = Long.valueOf(environment.getProperty("admin.mobile"));
        adminUsername = environment.getProperty("admin.username");
        adminEmail = environment.getProperty("admin.email");
        adminPassword = environment.getProperty("admin.password");
        createDefaultAdmin();
        populateDB();
    }

    public void createDefaultAdmin() {
        User adminSaved = userDao.findByMobile(adminMobile);
        if (adminSaved == null) {
            User admin = new User(adminMobile, adminUsername, adminPassword);
            admin.setEmail(adminEmail);
            userDao.save(admin);
            authorizationDao.save(new Authorization(admin, Role.ADMIN));
        }
    }
    
    public void populateDB() {
        Theme[] themeArray = { new Theme("Acción"), new Theme("Suspense"), new Theme("Drama") };
        themeDao.save(Arrays.asList(themeArray));

        Style[] styleArray = { new Style("Infantil", "Lectura sencilla"), new Style("Especializado", "Expertos de la temática") };
        styleDao.save(Arrays.asList(styleArray));

        Author[] authorArray = { 
                new Author("Jesús", "Ber", new Contact("j@gmail.com", 666666661), styleArray[0]),
                new Author("Cris", "Ber", new Contact("c@gmail.com", 666666662), styleArray[0]),
                new Author("Ana", "Ber", new Contact("a@gmail.com", 666666663), styleArray[1]),
                new Author("Ana", "Reb", new Contact("a2@gmail.com", 666666663), styleArray[1]),
                new Author("Pedra", "Reb", new Contact("p@gmail.com", 666666664), styleArray[1]),
                new Author("Juana", "Reb", new Contact("j@gmail.com", 666666665), styleArray[1]),
                new Author("Teresa", "Reb", new Contact("t@gmail.com", 666666666), styleArray[1]) };
        authorDao.save(Arrays.asList(authorArray));

        Book[] bookArray = {
                new Book("isbn1", "La flauta", Arrays.asList(authorArray[0]), Arrays.asList(themeArray[0], themeArray[2])),
                new Book("isbn2", "La mazorca", Arrays.asList(authorArray[1], authorArray[2]), Arrays.asList(themeArray[1])),
                new Book("isbn3", "El pepino", Arrays.asList(authorArray[2]), Arrays.asList(themeArray[0])),
                new Book("isbn4", "El pepino II", Arrays.asList(authorArray[2]), Arrays.asList(themeArray[0])) };
        bookDao.save(Arrays.asList(bookArray));
    }

}
