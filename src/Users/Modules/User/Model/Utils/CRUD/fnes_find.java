package Users.Modules.User.Model.Utils.CRUD;

import Users.Modules.User.Model.Classes.Singleton;
import Users.Modules.User.Model.Classes.userad;
import Users.Modules.User.Model.Classes.usercl;
import Users.Modules.User.Model.Classes.usern;
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
		String search =functions.menucombox( admin,"Elegeix un usuari","Usuari");
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
		String search = functions.menucombox(client,"Elegeix un usuari","Usuari");
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
		String search = functions.menucombox(userregister,"Elegeix un usuari","Usuari");
		if (search != ""){
			for (int i = 0; i<9; i++) {
				ID += search.charAt(i);
			}
			u1 = new usern (ID);
		}
		return u1;		
	}
}
