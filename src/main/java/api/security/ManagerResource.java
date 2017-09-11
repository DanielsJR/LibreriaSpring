package api.security;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.Uris;

@RestController
@RequestMapping(Uris.VERSION + Uris.MANAGER)
public class ManagerResource {

    @RequestMapping(method = RequestMethod.GET)
    // @PreAuthorize("hasRole('MANAGER')")
    public String manager(String param) {
        return "{\"manager\":\"" + Uris.MANAGER + "\"}";
    }

}
