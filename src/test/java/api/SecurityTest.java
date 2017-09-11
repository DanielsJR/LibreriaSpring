package api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class SecurityTest {
    private static final String url = "http://localhost:8080/LibreriaSpring.1.0.0/api/v0";



    @Test
    public void allRequest() {
        String all = new RestBuilder<String>(url).path(Uris.ALL).clazz(String.class).get().build();
        System.out.println("INFO >>>>> " + all);


    }

 
    @Test
    public void adminRequest() {
        String admin = new RestBuilder<String>(url).path(Uris.ADMIN).basicAuth("111", "111").clazz(String.class).get().build();
        System.out.println("INFO >>>>> " + admin);

    }

    @Test
    public void managerRequest() {
        String manager = new RestBuilder<String>(url).path(Uris.MANAGER).basicAuth("222", "222").clazz(String.class).get().build();
        System.out.println("INFO >>>>> " + manager);

    }
    
    @Test
    public void multiRoleRequest() {
        String admin = new RestBuilder<String>(url).path(Uris.ADMIN).basicAuth("333", "333").clazz(String.class).get().build();
        String manager = new RestBuilder<String>(url).path(Uris.MANAGER).basicAuth("333", "333").clazz(String.class).get().build();
        System.out.println("INFO >>>>> " + manager+" and "+admin);

    }
    
    /*
    @Test
    public void authenticatedRequest() {
        String autenticated = new RestBuilder<String>(url).path(Uris.AUTHENTICATED).clazz(String.class).get().build();
        System.out.println("INFO >>>>> " + autenticated);

    }*/

}
