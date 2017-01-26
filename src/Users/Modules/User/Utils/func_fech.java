package Users.Modules.User.Utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import Users.Classes.fecha;
import Users.Classes.setting;
import Users.Modules.User.Classes.Singleton;
import Users.Modules.User.Classes.usu;
import Users.Utils.functions;
import Users.Utils.validate;

public class func_fech {

	// PIDE FECHA
	public static fecha pedirfecha(int x, int y) {
		// ATRIBUTS
		String type=Singleton.config.getffecha();
		String tipo=" ("+type+")";
		String s = "";
		boolean correcto = false;
		boolean val = true;
		String cad = "";
		fecha fec = null;
		String dem = "";
		String er = "";
		int tyfecha = 0;
		
		if (y == 0) {
			er = "";
		} else if (y == 1) {
			er = Singleton.language.getProperty("error_edad");
		}

		if (x == 0) {
			dem = Singleton.language.getProperty("fecha_nac") + tipo;
		} else if (x == 1) {
			dem = Singleton.language.getProperty("fecha_cont") + tipo;
		}

		// DEMANA EL STRING Y VALIDA EL FORMATO
		do {
			do {
				s = functions.vString(dem + er, "FECHA");
				tyfecha = func_fech.vFECHA(type);
				val = validate.validarFechFormat(s, tyfecha);
				
				if (val == false)
					cad = cad + ("\n" + Singleton.language.getProperty("error_formato"));
			} while (val == false);

			// ES CREA EL OBJECTE Y EL VALIDA LA FECHA
			fec = new fecha(s, type);
			correcto = fec.VFecha(s, type);
			if (correcto == true)
				JOptionPane.showMessageDialog(null, Singleton.language.getProperty("error_fecha"), Singleton.language.getProperty("warning"), JOptionPane.WARNING_MESSAGE);
		} while (correcto == true);
		return fec;
	}

