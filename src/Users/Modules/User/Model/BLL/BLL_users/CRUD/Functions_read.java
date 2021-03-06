package Users.Modules.User.Model.BLL.BLL_users.CRUD;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Users.Classes.lenguage;
import Users.Modules.User.Model.Classes.Singleton;
import Users.Modules.User.Model.Classes.userad;
import Users.Modules.User.Model.Classes.usercl;
import Users.Modules.User.Model.Classes.usern;
import Users.Modules.User.Model.DAO.fnes_users4;
import Users.Utils.functions;

public class Functions_read {
	public static void read_admin (){
        String PATH = null;

		userad a1=null;
		int menu = 0, location = -1;
		String [] menu_print = { lenguage.getInstance().getProperty("read_all"), lenguage.getInstance().getProperty("read_search"),"Manual"};
		if(Singleton.useradmin.isEmpty()){
			JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("error_01"), "ERROR", JOptionPane.ERROR_MESSAGE);
		}else{
			menu = functions.menuo(menu_print, lenguage.getInstance().getProperty("read_message"), lenguage.getInstance().getProperty("read_title"));
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
					a1=fnes_find.IDadmin();
					if(a1==null){
						JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("error_01"), "ERROR", JOptionPane.ERROR_MESSAGE);
					}else{
					//a1 = fnes_users4.ask_adminDNI();
					location = fnes_find.find_admin(a1);
					if (location != -1) {
						a1 = Singleton.useradmin.get(location);
						JOptionPane.showMessageDialog(null, a1.toString());
					}else {
						JOptionPane.showMessageDialog(null, "", "",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/Sergio/workspace/Users/src/Users/Ico/404.png"));
					}
					break;
					}
				case 2:
					a1 = fnes_users4.ask_adminDNI();
					location = fnes_find.find_admin(a1);
					if (location != -1) {
						a1 = Singleton.useradmin.get(location);
						JOptionPane.showMessageDialog(null, a1.toString());
					}else {
						try{
						PATH= new java.io.File(".").getCanonicalPath()+ "/src/Users/Ico/404.png";
						JOptionPane.showMessageDialog(null, "", "",JOptionPane.INFORMATION_MESSAGE, new ImageIcon(PATH));
						}catch(IOException e){}
						}
					break;
			}
		}
	}
	
	public static void read_client (){
        String PATH = null;
		usercl c1=null;
		int menu = 0, location = -1;
		String [] menu_print = {  lenguage.getInstance().getProperty("read_all"), lenguage.getInstance().getProperty("read_search"),"Manual" };

		if(Singleton.userclient.isEmpty()){
			JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("error_01"), "ERROR", JOptionPane.ERROR_MESSAGE);
			}else{
				menu = functions.menuo(menu_print, lenguage.getInstance().getProperty("read_message"), lenguage.getInstance().getProperty("read_title"));
			switch (menu){
				case 0:
					for (int i = 0; i <Singleton.userclient.size();i++){
						System.out.println("Numero de posicion: "+i);
						String cad = "";
						cad = cad + (Singleton.userclient.get(i).toString());
						JOptionPane.showMessageDialog(null, cad);
					}
					break;
				case 1:
					location = -1;
					c1=fnes_find.IDclient();
					if (c1==null){
						JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("error_01"), "ERROR", JOptionPane.ERROR_MESSAGE);
					}else{
					//c1 = fnes_users4.ask_clientDNI();
					location = fnes_find.find_client(c1);
					System.out.println("Numero que has elegido :"+location);
					if (location > -1) {
						c1 = Singleton.userclient.get(location);
						JOptionPane.showMessageDialog(null, c1.toString());
					}else {
						JOptionPane.showMessageDialog(null, "", "",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/Sergio/workspace/Users/src/Users/Ico/404.png"));
					}
					break;
					}
				case 2:
					c1 = fnes_users4.ask_clientDNI();
					location = fnes_find.find_client(c1);
					if (location != -1) {
						c1 = Singleton.userclient.get(location);
						JOptionPane.showMessageDialog(null, c1.toString());
					}else {
						try{
						PATH= new java.io.File(".").getCanonicalPath()+ "/src/Users/Ico/404.png";
						JOptionPane.showMessageDialog(null, "", "",JOptionPane.INFORMATION_MESSAGE, new ImageIcon(PATH));
						}catch(IOException e){}
						}
					break;
			}
		}
	}
	
	public static void read_usern (){
        String PATH = null;
 
		usern u1=null;
		int menu = 0, location = -1;
		String [] menu_print = {  lenguage.getInstance().getProperty("read_all"), lenguage.getInstance().getProperty("read_search"), "Manual" };

		if(Singleton.userregister.isEmpty()){
			JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("error_01"), "ERROR", JOptionPane.ERROR_MESSAGE);
			}else{
				menu = functions.menuo(menu_print, lenguage.getInstance().getProperty("read_message"), lenguage.getInstance().getProperty("read_title"));
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
					u1=fnes_find.IDuserregister();
					if (u1==null){
						JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("error_01"), "ERROR", JOptionPane.ERROR_MESSAGE);
					}else{
					//u1 = fnes_users4.ask_usernDNI();
					location = fnes_find.find_user(u1);
					if (location != -1) {
						u1 = Singleton.userregister.get(location);
						JOptionPane.showMessageDialog(null, u1.toString());
					}else {
						JOptionPane.showMessageDialog(null, "", "",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("C:/Users/Sergio/workspace/Users/src/Users/Ico/404.png"));
					}
					break;
					
					}
				case 2:
					u1 = fnes_users4.ask_usernDNI();
					location = fnes_find.find_user(u1);
					if (location != -1) {
						u1 = Singleton.userregister.get(location);
						JOptionPane.showMessageDialog(null, u1.toString());
					}else {
						try{
						PATH= new java.io.File(".").getCanonicalPath()+ "/src/Users/Ico/404.png";
						JOptionPane.showMessageDialog(null, "", "",JOptionPane.INFORMATION_MESSAGE, new ImageIcon(PATH));
						}catch(IOException e){}
						}
					break;
			}
		}
	}
}
