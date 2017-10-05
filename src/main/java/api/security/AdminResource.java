package api.security;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.Uris;

@RestController
@RequestMapping(Uris.VERSION+ Uris.ADMIN)
public class AdminResource {


    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(String param) {
        return "{\"admin\":\"" + Uris.ADMIN + "\"}";
    }

}