	// FECHA DE NAIXIMENT
	public static fecha fNAC() {
		fecha fenac = null;
		int ed = 0;
		boolean a = true;
		fecha fec = null;
		String Str="";
		String pa="";
		String[] ArrayFecha=null;
		String fechaformat=null;
		String fecha="";
		do {
			if (a == false) {
				fenac = func_fech.pedirfecha(0, 0);

			} else if (a == true) {
				fenac = func_fech.pedirfecha(0, 0);

			}
			String introducefecha=((fecha) fenac).getFecha();
			ArrayFecha = introducefecha.split("/");
			int day=Integer.parseInt(ArrayFecha [0]);
			int month=Integer.parseInt(ArrayFecha [1]);
			int year=Integer.parseInt(ArrayFecha [2]);
			
			
			if(Singleton.config.getffecha()=="dd/mm/yyyy"){
				fecha=day+"/"+month+"/"+year;
				pa="d/M/yyyy";
			}else if(Singleton.config.getffecha()=="dd-mm-yyyy"){
				fecha=day+"-"+month+"-"+year;
				pa="d-M-yyyy";
			}else if(Singleton.config.getffecha()=="yyyy/mm/dd"){
				fecha=year+"/"+month+"/"+day;
				pa="yyyy/M/d";
			}else if(Singleton.config.getffecha()=="yyyy-mm-dd"){
				fecha=year+"-"+month+"-"+day;
				pa="yyyy-M-d";
			}		
			
			Str= fecha;
			CharSequence cs=Str;
			
				DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pa);
				LocalDate fechaNac = LocalDate.parse(cs, fmt);
				LocalDate ahora = LocalDate.now();
				Period periodo = Period.between(fechaNac, ahora);
				System.out.printf("Tu edad es: %s a�os, %s meses y %s dias", periodo.getYears(), periodo.getMonths(), periodo.getDays());
				ed=periodo.getYears();
				
				if (ed <= -1) {
					a = false;
				}
				if (ed < 16) {
					a = false;
				}
				if(ed>=16){
					a=true;
				}
			} while (a == false);
		return fenac;
	}

	public static boolean compr(int n1, int n2) {
		if (n1 - n2 < 16) {
			return false;
		} else {
			return true;
		}

	}

	// FECHA CONTRACTACIO
	public static fecha fCONT(fecha nac) {
		// ATRIBUTS
		fecha fec = null;
		boolean bo = false;

		// ES DEMANA LA FECHA DE CONTRATACIO Y ES COMPROVA EN LA DE NAIXIMENT
		do {
			System.out.println("ENTRE EN FCONT");
			fec = func_fech.pedirfecha(1, 0);
			System.out.println("FEC: " + fec);
			bo = func_fech.ComparacionFcont(nac, fec);
			System.out.println("BO: " + bo);
		} while (bo == false);
		return fec;
	}

	// APTO PARA EL TRABAJO
	/*
	 * Un usuario apto para el trabajo es el que tiene mas de 15 anyos y menos
	 * de 66
	 */
	public static boolean ComparacionFcont(fecha nacimiento, fecha contratacion) {
		// ATRIBUTOS
		int difAnyos;
		boolean apto = false;

		// COMPARA LA FECHA DE CONTRATACION EN LA DE NACIMIENTO
		difAnyos = contratacion.comparaFechas("other", nacimiento);
		System.out.println("difAnyos" + difAnyos);

		// SI LA FECHA DE CONTRATACION ES -1 O 0 LA FECHA ES POSTERIOR A LA DE
		// NACIMIENTO
		if ((difAnyos == -1) || (difAnyos == 0)) {
			JOptionPane.showMessageDialog(null, "La fecha de contratacion debe ser posterior a la de nacimiento",
					"ERROR", JOptionPane.WARNING_MESSAGE);
			apto = false;
			System.out.println("Diferecia de anyos: " + difAnyos);

			// SINO RESTA LOS ANYS DE CONTRATACIO EN ELS DE NAIXIMENT(ESTO ES
			// UNA ESPECIE DE VALIDADOR)
		} else {
			difAnyos = contratacion.restarAnyos(1, nacimiento);
			fecha f = null;

			System.out.println("difAnyos" + difAnyos);
			// SI ESTA ENTRE 16 Y 65
			if ((difAnyos > 15) && (difAnyos < 66))
				apto = true;
			else {
				apto = false;
				JOptionPane.showMessageDialog(null, "El empleado debe tener almenos 16 anyos", "ATENCION",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		return apto;
	}

	// APTO PER AL TREBALL ATRIBUT DE EL OBJECTE (SI/NO)
	/* Per a que un usuri siga apte per al treball es comparara la fecha */
	public static String Apto(fecha nacimiento, fecha contratacion) {
		String end = "";
		boolean apto = func_fech.ComparacionFcont(nacimiento, contratacion);
		if (apto == true) {
			end = "Si";
		} else if (apto == false) {
			end = "No";
		}
		return end;
	}

	/* RETORNOS DE EDAD-ANTIGUITAT */
	// EDAD
	public static int vEDAD(fecha fnac) {
		// VARIABLES
		fecha fec = null;
		int ed = 0;
		boolean a = true;
		String Str="";
		System.out.println();
		String pa="";
		String[] ArrayFecha=null;
		String fechaformat=null;
		String fecha="";
		// OPERATIONS
	
		
		String introducefecha=((fecha) fnac).getFecha();
		ArrayFecha = introducefecha.split("/");
		int day=Integer.parseInt(ArrayFecha [0]);
		int month=Integer.parseInt(ArrayFecha [1]);
		int year=Integer.parseInt(ArrayFecha [2]);
		
		if(Singleton.config.getffecha()=="dd/mm/yyyy"){
			fecha=day+"/"+month+"/"+year;
			pa="d/M/yyyy";
		}else if(Singleton.config.getffecha()=="dd-mm-yyyy"){
			fecha=day+"-"+month+"-"+year;
			System.out.println("fecha "+fecha);
			pa="d-M-yyyy";
		}else if(Singleton.config.getffecha()=="yyyy/mm/dd"){
			fecha=year+"/"+month+"/"+day;
			pa="yyyy/M/d";
		}else if(Singleton.config.getffecha()=="yyyy-mm-dd"){
			fecha=year+"-"+month+"-"+day;
			pa="yyyy-M-d";
		}		
		
		Str= fecha;
		CharSequence cs=Str;
		
		do {
			
		
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pa);
			LocalDate fechaNac = LocalDate.parse(cs, fmt);
			LocalDate ahora = LocalDate.now();
			Period periodo = Period.between(fechaNac, ahora);
			System.out.printf("Tu edad es: %s a�os, %s meses y %s d�as", periodo.getYears(), periodo.getMonths(), periodo.getDays());
			ed=periodo.getYears();
						
			if (ed <= -1) {
				a = false;
			}
			if (ed < 16) {
				a = false;
			}
		} while (a == false);
		return ed;
	}

	// ANTIGUITAT
	public static int vANTIGUITAT(fecha a, fecha fnac) {
		int ed = 0;
		boolean e = true;
		fecha fec = null;
		String Str="";
		System.out.println();
		String pa="";
		String[] ArrayFecha=null;
		String fechaformat=null;
		String fecha="";
		// OPERATIONS
		
		String introducefecha=((fecha) a).getFecha();
		ArrayFecha = introducefecha.split("/");
		int day=Integer.parseInt(ArrayFecha [0]);
		int month=Integer.parseInt(ArrayFecha [1]);
		int year=Integer.parseInt(ArrayFecha [2]);
		System.out.println("aa"+Singleton.config.getffecha());
		if(Singleton.config.getffecha()=="dd/mm/yyyy"){
			fecha=day+"/"+month+"/"+year;
			pa="d/M/yyyy";
		}else if(Singleton.config.getffecha()=="dd-mm-yyyy"){
			fecha=day+"-"+month+"-"+year;
			System.out.println("fecha "+fecha);
			pa="d-M-yyyy";
		}else if(Singleton.config.getffecha()=="yyyy/mm/dd"){
			fecha=year+"/"+month+"/"+day;
			pa="yyyy/M/d";
		}else if(Singleton.config.getffecha()=="yyyy-mm-dd"){
			fecha=year+"-"+month+"-"+day;
			pa="yyyy-M-d";
		}		
		
		Str= fecha;
		System.out.println(Str);
		CharSequence cs=Str;
		System.out.println(cs);
		
		
		do {
			System.out.println(pa);
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pa);
			LocalDate fechaNac = LocalDate.parse(cs, fmt);
			LocalDate ahora = LocalDate.now();
			Period periodo = Period.between(fechaNac, ahora);
			System.out.printf("Tu edad es: %s a�os, %s meses y %s d�as", periodo.getYears(), periodo.getMonths(), periodo.getDays());
			ed=periodo.getYears();
			
			System.out.println(ed);
			
			System.out.println("ed" + ed);
			if (ed <= -1) {
				e = false;
			}
		} while (e == false);
		return ed;
	}

	public static String vALTA() {
		int c = 0;
		String co = "";
		fecha f = new fecha();
		co = ((fecha) f).fechaactual();

		return co;
	}

	public static String PideStringFecha2(int tipo) {
		String sf = "";

		switch (tipo) {
		case 0:
			sf = "[dd/MM/yyyy]";
			break;

		case 1:
			sf = "[dd-MM-yyyy]";
			break;

		case 2:
			sf = "[yyyy/MM/dd]";
			break;

		case 3:
			sf = "[yyyy-MM-dd]";
			break;
		}
		return sf;
	}

	public static int vFECHA(String fecha) {		
			if (fecha.equals("dd/mm/yyyy")) {
				return 0;
			}
			if (fecha.equals("dd-mm-yyyy")) {
				return 1;
			}
			if (fecha.equals("yyyy/mm/dd")) {
				return 2;
			}
			if (fecha.equals("yyyy-mm-dd")) {
				return 3;
			}
		
		return 4;
		}
		
	

}