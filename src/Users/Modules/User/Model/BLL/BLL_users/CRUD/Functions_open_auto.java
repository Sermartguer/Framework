package Users.Modules.User.Model.BLL.BLL_users.CRUD;

import Users.Classes.setting;
import Users.Modules.User.Model.Classes.Singleton;
import Users.Modules.User.Model.BLL.BLL_users.Files_Users.Admin.Utils_Files.*;
import Users.Modules.User.Model.BLL.BLL_users.Files_Users.Client.Utils_Files_Client.*;
import Users.Modules.User.Model.BLL.BLL_users.Files_Users.Normal.Utils_Files_Normal.*;
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
