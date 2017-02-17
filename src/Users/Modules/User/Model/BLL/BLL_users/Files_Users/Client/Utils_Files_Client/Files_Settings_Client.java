package Users.Modules.User.Model.BLL.BLL_users.Files_Users.Client.Utils_Files_Client;

import javax.swing.JOptionPane;

import Users.Classes.setting;
import Users.Modules.User.Model.Classes.Singleton;

public class Files_Settings_Client {
	public static void open_auto_client(){
		//Open_Client.openjson_client();
		Open_Client.opentxt_client();
		Open_Client.openxml_client();
	}
	public static void save_auto_client(){
		//Save_Client.savejson_client();
		Save_Client.savetxt_client();
		Save_Client.savexml_client();
	}
	public static void open_ondemmand_client(){
		String file=setting.getInstance().getfile();
		if (file.equals("XML")){
			Singleton.userclient=Open_Client.obri_xml_ondemand();
		}else if(file.equals("TXT")){
			Singleton.userclient=Open_Client.obri_txt_ondemand();
		}else if (file.equals("JSON")){
			JOptionPane.showMessageDialog(null,"Service Unavailable" ,"Error", JOptionPane.ERROR_MESSAGE);
			//Singleton.useradmin=Open_Admin.obri_json();
		}
	}
	public static void save_ondemand_client(){
		String file=setting.getInstance().getfile();
		System.out.println(file);
		if (file.equals("XML")){
			Save_Client.savexml_client_ondemmand();
		}else if(file.equals("TXT")){
			Save_Client.savetxt_client_ondemmand();
		}else if (file.equals("JSON")){
			JOptionPane.showMessageDialog(null,"Service Unavailable" ,"Error", JOptionPane.ERROR_MESSAGE);
			//Singleton.useradmin=Open_Admin.obri_json();
		}
	}
}
