package beans;

public class Credentials {

	public Credentials(String username, String password, int employeeId) {
		super();
		this.username = username;
		this.password = password;
		this.employeeId = employeeId;
	}

	public Credentials(String username, int employeeId) {
		super();
		this.username = username;
		this.employeeId = employeeId;
	}

	public Credentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Credentials() {
		super();
	}

	private String username;
	private String password;
	private int employeeId;
	private boolean valid;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + (valid ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credentials other = (Credentials) obj;
		if (employeeId != other.employeeId)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (valid != other.valid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Credentials [username=" + username + ", password=" + password + ", employeeId=" + employeeId
				+ ", valid=" + valid + "]";
	}
}
