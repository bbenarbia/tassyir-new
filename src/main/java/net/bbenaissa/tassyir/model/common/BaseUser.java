package net.bbenaissa.tassyir.model.common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public class BaseUser extends BaseEntity {

	@Column(name = "first_name")
	@NotEmpty
	protected String firstName;

	@Column(name = "last_name")
	@NotEmpty
	protected String lastName;

	@Column(name = "login")
	@NotEmpty
	protected String login;

	@Column(name = "password")
	@NotEmpty
	protected String password;

	@Column(name = "connected")
	protected Boolean connected;

	@Column(name = "locked")
	protected Boolean locked;

	@Column(name = "is_admin")
	protected Boolean isAdmin;

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getConnected() {
		return connected;
	}

	public void setConnected(Boolean connected) {
		this.connected = connected;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
