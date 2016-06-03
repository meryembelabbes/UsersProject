package userController;

import java.io.File;
import java.io.FileOutputStream;
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
 * Cette classe est le contr�leur d'utilisateurs que vous devez impl�menter. 
 * Elle contient un attribut correspondant � la base de donn�es utilisateurs que vous allez cr�er.
 * Elle contient toutes les fonctions de l'interface IUserController que vous devez impl�menter.
 * 
 * @author Jose Mennesson (Mettre � jour)
 * @version 04/2016 (Mettre � jour)
 * 
 */

public class UserController implements IUserController
{
	
	/**
	 * Contient une instance de base de donn�es d'utilisateurs
	 * 
	 */
	private UserDB userDB=null;
	
	
	/**
	 * Constructeur de controleur d'utilisateurs cr�ant la base de donn�es d'utilisateurs
	 * 
	 * @param file
	 * 		Fichier XML contenant la base de donn�es d'utilisateurs
	 */
	public UserController(String file){
		UserDB userDB=new UserDB(file);
		this.setUserDB(userDB);
	}

	@Override
	public String getUserName(String userLogin) {
			User user = userDB.hm.get(userLogin);
		return user.getUserName();
	}

	@Override
	public String getUserClass(String userLogin, String userPwd) {
		User user = userDB.hm.get(userLogin);
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
		if (userDB.hm.containsKey(studentLogin)){
			User user = userDB.hm.get(studentLogin);
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
		
		if (!userDB.hm.containsKey(newAdminlogin)){
		Admin userLogin = new Admin (surname, firstname, newAdminlogin, pwd, userId);
		userDB.hm.put(newAdminlogin,userLogin);
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
		
		if (!userDB.hm.containsKey(newteacherLogin)){
		Teacher userLogin = new Teacher (surname, firstname, newteacherLogin, pwd, userId);
		userDB.hm.put(newteacherLogin,userLogin);
		return true;
		}
		return false;
	}

	@Override
	public boolean addStudent(String adminLogin, String newStudentLogin, int userId, String firstname,
			String surname, String pwd) {
		//TODO
		
		Student userLogin = new Student (surname, firstname, newStudentLogin,  pwd, userId);
		userDB.hm.put(newStudentLogin,userLogin);
		
		return false;
	}

	@Override
	public boolean removeUser(String adminLogin, String userLogin) {
		// TODO 
			if (userDB.hm.containsKey(userLogin)){
				userDB.hm.remove(userLogin);
			return true;
			}
		return false;
	}

	@Override
	public boolean addGroup(String adminLogin, int groupId) {
		// TODO
			if (!userDB.hg.containsKey(String.valueOf(groupId))){
				String id = String.valueOf(groupId);
				Group group = new Group(id);
				userDB.hg.put(id,group);
				return true;
			}
			return false;

	}

	@Override
	public boolean removeGroup(String adminLogin, int groupId) {
		// TODO
			if (userDB.hg.containsKey(String.valueOf(groupId))){
				userDB.hg.remove(groupId);
				return true;
			}
			return false;
	}

	@Override
	public boolean associateStudToGroup(String adminLogin, String studentLogin, int groupId) {
		// TODO
		Group group = userDB.hg.get(groupId);
		if (group!=null){
			if(!group.students.contains(studentLogin)){
				group.students.add(studentLogin);
		
				Student student = (Student) userDB.hm.get(studentLogin);
				if (student!=null){
					student.studentGroupId = String.valueOf(groupId);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String[] usersToString() {
		Set<String[]> usersSet = new HashSet<String[]>() ;
		Set<String>key = userDB.hm.keySet();
		Iterator<String> itkey = key.iterator();
		while (itkey.hasNext()){
			String userLogin = itkey.next();
			Student student = (Student) userDB.hm.get(userLogin);
				String[] studentData = new String[6];
				studentData[0] = student.getUserLogin();
				studentData[1] = student.getUserName();
				studentData[2] = student.getUserSurname();
				studentData[3] = String.valueOf(student.getUserId());	 		
				studentData[4] = student.getUserPwd();
				studentData[5] = student.studentGroupId;
			usersSet.add(studentData);
		}
		String[] users = usersSet.toArray(new String[usersSet.size()]);
		return users;
	}

	@Override
	public String[] groupsToString() {
		Set<String[]> groupsSet = new HashSet<String[]>() ;
		Set<String>key = userDB.hg.keySet();
		Iterator<String> itkey = key.iterator();
		while (itkey.hasNext()){
			String groupLogin = itkey.next();
			Group group = (Group) userDB.hg.get(groupLogin);
				Set<String> groupdata = new HashSet<String>();
				groupdata.add(group.getGroupId());
				groupdata.addAll(group.students);
				String[] groupData = groupdata.toArray(new String[groupdata.size()]);
			groupsSet.add(groupData);
		}
		String[] groups = groupsSet.toArray(new String[groupsSet.size()]);
		return groups;
	}
	
	@Override
	public String[] usersLoginToString() {
		Set<String> key = userDB.hm.keySet();
		String[] usersLogin = key.toArray(new String[key.size()]);
		return usersLogin;
	}

	@Override
	public String[] studentsLoginToString() {
		
		Set<String> key = userDB.hm.keySet();
		Set<String> studentskey = new HashSet<String>();
		Iterator<String> itkey = key.iterator();
		
		while (itkey.hasNext()) {
			String userlog = itkey.next();
			User user = userDB.hm.get(userlog);
			if (user.getUserId()>0&&user.getUserId()<8001) {
				studentskey.add(userlog);
			}
		}
		String[] studentsLogin = studentskey.toArray(new String[key.size()]);
		
		return studentsLogin;
	}
	
	private String[] adminsLoginToString() {
		
		Set<String> key = userDB.hm.keySet();
		Set<String> adminskey = new HashSet<String>();
		Iterator<String> itkey = key.iterator();
		
		while (itkey.hasNext()) {
			String userlog = itkey.next();
			User user = userDB.hm.get(userlog);
			if (user.getUserId()>9000) {
				adminskey.add(userlog);
			}
		}
		String[] adminsLogin = adminskey.toArray(new String[key.size()]);
		
		return adminsLogin;
	}

	private String[] teachersLoginToString() {
		
		Set<String> key = userDB.hm.keySet();
		Set<String> teacherskey = new HashSet<String>();
		Iterator<String> itkey = key.iterator();
		
		while (itkey.hasNext()) {
			String userlog = itkey.next();
			User user = userDB.hm.get(userlog);
			if (user.getUserId()<9001&&user.getUserId()>8000) {
				teacherskey.add(userlog);
			}
		}
		String[] teachersLogin = teacherskey.toArray(new String[key.size()]);
		
		return teachersLogin;
	}
	@Override
	public String[] groupsIdToString() {
			Set<String> key = userDB.hg.keySet();
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
				userDB.hg.put(groupId,group);
					
				List<Element> groupStudentElts = groupElt.getChildren("GroupStudent");
				Iterator<Element> itgroupStudent = groupStudentElts.iterator();
					
				while (itgroupStudent.hasNext()){
						Element groupStudentElt = (Element)itgroupStudent.next();
							String groupStudentLogin = groupStudentElt.getText();
						group.students.add(groupStudentLogin);	
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
				userDB.hm.put(userLogin,Admin);
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
				userDB.hm.put(userLogin,Student);
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
				userDB.hm.put(userLogin,TeacherID);
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
					Group user = userDB.hg.get(groupsID[i]);
					if (user!=null){
						Element group = new Element ("Group");
							Element groupID = new Element("GroupID"); 
								groupID.setText(user.getGroupId());
							group.addContent(groupID);
							Element groupStudents = new Element ("GroupStudents");
								Set<String> groupStudentsList = user.students; 
								Iterator<String> itgroupStudent = groupStudentsList.iterator();
								while (itgroupStudent.hasNext()){
									String groupstudentlog = itgroupStudent.next();
									Element groupStudent = new Element ("GroupStudent");
										groupStudent.setText(groupstudentlog);
									groupStudents.addContent(groupStudent);
								}
								group.addContent(groupStudents);
						groups.addContent(group);
					}
				}
				rootElt.addContent(groups);
			}
			
			//Loop for admins
			
			if (adminsLogin[1]!=null){
				Element admins = new Element("Admins");
				for (int i = 0; i<adminsLogin.length; i++) {
					Admin user = (Admin) userDB.hm.get(adminsLogin[i]);
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
			
			if (studentsLogin[0]!=null){
				Element students = new Element ("Students");
				for (int i = 0; i<studentsLogin.length; i++) {
					Student user = (Student) userDB.hm.get(studentsLogin[i]);
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
			
			if (teachersLogin[1]!=null){
				Element teachers = new Element ("Teachers");
				for (int i = 0; i<teachersLogin.length; i++) {
					Teacher user = (Teacher) userDB.hm.get(teachersLogin[i]);
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

