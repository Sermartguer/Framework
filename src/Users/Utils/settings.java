package Users.Utils;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import Users.Modules.User.Classes.Singleton;
import Users.Utils.functions;

public class settings {

	
	public static void settingfecha() {
		String setting = Singleton.config.getffecha();
		System.out.println("dentro");
		String[] settq = { "dd/mm/yyyy", "dd-mm-yyyy", "yyyy/mm/dd", "yyyy-mm-dd", Singleton.language.getProperty("exit") };
		int operatorq = 0;
		operatorq = functions.menuo(settq, Singleton.language.getProperty("choose_an_option"), Singleton.language.getProperty("userm"));
		
		if (operatorq == -1) {
			System.exit(0);
		}

		switch (operatorq) {
		case 0:
			setting = "";
			setting = "dd/mm/yyyy";
			Singleton.config.setffecha(setting);
			JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+ Singleton.config.getffecha(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
			break;
		case 1:
			setting = "";
			setting = "dd-mm-yyyy";
			Singleton.config.setffecha(setting);
			JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+ Singleton.config.getffecha(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
			break;
		case 2:
			setting = "";
			setting = "yyyy/mm/dd";
			Singleton.config.setffecha(setting);
			JOptionPane.showMessageDialog(null,Singleton.language.getProperty("changes")+ Singleton.config.getffecha(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
			break;
		case 3:
			setting = "";
			setting = "yyyy-mm-dd";
			Singleton.config.setffecha(setting);
			JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+ Singleton.config.getffecha(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
			break;
		case 4:
			break;

		}
	}
	public static void coin (){
		int set = 0;
		String coin="";
		String[] settq = { "Euro", "Dollar", "Lliura", Singleton.language.getProperty("exit") };
		set = functions.menuo(settq, Singleton.language.getProperty("choose_an_option"), Singleton.language.getProperty("config"));
		switch (set) {
		case 0:
			coin="euro";
			Singleton.config.setcoin(coin);
			JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getcoin(),"FECHA",JOptionPane.INFORMATION_MESSAGE);

		break;
		case 1:
			coin="dollar";
			Singleton.config.setcoin(coin);
			JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getcoin(),"FECHA",JOptionPane.INFORMATION_MESSAGE);

		break;
		case 2:
			coin="libra";
			Singleton.config.setcoin(coin);
			JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getcoin(),"FECHA",JOptionPane.INFORMATION_MESSAGE);

		break;
		case 3:
			break;

		}
	}
	public static void decimal () {
		String decimal="";
		int menu = 0;
		String [] menu_decimal = { ".0", ".00", ".000" };
		
		menu = functions.menuo(menu_decimal, Singleton.language.getProperty("choose_an_option"), Singleton.language.getProperty("config"));
		
		switch (menu) {
			case 0:
				decimal = ".0";
				Singleton.config.setdecimal(decimal);
				JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getdecimal(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 1:
				decimal = ".00";
				Singleton.config.setdecimal(decimal);
				JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getdecimal(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 2:
				decimal = ".000";
				Singleton.config.setdecimal(decimal);
				JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getdecimal(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
				break;
		}
	}
	
	public static void lang (){
		String language="";
		
		String[] lan= {Singleton.language.getProperty("english"),Singleton.language.getProperty("spanish"),"Valencia",Singleton.language.getProperty("exit") };
		 int option= functions.menuo(lan, Singleton.language.getProperty("choose_an_option"), Singleton.language.getProperty("dateconf2"));
			switch(option){
			case 0:
				language="English";
				Singleton.language.setIdioma("English");
				Singleton.config.setlang("English");
				JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getlang(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 1:
				language="Spanish";
				Singleton.language.setIdioma("Spanish");
				Singleton.config.setlang("Spanish");
				JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getlang(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 2:
				language="Valencia";
				Singleton.language.setIdioma("Valencia");
				Singleton.config.setlang("Valencia");
				JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getlang(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 3:
				break;
			}

		}
	public static void file(){
		String files="";
		String[] file= {"JSON","XML","TXT",Singleton.language.getProperty("exit") };
		 int option= functions.menuo(file, Singleton.language.getProperty("choose_an_option"), "FILES");
			switch(option){
			case 0:
				files="JSON";
				Singleton.config.setfile(files);
				JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getfile(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 1:
				files="XML";
				Singleton.config.setfile(files);
				JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getfile(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 2:
				files="TXT";
				Singleton.config.setfile(files);
				JOptionPane.showMessageDialog(null, Singleton.language.getProperty("changes")+Singleton.config.getfile(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 3:
				break;
				
			}
			
	}
	public static boolean dummies(){

	int dummi = 0;
		String[] opdummi = {Singleton.language.getProperty("yes"),"No", Singleton.language.getProperty("exit") };
		dummi = functions.menuo(opdummi, Singleton.language.getProperty("choose_an_option"),Singleton.language.getProperty("config"));
			if(dummi==0){
				Singleton.config.setdummies(true);
				return true;
			}else if(dummi==1){
				Singleton.config.setdummies(false);
				return false;
			}
			return false;
	}
	
}