package valenzuelagerald.centurylink.objects;

import java.util.List;

import lombok.Data;

@Data

public class Users {
	
	private List<User> users;

	@Override
	public String toString(){
		return "User{ login=" + users + "}";
	}
}
