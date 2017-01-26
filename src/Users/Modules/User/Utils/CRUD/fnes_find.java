package Users.Modules.User.Utils.CRUD;

import Users.Modules.User.Classes.Singleton;
import Users.Modules.User.Classes.userad;
import Users.Modules.User.Classes.usercl;
import Users.Modules.User.Classes.usern;

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
}
