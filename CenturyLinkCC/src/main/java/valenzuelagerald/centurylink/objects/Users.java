package valenzuelagerald.centurylink.objects;

import java.util.List;

import lombok.Data;

@Data
public class Users {
	
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString(){
		return "User{ login=" + users + "}";
	}
}
