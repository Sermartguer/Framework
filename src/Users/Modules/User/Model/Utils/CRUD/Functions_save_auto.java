package Users.Modules.User.Model.Utils.CRUD;

import Users.Modules.User.Model.Utils.Admin.Utils_Files.Files_Settings;
import Users.Modules.User.Model.Utils.Client.Utils_Files_Client.Files_Settings_Client;
import Users.Modules.User.Model.Utils.Normal.Utils_Files_Normal.Files_Settings_Normal;
import Users.Utils.JSON_Setting;


public class Functions_save_auto {
	public static void save () {
		//Admin
		Files_Settings.save_auto_admin();
		Files_Settings_Normal.save_auto_normal();
		Files_Settings_Client.save_auto_client();
		JSON_Setting.savejson_config();
	}
}
