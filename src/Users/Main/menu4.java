package Users.Main;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import Users.Utils.*;
import Users.Modules.User.Classes.Singleton;
import Users.Modules.User.Utils.Admin.Utils_Files.Files_Settings;
import Users.Modules.User.Utils.CRUD.Functions_create;
import Users.Modules.User.Utils.CRUD.Functions_delete;
import Users.Modules.User.Utils.CRUD.Functions_open_auto;
import Users.Modules.User.Utils.CRUD.Functions_order;
import Users.Modules.User.Utils.CRUD.Functions_read;
import Users.Modules.User.Utils.CRUD.Functions_save_auto;
import Users.Modules.User.Utils.CRUD.Functions_update;
import Users.Modules.User.Utils.Client.Utils_Files_Client.Files_Settings_Client;
import Users.Modules.User.Utils.Normal.Utils_Files_Normal.Files_Settings_Normal;
import Users.Classes.*;

public class menu4 {

	public static void main(String[] args) {
		// Variables
		int operator = 0, ops = 0, operator_users = 0,settin=0;
		String coin = "euro", date = "dd/mm/yyyy", decimal = ".0", file = "XML";
		boolean continu = false,dummies=true;
		// Operations
		

		Functions_open_auto.open();
		if (Singleton.useradmin==null){
			System.out.println("Ye loco");
		}
		Singleton.config = new setting(Singleton.language.getIdioma(), decimal, date, coin, file, dummies);
		String[] options_users = {Singleton.language.getProperty("client"),Singleton.language.getProperty("normal"),Singleton.language.getProperty("admin"),Singleton.language.getProperty("return")};
		String[] options = {Singleton.language.getProperty("userm"),Singleton.language.getProperty("config"),Singleton.language.getProperty("exit")};
		String[] op = { Singleton.language.getProperty("create"),Singleton.language.getProperty("print_data"),Singleton.language.getProperty("change_data"),Singleton.language.getProperty("delete"),Singleton.language.getProperty("order"),
				"Open", "Save", Singleton.language.getProperty("exit") };
		String[] opsettin = {Singleton.language.getProperty("date"),Singleton.language.getProperty("coin"),Singleton.language.getProperty("decimals"),Singleton.language.getProperty("lang"),"Dummies",Singleton.language.getProperty("files"),Singleton.language.getProperty("return") };
		do {
			operator = functions.menuo(options, Singleton.language.getProperty("choose_an_option"),Singleton.language.getProperty("userm"));
			if (operator == -1) {
				System.exit(0);
			}
			switch (operator) {
			case 0:
				do {
					operator_users = functions.menuo(options_users, Singleton.language.getProperty("choose_an_option"),Singleton.language.getProperty("userm"));
					switch (operator_users) {
					case 0:
						do {
							//////////////////////// CLIENT	////////////////////////
							ops = functions.menuo(op, Singleton.language.getProperty("choose_an_option"),Singleton.language.getProperty("client"));
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
							ops = functions.menuo(op, Singleton.language.getProperty("choose_an_option"),Singleton.language.getProperty("normal"));
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
							ops = functions.menuo(op, Singleton.language.getProperty("choose_an_option"),Singleton.language.getProperty("admin"));
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
					settin = functions.menuo(opsettin, Singleton.language.getProperty("choose_an_option"),Singleton.language.getProperty("config"));
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
						continu = true;
						break;
					}
				} while (continu == false);
				break;
			case 2:
				Functions_save_auto.save();
				JOptionPane.showMessageDialog(null, Singleton.language.getProperty("oodbye"), Singleton.language.getProperty("exit"),JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
				break;
			}
		} while (operator != 4);
	}
}
