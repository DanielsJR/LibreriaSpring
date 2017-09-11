package api.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.Uris;

@RestController
@RequestMapping(Uris.VERSION + Uris.ALL)
public class AllResource {

    @RequestMapping(method = RequestMethod.GET)
    // @PreAuthorize("hasRole('ADMIN')")
    public String all(String param) {
       // return "{\"all\":\"" + Uris.ALL + "\"}";
        return "{\r\n  \"results\": [\r\n    \"Item 1\",\r\n    \"Item 2\",\r\n  ]\r\n}";
   
        
    }

}
