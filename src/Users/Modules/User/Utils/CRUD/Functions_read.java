package Users.Modules.User.Utils.CRUD;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Users.Modules.User.Classes.Singleton;
import Users.Modules.User.Classes.userad;
import Users.Modules.User.Classes.usercl;
import Users.Modules.User.Classes.usern;
import Users.Modules.User.Utils.CRUD.*;
import Users.Modules.User.Utils.fnes_users4;
import Users.Utils.functions;

public class Functions_read {
	public static void read_admin (){
		userad a1=null;
		int menu = 0, location = -1;
		String [] menu_print = { Singleton.language.getProperty("read_all"), Singleton.language.getProperty("read_search")};
		if(Singleton.useradmin.isEmpty()){
			JOptionPane.showMessageDialog(null,Singleton.language.getProperty("error_01"), "ERROR", JOptionPane.ERROR_MESSAGE);
		}else{
			menu = functions.menuo(menu_print, Singleton.language.getProperty("read_message"), Singleton.language.getProperty("read_title"));
			switch (menu){
				case 0:
					for (int i = 0; i <Singleton.useradmin.size();i++){
						String cad = "";
						cad = cad + (Singleton.useradmin.get(i).toString());
						JOptionPane.showMessageDialog(null, cad);
					}
					break;
				case 1:
					location = -1;
					a1 = fnes_users4.ask_adminDNI();
					location = fnes_find.find_admin(a1);
					if (location != -1) {
						a1 = Singleton.useradmin.get(location);
						JOptionPane.showMessageDialog(null, a1.toString());
					}else {
						JOptionPane.showMessageDialog(null, "", "",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/Sergio/workspace/Users/src/Users/Ico/404.png"));
					}
					break;
			}
		}
	}
	
	public static void read_client (){
		usercl c1=null;
		int menu = 0, location = -1;
		String [] menu_print = {  Singleton.language.getProperty("read_all"), Singleton.language.getProperty("read_search") };

		if(Singleton.userclient.isEmpty()){
			JOptionPane.showMessageDialog(null,Singleton.language.getProperty("error_01"), "ERROR", JOptionPane.ERROR_MESSAGE);
			}else{
				menu = functions.menuo(menu_print, Singleton.language.getProperty("read_message"), Singleton.language.getProperty("read_title"));
			switch (menu){
				case 0:
					for (int i = 0; i <Singleton.userclient.size();i++){
						String cad = "";
						cad = cad + (Singleton.userclient.get(i).toString());
						JOptionPane.showMessageDialog(null, cad);
					}
					break;
				case 1:
					location = -1;
					c1 = fnes_users4.ask_clientDNI();
					location = fnes_find.find_client(c1);
					if (location != -1) {
						c1 = Singleton.userclient.get(location);
						JOptionPane.showMessageDialog(null, c1.toString());
					}else {
						JOptionPane.showMessageDialog(null, "", "",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/Sergio/workspace/Users/src/Users/Ico/404.png"));
					}
					break;
			}
		}
	}
	
	public static void read_usern (){
		usern u1=null;
		int menu = 0, location = -1;
		String [] menu_print = {  Singleton.language.getProperty("read_all"), Singleton.language.getProperty("read_search") };

		if(Singleton.userregister.isEmpty()){
			JOptionPane.showMessageDialog(null,Singleton.language.getProperty("error_01"), "ERROR", JOptionPane.ERROR_MESSAGE);
			}else{
				menu = functions.menuo(menu_print, Singleton.language.getProperty("read_message"), Singleton.language.getProperty("read_title"));
			switch (menu){
				case 0:
					for (int i = 0; i <Singleton.userregister.size();i++){
						String cad = "";
						cad = cad + (Singleton.userregister.get(i).toString());
						JOptionPane.showMessageDialog(null, cad);
					}
					break;
				case 1:
					location = -1;
					u1 = fnes_users4.ask_usernDNI();
					location = fnes_find.find_user(u1);
					if (location != -1) {
						u1 = Singleton.userregister.get(location);
						JOptionPane.showMessageDialog(null, u1.toString());
					}else {
						JOptionPane.showMessageDialog(null, "", "",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/Sergio/workspace/Users/src/Users/Ico/404.png"));
					}
					break;
			}
		}
	}
}
