package userController;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import javax.print.DocFlavor.STRING;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import userModel.Admin;
import userModel.Group;
import userModel.Student;
import userModel.Teacher;
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
	public boolean addAdmin(String adminLogin, String newAdminlogin, int ID, String firstname, String surname,
			String pwd) {
		
		String adminID = Integer.toString(ID); 
		Admin userLogin = new Admin (newAdminlogin, adminID, firstname, surname, pwd);
		userDB.hm.put(newAdminlogin,userLogin);
		
		return false;
	}

	@Override
	public boolean addTeacher(String adminLogin, String newteacherLogin, int ID, String firstname,
			String surname, String pwd) {
		
		String teacherID = Integer.toString(ID); 
		Teacher userLogin = new Teacher (newteacherLogin, teacherID, firstname, surname, pwd);
		userDB.hm.put(newteacherLogin,userLogin);
		
		return false;
	}

	@Override
	public boolean addStudent(String adminLogin, String newStudentLogin, int ID, String firstname,
			String surname, String pwd) {
		
		String studentID = Integer.toString(ID); 
		Teacher userLogin = new Teacher (newStudentLogin, studentID, firstname, surname, pwd);
		userDB.hm.put(newStudentLogin,userLogin);
		
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
		
		return usersLogin;
	}

	@Override
	public String[] studentsLoginToString() {
		
		return null;
	}
	
	private String[] adminsLoginToString() {
		// TODO Auto-generated method stub
		return null;
	}

	private String[] teachersLoginToString() {
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
	private String getTeacherID(String teacherLogin) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getStudentID(String studentLogin) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getAdminID(String adminLogin) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getUserPwd(String userLogin) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getUserSurname(String userLogin) {
		// TODO Auto-generated method stub
		return null;
	}
	public UserDB getUserDB() {
		return userDB;
	}

	public void setUserDB(UserDB userDB) {
		this.userDB = userDB;

	}

	@Override
	public boolean loadDB() {
		//Creation
		
		org.jdom2.Document document = null;
		Element rootElt;
		
		//Read
		
		SAXBuilder sxb = new SAXBuilder();
		try{
			document = sxb.build(new File(UserDB.getFile()));
		}catch(Exception e){}
		
		//Translation
		
		if(document !=null){
			rootElt = document.getRootElement();
			
			//class admin
			
			List<Element> adminElts = rootElt.getChildren("Admin");
			Iterator<Element> itAdmin = adminElts.iterator();
			while (itAdmin.hasNext()){
				Element adminElt = (Element)itAdmin.next();
				String userLogin = adminElt.getChild("UserLogin").getText();
				String userName = adminElt.getChild("UserName").getText();
				String userSurname = adminElt.getChild("UserSurname").getText();
				String userPwd = adminElt.getChild("UserPwd").getText();
				String adminID= adminElt.getChild("AdminID").getText();
				Admin AdminID = new Admin (userSurname,userName,userLogin,userPwd,adminID);
				userDB.hm.put(userLogin,AdminID);
			}
			
			//class student
			
			List<Element> studentElts = rootElt.getChildren("Student");
			Iterator<Element> itStudent = studentElts.iterator();
			while (itStudent.hasNext()){
				Element studentElt = (Element)itStudent.next();
				String userLogin = studentElt.getChild("UserLogin").getText();
				String userName = studentElt.getChild("UserName").getText();
				String userSurname = studentElt.getChild("UserSurname").getText();
				String userPwd = studentElt.getChild("UserPwd").getText();
				String studentID= studentElt.getChild("StudentID").getText();
				Student StudentID = new Student (userSurname,userName,userLogin,userPwd,studentID);
				userDB.hm.put(userLogin,StudentID);
			}
			
			//class teacher
			
			List<Element> teacherElts = rootElt.getChildren("Teacher");
			Iterator<Element> itTeacher = teacherElts.iterator();
			while (itTeacher.hasNext()){
				Element teacherElt = (Element)itTeacher.next();
				String userLogin = teacherElt.getChild("UserLogin").getText();
				String userName = teacherElt.getChild("UserName").getText();
				String userSurname = teacherElt.getChild("UserSurname").getText();
				String userPwd = teacherElt.getChild("UserPwd").getText();
				String teacherID= teacherElt.getChild("TeacherID").getText();
				Teacher TeacherID = new Teacher (userSurname,userName,userLogin,userPwd,teacherID);
				userDB.hm.put(userLogin,TeacherID);
			}
			
			//group
			
			List<Element> groupElts = rootElt.getChildren("Group");
			Iterator<Element> itGroup = groupElts.iterator();
			while (itGroup.hasNext()){
				Element groupElt = (Element)itAdmin.next();
				String userLogin = groupElt.getChild("GroupID").getText();
				Group GroupID = new Group ();
				userDB.hg.put(userLogin,GroupID);
			}
		}
		return false;
	}

	@Override
	public boolean saveDB() {
		String[] studentsLogin = studentsLoginToString();
		String[] adminsLogin = adminsLoginToString(); 
		String[] teachersLogin = teachersLoginToString();
//		String[] groupsID = groupsIdToString();
		
		//Translation
		Element rootElt = new Element ("UserBD");
		Document document = new Document(rootElt);
//			Element groups = new Element ("Groups");
//			//Loop for groups
//			for(int i = 0; i<groupsID.length; i++) { 
//				Element group = new Element ("Group");
//					Element groupID = new Element("GroupID"); 
//						groupID.setText(groupsID[i]);
//					group.addContent(groupID);
//					 
//					
//					
//				groups.addContent(group);
//			}
//			rootElt.addContent(groups);
			
			Element admins = new Element("Admins");
			//Loop for admins
			for (int i = 0; i<adminsLogin.length; i++) {
				Element admin = new Element ("Admin");
					Element userLogin = new Element ("UserLogin");
						userLogin.setText(adminsLogin[i]);
					admin.addContent(userLogin);
					Element userName = new Element ("UserName");
						userName.setText(getUserName(adminsLogin[i]));
					admin.addContent(userName);
					Element userSurname = new Element ("UserSurname");
						userSurname.setText(getUserSurname(adminsLogin[i]));
					admin.addContent(userSurname);
					Element userPwd = new Element ("UserPwd");
						userPwd.setText(getUserPwd(adminsLogin[i]));
					admin.addContent(userPwd);
					Element adminID = new Element ("AdminID");
						adminID.setText(getAdminID(adminsLogin[i]));
					admin.addContent(adminID);
				admins.addContent(admin);
			}
			rootElt.addContent(admins);
			
			Element students = new Element ("Student");
			//Loop for students
			for (int i = 0; i<studentsLogin.length; i++) {
				Element student = new Element ("Student");
					Element userLogin = new Element ("UserLogin");
						userLogin.setText(studentsLogin[i]);
					student.addContent(userLogin);
					Element userName = new Element ("UserName");
						userName.setText(getUserName(studentsLogin[i]));
					student.addContent(userName);
					Element userSurname = new Element ("UserSurname");
						userSurname.setText(getUserSurname(studentsLogin[i]));
					student.addContent(userSurname);
					Element userPwd = new Element ("UserPwd");
						userPwd.setText(getUserPwd(studentsLogin[i]));
					student.addContent(userPwd);
					Element studentID = new Element ("StudentID");
						studentID.setText(getStudentID(studentsLogin[i]));
					student.addContent(studentID);
				students.addContent(student);
			}
			rootElt.addContent(students);
			
			Element teachers = new Element ("Teachers");
			//Loop for teachers
			for (int i = 0; i<teachersLogin.length; i++) {
				Element teacher = new Element ("Teacher");
					Element userLogin = new Element ("UserLogin");
						userLogin.setText(teachersLogin[i]);
					teacher.addContent(userLogin);
					Element userName = new Element ("UserName");
						userName.setText(getUserName(teachersLogin[i]));
					teacher.addContent(userName);
					Element userSurname = new Element ("UserSurname");
						userSurname.setText(getUserSurname(teachersLogin[i]));
					teacher.addContent(userSurname);
					Element userPwd = new Element ("UserPwd");
						userPwd.setText(getUserPwd(teachersLogin[i]));
					teacher.addContent(userPwd);
					Element teacherID = new Element ("TeacherID");
						teacherID.setText(getTeacherID(teachersLogin[i]));
					teacher.addContent(teacherID);
				teachers.addContent(teacher);
			}
			rootElt.addContent(teachers);
			//Write
			try{
				XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
				sortie.output(document, new FileOutputStream(UserDB.getFile()));
			}catch (java.io.IOException e){}
		return false;
	}
}

