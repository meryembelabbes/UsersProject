/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import userModel.User;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Teacher.
 * 
 * @author mac
 */
public class Teacher extends User {
	/**
	 * Description of the property contrainteHoraires.
	 */
	
//	public HashSet<TimeConstraint> contrainteHoraires = new HashSet<TimeConstraint>();

	/**
	 * Description of the property teacherId.
	 */
	public String teacherId = "";

	// Start of user code (user defined attributes for Teacher)

	// End of user code

	/**
	 * The constructor.
	 */
	public Teacher(String userSurname, String userName, String userLogin,String userPwd,int userId) {
		// Start of user code constructor for Teacher)
		super(userSurname, userName, userLogin, userPwd, userId);
		// End of user code
	}

	// Start of user code (user defined methods for Teacher)

	// End of user code
	/**
	 * Returns contrainteHoraires.
	 * @return contrainteHoraires 
	 */
//	public HashSet<TimeConstraint> getContrainteHoraires() {
//		return this.contrainteHoraires;
//	}

	/**
	 * Returns teacherId.
	 * @return teacherId 
	 */
	public String getTeacherId() {
		return this.teacherId;
	}

	/**
	 * Sets a value to attribute teacherId. 
	 * @param newTeacherId 
	 */
	public void setTeacherId(String newTeacherId) {
		this.teacherId = newTeacherId;
	}

}
