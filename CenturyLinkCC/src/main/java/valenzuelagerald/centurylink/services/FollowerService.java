package valenzuelagerald.centurylink.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import valenzuelagerald.centurylink.App;
import valenzuelagerald.centurylink.objects.User;
import valenzuelagerald.centurylink.objects.Users;

@Service
public class FollowerService {

	private Users allUsers;

	@Autowired
	private static final Logger log = LoggerFactory.getLogger(App.class);
	@Autowired
	private RestTemplate rest;

	public ResponseEntity<Users> getFollowersFromGitHub(String user) {

		List<User> list = new ArrayList<>();
		allUsers = new Users();
		allUsers.setUsers(list);
		
		int count = 0;

		List<User> object = sendExchange(user);

		checkObjectForUsers(object, count);
		
		return new ResponseEntity<Users>(allUsers, HttpStatus.ACCEPTED);
	}

	private List<User> sendExchange(String user) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<User[]> response = rest.getForEntity("https://api.github.com/users/{user}/followers?per_page=5",
				User[].class, user);

		return Arrays.asList(response.getBody());
	}

	private void checkObjectForUsers(List<User> object, int count) {
		List<String> names = new ArrayList<>();

		if (count > 2) {
			return;
		} else {

			for (int i = 0; i < object.size(); i++) {
				allUsers.getUsers().add(object.get(i));

				String currentUsersFollower = object.get(i).toString();
				int index = currentUsersFollower.indexOf("login=");
				int end = currentUsersFollower.indexOf(",");
				String loginName = currentUsersFollower.substring(index + 6, end);
				names.add(loginName);
				
				List<User> nextLevelObject = sendExchange(loginName);
				checkObjectForUsers(nextLevelObject, count + 1);
			}
		}
		return;
	}

}
