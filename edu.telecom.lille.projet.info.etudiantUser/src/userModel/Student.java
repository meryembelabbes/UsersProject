/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import userModel.User;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Student.
 * 
 * @author mac
 */
public class Student extends User {
	/**
	 * Description of the property studentGroupId.
	 */
	public String studentGroupId = "0";

	// Start of user code (user defined attributes for Student)

	// End of user code

	/**
	 * The constructor.
	 */
	public Student(String userSurname, String userName, String userLogin,String userPwd, int userId) {
		// Start of user code constructor for Student)
		super(userSurname, userName, userLogin, userPwd, userId);
		// End of user code
	}
	// Start of user code (user defined methods for Student)

	// End of user code
	
	/**
	 * Returns studentGroupId.
	 * @return studentGroupId 
	 */
	public String getStudentGroupId() {
		return this.studentGroupId;
	}
	public void setStudentGroupId( String newstudentGroupId) {
		this.studentGroupId = newstudentGroupId;
	}
}
