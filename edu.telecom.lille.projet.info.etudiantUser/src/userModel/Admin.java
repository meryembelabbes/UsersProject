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
	 * Description of the method addAdmin.
	 */
	public void addAdmin() {
		// Start of user code for method addAdmin
		// End of user code
	}

	/**
	 * Description of the method addTeacher.
	 */
	public void addTeacher() {
		// Start of user code for method addTeacher
		// End of user code
	}

	/**
	 * Description of the method addStudent.
	 */
	public void addStudent() {
		// Start of user code for method addStudent
		// End of user code
	}

	/**
	 * Description of the method addGroup.
	 */
	public void addGroup() {
		// Start of user code for method addGroup
		// End of user code
	}

	/**
	 * Description of the method removeUser.
	 */
	public void removeUser() {
		// Start of user code for method removeUser
		// End of user code
	}

	/**
	 * Description of the method removeGroup.
	 */
	public void removeGroup() {
		// Start of user code for method removeGroup
		// End of user code
	}

	/**
	 * Description of the method associateStudToGroup.
	 */
	public void associateStudToGroup() {
		// Start of user code for method associateStudToGroup
		// End of user code
	}

	// Start of user code (user defined methods for Admin)

	// End of user code
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
