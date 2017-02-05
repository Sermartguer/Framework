package Users.Modules.User.Model.Utils;


import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Users.Classes.lenguage;
import Users.Classes.setting;
import Users.Main.menu4;
import Users.Modules.User.Model.Classes.Singleton;
import Users.Modules.User.Model.Classes.userad;
import Users.Modules.User.Model.Utils.CRUD.fnes_find;
import Users.Modules.User.Model.dummies.fnes_users_dummies;
import Users.Utils.*;

public class fnes_v {

	
	/*NOM I DERIVATS*/
	public static String vNOM(){
		boolean res=false;
		String nom="", cad="";
		do{
			nom=functions.vString(lenguage.getInstance().getProperty("name")+cad, "NOM");
			cad="";
			res=validate.NOM(nom);
			if (res==false){
				cad=cad+("\n"+"Error no has introduit un nom valid");
			}
		}while (res==false);
		return nom;
	}
	public static String vauto(int opcio){
		String nom="";
		if (opcio==0){
		 String[] names = {"Abraham", "Ad�n", "Agapito", "Cristobal", "Alex", "Cristian", "Custodio", "David", "Danilo", "Dani"};
		 int random = (int) (Math.random()*names.length);
	         nom=names[random];
	         return nom;
		}if (opcio==1){
         String[] names = {"sergiete193@gmail.com", "paco@sharklasers.com", "lolo@sharklasers.com", "oscarsegui@sharklasers.com"};
         int random = (int) (Math.random()*names.length);
          nom=names[random];
          return nom;
		}if(opcio==2){
         String[] names = {"nailsarkle", "gizalips", "periwinkleminus", "cavernousgentle", "nurturingvalue"};
         int random = (int) (Math.random()*names.length);
          nom=names[random];
          return nom;
		}
		return "";
         
	}
	
	public static String vUSERNAME(String nom){
		boolean res=false;
		String username="";
		boolean boo=false;
		do{
			username=functions.vString("Dame el USERNAME (MIN:4-MAX:15)", "USERNAME");
			do{
				Pattern pattern=Pattern.compile(nom);
		        Matcher matcher = pattern.matcher(username);
				if(matcher.matches()){
					username=functions.vString("Dame el USERNAME (MIN:4-MAX:15)", "USERNAME");
						
				}else{
				boo=true;
				}
				}while(boo==false);
			
			res=validate.USERNAME(username);
			return username;
		}while (res==false);
	}


	
	
	/*IDENTIFICADORS DE USUARI*/
public static String vDNIauto(){
	String dniauto="";
	String numeros="";
	String letra="";
	boolean res=false;
	userad a1=null;
	boolean correct=false;
	int location=0;
	
	do{
		
	Random rnd = new Random(); 
	rnd.setSeed(System.currentTimeMillis()); 
	int al6 = 10000000 + rnd.nextInt(90000000); 
	String letras = "TRWAGMYFPDXBNJZSQVHLCKE"; 
	int index = al6 - (Math.abs(al6/23)*23);
	numeros=numeros+al6;
	letra=letra+letras.charAt(index);
	dniauto=numeros+letra;
	res=validate.DNI(dniauto);
	a1 = fnes_users_dummies.ask_adminDNI_dummies(dniauto);
	if (Singleton.useradmin==null){
		System.out.println("Esta buit");
	}else{
	location = fnes_find.find_admin(a1);
	}
	if (location != 1){
		correct=true;
	}

	}while((res==false)||(correct==false));
	return dniauto;
}
	public static String vDNI(){
		String cad="";
		boolean res=false;
		String dni="";
		do{
			dni=functions.vString(lenguage.getInstance().getProperty("typedni")+cad, "DNI");
			res=validate.DNI(dni);
			 cad="";
			 if(res==false){
				 cad=cad+("\n"+"Error no has introduit un DNI valid");
			 }
		}while(res==false);
		return dni;
	}
	
	public static String vCIF(){
		String cad="";
		boolean res=false;
		String cif="";
		do{
			cif=functions.vString("Dame el CIF (B21806989)"+cad, "USERNAME");
			res=validate.CIF(cif);
			if (res==false){
				cad=cad+("\n"+"Error no has introduit un cif valid");
			}
		}while (res==false);
		return cif;
	}
	
	/*IDENTIFICADOR MISCELANIA*/
	public static String vEMAIL(){
		String cad="";
		boolean res=false;
		String email="";
		do{
			email=functions.vString("Dame el EMAIL"+cad, "EMAIL");
			res=validate.EMAIL(email);
			if (res==false){
				cad=cad+("\n"+"Error no has introduit un email valid");
			}
		}while (res==false);
		return email;
	}
	public static String vTLF(){
		String cad="";
		boolean res=false;
		String tlf="";
		do{
			tlf=functions.vString("Dame el TLF"+cad, "TLF");
			res=validate.TLF(tlf);
			if (res==false){
				cad=cad+("\n"+"Error no has introduit un telefono valid");
			}
		}while (res==false);
		return tlf;
	}
	
	
	
