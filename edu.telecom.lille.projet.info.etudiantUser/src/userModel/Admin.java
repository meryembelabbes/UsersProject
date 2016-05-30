/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import userModel.User;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Admin.
 * 
 * @author mac
 */
public class Admin extends User {
	/**
	 * Description of the property adminId.
	 */
	public String adminId;
	// Start of user code (user defined attributes for Admin)

	// End of user code

	/**
	 * The constructor.
	 */
	public Admin(String userSurname, String userName, String userLogin,String userPwd,String newId) {
		// Start of user code constructor for Admin)
		super(userSurname,userName,userLogin,userPwd);
		this.adminId = newId;
		// End of user code
	}
	
	/**
	 * Returns adminId.
	 * @return adminId 
	 */
	public String getAdminId() {
		return this.adminId;
	}

	/**
	 * Sets a value to attribute adminId. 
	 * @param newAdminId 
	 */
	public void setAdminId(String newAdminId) {
		this.adminId = newAdminId;
	}

}
