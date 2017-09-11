package api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Uris.VERSION)
public class VersionResource {

	@RequestMapping(method = RequestMethod.GET)
	public String version(String param) {
		return "{\"version\":\"" + Uris.VERSION + "\"}";
	}


}