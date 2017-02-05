package Users.Modules.User.Model.Utils.CRUD;

import javax.swing.JOptionPane;

import Users.Classes.lenguage;
import Users.Main.menu4;
import Users.Modules.User.Model.Classes.Singleton;
import Users.Modules.User.Model.Classes.userad;
import Users.Modules.User.Model.Classes.usercl;
import Users.Modules.User.Model.Classes.usern;
import Users.Modules.User.Model.Utils.CRUD.*;
import Users.Utils.functions;
import Users.Modules.User.Model.Utils.fnes_users4;

public class Functions_delete {
	public static void delete_admin () {
		userad a1=null;
		int location = -1;
		int menu = 0;
		String [] menu_print = { lenguage.getInstance().getProperty("read_all"), lenguage.getInstance().getProperty("read_search")};
		if(Singleton.useradmin.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hi han dades, per favor crea un usuari", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else{
			menu = functions.menuo(menu_print, lenguage.getInstance().getProperty("read_message"), lenguage.getInstance().getProperty("read_title"));
			switch (menu){
			case 0:				
					Singleton.useradmin.clear();
				break;
			case 1:
			location = -1;
			a1=fnes_find.IDadmin();
			//a1 = fnes_users4.ask_adminDNI();
			location = fnes_find.find_admin(a1);
			if (location != -1) {
				Singleton.useradmin.remove(location);
				JOptionPane.showMessageDialog(null, "L'usuari s'ha eliminat correctament");
			}else {
				JOptionPane.showMessageDialog(null, "L'usuari no existeix", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			break;
			}
		}
	}
	
	public static void delete_client () {
		usercl c1=null;

		int location = -1;
		int menu = 0;
		String [] menu_print = { lenguage.getInstance().getProperty("read_all"), lenguage.getInstance().getProperty("read_search")};
		if(Singleton.userclient.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hi han dades, per favor crea un usuari", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else{
			menu = functions.menuo(menu_print, lenguage.getInstance().getProperty("read_message"), lenguage.getInstance().getProperty("read_title"));
			switch (menu){
			case 0:				
					Singleton.userclient.clear();
				break;
			case 1:
			location = -1;
			c1=fnes_find.IDclient();
			//c1 = fnes_users4.ask_clientDNI();
			location = fnes_find.find_client(c1);
			if (location != -1) {
				Singleton.userclient.remove(location);
				JOptionPane.showMessageDialog(null, "Borrat");
			}else {
				JOptionPane.showMessageDialog(null, "L'usuari no existeix", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			break;
			}
		}
	}
	
	public static void delete_userregister () {
		usern u1=null;
		int location = -1;
		String [] menu_print = { lenguage.getInstance().getProperty("read_all"), lenguage.getInstance().getProperty("read_search")};
		int menu = 0;

		if(Singleton.userregister.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hi han dades, per favor crea un usuari", "ERROR", JOptionPane.ERROR_MESSAGE);
		}else{
			menu = functions.menuo(menu_print, lenguage.getInstance().getProperty("read_message"), lenguage.getInstance().getProperty("read_title"));
			switch (menu){
			case 0:
				Singleton.userregister.clear();
				break;
			case 1:
			location = -1;
			u1=fnes_find.IDuserregister();
			//u1 = fnes_users4.ask_usernDNI();
			location = fnes_find.find_user(u1);
			if (location != -1) {
				Singleton.userregister.remove(location);
				JOptionPane.showMessageDialog(null, "Borrat");
			}else {
				JOptionPane.showMessageDialog(null, "L'usuari no existeix", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			break;
			}
		}
	}
}
