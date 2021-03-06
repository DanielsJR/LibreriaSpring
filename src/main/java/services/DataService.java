package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.AuthorDao;
import daos.BookDao;
import daos.StyleDao;
import daos.ThemeDao;
import daos.users.AuthorizationDao;
import daos.users.TokenDao;
import daos.users.UserDao;

@Service
public class DataService {

    @Autowired
    private Populate populate;

    @Autowired
    private AuthorizationDao authorizationDao;

    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private BookDao bookDao;
    
    @Autowired
    private ThemeDao themeDao;
    
    @Autowired
    private AuthorDao authorDao;
    
    @Autowired
    private StyleDao styleDao;


    public void deleteAllExceptAdmin() {

        authorizationDao.deleteAll();
        tokenDao.deleteAll();
        userDao.deleteAll();
        
        bookDao.deleteAll();
        themeDao.deleteAll();
        authorDao.deleteAll();
        styleDao.deleteAll();

        populate.createDefaultAdmin();
       
    }

}
