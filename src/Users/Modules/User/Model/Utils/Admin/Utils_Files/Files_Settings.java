package Users.Modules.User.Model.Utils.Admin.Utils_Files;

import javax.swing.JOptionPane;

import Users.Modules.User.Model.Classes.Singleton;

public class Files_Settings {
public static void open_auto_admin(){
	//Open_Admin.openjson_admin();
	Open_Admin.openxml_admin();
	Open_Admin.opentxt_admin();
}
public static void save_auto_admin(){
	//Save_Admin.savejson_admin();
	Save_Admin.savexml_admin();
	Save_Admin.savetxt_admin();
}
public static void open_ondemmand_admin(){
	String file=Singleton.config.getfile();
	if (file.equals("XML")){
		Singleton.useradmin=Open_Admin.obri_xml();
	}else if(file.equals("TXT")){
		Singleton.useradmin=Open_Admin.obri_txt();
	}else if (file.equals("JSON")){
		JOptionPane.showMessageDialog(null,"Service Unavailable" ,"Error", JOptionPane.ERROR_MESSAGE);
		//Singleton.useradmin=Open_Admin.obri_json();
	}
}
public static void save_ondemand_admin(){
	String file=Singleton.config.getfile();
	System.out.println(file);
	if (file.equals("XML")){
		Save_Admin.savexml_admin_ondemmand();	
	}else if(file.equals("TXT")){
		Save_Admin.savetxt_admin_ondemmand();
	}else if (file.equals("JSON")){
		JOptionPane.showMessageDialog(null,"Service Unavailable" ,"Error", JOptionPane.ERROR_MESSAGE);
		//Singleton.useradmin=Open_Admin.obri_json();
	}
}
}
