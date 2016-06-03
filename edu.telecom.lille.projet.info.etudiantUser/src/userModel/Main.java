package userModel;

import userController.UserController;
/**
 * Cette classe permet de tester les fonctions du contrôleur d'utilisateurs.
 * Elle crée une base de données de 6 utilisateurs et les sauvegarde dans le fichier "usersDB.xml". 
 * 
 * @author Jose Mennesson (Mettre à jour)
 * @version 04/2016 (Mettre à jour)
 * 
 */

public class Main {
	/**
	 * Fonction principale 
	 * 
	 * @param args
	 * 			Les arguments donnés en entrée du programme.
	 * 
	 */
	public static void main(String[] args) {
		final String file="usersDB.xml";
		UserController UC=new UserController(file);
		UC.addAdmin("su","KF",9001,"Kevin", "Flynn",  "@tron");
		UC.addAdmin("su","KR",9002,"Keanu", "Reeves",  "redpill");
		UC.addTeacher("su","GS",8001,"Grand", "Schtroumpf",  "salsepareille");
		UC.addTeacher("su","MF",8002,"Morgan", "Freeman",  "iknowall");
		UC.addStudent("su","BS",0001,"Buffy", "Summers",  "stake");
		UC.addStudent("su","NL",0002,"Nicolas", "Lepetit",  "prout");
		UC.usersToString();
		UC.groupsToString();
		UC.addStudent("su", "BT", 0003, "Thibaud", "Blondin", "azerty");
		UC.addGroup("su",0001);
		UC.addGroup("su",0002);
		UC.associateStudToGroup("su", "BT", 0001);
		UC.associateStudToGroup("su", "BS", 0001);
		UC.associateStudToGroup("su", "NL", 0002);
		UC.saveDB();
		UC.loadDB();
		UC.usersToString();
		UC.groupsToString();
		UC.removeGroup("su", 0002);
		UC.removeUser("su","BT");
		UC.removeUser("su","MF");
		UC.usersToString();
		UC.groupsToString();
		UC.saveDB();
	}
}
