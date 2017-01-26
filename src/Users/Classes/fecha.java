package Users.Classes;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.text.SimpleDateFormat;
import java.io.Serializable;
import java.text.ParseException;

public class fecha implements Serializable{

	private int day;

	private int month;

	private int year;

	private String fecha;
	private SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
	private String param="";

/*CONSTRUCTOR*/
	public fecha (){
		
	}
	

		public fecha (String introducefecha,String param){
				String[] ArrayFecha=null;
				String fechaformat=null;
				switch (param) {
			case "dd/mm/yyyy":
				ArrayFecha=introducefecha.split("/");
				this.day=Integer.parseInt(ArrayFecha[0]);
				this.month=Integer.parseInt(ArrayFecha[1]);
				this.year=Integer.parseInt(ArrayFecha[2]);
				fechaformat=day+"/"+month+"/"+year;
				this.fecha=fechaformat;
				this.param="dd/mm/yyyy";
			break;
			
			case "dd-mm-yyyy":
				ArrayFecha = introducefecha.split("-");
				this.day=Integer.parseInt(ArrayFecha [0]);
				this.month=Integer.parseInt(ArrayFecha [1]);
				this.year=Integer.parseInt(ArrayFecha [2]);
				this.fecha=day+"-"+month+"-"+year;
				this.param="dd-mm-yyyy";
				break;
			
			case "yyyy/mm/dd":
				ArrayFecha = introducefecha.split("/");
				this.year=Integer.parseInt(ArrayFecha [0]);
				this.month=Integer.parseInt(ArrayFecha [1]);
				this.day=Integer.parseInt(ArrayFecha [2]);
				this.fecha=day+"/"+month+"/"+year;
				this.param="yyyy/mm/dd";
				break;
				
			case "yyyy-mm-dd":
				ArrayFecha = introducefecha.split("-");
				this.year=Integer.parseInt(ArrayFecha [0]);
				this.month=Integer.parseInt(ArrayFecha [1]);
				this.day=Integer.parseInt(ArrayFecha [2]);
				this.fecha=day+"-"+month+"-"+year;
				this.param="yyyy-mm-dd";
				System.out.println("formati1 "+this.param);
				break;
		}	
		}
	
/*GETER-FECHA*/
	public String getFecha(){
		return fecha;
		}
	
/*SETTER-FECHA*/
	public void setFecha(String fecha){

		this.fecha = fecha;
		}
	
/*CONVERSIONES*/
	//DE STRING A CALENDAR
	public Calendar deStringToCalendar(String fecha){
		Date fechaDate = new Date();
		Calendar fechaCalendar=new GregorianCalendar();
		try{
		fechaDate = formato.parse(fecha);
		fechaCalendar.setTime(fechaDate);
		}catch (ParseException e){
		e.printStackTrace();
		}
		return fechaCalendar;
		}
	
	//DE CALENDAR A STRING
	public String deCalendartoString(){
	      Calendar cal = Calendar.getInstance();
	      return (cal.getTime().toString());
	   }
	
	//DE CALENDAR A DATE
    public static Date CaltoDate(Calendar fecha) {
        Date fec;

        fec = fecha.getTime();

        return fec;
    }
    
    //DE DATE A STRING
    public static String DatetoString(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String fec = sdf.format(fecha);

        return fec;
    }
    
