package Users.Modules.User.Utils.CRUD;

import Users.Classes.setting;
import Users.Modules.User.Classes.Singleton;
import Users.Modules.User.Utils.Admin.Utils_Files.Files_Settings;
import Users.Modules.User.Utils.Client.Utils_Files_Client.Files_Settings_Client;
import Users.Modules.User.Utils.Normal.Utils_Files_Normal.Files_Settings_Normal;
import Users.Utils.JSON_Setting;


public class Functions_open_auto {
	public static void open () {
		//Admin
		Files_Settings.open_auto_admin();
		//Normal
		Files_Settings_Normal.open_auto_normal();
		//Client
		Files_Settings_Client.open_auto_client();
		JSON_Setting.openjson_config();
		System.out.println(setting.getInstance().toString());

	}
}
