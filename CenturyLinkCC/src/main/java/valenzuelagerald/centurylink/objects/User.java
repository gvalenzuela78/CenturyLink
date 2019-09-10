package valenzuelagerald.centurylink.objects;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class User {

	private String login;
	private long id;
	private String node_id;
	private String avatar_url;
	private String gravatar_id;
	private String url;
	private String html_url;
	private String followers_url;
	private String following_url;
	private String gists_url;
	private String starred_url;
	private String subscriptions_url;
	private String organizations_url;
	private String repos_url;
	private String events_url;
	private String received_events_url;
	private String type;
	private boolean site_admin;

	@Override
	public String toString() {
		return "User{ login=" + login + ", id=" + id + ", node_id=" + node_id + ", avatar_url=" + avatar_url
				+ ", gravatar_id=" + gravatar_id + ", url=" + url + ", html_url=" + html_url + ", followers_url="
				+ followers_url + ", following_url=" + following_url + ", gists_url=" + gists_url + ", starred_url="
				+ starred_url + ", subscriptions_url=" + subscriptions_url + ", organizations_url=" + organizations_url
				+ ", repos_url=" + repos_url + ", events_url=" + events_url + ", received_events_url="
				+ received_events_url + ", type=" + type + ", site_admin=" + site_admin + "}";
	}
}
