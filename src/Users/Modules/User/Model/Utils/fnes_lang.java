package Users.Modules.User.Model.Utils;

import javax.swing.JOptionPane;

import Users.Classes.lenguage;
import Users.Classes.*;

public class fnes_lang {
	
	public static int menuo(String[] options, String message, String title){
		/*En el main te que haber una variable 	String [ ] operaciones= {"suma","resta","producto","divisi�n", "hola"}; */
		//Variables
			int option=0;
		//Operations
			option=JOptionPane.showOptionDialog(null, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
			return option;
		}
	
public static String[] menuf (String lang){
	
	String[] op={};
	if (lang=="es"){
		String[] options = { "Cliente", "Normal", "Admin", "Configuracion", "Salir" };

		return options;
	}
	if (lang=="en"){
		String[] options = { "Client", "Normal", "Admin", "Settings", "Exit" };
		return options;
	}
	return op;
}

public static String[] menucrud (String lang){
	String[] op={};
	if (lang=="es"){
		String[] options = { "Crear", "Leer", "Actualizar", "Eliminar", "Salir" };
		return options;
	}
	if (lang=="en"){
		String[] options = { "Create", "Read", "Update", "Delete", "Exit" };
		return options;
	}
	return op;
}
public static String[] menusetting (String lang){
	String[] op={};
	if (lang=="es"){
		String[] options = { "FECHA", "MONEDA", "DECIMALS", "Salir" };
		return options;
	}
	if (lang=="en"){
		String[] options = { "DATE", "COIN", "DECIMAL", "EXIT" };
		return options;
	}
	return op;
}
	
	
}