	////////////////SEXE///////////////////

	public static String vSEX(){
		String cad="";
		boolean res=false;
		String sex="";
		String idioma=lenguage.getInstance().getIdioma();
		
		do {
			
			sex=functions.vString(lenguage.getInstance().getProperty("askv_01")+cad, lenguage.getInstance().getProperty("askv_tittle_01"));
			res=validate.SEX(sex);
			
			if (res==false){
				cad="";
				cad=cad+"\n"+(lenguage.getInstance().getProperty("errorv_01"));
			}
			System.out.println("idioma"+idioma);
			System.out.println("sex"+sex);
			if(idioma.equals("English")){
				if((sex.equals("M"))||(sex.equals("m"))){
					sex="Man";
					res=true;
				}else if((sex.equals("W"))||(sex.equals("w"))){
					sex="Woman";
					res=true;
				}else if((sex.equals("O"))||(sex.equals("o"))){
					sex="Other";
					res=true;
				}
			}else if(idioma.equals("Valencia")){
				if((sex.equals("H"))||(sex.equals("h"))){
					sex="Home";
					res=true;
				}else if((sex.equals("D"))||(sex.equals("d"))){
					sex="Dona";
					res=true;
				}else if((sex.equals("A"))||(sex.equals("a"))){
					sex="Altre";
					res=true;
				}
			}else if(idioma.equals("Spanish")){
				if((sex.equals("H"))||(sex.equals("h"))){
					System.out.println("Entre aci");
					sex="Hombre";
					res=true;
				}else if((sex.equals("M"))||(sex.equals("m"))){
					sex="Mujer";
					res=true;
				}else if((sex.equals("O"))||(sex.equals("o"))){
					sex="Otro";
					res=true;
				}
				
			}
			
			
		}while (res==false);
		System.out.println("sex"+sex);
		return sex;
	}
	public static String vSEXdummies(){
		String cad="";
		boolean res=false;
		String sex="";
		String idioma=lenguage.getInstance().getIdioma();
		
		do {
			
			if(idioma.equals("English")){
			sex="M";
			}else if(idioma.equals("Valencia")){
			sex="H";
			}else if(idioma.equals("Spanish")){
			sex="H";
			}
			
			
			res=validate.SEX(sex);
			
			if (res==false){
				cad="";
				cad=cad+"\n"+(lenguage.getInstance().getProperty("errorv_01"));
			}
			System.out.println("idioma"+idioma);
			System.out.println(res);
			System.out.println(sex);
			if(idioma.equals("English")){
				if((sex.equals("M"))||(sex.equals("m"))){
					sex="Man";
					res=true;
				}else if((sex.equals("W"))||(sex.equals("w"))){
					sex="Woman";
					res=true;
				}else if((sex.equals("O"))||(sex.equals("o"))){
					sex="Other";
					res=true;
				}
			}else if(idioma.equals("Valencia")){
				if((sex.equals("H"))||(sex.equals("h"))){
					sex="Home";
					res=true;
				}else if((sex.equals("D"))||(sex.equals("d"))){
					sex="Dona";
					res=true;
				}else if((sex.equals("A"))||(sex.equals("a"))){
					sex="Altre";
					res=true;
				}
			}else if(idioma.equals("Spanish")){
				if((sex.equals("H"))||(sex.equals("h"))){
					System.out.println("Entre aci");
					sex="Hombre";
					res=true;
				}else if((sex.equals("M"))||(sex.equals("m"))){
					sex="Mujer";
					res=true;
				}else if((sex.equals("O"))||(sex.equals("o"))){
					sex="Otro";
					res=true;
				}
				
			}
			
			
		}while (res==false);
		System.out.println("sex"+sex);
		return sex;
	}
	public static String vCP(){
		String cad="";
		boolean res=false;
		String cp="";
		do {
			cp=functions.vString("Dame un CP"+cad, "CP");
			res=validate.CP(cp);
			if (res==false){
				cad=cad+("\n"+"Error no has introduit un sexe valid");
			}
		}while (res==false);
		return cp;
	}
	
	public static int vN_COM(){
		boolean bo=false;
		int n_com=0;
		String n_coms="";
		do{
			n_com=functions.vint(lenguage.getInstance().getProperty("n_coments"), lenguage.getInstance().getProperty("coments"));
			n_coms=""+n_com;
			bo=validate.N_COM(n_coms);
			
		}while(bo==false);
		 return Integer.parseInt(n_coms);
	}
	
}
