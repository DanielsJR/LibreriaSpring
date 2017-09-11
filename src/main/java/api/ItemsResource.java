package api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uris.VERSION + Uris.ITEMS)
public class ItemsResource {
    
    @RequestMapping(method = RequestMethod.GET)
    public String results(String param) {
      
        return "{\r\n\t\"results\": [\r\n\t\t\"Item 1\",\r\n\t\t\"Item 2\"\r\n\t]\r\n}";
        //return "{\r\n  \"results\":  \"Item 1\"\r\n}";
   
        
    }

}