    //DE STRING A DATE
    public static Date StringtoDate(String fecha) {
        Date fec = null;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        try {
            fec = formatter.parse(fecha);
        } catch (ParseException e) {
        	e.printStackTrace();
         
        }

        return fec;
    }
   
/*COMPARA-FECHA*/
	public int comparaFechas(String type, fecha other) {
		int res = 0;
		
		switch (type) {
		//Compara la fecha del sistema
		case "system":
			Calendar system = Calendar.getInstance();
			Calendar fecha = Calendar.getInstance();

			fecha.set(this.year, this.month - 1, this.day);

			res = fecha.compareTo(system);
			break;
		//Compara una fecha que li has pasat tu.
		case "other":
			Calendar fecha1 = Calendar.getInstance();
			Calendar fecha2 = Calendar.getInstance();

			fecha1.clear();
			fecha2.clear();

			fecha1.set(this.year, this.month - 1, this.day);
			fecha2.set(other.year, other.month - 1, other.day);

			res = fecha1.compareTo(fecha2);
			break;

	}
		return res;
	}
	


/*RESTA-FECHA*/
	/*Resta una fecha en la del sistema*/
	public int RestFechas(){
		int rest, any1, yearsystem;
		Calendar cal=new GregorianCalendar();
		System.out.println("Fecha"+fecha);
		cal=(deStringToCalendar(fecha));
		
		any1=cal.get(Calendar.YEAR);
		yearsystem=this.anyoactual();
		
		rest=yearsystem-any1;
		
		return rest;
	}
	
	
	public fecha(int dia, int mes, int ano) {

		this.day = dia;
		this.month = mes;
		this.year = ano;

		this.fecha = this.day + "/" + this.month + "/" + this.year;
	}
/*RESTA-ANYOS*/
	/*Resta unicament els anys*/
	public int restarAnyos(int tipo, fecha Fecha2) {

		int restFech = 0;

		if (tipo == 0) {
			Calendar system = Calendar.getInstance();
			fecha sistema = new fecha(system.get(Calendar.DATE), system.get(Calendar.MONTH) + 1,
					system.get(Calendar.YEAR));

			restFech = sistema.year - this.year; 

		} else if (tipo == 1) {
			restFech = this.year - Fecha2.year;
		}
		return restFech;
	}

/*VALIDA-FECHA*/
	/*Incluix el any bisiesto*/
	public boolean VFecha(String fech,String param){

		//Es dividix en arrays el "dia/mes/any"
		String[] ArrayFecha=null;
		String fechaformat=null;
		switch (param) {
		case "dd/mm/yyyy":
		ArrayFecha=fech.split("/");
		this.day=Integer.parseInt(ArrayFecha[0]);
		this.month=Integer.parseInt(ArrayFecha[1]);
		this.year=Integer.parseInt(ArrayFecha[2]);
		fechaformat=day+"/"+month+"/"+year;
		this.fecha=fechaformat;
		break;
		
		case "dd-mm-yyyy":
			ArrayFecha = fech.split("-");
			this.day=Integer.parseInt(ArrayFecha [0]);
			this.month=Integer.parseInt(ArrayFecha [1]);
			this.year=Integer.parseInt(ArrayFecha [2]);
			this.fecha=day+"/"+month+"/"+year;
			break;
		
		case "yyyy/mm/dd":
			ArrayFecha = fech.split("/");
			this.day=Integer.parseInt(ArrayFecha [2]);
			this.month=Integer.parseInt(ArrayFecha [1]);
			this.year=Integer.parseInt(ArrayFecha [0]);
			this.fecha=day+"/"+month+"/"+year;
			break;
			
		case "yyyy-mm-dd":
			ArrayFecha = fech.split("-");
			this.day=Integer.parseInt(ArrayFecha [2]);
			this.month=Integer.parseInt(ArrayFecha [1]);
			this.year=Integer.parseInt(ArrayFecha [0]);
			this.fecha=day+"/"+month+"/"+year;
			break;
	}	
		/*System.out.println("fecha "+fecha);
		System.out.println(day);
		System.out.println(month);
		System.out.println(year);*/
		
		//Comprova que el mes es correcte "que esta entre 1 y 12"
          if ((month < 1) || (month > 12)){
        	  System.out.println("month"+month);
                  return true;
          }
        //Comprova que el any es correcte "esta entre 1930 y 2100"
          if ((year < 1930) || (year > 2100)){
              return true;
          }
          int[] months={0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //Si el mes es "febrer" day==29
          if (month==2){
        	  System.out.println("entre");
                  int febMax=28;
                  if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))){
                	  System.out.println("bisiesto");
                	  		months[2]=29;
                	  		
                          febMax=29;
                          System.out.println(months);
              	  		System.out.println(months[2]);
                          return false;
                          
                  }
                  
                
                  if ((day<1)||(day>months[2])){
                          return true;
                  }
         //Comprova que el dia es correcte "que esta ente 1 y el dia del mes corresponent"
          }else if ((day < 1)||(day > months[month])){
        	  System.out.println("entre en day");
        	  return true;
          }
          return false;
  }
	

/*FECHES ACTUALS*/
	//FECHA ACTUAL
	public String fechaactual(){
		String c="";
		 Calendar fecha = new GregorianCalendar();
	        int day = fecha.get(Calendar.DAY_OF_MONTH);
	        int year = fecha.get(Calendar.YEAR);
	        int month = fecha.get(Calendar.MONTH)+1;
		c=day+"/"+month+"/"+year;
		return c;
	}
	
	//DIA ACTUAL
    public int diaactual(){
        Calendar fecha = new GregorianCalendar();
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        return dia;
    }
    
    //ANY ACTUAL
    public int anyoactual(){
        Calendar fecha = new GregorianCalendar();
        int anyo = fecha.get(Calendar.YEAR);
        return anyo;
    }
    
    //MES ACTUAL
    public int mesactual(){
        Calendar fecha = new GregorianCalendar();
        int mes = fecha.get(Calendar.MONTH);
        return mes+1;
    }
    
	/*TOSTRING*/
    //TOSTRING
    
    
    public String toString(String param){
	String fecha=null;
	
	System.out.println("entre al tostring");
	System.out.println("formater"+this.param);
	
	if(param.equals("dd/mm/yyyy"))
		fecha=this.day+"/"+this.month+"/"+this.year;
		
	if(param.equals("dd-mm-yyyy")){
		fecha=this.day+"-"+this.month+"-"+this.year;
		
	}
    if(param.equals("yyyy/mm/dd")){
		fecha=this.year+"/"+this.month+"/"+this.day;
		
	}
    if(param.equals("yyyy-mm-dd")){
		fecha=this.year+"-"+this.month+"-"+this.day;
		
	}
	
		
	return fecha;
	   }

	
	}
