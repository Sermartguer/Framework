package Users.Modules.User.Model.BLL.BLL_users.CRUD;

import Users.Modules.User.Model.BLL.BLL_users.Files_Users.Admin.Utils_Files.*;
import Users.Modules.User.Model.BLL.BLL_users.Files_Users.Client.Utils_Files_Client.*;
import Users.Modules.User.Model.BLL.BLL_users.Files_Users.Normal.Utils_Files_Normal.*;
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
