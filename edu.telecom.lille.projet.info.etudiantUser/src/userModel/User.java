/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of User.
 * 
 * @author meryem
 */
public class User {
	/**
	 * Description of the property userSurname.
	 */
	private String userSurname = new String();

	/**
	 * Description of the property UserName.
	 */
	private String userName = new String();

	/**
	 * Description of the property userLogin.
	 */
	private String userLogin = new String();

	/**
	 * Description of the property userPwd.
	 */
	private String userPwd = new String();
	
	private int userId;
	/**
	 * The constructor.
	 */
	public User(String userSurname, String userName, String userLogin,String userPwd,int userId) {
		// Start of user code constructor for User)
		//super();
		this.userName=userName;
		this.userSurname=userSurname;
		this.userLogin=userLogin;
		this.userPwd=userPwd;
		this.userId=userId;
		
		// End of user code
	}

	// Start of user code (user defined methods for User)

	// End of user code
	/**
	 * Returns userSurname.
	 * @return userSurname 
	 */
	public String getUserSurname() {
		return this.userSurname;
	}

	/**
	 * Sets a value to attribute userSurname. 
	 * @param newUserSurname 
	 */
	public void setUserSurname(String newUserSurname) {
		this.userSurname = newUserSurname;
	}

	/**
	 * Returns UserName.
	 * @return UserName 
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * Sets a value to attribute UserName. 
	 * @param newUserName 
	 */
	public void setUserName(String newUserName) {
		this.userName = newUserName;
	}

	/**
	 * Returns userLogin.
	 * @return userLogin 
	 */
	public String getUserLogin() {
		return this.userLogin;
	}

	/**
	 * Sets a value to attribute userLogin. 
	 * @param newUserLogin 
	 */
	public void setUserLogin(String newUserLogin) {
		this.userLogin = newUserLogin;
	}

	/**
	 * Returns userPwd.
	 * @return userPwd 
	 */
	public String getUserPwd() {
		return this.userPwd;
	}

	/**
	 * Sets a value to attribute userPwd. 
	 * @param newUserPwd 
	 */
	public void setUserPwd(String newUserPwd) {
		this.userPwd = newUserPwd;
	}
	
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int newUserId) {
		this.userId = newUserId;
	}
}
