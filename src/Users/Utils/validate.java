package Users.Utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Users.Modules.User.Classes.Singleton;


public class validate {
	
	private static final String pEMAIL=("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	private static final String pNOMAP="^[a-zA-Z\\s]*$";//Servix per a el nom/apellidos i totes les cadenes que tinguen soles lletres.
	private static final String pUSERNAME="^[a-z0-9_-]{3,15}$";
	private static final String pCIF="^[a-zA-Z]{1}[0-9]{8}$";
	private static final String pTLF="^[0-9]{2,3}-? ?[0-9]{7,8}$";
	private static final String pEDAD="^[0-9]{2}/[0-9]{1,2}/[0-9]{4}$";
	private static final String pEDAD2="^[0-9]{2}-[0-9]{1,2}-[0-9]{4}$";
	private static final String pANTIGUITAT="^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
	private static final String pSEX="^[hH&mM&oO]{1}$";
	private static final String pSEXe="^[Mm&wW&oO]{1}$";
	private static final String pSEXv="^[hH&dD&aA]{1}$";
	private static final String pCP="^([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}$";
	private static final String plantilla_dni="([0-9]{8})([A-Z])";
	private static final String pn_com="([0-9]{0,3})";
	/*NOM I DERIVATS*/
	public static boolean NOM (String nom){
		Pattern pattern=Pattern.compile(pNOMAP);
		Matcher matcher=pattern.matcher(nom);
		if(matcher.matches()){
			return true;
			  } 
		    return false; 
	}
	
	public static boolean USERNAME (String username){
		Pattern pattern=Pattern.compile(pUSERNAME);
        Matcher matcher = pattern.matcher(username);
		if(matcher.matches()){
		return true;
			  } 
		    return false; 
		  }
	
	/*IDENTIFICADORS DE USUARI*/
	public static boolean DNI (String DNI){
		boolean val = false;
		String dni2 = "", caracteres="TRWAGMYFPDXBNJZSQVHLCKET";
		int dni = 0, modulo = 0;
		Pattern pattern=Pattern.compile(plantilla_dni);
		Matcher matcher=pattern.matcher(DNI);
		if(matcher.matches()){
			for(int i=0; i<8; i++)
				dni2 += DNI.charAt(i);			
			char letra = DNI.charAt(8);			
				dni = Integer.parseInt(dni2);
			    	modulo= dni % 23;
			    		char let = caracteres.charAt(modulo);
					    	if(let == letra)
					    		val = true;
		}else
					    		val = false;
	    return val; 
	   
		  }
	
	
	public static boolean CIF(String CIF){
		Pattern pattern=Pattern.compile(pCIF);
		Matcher matcher=pattern.matcher(CIF);
		if(matcher.matches()){
			return true;
		}
		return false; 
	}
	
	/*IDENTIFICADOR MISCELANIA*/

	public static boolean EMAIL(String email){
		Pattern pattern=Pattern.compile(pEMAIL);
		Matcher matcher=pattern.matcher(email);
		if(matcher.matches()){
			return true;
		}
		return false; 
	}
	
	public static boolean TLF (String tlf){
		Pattern pattern=Pattern.compile(pTLF);
		Matcher matcher=pattern.matcher(tlf);
		if(matcher.matches()){
			return true;
		}
		return false; 
	}

	public static boolean validarFechFormat(String fecha, int tipo) {
		String s = "";

		if (tipo == 0) {
			s = "\\d{1,2}/\\d{1,2}/\\d{4}";
		} else if (tipo == 1) {
			s = "\\d{1,2}-\\d{1,2}-\\d{4}";
		} else if (tipo == 2) {
			s = "\\d{4}/\\d{1,2}/\\d{1,2}";
		} else if (tipo == 3) {
			s = "\\d{4}-\\d{1,2}-\\d{1,2}";
		} else if (tipo == 4) {
			s = "\\d{1,2}/\\d{1,2}/\\d{2}";
		}

		return fecha.matches(s);
	}
	public static boolean EDAD (String edad){
		Pattern pattern=Pattern.compile(pEDAD2);
		Matcher matcher=pattern.matcher(edad);
		if(matcher.matches()){
			return true;
		}
		return false; 
	}
	public static boolean ANTIGUITAT (String antiguitat){
		Pattern pattern=Pattern.compile(pEDAD);
		Matcher matcher=pattern.matcher(antiguitat);
		if(matcher.matches()){
			return true;
		}
		return false; 
	}
	
	public static boolean SEX (String sex){
		System.out.println(Singleton.language.getIdioma());
		String idioma=Singleton.language.getIdioma();
		if(idioma=="English"){
			Pattern pattern=Pattern.compile(pSEXe);
			Matcher matcher=pattern.matcher(sex);
			if(matcher.matches()){
				return true;
			}
			return false; 
		}else if(idioma=="Valencia"){
			Pattern pattern=Pattern.compile(pSEXv);
			Matcher matcher=pattern.matcher(sex);
			if(matcher.matches()){
				return true;
			}
			return false; 
		}else if(idioma=="Spanish"){
		Pattern pattern=Pattern.compile(pSEX);
		Matcher matcher=pattern.matcher(sex);
		if(matcher.matches()){
			return true;
		}
		return false; 
		}
		return false;
	}
	
	public static boolean CP (String cp){
		Pattern pattern=Pattern.compile(pCP);
		Matcher matcher=pattern.matcher(cp);
		if(matcher.matches()){
			return true;
		}
		return false; 
	}
	
	public static boolean N_COM(String n_com){
		Pattern pattern=Pattern.compile(pn_com);
		Matcher matcher=pattern.matcher(n_com);
		if(matcher.matches()){
			return true;
		}
		return false; 
	}
	
}
