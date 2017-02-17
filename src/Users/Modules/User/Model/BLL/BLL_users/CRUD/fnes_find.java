package Users.Modules.User.Model.BLL.BLL_users.CRUD;

import javax.swing.JOptionPane;

import Users.Classes.lenguage;
import Users.Modules.User.Model.Classes.Singleton;
import Users.Modules.User.Model.Classes.userad;
import Users.Modules.User.Model.Classes.usercl;
import Users.Modules.User.Model.Classes.usern;
import Users.Modules.User.Model.Classes.usu;
import Users.Modules.User.Model.DAO.fnes_users4;
import Users.Utils.functions;

public class fnes_find {
	public static int find_admin(userad admin) { 
		for (int i = 0; i<=(Singleton.useradmin.size()-1); i++){
			if((Singleton.useradmin.get(i)).equals(admin) )
				return i;
		}
		return -1;
	}
	
	public static int find_client(usercl client) {
		for (int i = 0; i<=(Singleton.userclient.size()-1); i++){
			if((Singleton.userclient.get(i)).equals(client) )
				return i;
		}
		return -1;
	}
	
	public static int find_user(usern user) { 
		for (int i = 0; i<=(Singleton.userregister.size()-1); i++){
			if((Singleton.userregister.get(i)).equals(user) )
				return i;
		}
		return -1;
	}
	
	public static String[] generate_vector_admin () {
		userad a1 = null;
		String s = "";
		int arraylist =Singleton.useradmin.size();
		String [] user = new String[arraylist];
		for (int i = 0; i<arraylist; i++) {
			a1 = (userad) Singleton.useradmin.get(i);
			s=a1.getdni()+"     "+a1.getnom()+"     "+a1.getemail();
			user[i] = s;
		}
		
		return user;
	}
	
	public static String[] generate_vector_client () {
		usercl c1 = null;
		String s = "";
		int arraylist =Singleton.userclient.size();
		String [] user = new String[arraylist];
		for (int i = 0; i<arraylist; i++) {
			c1 = (usercl) Singleton.userclient.get(i);
			s=c1.getdni()+"     "+c1.getnom()+"     "+c1.getemail();
			user[i] = s;
		}
		
		return user;
	}
	
	public static String[] generate_vector_userregister () {
		usern u1 = null;
		String s = "";
		int arraylist =Singleton.userregister.size();
		String [] user = new String[arraylist];
		for (int i = 0; i<arraylist; i++) {
			u1 = (usern) Singleton.userregister.get(i);
			s=u1.getdni()+"     "+u1.getnom()+"     "+u1.getemail();
			user[i] = s;
		}
		
		return user;
	}
	
	public static userad IDadmin () {
		userad a1 = null;
		String ID = "";
		String [] admin = generate_vector_admin ();
		String search =functions.menucomboxmenu( admin,"Elegeix un usuari","Usuari");
		if (search != ""){
			for (int i = 0; i<9; i++) {
				ID += search.charAt(i);
			}
			a1 = new userad (ID);
		}
		return a1;		
	}
	
	public static usercl IDclient () {
		usercl c1 = null;
		String ID = "";
		String [] client = generate_vector_client ();
		String search = functions.menucomboxmenu(client,"Elegeix un usuari","Usuari");
		if (search != ""){
			for (int i = 0; i<9; i++) {
				ID += search.charAt(i);
			}
			c1 = new usercl (ID);
		}
		return c1;		
	}
	
	public static usern IDuserregister () {
		usern u1 = null;
		String ID = "";
		String [] userregister = generate_vector_userregister ();
		String search = functions.menucomboxmenu(userregister,"Elegeix un usuari","Usuari");
		if (search != ""){
			for (int i = 0; i<9; i++) {
				ID += search.charAt(i);
			}
			u1 = new usern (ID);
		}
		return u1;		
	}
	
	public static int set_adminDNI ( usu param){
		userad a1=null;
		int location = -1;
		a1 = fnes_users4.ask_adminDNI();
		location = fnes_find.find_admin(a1);
		if (location != -1) {
			JOptionPane.showMessageDialog(null,"Error introduix un altre DNI", "DNI", JOptionPane.ERROR_MESSAGE);
			return 0;
		}else {
			param.setdni(Singleton.DNI);
			return -1;
		}
	}
	
	public static int set_clientDNI (usu param){
		usercl c1=null;
		int location = -1;
		c1 = fnes_users4.ask_clientDNI();
		location = fnes_find.find_client(c1);
		if (location != -1) {
			JOptionPane.showMessageDialog(null,"Error introduix un altre DNI", "DNI", JOptionPane.ERROR_MESSAGE);
			return 0;
		}else {
			param.setdni(Singleton.DNI);
			return -1;
		}
	}
	
	public static int set_usernDNI (usu param){
		usern u1=null;
		int location = -1;
		u1 = fnes_users4.ask_usernDNI();
		location = fnes_find.find_user(u1);
		System.out.println("Location: "+location);
		if (location != -1) {
			JOptionPane.showMessageDialog(null,"Error introduix un altre DNI", "DNI", JOptionPane.ERROR_MESSAGE);
			return 0;
		}else {
			param.setdni(Singleton.DNI);
			return -1;
		}
	}
}
