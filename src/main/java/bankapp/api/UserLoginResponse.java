package bankapp.api;

public class UserLoginResponse extends BaseResponse{
	


	
	private String sessionKey;
	
	private status status;
	
	private String username;

	
	
	
	
	
	public String getSessionKey() {
		return sessionKey;
	}






	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}






	public status getStatus() {
		return status;
	}






	public void setStatus(status status) {
		this.status = status;
	}






	public String getUsername() {
		return username;
	}






	public void setUsername(String username) {
		this.username = username;
	}






	@Override
	public String toString() {
		return "UserLoginResponse [sessionKey=" + sessionKey + ", status=" + status + ", username=" + username
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

	
}
