package Users.Utils;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import Users.Classes.lenguage;
import Users.Classes.setting;
import Users.Modules.User.Model.Classes.Singleton;
import Users.Utils.functions;

public class settings {

	
	public static void settingfecha() {
		String set = setting.getInstance().getffecha();
		System.out.println("dentro");
		String[] settq = { "dd/mm/yyyy", "dd-mm-yyyy", "yyyy/mm/dd", "yyyy-mm-dd", lenguage.getInstance().getProperty("exit") };
		int operatorq = 0;
		operatorq = functions.menuo(settq, lenguage.getInstance().getProperty("choose_an_option"), lenguage.getInstance().getProperty("userm"));
		
		if (operatorq == -1) {
			System.exit(0);
		}

		switch (operatorq) {
		case 0:
			set = "";
			set = "dd/mm/yyyy";
			setting.getInstance().setffecha(set);
			//Singleton.config.setffecha(set);
			//JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+ Singleton.config.getffecha(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
			break;
		case 1:
			set = "";
			set = "dd-mm-yyyy";
			setting.getInstance().setffecha(set);
			//Singleton.config.setffecha(set);
			//JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+ Singleton.config.getffecha(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
			break;
		case 2:
			set = "";
			set = "yyyy/mm/dd";
			//Singleton.config.setffecha(set);
			setting.getInstance().setffecha(set);
			//JOptionPane.showMessageDialog(null,Singleton.language.getProperty("changes")+ Singleton.config.getffecha(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
			break;
		case 3:
			set = "";
			set = "yyyy-mm-dd";
			//Singleton.config.setffecha(set);
			setting.getInstance().setffecha(set);
			//JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+ Singleton.config.getffecha(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
			break;
		case 4:
			break;

		}
	}
	public static void coin (){
		int set = 0;
		String coin="";
		String[] settq = { "Euro", "Dollar", "Lliura", lenguage.getInstance().getProperty("exit") };
		set = functions.menuo(settq, lenguage.getInstance().getProperty("choose_an_option"), lenguage.getInstance().getProperty("config"));
		switch (set) {
		case 0:
			coin="euro";
			//Singleton.config.setcoin(coin);
			setting.getInstance().setcoin(coin);
			//JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getcoin(),"FECHA",JOptionPane.INFORMATION_MESSAGE);

		break;
		case 1:
			coin="dollar";
			//Singleton.config.setcoin(coin);
			setting.getInstance().setcoin(coin);
			//JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getcoin(),"FECHA",JOptionPane.INFORMATION_MESSAGE);

		break;
		case 2:
			coin="libra";
			//Singleton.config.setcoin(coin);
			setting.getInstance().setcoin(coin);
			//JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getcoin(),"FECHA",JOptionPane.INFORMATION_MESSAGE);

		break;
		case 3:
			break;

		}
	}
	public static void decimal () {
		String decimal="";
		int menu = 0;
		String [] menu_decimal = { ".0", ".00", ".000" };
		
		menu = functions.menuo(menu_decimal, lenguage.getInstance().getProperty("choose_an_option"), lenguage.getInstance().getProperty("config"));
		
		switch (menu) {
			case 0:
				decimal = ".0";
				setting.getInstance().setdecimal(decimal);
				//Singleton.config.setdecimal(decimal);
				//JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getdecimal(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 1:
				decimal = ".00";
				setting.getInstance().setdecimal(decimal);
				//Singleton.config.setdecimal(decimal);
				//JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getdecimal(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 2:
				decimal = ".000";
				//Singleton.config.setdecimal(decimal);
				setting.getInstance().setdecimal(decimal);
				//JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getdecimal(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
				break;
		}
	}
	
	public static void lang (){
		String language="";
		
		String[] lan= {lenguage.getInstance().getProperty("english"),lenguage.getInstance().getProperty("spanish"),"Valencia",lenguage.getInstance().getProperty("exit") };
		 int option= functions.menuo(lan, lenguage.getInstance().getProperty("choose_an_option"), lenguage.getInstance().getProperty("dateconf2"));
			switch(option){
			case 0:
				language="English";
				//lenguage.getInstance().setIdioma("English");
				//Singleton.config.setlang("English");
				setting.getInstance().setlang(language);
				//JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+Singleton.config.getlang(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 1:
				language="Spanish";
				//lenguage.getInstance().setIdioma("Spanish");
				//Singleton.config.setlang("Spanish");
				setting.getInstance().setlang(language);
				//JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+Singleton.config.getlang(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 2:
				language="Valencia";
				//lenguage.getInstance().setIdioma("Valencia");
				//Singleton.config.setlang("Valencia");
				setting.getInstance().setlang(language);
				//JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+Singleton.config.getlang(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 3:
				break;
			}

		}
	public static void file(){
		String files="";
		String[] file= {"JSON","XML","TXT",lenguage.getInstance().getProperty("exit") };
		 int option= functions.menuo(file, lenguage.getInstance().getProperty("choose_an_option"), "FILES");
			switch(option){
			case 0:
				files="JSON";
				//Singleton.config.setfile(files);
				setting.getInstance().setfile(files);
				//JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+Singleton.config.getfile(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 1:
				files="XML";
				//Singleton.config.setfile(files);
				setting.getInstance().setfile(files);
				//JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+Singleton.config.getfile(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 2:
				files="TXT";
				//Singleton.config.setfile(files);
				setting.getInstance().setfile(files);
				//JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+Singleton.config.getfile(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 3:
				break;
				
			}
			
	}
	public static boolean dummies(){

	int dummi = 0;
		String[] opdummi = {lenguage.getInstance().getProperty("yes"),"No", lenguage.getInstance().getProperty("exit") };
		dummi = functions.menuo(opdummi, lenguage.getInstance().getProperty("choose_an_option"),lenguage.getInstance().getProperty("config"));
			if(dummi==0){
				//Singleton.config.setdummies(true);
				setting.getInstance().setdummies(true);
				return true;
			}else if(dummi==1){
				//Singleton.config.setdummies(false);
				setting.getInstance().setdummies(false);
				return false;
			}
			return false;
	}
	
}