package api.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.Uris;

@RestController
@RequestMapping(Uris.VERSION + Uris.AUTHENTICATED)
public class AuthenticatedResource {

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('AUTHENTICATED')")
    public String authenticated(String param) {
        return "{\"authenticated\":\"" + Uris.AUTHENTICATED + "\"}";
    }

}
