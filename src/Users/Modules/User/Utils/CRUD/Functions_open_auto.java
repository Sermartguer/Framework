package Users.Modules.User.Utils.CRUD;

import Users.Modules.User.Classes.Singleton;
import Users.Modules.User.Utils.Admin.Utils_Files.Files_Settings;
import Users.Modules.User.Utils.Client.Utils_Files_Client.Files_Settings_Client;
import Users.Modules.User.Utils.Normal.Utils_Files_Normal.Files_Settings_Normal;


public class Functions_open_auto {
	public static void open () {
		//Admin
		Files_Settings.open_auto_admin();
		//Normal
		Files_Settings_Normal.open_auto_normal();
		//Client
		Files_Settings_Client.open_auto_client();
	}
}
