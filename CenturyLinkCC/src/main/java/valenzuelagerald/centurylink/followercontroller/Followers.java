package valenzuelagerald.centurylink.followercontroller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import valenzuelagerald.centurylink.objects.User;

@RestController
@RequestMapping(path = "/users")
public class Followers {

	@Autowired
	private RestTemplate rest;

	@GetMapping(path = "{user}/following", produces = "application/json")
	public ResponseEntity<User[]> getFollowers(@PathVariable("user") String user) {

		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>(headers);
	    
		ResponseEntity<User[]> object = rest.exchange("https://api.github.com/users/{user}/followers?per_page=5", HttpMethod.GET, entity, User[].class, user);

		return object;
	}

}
