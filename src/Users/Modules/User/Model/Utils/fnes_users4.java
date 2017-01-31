package Users.Modules.User.Model.Utils;

import java.text.ParseException;

import javax.swing.JOptionPane;

import Users.Modules.User.Model.Classes.*;
import Users.Utils.functions;
import Users.Classes.*;

public class fnes_users4 {
	/* INT I=0-CLIENT 1-NORMAL 2-ADMIN */
	public static usu create_users(int i) {
		usu u = null;
		////////////// CLIENT//////////
		if (i == 0) {
			// Atributs
			int ptos = 0;
			int descuentos = 0;
			String nom = "";
			String dni = "";
			fecha fnac = null;
			int edad = 0;
			int n_comp=0;
			String email="";
			// Operacions
			email = fnes_v.vEMAIL();
			nom = fnes_v.vNOM();
			dni = Singleton.DNI;
			fnac = func_fech.fNAC();
			edad = func_fech.vEDAD(fnac);
			n_comp=functions.vint(lenguage.getInstance().getProperty("shopp"), lenguage.getInstance().getProperty("shopp2"));
			descuentos = func_plus.discount(n_comp);
			
			u = new usercl(nom, dni, fnac, edad,email,n_comp, descuentos);
		} else if (i == 1) {
			////////////// NORMAL//////////////
			
			// Atributs
			String nom = "";
			String dni = "";
			int edad = 0;
			fecha fnac = null;
			int n_com=0;
			String karma="";
			int points=0;
			String email="";
			// Operacions
			email = fnes_v.vEMAIL();
			nom = fnes_v.vNOM();
			dni = Singleton.DNI;
			fnac = func_fech.fNAC();
			edad = func_fech.vEDAD(fnac);
			n_com=fnes_v.vN_COM();
			karma=func_plus.karma(n_com);
			points=func_plus.points(karma);
			
			u = new usern(nom, dni, fnac, edad,email,n_com,karma,points);
		} else if (i == 2) {
			////////////// ADMIN//////////////
			// ATRIBUTS
			int edad = 0;
			String email = "", username = "";
			String sex = "";
			String nom = "";
			String dni = "";
			int antiguitat = 0;
			int salary=0;
			fecha fnac = null;
			fecha fant = null;
			String apto = "";
			String alta = "";
			int sou=0;
			// OPERACIONS
			nom = fnes_v.vNOM();
			dni = Singleton.DNI;
			sex = fnes_v.vSEX();
			email = fnes_v.vEMAIL();
			username = fnes_v.vUSERNAME(nom);
			fnac = func_fech.fNAC();
			edad = func_fech.vEDAD(fnac);
			fant = func_fech.fCONT(fnac);
			antiguitat = func_fech.vANTIGUITAT(fant, fnac);
			salary=func_plus.salary(antiguitat);
			apto = func_fech.Apto(fnac, fant);
			alta = func_fech.vALTA();
			sou=functions.vint("Dame el sou", "SOU");
			
			u = new userad(nom, dni, fnac, edad, sex, email, username, fant, antiguitat,salary, apto, alta,sou);
			System.out.println("Objecte admin" + "\n" + u);
		}

		return u;
	}

		public static userad ask_adminDNI () {
				
				Singleton.DNI=fnes_v.vDNI();
				
				return new userad (Singleton.DNI);
			}
			
		public static usercl ask_clientDNI () {
			
				Singleton.DNI=fnes_v.vDNI();
			
			return new usercl(Singleton.DNI);
		}
		public static usern ask_usernDNI () {
			
			Singleton.DNI=fnes_v.vDNI();
			
			return new usern(Singleton.DNI);
		}
	
	
	public static String read_user(usu u){
		String cad = "";
		if (u instanceof usercl) {
			cad = cad + ((usercl) u).toString();
		}
		if (u instanceof usern) {
			cad = cad + ((usern) u).toString();
		}
		if (u instanceof userad) {
			cad = cad + ((userad) u).toString();
		}
		System.out.println(cad);
		return cad;
	}

