package userController;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import userModel.*;

/**
 * Cette classe est le contrôleur d'utilisateurs que vous devez implémenter. 
 * Elle contient un attribut correspondant à la base de données utilisateurs que vous allez créer.
 * Elle contient toutes les fonctions de l'interface IUserController que vous devez implémenter.
 * 
 * @author Jose Mennesson (Mettre à jour)
 * @version 04/2016 (Mettre à jour)
 * 
 */

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
			User user = userDB.getUser(userLogin);
		return user.getUserName() +" "+ user.getUserSurname();
	}

	@Override
	public String getUserClass(String userLogin, String userPwd) {
		User user = userDB.getUser(userLogin);
		if (user != null&&userPwd == user.getUserPwd()){
			if (user.getUserId()>0&&user.getUserId()<8001){
				return "Student";
			}
			else if (user.getUserId()<9001){
				return "Teacher";
			}
			else {
				return "Administrator";
				}
			}	
			return "";
	}

	@Override
	public int getStudentGroup(String studentLogin){
		if (userDB.containsUser(studentLogin)){
			User user = userDB.getUser(studentLogin);
			String studentPwd = user.getUserPwd();
			if (getUserClass(studentLogin,studentPwd)=="Student"){
				int groupid = Integer.parseInt(((Student) user).getStudentGroupId());
				return groupid;
			}
		}
		return -1;
	}

	@Override
	public boolean addAdmin(String adminLogin, String newAdminlogin, int userId, String firstname, String surname,
			String pwd) {
		//TODO
		
		if (!userDB.containsUser(newAdminlogin)){
		Admin admin = new Admin (surname, firstname, newAdminlogin, pwd, userId);
		userDB.addUser(admin);
		return true;
	}
	else{
		return false;
	}
	}

	@Override
	public boolean addTeacher(String adminLogin, String newteacherLogin, int userId, String firstname,
			String surname, String pwd) {
		//TODO
		
		if (!userDB.containsUser(newteacherLogin)){
			Teacher userLogin = new Teacher (surname, firstname, newteacherLogin, pwd, userId);
			userDB.addUser(userLogin);
			return true;
		}
		return false;
	}

	@Override
	public boolean addStudent(String adminLogin, String newStudentLogin, int userId, String firstname,
			String surname, String pwd) {
		//TODO
		
		Student userLogin = new Student (surname, firstname, newStudentLogin,  pwd, userId);
		userDB.addUser(userLogin);
		
		return false;
	}

	@Override
	public boolean removeUser(String adminLogin, String userLogin) {
		// TODO 
			if (userDB.containsUser(userLogin)&&userLogin!="su"){
				User user = userDB.getUser(userLogin);
				if (user.getUserId()<8001){
					if (Integer.parseInt(((Student) user).getStudentGroupId())!=0){
						userDB.removeUserGroup(((Student) user).getStudentGroupId(), userLogin);
					}
				}
				userDB.removeUser(userLogin);
			return true;
			}
		return false;
	}

	@Override
	public boolean addGroup(String adminLogin, int groupId) {
		// TODO
			if (!userDB.containsGroup(String.valueOf(groupId))){
				String id = String.valueOf(groupId);
				Group group = new Group(id);
				userDB.addGroup(group);
				return true;
			}
			return false;

	}

	@Override
	public boolean removeGroup(String adminLogin, int groupId) {
		// TODO
			if (userDB.containsGroup(String.valueOf(groupId))){
				Group group = userDB.getGroup(String.valueOf(groupId));
				HashSet<String> students = group.getStudents();
				Iterator<String> itStudents = students.iterator();
				while (itStudents.hasNext()){
					String studentLog = itStudents.next();
					Student student = (Student)userDB.getUser (studentLog);
					student.setStudentGroupId("0");
				}
				userDB.removeGroup(String.valueOf(groupId));
				return true;
			}
			return false;
	}

	@Override
	public boolean associateStudToGroup(String adminLogin, String studentLogin, int groupId) {

		Group group = userDB.getGroup(String.valueOf(groupId));
		if (group!=null){
			if(!group.contains(studentLogin)){
				Student student = (Student) userDB.getUser(studentLogin);
				if (student!=null){
					if (student.getStudentGroupId()!="0"){
						
					}
					student.setStudentGroupId(String.valueOf(groupId));
					group.addStudent(studentLogin);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String[] usersToString() {
		Set<String>keySet = userDB.userKeySet();
		String[] keys = keySet.toArray(new String[keySet.size()]);
		String[] users = new String[keySet.size()];;
		for (int i=0;i<keys.length;i++){
			String userLogin = keys[i];
			if (userLogin!=null){
				User user = userDB.getUser(userLogin);
				String userData=user.getUserLogin()+" - "+user.getUserName()+" - "+user.getUserSurname()+" - "+String.valueOf(user.getUserId())+" - "+user.getUserPwd();
				if (user.getUserId()!=0&&user.getUserId()<8001){
					userData += " - " + ((Student)user).getStudentGroupId();
				}
				users[i] = userData;
			}
		}
		System.out.println(Arrays.toString(users));
		return users;
	}

	@Override
	public String[] groupsToString() {
		Set<String>keySet = userDB.groupKeySet();
		String[] keys = keySet.toArray(new String[keySet.size()]);
		String[] groups = new String[keySet.size()];
		for (int i=0;i<keys.length;i++){
			String groupId = keys[i];
			Group group = userDB.getGroup(groupId);
			String groupData = "";
			if (group!=null) {
				groupData = group.getGroupId();
				HashSet<String> groupStudents = group.getStudents();
				Iterator<String> itGroupStudents = groupStudents.iterator();
					while (itGroupStudents.hasNext()){
						String student = itGroupStudents.next();
						groupData += " - " + student;
					}
				if (groupData!=null){
					groups[i] = groupData;
				}
			}
		}
		System.out.println(Arrays.toString(groups));
		return groups;
	}
	
	@Override
	public String[] usersLoginToString() {
		Set<String> key = userDB.userKeySet();
		String[] usersLogin = key.toArray(new String[key.size()]);
		return usersLogin;
	}

	@Override
	public String[] studentsLoginToString() {
		
		Set<String> key = userDB.userKeySet();
		Set<String> studentskey = new HashSet<String>();
		Iterator<String> itkey = key.iterator();
		
		while (itkey.hasNext()) {
			String userlog = itkey.next();
			User user = userDB.getUser(userlog);
			if (user.getUserId()>0&&user.getUserId()<8001) {
				studentskey.add(userlog);
			}
		}
		String[] studentsLogin = studentskey.toArray(new String[key.size()]);
		
		return studentsLogin;
	}
	
	private String[] adminsLoginToString() {
		
		Set<String> key = userDB.userKeySet();
		Set<String> adminskey = new HashSet<String>();
		Iterator<String> itkey = key.iterator();
		
		while (itkey.hasNext()) {
			String userlog = itkey.next();
			User user = userDB.getUser(userlog);
			if (user.getUserId()>9000) {
				adminskey.add(userlog);
			}
		}
		String[] adminsLogin = adminskey.toArray(new String[key.size()]);
		
		return adminsLogin;
	}

	private String[] teachersLoginToString() {
		
		Set<String> key = userDB.userKeySet();
		Set<String> teacherskey = new HashSet<String>();
		Iterator<String> itkey = key.iterator();
		
		while (itkey.hasNext()) {
			String userlog = itkey.next();
			User user = userDB.getUser(userlog);
			if (user.getUserId()<9001&&user.getUserId()>8000) {
				teacherskey.add(userlog);
			}
		}
		String[] teachersLogin = teacherskey.toArray(new String[key.size()]);
		
		return teachersLogin;
	}
	@Override
	public String[] groupsIdToString() {
			Set<String> key = userDB.groupKeySet();
			String[] groupId = key.toArray(new String[key.size()]);
		return groupId;
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
		
		//Conversion
		
		if(document !=null){
			rootElt = document.getRootElement();
			
			List<Element> groupElts = rootElt.getChildren("Group");
			Iterator<Element> itGroup = groupElts.iterator();
			
			while (itGroup.hasNext()){
				Element groupElt = (Element)itGroup.next();
					String groupId = groupElt.getChild("GroupId").getText();
				Group group = new Group (groupId);
				userDB.addGroup(group);
					
				List<Element> groupStudentElts = groupElt.getChildren("GroupStudent");
				Iterator<Element> itgroupStudent = groupStudentElts.iterator();
					
				while (itgroupStudent.hasNext()){
						Element groupStudentElt = (Element)itgroupStudent.next();
							String groupStudentLogin = groupStudentElt.getText();
						group.addStudent(groupStudentLogin);	
				}
			}
			
			//class admin
			
			List<Element> adminElts = rootElt.getChildren("Admin");
			Iterator<Element> itAdmin = adminElts.iterator();
			
			
			
			while (itAdmin.hasNext()){
				Element adminElt = (Element)itAdmin.next();
					String userLogin = adminElt.getChild("UserLogin").getText();
					String userName = adminElt.getChild("UserName").getText();
					String userSurname = adminElt.getChild("UserSurname").getText();
					String userPwd = adminElt.getChild("UserPwd").getText();
					String id = adminElt.getChild("AdminID").getText();
					int adminId = Integer.parseInt(id);
				Admin Admin = new Admin (userSurname,userName,userLogin,userPwd,adminId);
				userDB.addUser(Admin);
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
					String id = studentElt.getChild("StudentID").getText();
					int studentId = Integer.parseInt(id);
				Student Student = new Student (userSurname,userName,userLogin,userPwd,studentId);
				userDB.addUser(Student);
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
					String id = teacherElt.getChild("TeacherID").getText();
					int teacherId = Integer.parseInt(id);
				Teacher TeacherID = new Teacher (userSurname,userName,userLogin,userPwd,teacherId);
				userDB.addUser(TeacherID);
			}
		}
		return false;
	}

	@Override
	public boolean saveDB() {
		
		String[] studentsLogin = studentsLoginToString();
		String[] adminsLogin = adminsLoginToString(); 
		String[] teachersLogin = teachersLoginToString();
		String[] groupsID = groupsIdToString();
		
		//Translation
		Element rootElt = new Element ("UserBD");
		Document document = new Document(rootElt);
		
			//Loop for groups
		
			if (groupsID.length!=0){
				Element groups = new Element ("Groups");
				for(int i = 0; i<groupsID.length; i++) {
					Group user = userDB.getGroup(groupsID[i]);
					if (user!=null){
						Element group = new Element ("Group");
							Element groupID = new Element("GroupID"); 
								groupID.setText(user.getGroupId());
							group.addContent(groupID);
							Element groupStudents = new Element ("GroupStudents");
								Set<String> groupStudentList = user.getStudents();
								Iterator<String> itgroupStudent = groupStudentList.iterator();
								while (itgroupStudent.hasNext()){
									String groupstudentlog = itgroupStudent.next();
									Element groupStudent = new Element ("GroupStudent");
									groupStudents.addContent(groupStudent.setText(groupstudentlog));		
								}
								group.addContent(groupStudents);
						groups.addContent(group);
					}
				}
				rootElt.addContent(groups);
			}
			
			//Loop for admins
			
			if (adminsLogin.length!=0){
				Element admins = new Element("Admins");
				for (int i = 0; i<adminsLogin.length; i++) {
					Admin user = (Admin) userDB.getUser(adminsLogin[i]);
					if (user!=null){
						Element admin = new Element ("Admin");
							Element userLogin = new Element ("UserLogin");
								String log = user.getUserLogin();	
							admin.addContent(userLogin.setText(log));
							Element userName = new Element ("UserName");
								userName.setText(user.getUserName());
							admin.addContent(userName);
							Element userSurname = new Element ("UserSurname");
								userSurname.setText(user.getUserSurname());
							admin.addContent(userSurname);
							Element userPwd = new Element ("UserPwd");
								userPwd.setText(user.getUserPwd());
							admin.addContent(userPwd);
							Element adminID = new Element ("AdminID");
								adminID.setText(Integer.toString(user.getUserId()));
							admin.addContent(adminID);
						admins.addContent(admin);
					}
				}
				rootElt.addContent(admins);
			}
			
			//Loop for students
			
			if (studentsLogin.length!=0){
				Element students = new Element ("Students");
				for (int i = 0; i<studentsLogin.length; i++) {
					Student user = (Student) userDB.getUser(studentsLogin[i]);
					if (user!=null){
						Element student = new Element ("Student");
							Element userLogin = new Element ("UserLogin");
								userLogin.setText(studentsLogin[i]);
							student.addContent(userLogin);
							Element userName = new Element ("UserName");
								userName.setText(user.getUserName());
							student.addContent(userName);
							Element userSurname = new Element ("UserSurname");
								userSurname.setText(user.getUserSurname());
							student.addContent(userSurname);
							Element userPwd = new Element ("UserPwd");
								userPwd.setText(user.getUserPwd());
							student.addContent(userPwd);
							Element studentID = new Element ("StudentID");
								studentID.setText(Integer.toString(user.getUserId()));
							student.addContent(studentID);
						students.addContent(student);
					}
				}
				rootElt.addContent(students);
			}
			
			//Loop for teachers
			
			if (teachersLogin.length!=0){
				Element teachers = new Element ("Teachers");
				for (int i = 0; i<teachersLogin.length; i++) {
					Teacher user = (Teacher) userDB.getUser(teachersLogin[i]);
					if (user!=null){
						Element teacher = new Element ("Teacher");
							Element userLogin = new Element ("UserLogin");
								userLogin.setText(teachersLogin[i]);
							teacher.addContent(userLogin);
							Element userName = new Element ("UserName");
								userName.setText(user.getUserName());
							teacher.addContent(userName);
							Element userSurname = new Element ("UserSurname");
								userSurname.setText(user.getUserSurname());
							teacher.addContent(userSurname);
							Element userPwd = new Element ("UserPwd");
								userPwd.setText(user.getUserPwd());
							teacher.addContent(userPwd);
							Element teacherID = new Element ("TeacherID");
								teacherID.setText(Integer.toString(user.getUserId()));
							teacher.addContent(teacherID);
						teachers.addContent(teacher);
					}
				}
				rootElt.addContent(teachers);
			}

			//Write
			try{
				XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
				sortie.output(document, new FileOutputStream(UserDB.getFile()));
			}catch (java.io.IOException e){}
		return false;
	}
}

