package Users.Modules.User.Model.Utils.CRUD;

import java.util.Collections;

import javax.swing.JOptionPane;

import Users.Classes.lenguage;
import Users.Modules.User.Model.Classes.Singleton;
import Users.Modules.User.Model.Classes.order.Orderage;
import Users.Modules.User.Model.Classes.order.Orderbirthday;
import Users.Modules.User.Model.Classes.order.Ordername;
import Users.Modules.User.Model.Classes.order.Ordershopping;
import Users.Utils.functions;

public class Functions_order {
	public static void change_orderadmin () {
		String [] options = { "A) DNI", lenguage.getInstance().getProperty("menu_2"), lenguage.getInstance().getProperty("menu_3"), lenguage.getInstance().getProperty("menu_4")};
		String menu = "";
		char order = ' ';
		
		if(Singleton.useradmin.isEmpty()){
			JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("error_01"), "ERROR", JOptionPane.ERROR_MESSAGE);
		}else{
			menu = functions.menucombox( options,lenguage.getInstance().getProperty("ask_01"), lenguage.getInstance().getProperty("ask_title01"));
			order = menu.charAt(0);
			switch (order) {
				case 'A':
					Collections.sort(Singleton.useradmin);
					break;
				case 'B':
					Collections.sort(Singleton.useradmin, new Ordername());
					break;
				case 'C':
					Collections.sort(Singleton.useradmin, new Orderbirthday());
					break;
				case 'D':
					Collections.sort(Singleton.useradmin, new Orderage());
					break;
			}
		}
	}
	
	public static void change_orderclient (){
		String [] options = { "A) DNI", lenguage.getInstance().getProperty("menu_2"), lenguage.getInstance().getProperty("menu_3"), lenguage.getInstance().getProperty("menu_4"),"E) Numero de compras"};
		String menu = "";
		char order = ' ';
		
		if(Singleton.userclient.isEmpty()){
			JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("error_01"), "ERROR", JOptionPane.ERROR_MESSAGE);
		}else{
			menu = functions.menucombox( options,lenguage.getInstance().getProperty("ask_01"), lenguage.getInstance().getProperty("ask_title01"));
			order = menu.charAt(0);
			switch (order) {
				case 'A':
					Collections.sort(Singleton.userclient);
					break;
				case 'B':
					Collections.sort(Singleton.userclient, new Ordername());
					break;
				case 'C':
					Collections.sort(Singleton.userclient, new Orderbirthday());
					break;
				case 'D':
					Collections.sort(Singleton.userclient, new Orderage());
					break;
				case 'E':
					Collections.sort(Singleton.userclient, new Ordershopping());
					break;
			}
		}
	}
	
	public static void change_orderuser (){
		String [] options = { "A) DNI", lenguage.getInstance().getProperty("menu_2"), lenguage.getInstance().getProperty("menu_3"), lenguage.getInstance().getProperty("menu_4"),"E) Numero de compras"};
		String menu = "";
		char order = ' ';
		
		
		if(Singleton.userregister.isEmpty()){
			JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("error_01"), "ERROR", JOptionPane.ERROR_MESSAGE);
		}else{
			menu = functions.menucombox( options,lenguage.getInstance().getProperty("ask_01"), lenguage.getInstance().getProperty("ask_title01"));
			order = menu.charAt(0);
			switch (order) {
				case 'A':
					Collections.sort(Singleton.userregister);
					break;

				case 'B':
					Collections.sort(Singleton.userregister, new Ordername());
					break;
				case 'C':
					Collections.sort(Singleton.userregister, new Orderbirthday());
					break;
				case 'D':
					Collections.sort(Singleton.userregister, new Orderage());
					break;
				case 'E':
					Collections.sort(Singleton.userclient, new Ordershopping());
					break;
			}
		}
	}
}
