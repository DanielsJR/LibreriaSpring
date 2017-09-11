package api;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import daos.DaosLibraryServiceIntegrationTest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class BookResourceTest {

    private static final String url = "http://localhost:8080/LibreriaSpring.1.0.0/api/v0";
    
    @Autowired
    private DaosLibraryServiceIntegrationTest daosLibraryServiceIntegrationTest;
    
    @Before
    public void populate() {
        daosLibraryServiceIntegrationTest.populate();
    }


    @Test
    public void allBooks() {
        String all = new RestBuilder<String>(url).path(Uris.BOOKS).clazz(String.class).get().build();
        System.out.println("INFO >>>>> " + all);

    }
    
   @After
    public void deleteAll() {
        daosLibraryServiceIntegrationTest.deleteAll();
    }

}

