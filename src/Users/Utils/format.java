package Users.Utils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import Users.Classes.setting;
import Users.Modules.User.Classes.Singleton;

public class format {
	
	
/*///////////////////////////COINS//////////////////////*/
	public static String coins(double moneda) throws ParseException{
		String co=setting.getInstance().getcoin();
		String decimal=setting.getInstance().getdecimal();
		System.out.println(moneda);
		System.out.println(co);
		if (co.equals("dollar")){
			moneda = moneda*1.0844f;
		}else if(co.equals("libra")){
			moneda = moneda*0.72686f;
		}else if(co.equals("euro")){
			moneda = moneda*1f;
		}
		
		String coinformat="";
		double value;
		String numbera = Double.toString(moneda);
		String finalvalue = "";
		DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
		symbols.setDecimalSeparator('.');
		DecimalFormat nformat = new DecimalFormat(decimal, symbols);
		value=Double.valueOf(nformat.format(moneda));
		numbera=nformat.format (moneda);
		Double moned = nformat.parse( numbera ).doubleValue();		
		
		
		System.out.println(co);
		if (co.equals("dollar")){
			coinformat="$";
			finalvalue=Double.toString(moned);
			finalvalue=finalvalue+coinformat;
			return finalvalue;
		}else if(co.equals("libra")){
			coinformat="L";
			finalvalue=Double.toString(moned);
			finalvalue=finalvalue+coinformat;
			return finalvalue;
		}
		if(co.equals("euro")){
			System.out.println("entre aci");
			coinformat="€";
			finalvalue=Double.toString(moned);
			finalvalue=finalvalue+coinformat;
			return finalvalue;
		}
		return "";
	}

	
	/*///////////////////////////PORCENTAJE//////////////////////*/
	public static String por(int i){
		String s="";
		s= Integer.toString(i) + "%";
		return s;
	}
	/*///////////////////////////PTOS//////////////////////*/
	public static String fPTOS(int i){
		String s = "";
			s = Integer.toString(i) + " ptos";
		return s;
	}
}