	public static usu update_users(usu u,String type) {

		/* INT I=0-CLIENT 1-NORMAL 2-ADMIN */
	   ////////////////////// UPDATE CLIENT///////////////////
		if (u instanceof usercl) {

			String[] options = { lenguage.getInstance().getProperty("name2"), "DNI", lenguage.getInstance().getProperty("nac_fech"),lenguage.getInstance().getProperty("shopp2"), lenguage.getInstance().getProperty("return") };
			int operator = 0;
			String res = "";


			do {

				operator = functions.menuo(options, "Que vols cambiar", "Choose one");
				if (operator == -1) {
					System.exit(0);
				}

				switch (operator) {

				case 0:

					/* NOM */
					res = fnes_v.vNOM();
					u.setnom(res);
					JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes") + u.getnom(),lenguage.getInstance().getProperty("warning"), JOptionPane.INFORMATION_MESSAGE);

					break;

				case 1:

					/* DNI */
					res = fnes_v.vDNI();
					u.setdni(res);
					JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+ u.getdni(),lenguage.getInstance().getProperty("warning"), JOptionPane.INFORMATION_MESSAGE);

					break;
				
				
			
				case 2:
					/* Edad */
					// res=fnes_v.vEDAD();
					fecha fnac = null;
					int edad = 0;
					fnac = func_fech.fNAC();
					((usu) u).setf_nac(fnac);
					edad = func_fech.vEDAD(fnac);
					((usu) u).setedad(edad);
					JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("changes") + ((usu) u).getf_nac() + "\n"+"Y la teua edad es: " + ((usu) u).getedad(),lenguage.getInstance().getProperty("warning"), JOptionPane.INFORMATION_MESSAGE);

					break;
					
				case 3:
					/* NUMERO DE COMPRES*/
					int n_comp=0;
					int descuentos=0;
					n_comp=functions.vint("Dame el numero de compres que has fet", "Numero de compres");
					((usercl)u).setn_comp(n_comp);
					descuentos = func_plus.discount(n_comp);
					((usercl)u).setdes(descuentos);
					break;
				case 4:
					
					break;
				}// fi_switch

			} while (operator != 4);
			//////////////////////UPDATE NORMAL///////////////////

		} else if (u instanceof usern) {

			String[] options = { lenguage.getInstance().getProperty("name2"), "DNI", lenguage.getInstance().getProperty("nac_fech"), lenguage.getInstance().getProperty("ptos"), lenguage.getInstance().getProperty("exit") };

			int operator = 0;
			String res = "";

			int n_com=0;
			String karma="";
			int points=0;
			do {

				operator = functions.menuo(options, "Que vols cambiar", "Choose one");
				if (operator == -1) {
					System.exit(0);
				}

				switch (operator) {

				case 0:

					/* DNI */
					res = fnes_v.vNOM();
					u.setnom(res);
					JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("changes")+ u.getnom(),lenguage.getInstance().getProperty("warning"), JOptionPane.INFORMATION_MESSAGE);

					break;

				case 1:

					/* NOM */
					res = fnes_v.vDNI();
					u.setdni(res);
					JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("changes")+ u.getdni(),lenguage.getInstance().getProperty("warning"), JOptionPane.INFORMATION_MESSAGE);

					break;
				case 2:

					/* EDAD */
					fecha fnac = null;
					int edad = 0;
					fnac = func_fech.fNAC();
					edad = func_fech.vEDAD(fnac);
					((usu) u).setf_nac(fnac);
					
					((usu) u).setedad(edad);
					JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("changes") + ((usu) u).getf_nac() + "\n"+"Y la teua edad es: " + ((usu) u).getedad(),lenguage.getInstance().getProperty("warning"), JOptionPane.INFORMATION_MESSAGE);

					break;

				case 3:

					/* Punts */
					n_com=fnes_v.vN_COM();
					((usern)u).setn_com(n_com);
					karma=func_plus.karma(n_com);
					((usern)u).setkarma(karma);
					points=func_plus.points(karma);
					((usern)u).setpunts(points);
					break;
				case 4:

					break;
				}// fi_switch

			} while (operator != 4);
		} else if (u instanceof userad) {
			//////////////////////UPDATE ADMIN///////////////////

			String[] options = {  lenguage.getInstance().getProperty("name2"), "DNI", "SEXE", lenguage.getInstance().getProperty("email2"), lenguage.getInstance().getProperty("user2"), lenguage.getInstance().getProperty("nac_fech"),
					lenguage.getInstance().getProperty("hiring_date2")};
			String operator = "",res = "";
		

				operator = functions.menucombox(options, "Que vols cambiar", "Choose one");
				
				if(operator.equalsIgnoreCase(lenguage.getInstance().getProperty("name2"))){
					operator="NOM";
				}
				if(operator.equalsIgnoreCase(lenguage.getInstance().getProperty("email2"))){
					operator="EMAIL";
				}
				if(operator.equalsIgnoreCase(lenguage.getInstance().getProperty("user2"))){
					operator="USERNAME";
				}
				if(operator.equalsIgnoreCase(lenguage.getInstance().getProperty("nac_fech"))){
					operator="FECHA DE NAIXIMENT";
				}
				if(operator.equalsIgnoreCase(lenguage.getInstance().getProperty("hiring_date2"))){
					operator="FECHA DE CONTRATACIO";
				}
				

				switch (operator) {

				case "NOM":
					
					/* NOM */
					res = fnes_v.vNOM();
					u.setnom(res);
					JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes") + u.getnom(),lenguage.getInstance().getProperty("warning"), JOptionPane.INFORMATION_MESSAGE);

					break;

				case "DNI":

					/* DNI */
					res = fnes_v.vDNI();
					u.setdni(res);
					JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes") + u.getdni(),lenguage.getInstance().getProperty("warning"), JOptionPane.INFORMATION_MESSAGE);

					break;

				case "SEXE":

					/* SEXE */
					res = fnes_v.vSEX();
					((userad) u).setsex(res);
					JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("changes")+ ((userad) u).getsexo(), lenguage.getInstance().getProperty("warning"),JOptionPane.INFORMATION_MESSAGE);

					break;

				case "EMAIL":

					/* EMAIL */
					res = fnes_v.vEMAIL();
					((userad) u).setemail(res);
					JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("changes")+ ((userad) u).getemail(), lenguage.getInstance().getProperty("warning"),JOptionPane.INFORMATION_MESSAGE);

					break;
				case "USERNAME":

					/* USERNAME */
					String nom = "";
					res = fnes_v.vUSERNAME(nom);
					((userad) u).setusername(res);
					JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("changes")+((userad) u).getusername(),lenguage.getInstance().getProperty("warning"),JOptionPane.INFORMATION_MESSAGE);

					break;
				case "FECHA DE NAIXIMENT":
					fecha fnac = null;
					int edad = 0,ant=0;
					boolean bo=false;
					
					do{
					fnac = func_fech.fNAC();
					edad = func_fech.vEDAD(fnac);
					ant=((userad) u).getAntiguitat();
					System.out.println(edad-ant);
					bo=func_fech.compr(edad, ant);
					}while(bo==false);
					
					((usu) u).setf_nac(fnac);
					((usu) u).setedad(edad);
					
					JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("changes")+((usu) u).getf_nac() + "\n"+ "Y la teua edad es: " +((usu) u).getedad(), lenguage.getInstance().getProperty("warning"), JOptionPane.INFORMATION_MESSAGE);

					break;
				case "FECHA DE CONTRATACIO":
					int anto = 0,salary=0;
					String apto = "";
					fecha fant = null;
					
					fecha fnaci = ((usu) u).getf_nac();
					fant = func_fech.fCONT(fnaci);
					((userad) u).setfant(fant);
					anto = func_fech.vANTIGUITAT(fant, fnaci);
					((userad) u).seteant(anto);
					apto = func_fech.Apto(fnaci, fant);
					((userad) u).setapto(apto);
					salary=func_plus.salary(anto);
					((userad)u).setsalary(salary);
					
					JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("changes") + ((userad) u).getfant()+((userad) u).getAntiguitat(),lenguage.getInstance().getProperty("warning"), JOptionPane.INFORMATION_MESSAGE);

					break;
				
				}// fi_switch

			
		}
		return u;
	}

	public static usu delete_user(usu u) {
		u = null;
		return u;
	}

}