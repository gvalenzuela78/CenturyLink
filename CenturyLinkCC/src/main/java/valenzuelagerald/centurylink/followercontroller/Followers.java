package valenzuelagerald.centurylink.followercontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import valenzuelagerald.centurylink.App;
import valenzuelagerald.centurylink.objects.Users;
import valenzuelagerald.centurylink.services.FollowerService;

@RestController
@RequestMapping(path = "/users")
public class Followers {

	@Autowired
	private static final Logger log = LoggerFactory.getLogger(App.class);
	@Autowired
	private FollowerService followerService;

	@GetMapping(path = "{user}/followers", produces = "application/json")
	public ResponseEntity<Users> getFollowers(@PathVariable("user") String user) {

		return followerService.getFollowersFromGitHub(user);

	}

}
