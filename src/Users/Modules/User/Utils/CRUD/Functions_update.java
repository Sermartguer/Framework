package Users.Modules.User.Utils.CRUD;

import javax.swing.JOptionPane;

import Users.Classes.setting;
import Users.Modules.User.Classes.Singleton;
import Users.Modules.User.Classes.userad;
import Users.Modules.User.Classes.usercl;
import Users.Modules.User.Classes.usern;
import Users.Modules.User.Utils.fnes_users4;
import Users.Modules.User.Utils.CRUD.*;
public class Functions_update {
	
	public static void update_admin (){
		userad a1=null;

		int location1 = -1;
		
		if(Singleton.useradmin.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hi han dades, per favor crea un usuari", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else{
			location1 = -1;
			a1 = fnes_users4.ask_adminDNI();
			location1 = fnes_find.find_admin(a1);
			if (location1 != -1) {
				a1 = Singleton.useradmin.get(location1);
				fnes_users4.update_users(a1, setting.getInstance().getffecha());
				Singleton.useradmin.set(location1, a1);
			}else {
				JOptionPane.showMessageDialog(null,"L'usuari no existeix", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void update_client () {
		usercl c1=null;

		int location1 = -1;
		
		if(Singleton.userclient.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hi han dades, per favor crea un usuari", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else{
			location1 = -1;
			c1 = fnes_users4.ask_clientDNI();
			location1 = fnes_find.find_client(c1);
			if (location1 != -1) {
				c1 = Singleton.userclient.get(location1);
				fnes_users4.update_users(c1, setting.getInstance().getffecha());
				Singleton.userclient.set(location1, c1);
			}else {
				JOptionPane.showMessageDialog(null, "L'usuari no existeix", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public static void update_userregister () {
		usern u1=null;
		int location1 = -1;
		
		if(Singleton.userregister.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hi han dades, per favor crea un usuari", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else{
			//location1 = -1;
			u1 = fnes_users4.ask_usernDNI();
			location1 = fnes_find.find_user(u1);
			if (location1 != -1) {
				u1 = Singleton.userregister.get(location1);
				fnes_users4.update_users(u1, setting.getInstance().getffecha());
				Singleton.userregister.set(location1, u1);
			}else {
				JOptionPane.showMessageDialog(null, "L'usuari no existeix", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
