package Users.Modules.User.Model.BLL;

import java.util.Random;

import Users.Classes.fecha;
import Users.Modules.User.Model.Classes.Singleton;
import Users.Modules.User.Model.Classes.userad;
import Users.Modules.User.Model.Classes.usercl;
import Users.Modules.User.Model.Classes.usern;
import Users.Modules.User.Model.Utils.fnes_v;
import Users.Modules.User.Model.Utils.func_fech;
import Users.Modules.User.Model.Utils.func_plus;
import Users.Modules.User.Model.Utils.CRUD.fnes_find;
import Users.Modules.User.Model.dummies.fnes_users_dummies;
import Users.Utils.validate;

public class BLL_dummies {
	/*public static String dni(int dni) {
		String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
        return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
    }*/
	
	public static String DNI (){
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
	
	public static String user (){
		String user = "";
		String[] users = {"vicent", "walter", "joan", "daniel", "josep", "felipe",
	            "jaume", "sergio", "paco", "emilio", "nando", "alfons", "eduard", 
	            "pepe", "oscar", "lorelay", "jim", "ismael", "jordi", "ramon", "javier",
	            "beltran", "pablo", "juanjo"};
		
		int position = (int) (Math.random() * 222) % 10;
		return user = users[position];
	}
	

	public static String name (){
		String name = "";
		String[] names = {"vicent", "walter", "joan", "daniel", "josep", "felipe",
	            "jaume", "sergio", "paco", "emilio", "nando", "alfons", "eduard", 
	            "pepe", "oscar", "lorelay", "jim", "ismael", "jordi", "ramon", "javier",
	            "beltran", "pablo", "juanjo"};
		
		int position = (int) (Math.random() * 222) % 10;
		return name = names[position];
	}
	
	public static String surname (){
		String surname = "";
		String [] surnames = {"vicent", "walter", "joan", "daniel", "josep", "felipe",
	            "jaume", "sergio", "paco", "emilio", "nando", "alfons", "eduard", 
	            "pepe", "oscar", "lorelay", "jim", "ismael", "jordi", "ramon", "javier",
	            "beltran", "pablo", "juanjo"};
		
		int position = (int) (Math.random() * 222) % 10;
		return surname = surnames[position];
	}
	
	public static String email (){
		String email = "";
		String[] emails = {"vicent", "walter", "joan", "daniel", "josep", "felipe",
	            "jaume", "sergio", "paco", "emilio", "nando", "alfons", "eduard", 
	            "pepe", "oscar", "lorelay", "jim", "ismael", "jordi", "ramon", "javier",
	            "beltran", "pablo", "juanjo"};
		
		int position = (int) (Math.random() * 222) % 10;
		return email = emails[position]+"@gmail.com";
	}
	
	public static fecha datebirthday (){
		
		String [] years = {"1980", "1981","1982","1983","1983","1984","1985","1986","1987","1988","1989","1990"};
		 int puevayear = (int) Math.floor(Math.random()*6+1);
		 System.out.println("Numero aleatorio"+puevayear);
		//int puevayear=(int)(Math.random()*222)%10;
		String email = years[puevayear];
		System.out.println("Posicion del array "+email);
		int year4 = Integer.parseInt(email);
		int day=new Random().nextInt(10+1) + 10;
		int month=new Random().nextInt(11+1)+1;
		//int year3=new Random().nextInt(1980-1950)+1950;

		//int day = (int) (Math.random() * (1 - 31) + 31);
		//int month = (int) (Math.random() * (1 - 12) + 12);
		//int year3 = (int) (Math.random() * (0 - 99) + 99);
		//int position = (int) (Math.random() * 222) % 2;
		//String year2 = years[position]+year3;
		//int year = Integer.parseInt(year3);
		String fechas=day+"/"+month+"/"+year4;
		System.out.println("FECHA TOTAL :"+fechas);
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
		int year3=new Random().nextInt(2016-1999)+1999;
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
		fecha datebirthday=BLL_dummies.datebirthday();
		int age=func_fech.vEDAD(datebirthday);
		fecha datecontract=BLL_dummies.datecontract();
		int anti=func_fech.vANTIGUITAT(datecontract, datebirthday);
		userad a1=null;
		int cont=0;
		do{
			a1 = new userad (user(),DNI(),datebirthday,age,email(),fnes_v.vSEXdummies(), surname(),datecontract,anti, salary(),"Si",alta(), incentive());
			//Singleton.useradmin.add(a1);
			cont++;
		}while(cont<1);
		return a1;
	}
	
	public static usercl makedummies_client () {
		fecha datebirthday=BLL_dummies.datebirthday();
		int age=func_fech.vEDAD(datebirthday);
		
		int cont=0;
		usercl c1=null;
		do{
			c1 = new usercl(user(),DNI(),datebirthday,age,email(), n_comp(),point());
			//Singleton.userclient.add(c1);
			cont++;
		}while(cont<1);
		return c1;
		}
	
	
	public static usern makedummies_userregister () {
		fecha datebirthday=BLL_dummies.datebirthday();
		int age=func_fech.vEDAD(datebirthday);
		int cont=0;
		usern n1=null;
		do{
			
			n1 = new usern(user(),DNI(),datebirthday,age,email(),n_comp(),func_plus.karma(n_comp()), point());
			//Singleton.userregister.add(u1);
		cont++;
		}while(cont<1);
		return n1; 
	}
}
