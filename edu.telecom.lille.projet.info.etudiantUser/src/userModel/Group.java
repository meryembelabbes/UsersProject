/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

import java.util.HashSet;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Group.
 * 
 * @author mac
 */
public class Group {
	/**
	 * Description of the property groupId.
	 */
	public String groupId = "";

	/**
	 * Description of the property students.
	 */
	public HashSet<Student> students = new HashSet<Student>();

	/**
	 * Description of the property NbStud.
	 */
	public Integer NbStud = Integer.valueOf(0);

	/**
	 * Description of the property userDBs.
	 */
	public HashSet<UserDB> userDBs = new HashSet<UserDB>();

	// Start of user code (user defined attributes for Group)

	// End of user code

	/**
	 * The constructor.
	 */
	public Group() {
		// Start of user code constructor for Group)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Group)

	// End of user code
	/**
	 * Returns groupId.
	 * @return groupId 
	 */
	public String getGroupId() {
		return this.groupId;
	}

	/**
	 * Sets a value to attribute groupId. 
	 * @param newGroupId 
	 */
	public void setGroupId(String newGroupId) {
		this.groupId = newGroupId;
	}

	/**
	 * Returns students.
	 * @return students 
	 */
	public HashSet<Student> getStudents() {
		return this.students;
	}

	/**
	 * Returns NbStud.
	 * @return NbStud 
	 */
	public Integer getNbStud() {
		return this.NbStud;
	}

	/**
	 * Sets a value to attribute NbStud. 
	 * @param newNbStud 
	 */
	public void setNbStud(Integer newNbStud) {
		this.NbStud = newNbStud;
	}

	/**
	 * Returns userDBs.
	 * @return userDBs 
	 */
	public HashSet<UserDB> getUserDBs() {
		return this.userDBs;
	}

}
