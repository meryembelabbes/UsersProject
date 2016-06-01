package userController;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import userModel.Admin;
import userModel.UserDB;
/**
 * Cette classe est le contrôleur d'utilisateurs que vous devez implémenter. 
 * Elle contient un attribut correspondant à la base de données utilisateurs que vous allez créer.
 * Elle contient toutes les fonctions de l'interface IUserController que vous devez implémenter.
 * 
 * @author Jose Mennesson (Mettre à jour)
 * @version 04/2016 (Mettre à jour)
 * 
 */

//TODO Classe à modifier

public class UserController implements IUserController
{
	
	/**
	 * Contient une instance de base de données d'utilisateurs
	 * 
	 */
	private UserDB userDB=null;
	
	
	/**
	 * Constructeur de controleur d'utilisateurs créant la base de données d'utilisateurs
	 * 
	 * @param file
	 * 		Fichier XML contenant la base de données d'utilisateurs
	 */
	public UserController(String file){
		UserDB userDB=new UserDB(file);
		this.setUserDB(userDB);
	}

	@Override
	public String getUserName(String userLogin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserClass(String userLogin, String userPwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getStudentGroup(String studentLogin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addAdmin(String adminLogin, String newAdminlogin, int adminID, String firstname, String surname,
			String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTeacher(String adminLogin, String newteacherLogin, int teacherID, String firstname,
			String surname, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addStudent(String adminLogin, String newStudentLogin, int studentID, String firstname,
			String surname, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeUser(String adminLogin, String userLogin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addGroup(String adminLogin, int groupId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeGroup(String adminLogin, int groupId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean associateStudToGroup(String adminLogin, String studentLogin, int groupId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] usersToString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] usersLoginToString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] studentsLoginToString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] groupsIdToString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] groupsToString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loadDB() {
		// TODO Auto-generated method stub
		org.jdom2.Document document = null;
		Element rootElt;
		SAXBuilder sxb = new SAXBuilder();
		try{
			document = sxb.build(new File(UserDB.getFile()));
		}catch(Exception e){}
		if(document !=null){
			rootElt = document.getRootElement();
			List<Element> adminElts = rootElt.getChildren("Admin");
			Iterator<Element> itAdmin = adminElts.iterator();
			while (itAdmin.hasNext()){
				Element unAdminElt = (Element)itAdmin.next();
				String userLogin = unAdminElt.getChildText("userLogin").getText();
				String userName = unAdminElt.getChildText("userName").getText();
				String userSurname = unAdminElt.getChildText("userSurname").getText();
				String userPwd = unAdminElt.getChildText("userPwd").getText();
				String adminID= unAdminElt.getChildText("adminID").getText();
				Admin Userlogin = new Admin (userSurname,userName,userLogin,userPwd,adminID);
				userDB.hm.put(userLogin,Userlogin);
			}
		}
		return false;
	}

	@Override
	public boolean saveDB() {
		// TODO Auto-generated method stub
		org.jdom2.Document document = null;
		
		try{
			XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
			sortie.output(document, new FileOutputStream(UserDB.getFile()));
			}catch (java.io.IOException e){}
		
		
		
		return false;
	}

	public UserDB getUserDB() {
		return userDB;
	}

	public void setUserDB(UserDB userDB) {
		this.userDB = userDB;

	}
	
	

}

