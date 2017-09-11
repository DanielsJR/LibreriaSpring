package daos;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class LibraryIT {

    @Autowired
    private DaosLibraryServiceIntegrationTest daosLibraryServiceIntegrationTest;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private StyleDao styleDao;
    
    @Autowired
    private ThemeDao themeDao;

    @Before
    public void populate() {
        daosLibraryServiceIntegrationTest.populate();
    }

    @Test
    public void testPopulate() {
        assertTrue(4 == bookDao.count());
    }

    
    @Test
    public void testFindByStyle() {
        assertEquals(2, authorDao.findByStyle(styleDao.findByNameIgnoreCase("Infantil")).size());
    }
    
    @Test
    public void testFindByTheme() {
        assertEquals(1, (themeDao.findByName("Drama")).size());
    }
        
    @Test
    public void testFindNameByStyleName() {
        assertEquals(2, authorDao.findNameByStyleName("Infantil").size());
        assertArrayEquals(new String[] {"Jesús", "Cris"}, authorDao.findNameByStyleName("Infantil").toArray());
    }
    
        @Test
    public void testFindDistinctNameByAnyBook(){
        assertEquals(3, authorDao.findDistinctNameByAnyBook().size());
        assertArrayEquals(new String[] {"Jesús", "Cris","Ana"}, authorDao.findDistinctNameByAnyBook().toArray());
    }
    
    @Test
    public void testFindNameByThemeName(){
        assertEquals(2, authorDao.findNameByThemeName("Suspense").size());
        assertArrayEquals(new String[] {"Cris","Ana"}, authorDao.findNameByThemeName("Suspense").toArray());
    }
    
    @Test
    public void findByTitleStartingWith(){
        assertEquals(2, bookDao.findByTitleStartingWith("El").size());
        assertArrayEquals(new String[] {"El pepino","El pepino II"}, bookDao.findByTitleStartingWith("El").toArray());
    }
    
    @Test
    public void findTitleByIdBetween(){
        assertEquals(1, bookDao.findTitleByIdBetween(1, 3).size());
        assertArrayEquals(new String[] {"La mazorca"}, bookDao.findTitleByIdBetween(1, 3).toArray());
    }
    
    @Test
    public void findByEstylo(){
       
        assertEquals(1, styleDao.findByNameStartingWith("In").size());
        assertArrayEquals(new String[] {"Infantil"}, styleDao.findByNameStartingWith("In").toArray());
    }



 
    @After
    public void deleteAll() {
        daosLibraryServiceIntegrationTest.deleteAll();
    }
    

}