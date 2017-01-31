package Users.Modules.User.Model.dummies;

import java.text.ParseException;

import javax.swing.JOptionPane;

import Users.Modules.User.Model.Classes.*;
import Users.Modules.User.Model.Utils.fnes_v;
import Users.Modules.User.Model.Utils.func_fech;
import Users.Modules.User.Model.Utils.func_plus;
import Users.Utils.functions;
import Users.Classes.*;

public class fnes_users_dummies {
	/* INT I=0-CLIENT 1-NORMAL 2-ADMIN */
	public static usu create_users(int i) {
		usu u = null;
		////////////// CLIENT//////////
		if (i == 0) {
			// Atributs
			int ptos = 0;
			fecha fnac = null;
			int edad = 0;
			String email="";
			// Operacions
			email = fnes_v.vauto(1);
			String nom = fnes_v.vauto(0);
			String dni = fnes_v.vDNIauto();
			fnac= new fecha("17/04/1998","dd/mm/yyyy");
			edad = func_fech.vEDAD(fnac);
			int n_comp=20;
			int descuentos = 20;
			
			u = new usercl(nom, dni, fnac, edad,email,n_comp, descuentos);
		} else if (i == 1) {
			////////////// NORMAL//////////////
			
			// Atributs
			
			int edad = 0;
			fecha fnac = null;
			String karma="";
			int points=0;
			String email="";

			// Operacions
			email = fnes_v.vauto(1);
			String nom = fnes_v.vauto(0);
			String dni =fnes_v.vDNIauto();
			fnac= new fecha("17/04/1998","dd/mm/yyyy");
			edad = func_fech.vEDAD(fnac);
			int n_com=20;
			karma=func_plus.karma(n_com);
			points=func_plus.points(karma);
			
			u = new usern(nom, dni, fnac, edad,email,n_com,karma,points);

		} else if (i == 2) {
			////////////// ADMIN//////////////
			// ATRIBUTS
			int edad = 0;
			String email = "", username = "";

			int antiguitat = 0;
			int salary=0;
			fecha fnac = null;
			fecha fant = null;
			String apto = "";
			String alta = "";
			int sou=0;
			// OPERACIONS
			String nom = fnes_v.vauto(0);
			String dni = fnes_v.vDNIauto();
			String sex = fnes_v.vSEXdummies();
			email = fnes_v.vauto(1);
			username = fnes_v.vauto(2);
			fnac= new fecha("17/04/1998","dd/mm/yyyy");
			edad = func_fech.vEDAD(fnac);
			fant =new fecha("17/04/2014","dd/mm/yyyy");
			antiguitat = func_fech.vANTIGUITAT(fant, fnac);
			salary=500;
			apto = func_fech.Apto(fnac, fant);
			alta = func_fech.vALTA();
			sou=500;
			u = new userad(nom, dni, fnac, edad,email, sex, username, fant, antiguitat,salary, apto, alta,sou);
			System.out.println("Objecte admin" + "\n" + u);


		}

		return u;
	}
	public static userad ask_adminDNI_dummies (String dni) {
		
		Singleton.DNI=dni;
		
		return new userad (Singleton.DNI);
	}
	
public static usercl ask_clientDNI_dummies (String dni) {
	
		Singleton.DNI=dni;
	
	return new usercl(Singleton.DNI);
}
public static usern ask_usernDNI_dummies (String dni) {
	
	Singleton.DNI=dni;
	
	return new usern(Singleton.DNI);
}
}