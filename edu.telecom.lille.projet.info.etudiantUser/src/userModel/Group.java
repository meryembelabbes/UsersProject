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
	private String groupId = "";

	/**
	 * Description of the property students.
	 */
	private HashSet<String> students = new HashSet<String>();

	/**
	 * Description of the property NbStud.
	 */
	private Integer NbStud = 0;



	/**
	 * The constructor.
	 */
	public Group(String groupId) {
		// Start of user code constructor for Group)
		super();
		this.groupId=groupId;
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
	public HashSet<String> getStudents(){
		return this.students;
	}
	
	public void setStudents(HashSet<String> newStudents){
		this.students = newStudents;
	}

	public void addStudent(String studentLogin) {
		this.NbStud +=1;
		students.add(studentLogin);
	}
	public void removeStudent(String studentLogin) {
		this.NbStud -=1;
		students.remove(studentLogin);
	}
	public boolean contains(String studentLogin){
		if (students.contains(studentLogin)){
		return true;
		}
		return false;
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
}
