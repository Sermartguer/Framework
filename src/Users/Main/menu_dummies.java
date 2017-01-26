package Users.Main;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import Users.Modules.User.Classes.*;
import Users.Utils.*;
import Users.Modules.User.Utils.*;
import Users.Classes.*;

public class menu_dummies {
	public static lenguage language = new lenguage("English");
	public static setting config = null;

	public static void main(String[] args) {
		// Variables
		int operator = 0, ops = 0;
		String res = "", coin = "euro", date = "dd/mm/yyyy", decimal = ".0";
		usercl cl = null;
		userad ad = null;
		usern n = null;
		boolean continu = false;
		// Operations

		ImageIcon icon = new ImageIcon("Ico/DarthPlagueisHS-SWI130.jpg");
		do {
			config = new setting(language.getIdioma(), decimal, date, coin);
			String[] options = { language.getProperty("client"), language.getProperty("normal"),
					language.getProperty("admin"), language.getProperty("config"), language.getProperty("exit") };
			String[] op = { language.getProperty("create"), language.getProperty("print_data"),
					language.getProperty("change_data"), language.getProperty("delete"), language.getProperty("exit") };
			
			// System.out.println("dalt"+language.getIdioma());
			// System.out.println(options[3]);
			operator = functions.menuo(options, language.getProperty("choose_an_option"),
					language.getProperty("userm"));

			if (operator == -1) {
				System.exit(0);
			}

			switch (operator) {

			case 0:
				do {

					//////////////////////// CLIENT //////////////////////////
					ops = functions.menuo(op, language.getProperty("choose_an_option"), language.getProperty("client"));
					if (ops == -1) {
						System.exit(0);
					}
					switch (ops) {

					// CREAR
					case 0:
						cl = (usercl) fnes_users4.create_users(0);
						break;

					// READ
					case 1:
						if (cl == null) {

							JOptionPane.showMessageDialog(null, menu4.language.getProperty("error_create"), "ERROR",
									JOptionPane.ERROR_MESSAGE);

						} else {
							res = fnes_users4.read_user(cl);
							JOptionPane.showMessageDialog(null, menu4.language.getProperty("client") + res,
									menu4.language.getProperty("client"), JOptionPane.INFORMATION_MESSAGE);
						}
						break;

					// UPDATE
					case 2:
						if (cl == null) {
							JOptionPane.showMessageDialog(null, menu4.language.getProperty("error_create"), "ERROR",
									JOptionPane.ERROR_MESSAGE);

						} else {
							fnes_users4.update_users(cl, date);
						}
						break;

					// DELETE
					case 3:
						if (cl == null) {
							JOptionPane.showMessageDialog(null, menu4.language.getProperty("error_create"), "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else {
							cl = (usercl) fnes_users4.delete_user(cl);
						}
						break;
					case 4:

						break;
					}
				} while (ops != 4);
				break;

			case 1:
				//////////////////////// NORMAL//////////////////////////
				do {

					ops = functions.menuo(op, language.getProperty("choose_an_option"), menu4.language.getProperty("normal"));
					if (ops == -1) {
						System.exit(0);
					}
					switch (ops) {

					// CREAR
					case 0:
						n = (usern) fnes_users4.create_users(1);
						break;

					// READ
					case 1:
						if (n == null) {
							JOptionPane.showMessageDialog(null, menu4.language.getProperty("error_create"), "ERROR",
									JOptionPane.ERROR_MESSAGE);

						} else {
							res = fnes_users4.read_user(n);
							JOptionPane.showMessageDialog(null, menu4.language.getProperty("normal") + res,
									menu4.language.getProperty("normal"), JOptionPane.INFORMATION_MESSAGE);
							System.out.println("entre");
						}
						break;

					// UPDATE
					case 2:
						System.out.println("dins");
						if (n == null) {
							JOptionPane.showMessageDialog(null, menu4.language.getProperty("error_create"), "ERROR",
									JOptionPane.ERROR_MESSAGE);

						} else {

							n = (usern) fnes_users4.update_users(n, date);

						}
						break;

					// DELETE
					case 3:
						if (n == null) {
							JOptionPane.showMessageDialog(null, menu4.language.getProperty("error_create"), "ERROR",
									JOptionPane.ERROR_MESSAGE);

						} else {
							n = (usern) fnes_users4.delete_user(n);
						}
						break;
					case 4:

						break;
					}
				} while (ops != 4);

				break;
			case 2:
				//////////////////////// ADMIN //////////////////////////
				do {

					ops = functions.menuo(op, language.getProperty("choose_an_option"), menu4.language.getProperty("admin"));
					if (ops == -1) {
						System.exit(0);
					}
					switch (ops) {

					// CREAR
					case 0:
						ad = (userad) fnes_users4.create_users(2);
						break;

					// READ
					case 1:
						if (ad == null) {
							JOptionPane.showMessageDialog(null, menu4.language.getProperty("error_create"), "ERROR",
									JOptionPane.ERROR_MESSAGE);

						} else {
							res = fnes_users4.read_user(ad);
							JOptionPane.showMessageDialog(null, menu4.language.getProperty("admin") + res,
									menu4.language.getProperty("admin"), JOptionPane.INFORMATION_MESSAGE);
						}
						break;

					// UPDATE
					case 2:
						if (ad == null) {
							JOptionPane.showMessageDialog(null, menu4.language.getProperty("error_create"), "ERROR",
									JOptionPane.ERROR_MESSAGE);

						} else {
							ad = (userad) fnes_users4.update_users(ad, date);
						}
						break;

					// DELETE
					case 3:
						if (ad == null) {
							JOptionPane.showMessageDialog(null, menu4.language.getProperty("error_create"), "ERROR",
									JOptionPane.ERROR_MESSAGE);

						} else {
							ad = (userad) fnes_users4.delete_user(ad);
						}
						break;
					case 4:

						break;

					}
				} while (ops != 4);

				break;

			// SETTINGS
			case 3:

				do {
					String[] opsettin = { language.getProperty("date"), language.getProperty("coin"), language.getProperty("decimals"), language.getProperty("lang"), language.getProperty("exit") };
					int settin = 0;
					settin = functions.menuo(opsettin, language.getProperty("choose_an_option"),
							language.getProperty("config"));
					switch (settin) {
					case 0:
						date = settings.settingfecha();
						System.out.println(continu);
						break;
					case 1:
						coin = settings.coin();
						
						break;
					case 2:
						decimal = settings.decimal();
						
						break;
					case 3:
						settings.lang();
						break;
					case 4:
						continu=true;
						break;
					}
				} while (continu == false);

			case 4:

				break;
			}

		} while (operator != 4);

	}
}
