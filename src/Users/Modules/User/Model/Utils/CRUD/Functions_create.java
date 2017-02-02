package Users.Modules.User.Model.Utils.CRUD;

import javax.swing.JOptionPane;

import Users.Classes.lenguage;
import Users.Classes.setting;
import Users.Modules.User.Model.BLL.BLL_dummies;
import Users.Modules.User.Model.Classes.Singleton;
import Users.Modules.User.Model.Classes.userad;
import Users.Modules.User.Model.Classes.usercl;
import Users.Modules.User.Model.Classes.usern;
import Users.Modules.User.Model.Utils.CRUD.*;
import Users.Modules.User.Model.dummies.fnes_users_dummies;
import Users.Modules.User.Model.Utils.fnes_users4;

public class Functions_create {
	
	public static userad create_admin () {
		userad a1=null;
		int location = -1;
		if (setting.getInstance().getdummies()==false){
		a1 = fnes_users4.ask_adminDNI();
		if (Singleton.useradmin==null){
			System.out.println("Esta buit");
		}else{
		location = fnes_find.find_admin(a1);
		}
		}
		if (location != -1) {
			JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("error_create"), "ERROR", JOptionPane.ERROR_MESSAGE);
		} else {
			
			if (setting.getInstance().getdummies()==true){
				a1=BLL_dummies.makedummies_admin();
			}else if (setting.getInstance().getdummies()==false){
				a1 = (userad) fnes_users4.create_users(2);
			}
			Singleton.useradmin.add(a1);
			System.out.println("Tamayo de el array "+Singleton.useradmin.size());
		}
		return a1;
	}
	
	public static usercl create_client () {
		usercl c1=null;
		int location = -1;
		if (setting.getInstance().getdummies()==false){
		c1 = fnes_users4.ask_clientDNI();
		location = fnes_find.find_client(c1);
		}
		if (location != -1) {
			JOptionPane.showMessageDialog(null,  lenguage.getInstance().getProperty("error_create"),"ERROR", JOptionPane.ERROR_MESSAGE);
		} else {
			if (setting.getInstance().getdummies()==true){
			//c1 = (usercl) fnes_users_dummies.create_users(0);
			c1=BLL_dummies.makedummies_client();
			}else if (setting.getInstance().getdummies()==false){
			c1= (usercl) fnes_users4.create_users(0);
			}
			Singleton.userclient.add(c1);
			System.out.println(Singleton.userclient);
		}
		return c1;
	}
	
	public static usern create_usern () {
		usern n1=null;
		int location = -1;
		if(setting.getInstance().getdummies()==false){
		n1 =fnes_users4.ask_usernDNI();
		location = fnes_find.find_user(n1);
		}
		if (location != -1) {
			JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("error_create"),"ERROR", JOptionPane.ERROR_MESSAGE);
		} else {
			if(setting.getInstance().getdummies()==true){
				n1=BLL_dummies.makedummies_userregister();
				//n1 = (usern) fnes_users_dummies.create_users(1);
			}else if (setting.getInstance().getdummies()==false){
				n1 = (usern) fnes_users4.create_users(1);
			}
			Singleton.userregister.add(n1);
		}
		return n1;
	}
}
