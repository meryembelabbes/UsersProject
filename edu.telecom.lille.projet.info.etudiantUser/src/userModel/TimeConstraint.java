/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package userModel;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of TimeConstraint.
 * 
 * @author meryem
 */
public class TimeConstraint {
	/**
	 * Description of the property Id.
	 */
	public String Id = "";

	/**
	 * Description of the property teacherLogin.
	 */
	public String teacherLogin = "";

	/**
	 * Description of the property dateDebut.
	 */
	public String dateDebut = "";

	/**
	 * Description of the property dateFin.
	 */
	public String dateFin = "";

	/**
	 * Description of the property commentaire.
	 */
	public String commentaire = "";

	// Start of user code (user defined attributes for TimeConstraint)

	// End of user code

	/**
	 * The constructor.
	 */
	public TimeConstraint() {
		// Start of user code constructor for TimeConstraint)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for TimeConstraint)

	// End of user code
	/**
	 * Returns Id.
	 * @return Id 
	 */
	public String getId() {
		return this.Id;
	}

	/**
	 * Sets a value to attribute Id. 
	 * @param newId 
	 */
	public void setId(String newId) {
		this.Id = newId;
	}

	/**
	 * Returns teacherLogin.
	 * @return teacherLogin 
	 */
	public String getTeacherLogin() {
		return this.teacherLogin;
	}

	/**
	 * Sets a value to attribute teacherLogin. 
	 * @param newTeacherLogin 
	 */
	public void setTeacherLogin(String newTeacherLogin) {
		this.teacherLogin = newTeacherLogin;
	}

	/**
	 * Returns dateDebut.
	 * @return dateDebut 
	 */
	public String getDateDebut() {
		return this.dateDebut;
	}

	/**
	 * Sets a value to attribute dateDebut. 
	 * @param newDateDebut 
	 */
	public void setDateDebut(String newDateDebut) {
		this.dateDebut = newDateDebut;
	}

	/**
	 * Returns dateFin.
	 * @return dateFin 
	 */
	public String getDateFin() {
		return this.dateFin;
	}

	/**
	 * Sets a value to attribute dateFin. 
	 * @param newDateFin 
	 */
	public void setDateFin(String newDateFin) {
		this.dateFin = newDateFin;
	}

	/**
	 * Returns commentaire.
	 * @return commentaire 
	 */
	public String getCommentaire() {
		return this.commentaire;
	}

	/**
	 * Sets a value to attribute commentaire. 
	 * @param newCommentaire 
	 */
	public void setCommentaire(String newCommentaire) {
		this.commentaire = newCommentaire;
	}

}
