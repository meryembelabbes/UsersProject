/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import java.util.HashSet;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of User.
 * 
 * @author mac
 */
public class User {
	/**
	 * Description of the property userSurname.
	 */
	public String userSurname;

	/**
	 * Description of the property UserName.
	 */
	public String userName;

	/**
	 * Description of the property userLogin.
	 */
	public String userLogin;

	/**
	 * Description of the property userPwd.
	 */
	protected String userPwd;
	
	

	/**
	 * Description of the property userDBs.
	 */
	public HashSet<UserDB> userDBs = new HashSet<UserDB>();

	// Start of user code (user defined attributes for User)

	// End of user code

	/**
	 * The constructor.
	 */
	public User(String userSurname, String userName, String userLogin,String userPwd ) {
		// Start of user code constructor for User)
		super();
		this.userName=userName;
		this.userSurname=userSurname;
		this.userLogin=userLogin;
		this.userPwd=userPwd;
		
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

	/**
	 * Returns userDBs.
	 * @return userDBs 
	 */
	public HashSet<UserDB> getUserDBs() {
		return this.userDBs;
	}

}
