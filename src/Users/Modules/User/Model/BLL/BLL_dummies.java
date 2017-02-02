package Users.Modules.User.Model.BLL;

import java.util.Random;

import Users.Classes.fecha;
import Users.Modules.User.Model.Classes.Singleton;
import Users.Modules.User.Model.Classes.userad;
import Users.Modules.User.Model.Classes.usercl;
import Users.Modules.User.Model.Classes.usern;
import Users.Modules.User.Model.Utils.func_fech;
import Users.Modules.User.Model.Utils.func_plus;

public class BLL_dummies {
	public static String dni(int dni) {
		String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
        return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
    }
	
	public static String DNI (){
		String cad = "";
        long time = new java.util.GregorianCalendar().getTimeInMillis();
        Random random = new Random(time);
        while (cad.length() < 8) {
            char c = (char) random.nextInt(255);
            if ((c >= '0' && c <= '9')) {
                cad += c;
            }
        }
        int numberdni = Integer.parseInt(cad);
        return dni(numberdni);
	}
	
	public static String user (){
		String user = "";
		String[] users = {"vicent", "walter", "joan", "maria", "daniel", "josep", "sara", "pepa", "felipe",
	            "jaume", "sergio", "paco", "emilio", "nando", "alfons", "eduard", "atalia", "veronica", "fina",
	            "pepe", "oscar", "lorelay", "jim", "lola", "laia", "ismael", "jordi", "ramon", "javier", "nuria",
	            "elena", "beltran", "pablo", "juanjo"};
		
		int position = (int) (Math.random() * 222) % 10;
		return user = users[position];
	}
	

	public static String name (){
		String name = "";
		String[] names = {"vicent", "walter", "joan", "maria", "daniel", "josep", "sara", "pepa", "felipe",
	            "jaume", "sergio", "paco", "emilio", "nando", "alfons", "eduard", "atalia", "veronica", "fina",
	            "pepe", "oscar", "lorelay", "jim", "lola", "laia", "ismael", "jordi", "ramon", "javier", "nuria",
	            "elena", "beltran", "pablo", "juanjo"};
		
		int position = (int) (Math.random() * 222) % 10;
		return name = names[position];
	}
	
	public static String surname (){
		String surname = "";
		String [] surnames = {"alfonso", "aliaga", "bas", "bataller", "boluda", "conesa", "camarena", "cucart", "doria",
					"ferrero", "garcia", "figuera", "tormo", "montagud", "gramage", "ubeda", "revert", "cordoba", "sempere",
					"martinez", "lopez", "albuixech", "torro", "belda", "mateu", "ribera", "satorres", "rubio", "cifuentes",
					"frances", "gomez", "mico", "ferrandiz", "casanova"};
		
		int position = (int) (Math.random() * 222) % 10;
		return surname = surnames[position];
	}
	
	public static String email (){
		String email = "";
		String[] emails = {"vicent", "walter", "joan", "maria", "daniel", "josep", "sara", "pepa", "felipe",
	            "jaume", "sergio", "paco", "emilio", "nando", "alfons", "eduard", "atalia", "veronica", "fina",
	            "pepe", "oscar", "lorelay", "jim", "lola", "laia", "ismael", "jordi", "ramon", "javier", "nuria",
	            "elena", "beltran", "pablo", "juanjo"};
		
		int position = (int) (Math.random() * 222) % 10;
		return email = emails[position]+"@gmail.com";
	}
	
	public static fecha datebirthday (){
		String [] years = {"19", "20"};
		int day=new Random().nextInt(10+1) + 10;
		int month=new Random().nextInt(11+1)+1;
		int year3=new Random().nextInt(1998-1950)+1950;

		//int day = (int) (Math.random() * (1 - 31) + 31);
		//int month = (int) (Math.random() * (1 - 12) + 12);
		//int year3 = (int) (Math.random() * (0 - 99) + 99);
		//int position = (int) (Math.random() * 222) % 2;
		//String year2 = years[position]+year3;
		//int year = Integer.parseInt(year3);
		String fechas=day+"/"+month+"/"+year3;
		
		return new fecha (fechas, "dd/mm/yyyy");
		
	}
	public static int age(fecha datebirth){
		int edad = func_fech.vEDAD(datebirth);
		return edad;
	}
//fecha datebirth=BLL_dummies.datebirthday();
//int edad = func_fech.vEDAD(datebirth);
public static String alta(){
	String alt=func_fech.vALTA();
	return alt;
}
	/* Admin
	 * 
	 */
	public static fecha datecontract (){
		String [] years = {"19", "20"};
		int day=new Random().nextInt(10+1) + 10;
		int month=new Random().nextInt(11+1)+1;
		int year3=new Random().nextInt(1998-1950)+1950;
		//String year2 = years[position]+year3;
		String fechas=day+"/"+month+"/"+year3;
		
		return new fecha (fechas, "dd/mm/yyyy");
	}
	public static int anti(fecha dathe, fecha contr){
		 int antiguitat = func_fech.vANTIGUITAT(dathe, contr);
return antiguitat;
	}
	//fecha datecontrackt=BLL_dummies.datecontract();

	public static float salary (){
		float salary = (float) (Math.random() * (600 - 2000) + 2000);
		return (float) Math.rint(salary * 100) / 100;
	}
	
	public static float incentive (){
		float incentive = (float) (Math.random() * (200 - 500) + 500);
		return (float) Math.rint(incentive * 100) / 100;
	}
	
	public static float shopping (){
		float shopping = (float) (Math.random() * (50 - 1000) + 1000);
		return (float) Math.rint(shopping * 100) / 100;
	}

	public static int n_comp(){
		int n_comp=(int)(Math.random()*(50-1000)+1000);
		return (int) Math.rint(n_comp*100)/100;
	}

	
	public static int point (){
		int point = (int) (Math.random() * (5 - 50) + 50);
		return (int) Math.rint(point * 100) / 100;
	}
	String alta = func_fech.vALTA();

	/* BUILDER
	 * 
	 */
	public static userad makedummies_admin () {
		userad a1=null;
		int cont=0;
		do{
			a1 = new userad (user(),DNI(),datebirthday(),age(datebirthday()),email(),"H", surname(),datecontract(),anti(datecontract(),datebirthday()), salary(),"Si",alta(), incentive());
			//Singleton.useradmin.add(a1);
			cont++;
		}while(cont<1);
		return a1;
	}
	
	public static usercl makedummies_client () {
		int cont=0;
		usercl c1=null;
		do{
			c1 = new usercl(user(),DNI(),datebirthday(),age(datebirthday()),email(), n_comp(),point());
			//Singleton.userclient.add(c1);
			cont++;
		}while(cont<1);
		return c1;
		}
	
	
	public static usern makedummies_userregister () {
		int cont=0;
		usern n1=null;
		do{
			
			n1 = new usern(user(),DNI(),datebirthday(),age(datebirthday()),email(),n_comp(),func_plus.karma(n_comp()), point());
			//Singleton.userregister.add(u1);
		cont++;
		}while(cont<1);
		return n1; 
	}
}
