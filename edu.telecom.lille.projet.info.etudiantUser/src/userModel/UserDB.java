package userModel;

import java.util.HashMap;
import java.util.Set;

/**
 * 
 * Cette classe gère la base de données d'utilisateurs. Elle doit permettre de sauvegarder et charger les utilisateurs et les groupes À partir d'un fichier XML. 
 * La structure du fichier XML devra être la même que celle du fichier userDB.xml.
 * @see <a href="../../userDB.xml">userDB.xml</a> 
 * 
 * @author  
 * @version 06/2016 
 * 
 */

public class UserDB {
	private HashMap<String, User> hm = new HashMap<String,User>();
	private HashMap<String,Group> hg = new HashMap<String,Group>();
	/**
	 * 
	 * Le fichier contenant la base de données.
	 * 
	 */
	private static String file;
	
	/**
	 * 
	 * Constructeur de UserDB. 
	 * 
	 
	 * 
	 * @param file2
	 * 		Le nom du fichier qui contient la base de données.
	 *  Création de l'admnistrateur 'su' qui permettra de charger la base de données au démarrage de l'application
	 */
	 
	public UserDB(String file){
		super();
		this.setFile(file);
		Admin admin = new Admin("su","admin","admin","admin",0000);
		hm.put("su",admin);
	}
	
	/**
	 * Getter de file
	 * 
	 * @return 
	 * 		Le nom du fichier qui contient la base de données.
	 */
	
	public static String getFile() {
		return file;
	}
	/**
	 * Setter de file
	 * 
	 * @param file
	 * 		Le nom du fichier qui contient la base de données.
	 */
	
	public void setFile(String file) {
		UserDB.file = file;
	}
	/**
	 * Getter de userDB
	 * 
	 * @return 
	 * 		Le Login et le User du userDB dans la base de données
	 */
	public HashMap<String, User> getUserDataBse(){
		return this.hm;
	}
	/**
	 * Setter de file
	 * 
	 * @param file
	 * 		Le Login et le User du userDB dans la base de données
	 */
	
	public void setDataBase(HashMap<String,User> newhm){
		this.hm = newhm;
	}
	
	public HashMap<String,User> getUserDataBase(){
		return this.hm ;
	}
	
	public void addUser(User user) {
		String userLogin = user.getUserLogin();
		hm.put(userLogin,user);
	}
	
	public void removeUser(String userLogin) {
		hm.remove(userLogin);
	}
	
	public boolean containsUser(String userLogin){
		if (hm.containsKey(userLogin)){
		return true;
		}
		return false;
	}
	
	public HashMap<String,Group> getGroupDataBse(){
		return this.hg;
	}
	
	public void setGroupDataBase(HashMap<String,Group> hg){
		this.hg=hg;
	}
	
	public HashMap<String, Group> getGroup(){
		return this.hg;
	}
	
	public void addGroup(Group group) {
		String groupId = group.getGroupId();
		hg.put(groupId,group);
	}
	
	public void removeGroup(String groupId) {
		hg.remove(groupId);
	}
	
	public boolean containsGroup(String groupId){
		if (hg.containsKey(groupId)){
		return true;
		}
		return false;
	}
	
	public Set<String> userKeySet() {
		Set<String> keySet = this.hm.keySet();
		keySet.remove("su");
		return keySet;
	}
	
	public Set<String> groupKeySet() {
		return this.hg.keySet();
	}
	
	public User getUser (String userLogin){
		return this.hm.get(userLogin);
	}
	
	public Group getGroup (String groupId){
		return this.hg.get(groupId);
	}
	
	public void removeUserGroup (String groupId, String userLogin) {
		Group group = hg.get(groupId);
		group.removeStudent(userLogin);
	}
}
	
