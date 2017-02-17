package Users.Utils;


import javax.swing.JOptionPane;

import Users.Classes.lenguage;
import Users.Classes.setting;
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
			JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+ setting.getInstance().getffecha(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
			break;
		case 1:
			set = "";
			set = "dd-mm-yyyy";
			setting.getInstance().setffecha(set);
			JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+ setting.getInstance().getffecha(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
			break;
		case 2:
			set = "";
			set = "yyyy/mm/dd";
			setting.getInstance().setffecha(set);
			JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+ setting.getInstance().getffecha(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
			break;
		case 3:
			set = "";
			set = "yyyy-mm-dd";
			setting.getInstance().setffecha(set);
			JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+ setting.getInstance().getffecha(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
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
			setting.getInstance().setcoin(coin);
			JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("changes")+setting.getInstance().getcoin(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
		break;
		case 1:
			coin="dollar";
			setting.getInstance().setcoin(coin);
			JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("changes")+setting.getInstance().getcoin(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
		break;
		case 2:
			coin="libra";
			setting.getInstance().setcoin(coin);
			JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("changes")+setting.getInstance().getcoin(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
		break;
		case 3:
			break;

		}
	}
	public static void decimal () {
		String decimal="";
		int menu = 0;
		String [] menu_decimal = { ".0", ".00", ".000" };
		
		menu = functions.menuo(menu_decimal, "Tin en compte que si el conté algún zero en la part final"+"\n"+" arredonira al valor mes proxim"+"\n"+"Exemple: Elegixes tres decimals y el valor 13.250,"+"\n"+"el resultat final sera 13.25"+"\n"+lenguage.getInstance().getProperty("choose_an_option"), lenguage.getInstance().getProperty("config"));
		
		switch (menu) {
			case 0:
				decimal = ".0";
				setting.getInstance().setdecimal(decimal);
				JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+setting.getInstance().getdecimal(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 1:
				decimal = ".00";
				setting.getInstance().setdecimal(decimal);
				JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+setting.getInstance().getdecimal(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 2:
				decimal = ".000";
				setting.getInstance().setdecimal(decimal);
				JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+setting.getInstance().getdecimal(),"FECHA",JOptionPane.INFORMATION_MESSAGE);
				break;
		}
	}
	
	public static void lang (){
		String language="";
		
		String[] lan= {lenguage.getInstance().getProperty("english"),lenguage.getInstance().getProperty("spanish"),"Valencia","Italiano","Portuges",lenguage.getInstance().getProperty("exit") };
		 int option= functions.menuo(lan, lenguage.getInstance().getProperty("choose_an_option"), lenguage.getInstance().getProperty("dateconf2"));
			switch(option){
			case 0:
				language="English";
				setting.getInstance().setlang(language);
				JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+setting.getInstance().getlang(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 1:
				language="Spanish";
				setting.getInstance().setlang(language);
				JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+setting.getInstance().getlang(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 2:
				language="Valencia";
				setting.getInstance().setlang(language);
				JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+setting.getInstance().getlang(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 3:
				language="Italiano";
				setting.getInstance().setlang(language);
				JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+setting.getInstance().getlang(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 4:
				language="Portuges";
				setting.getInstance().setlang(language);
				JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+setting.getInstance().getlang(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 5:
				break;
			}

		}
	public static void file(){
		String files="";
		String[] file= {"JSON","XML","TXT",lenguage.getInstance().getProperty("exit") };
		 int option= functions.menuo(file, lenguage.getInstance().getProperty("choose_an_option"), "FILES");
			switch(option){
			case 0:
				JOptionPane.showMessageDialog(null,"Service Unavailable" ,"Error", JOptionPane.ERROR_MESSAGE);
				break;
			case 1:
				files="XML";
				setting.getInstance().setfile(files);
				JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+setting.getInstance().getfile(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 2:
				files="TXT";
				setting.getInstance().setfile(files);
				JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+setting.getInstance().getfile(),"LANGUAGE",JOptionPane.INFORMATION_MESSAGE);
				break;
			case 3:
				break;
				
			}
			
	}
	public static boolean dummies(){

	int dummi = 0;
		String[] opdummi = {"ON","OFF", lenguage.getInstance().getProperty("exit") };
		dummi = functions.menuo(opdummi, lenguage.getInstance().getProperty("choose_an_option"),lenguage.getInstance().getProperty("config"));
			if(dummi==0){
				setting.getInstance().setdummies(true);
				return true;
			}else if(dummi==1){
				setting.getInstance().setdummies(false);
				return false;
			}
			return false;
	}
	public static void theme () {
		String [] options = { "METAL", "GTK", "MOTIF", "NINBUS", "Return"};
		int menu = 0;
		
		menu = functions.menuo(options, "Tema", "Tema" );
		switch (menu){
			case 0:// Metal - Predeterminado JAVA
				setting.getInstance().settheme("METAL");
				Functions_theme.theme();
				break;
	
			case 1:// GTK
				setting.getInstance().settheme("GTK");
				Functions_theme.theme();
				break;
	
			case 2:// Motif
				setting.getInstance().settheme("MOTIF");
				Functions_theme.theme();
				break;
	
			case 3:// Nimbus - JAVA
				setting.getInstance().settheme("NINBUS");
				Functions_theme.theme();
				break;
			case 4:
				break;
		}
	}
	public static void defaultsetting(){
		setting.getInstance().setcoin("euro");
		setting.getInstance().setdecimal(".0");
		setting.getInstance().setdummies(true);
		setting.getInstance().setffecha("dd/mm/yyyy");
		setting.getInstance().setfile("XML");
		setting.getInstance().setlang("English");
		setting.getInstance().settheme("METAL");
	}
	
}