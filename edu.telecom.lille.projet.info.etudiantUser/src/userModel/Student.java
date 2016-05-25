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
	 * Description of the property studentId.
	 */
	public String studentId = "";

	/**
	 * Description of the property studentGroupId.
	 */
	public String studentGroupId = "";

	// Start of user code (user defined attributes for Student)

	// End of user code

	/**
	 * The constructor.
	 */
	public Student() {
		// Start of user code constructor for Student)
		super();
		// End of user code
	}

	/**
	 * Description of the method getStudentGroup.
	 */
	public void getStudentGroup() {
		// Start of user code for method getStudentGroup
		// End of user code
	}

	// Start of user code (user defined methods for Student)

	// End of user code
	/**
	 * Returns studentId.
	 * @return studentId 
	 */
	public String getStudentId() {
		return this.studentId;
	}

	/**
	 * Sets a value to attribute studentId. 
	 * @param newStudentId 
	 */
	public void setStudentId(String newStudentId) {
		this.studentId = newStudentId;
	}

	/**
	 * Returns studentGroupId.
	 * @return studentGroupId 
	 */
	public String getStudentGroupId() {
		return this.studentGroupId;
	}

	/**
	 * Sets a value to attribute studentGroupId. 
	 * @param newStudentGroupId 
	 */
	public void setStudentGroupId(String newStudentGroupId) {
		this.studentGroupId = newStudentGroupId;
	}

}
