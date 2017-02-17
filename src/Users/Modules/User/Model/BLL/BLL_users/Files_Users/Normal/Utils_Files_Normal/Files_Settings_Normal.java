package Users.Modules.User.Model.BLL.BLL_users.Files_Users.Normal.Utils_Files_Normal;

import javax.swing.JOptionPane;

import Users.Classes.setting;
import Users.Modules.User.Model.Classes.Singleton;

public class Files_Settings_Normal {
	public static void open_auto_normal(){
		//Open_Normal.openjson_normal();
		Open_Normal.opentxt_normal();
		Open_Normal.openxml_normal();
		
	}
	public static void save_auto_normal(){
		//Save_Normal.savejson_normal();
		Save_Normal.savetxt_normal();
		Save_Normal.savexml_normal();
		
	}
	public static void open_ondemmand_normal(){
		String file=setting.getInstance().getfile();
		if (file.equals("XML")){
			Singleton.userregister=Open_Normal.obri_xml_ondemand();
		}else if(file.equals("TXT")){
			Singleton.userregister=Open_Normal.obri_txt_ondemand();
		}else if (file.equals("JSON")){
			JOptionPane.showMessageDialog(null,"Service Unavailable" ,"Error", JOptionPane.ERROR_MESSAGE);
			//Singleton.useradmin=Open_Admin.obri_json();
		}
	}
	public static void save_ondemand_normal(){
		String file=setting.getInstance().getfile();
		System.out.println(file);
		if (file.equals("XML")){
			Save_Normal.savexml_normal_ondemmand();
		}else if(file.equals("TXT")){
			Save_Normal.savetxt_normal_ondemmand();
		}else if (file.equals("JSON")){
			JOptionPane.showMessageDialog(null,"Service Unavailable" ,"Error", JOptionPane.ERROR_MESSAGE);
			//Singleton.useradmin=Open_Admin.obri_json();
		}
	}
}
