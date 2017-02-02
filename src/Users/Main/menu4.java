package Users.Main;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import Users.Utils.*;
import Users.Modules.User.Model.Classes.Singleton;
import Users.Modules.User.Model.Classes.userad;
import Users.Modules.User.Model.Classes.usercl;
import Users.Modules.User.Model.Classes.usern;
import Users.Modules.User.Model.Utils.Admin.Utils_Files.Files_Settings;
import Users.Modules.User.Model.Utils.CRUD.Functions_create;
import Users.Modules.User.Model.Utils.CRUD.Functions_delete;
import Users.Modules.User.Model.Utils.CRUD.Functions_open_auto;
import Users.Modules.User.Model.Utils.CRUD.Functions_order;
import Users.Modules.User.Model.Utils.CRUD.Functions_read;
import Users.Modules.User.Model.Utils.CRUD.Functions_save_auto;
import Users.Modules.User.Model.Utils.CRUD.Functions_update;
import Users.Modules.User.Model.Utils.Client.Utils_Files_Client.Files_Settings_Client;
import Users.Modules.User.Model.Utils.Normal.Utils_Files_Normal.Files_Settings_Normal;
import Users.Classes.*;

public class menu4 {

	public static void main(String[] args) {
		// Variables
		int operator = 0, ops = 0, operator_users = 0,settin=0;
		//String coin = "euro", date = "dd/mm/yyyy", decimal = ".0", file = "XML";
		boolean continu = false;
		// Operations
		setting.getInstance();
		
		
		do {
			String[] options_users = {lenguage.getInstance().getProperty("client"),lenguage.getInstance().getProperty("normal"),lenguage.getInstance().getProperty("admin"),lenguage.getInstance().getProperty("return")};
			String[] options = {lenguage.getInstance().getProperty("userm"),lenguage.getInstance().getProperty("config"),lenguage.getInstance().getProperty("exit")};
			String[] op = { lenguage.getInstance().getProperty("create"),lenguage.getInstance().getProperty("print_data"),lenguage.getInstance().getProperty("change_data"),lenguage.getInstance().getProperty("delete"),lenguage.getInstance().getProperty("order"),
					"Open", "Save", lenguage.getInstance().getProperty("exit") };
			operator = functions.menuo(options, lenguage.getInstance().getProperty("choose_an_option"),lenguage.getInstance().getProperty("userm"));
			if (operator == -1) {
				System.exit(0);
			}
			switch (operator) {
			case 0:
				do {
					operator_users = functions.menuo(options_users, lenguage.getInstance().getProperty("choose_an_option"),lenguage.getInstance().getProperty("userm"));
					switch (operator_users) {
					case 0:
						do {
							//////////////////////// CLIENT	////////////////////////
							ops = functions.menuo(op, lenguage.getInstance().getProperty("choose_an_option"),lenguage.getInstance().getProperty("client"));
							if (ops == -1) {
								System.exit(0);
							}
							switch (ops) {
							// CREAR
							case 0:
								Functions_create.create_client();
								break;
							// READ
							case 1:
								Functions_read.read_client();
								break;
							// UPDATE
							case 2:
								Functions_update.update_client();
								break;
							// DELETE
							case 3:
								Functions_delete.delete_client();
								break;
							// ORDENAR
							case 4:
								Functions_order.change_orderclient();
								break;
							case 5:
								Files_Settings_Client.open_ondemmand_client();
								break;
							case 6:
								Files_Settings_Client.save_ondemand_client();
								break;
							case 7:
								break;
							}
						} while (ops != 7);
						break;
					case 1:
						//////////////////////// NORMAL//////////////////////////
						do {
							ops = functions.menuo(op, lenguage.getInstance().getProperty("choose_an_option"),lenguage.getInstance().getProperty("normal"));
							if (ops == -1) {
								System.exit(0);
							}
							switch (ops) {
							// CREAR
							case 0:
								Functions_create.create_usern();
								break;
							// READ
							case 1:
								Functions_read.read_usern();
								break;
							// UPDATE
							case 2:
								Functions_update.update_userregister();
								break;
							// DELETE
							case 3:
								Functions_delete.delete_userregister();
								break;
							// ORDENAR
							case 4:
								Functions_order.change_orderuser();
								break;
							case 5:
								Files_Settings_Normal.open_ondemmand_normal();
								break;
							case 6:
								Files_Settings_Normal.save_ondemand_normal();
								break;
							case 7:
								break;
							}
						} while (ops != 7);
						break;
					case 2:
						////////////////////////	ADMIN	////////////////////////
						do {
							ops = functions.menuo(op, lenguage.getInstance().getProperty("choose_an_option"),lenguage.getInstance().getProperty("admin"));
							if (ops == -1) {
								System.exit(0);
							}
							switch (ops) {
							// CREAR
							case 0:
								Functions_create.create_admin();
								break;
							// READ
							case 1:
								Functions_read.read_admin();
								break;
							// UPDATE
							case 2:
								Functions_update.update_admin();
								break;
							// DELETE
							case 3:
								Functions_delete.delete_admin();
								break;
							// ORDENAR
							case 4:
								Functions_order.change_orderadmin();
								break;
							// OPEN
							case 5:
								Files_Settings.open_ondemmand_admin();
								break;
							case 6:
							// SAVE
								Files_Settings.save_ondemand_admin();
								break;
							case 7:
								break;
							}
						} while (ops != 7);
						break;
					case 3:
						break;
					}
				} while (operator_users != 3);
				break;
			case 1:
				do {
					String[] opsettin = {lenguage.getInstance().getProperty("date"),lenguage.getInstance().getProperty("coin"),lenguage.getInstance().getProperty("decimals"),lenguage.getInstance().getProperty("lang"),"Dummies",lenguage.getInstance().getProperty("files"),"Theme","Default APP",lenguage.getInstance().getProperty("return") };
					settin = functions.menuo(opsettin, lenguage.getInstance().getProperty("choose_an_option"),lenguage.getInstance().getProperty("config"));
					switch (settin) {
					case 0:
						settings.settingfecha();
						break;
					case 1:
						settings.coin();
						break;
					case 2:
						settings.decimal();
						break;
					case 3:
						settings.lang();
						break;
					case 4:
						settings.dummies();
						break;
					case 5:
						settings.file();
						break;
					case 6:
						settings.theme();
						break;
					case 7:
						settings.defaultsetting();
						break;
					case 8:
						continu = true;
						break;
					}
				} while (continu == false);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("goodbye"), lenguage.getInstance().getProperty("exit"),JOptionPane.INFORMATION_MESSAGE);
				Functions_save_auto.save();
				System.exit(0);
				break;
			}
		} while (operator != 4);
	}
}
