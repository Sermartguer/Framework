package Users.Utils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import java.text.ParseException;


import Users.Classes.setting;


public class format {
	
	
/*///////////////////////////COINS//////////////////////*/
	public static String coins(double moneda) throws ParseException{
		String co=setting.getInstance().getcoin();
		String decimal=setting.getInstance().getdecimal();
		String coinformat="";
		double value=0.0000000;
		String numbera = Double.toString(moneda);
		String finalvalue = "";
		
		if (co.equals("dollar")){
			moneda = moneda*1.0844f;
		}else if(co.equals("libra")){
			moneda = moneda*0.72686f;
		}else if(co.equals("euro")){
			moneda = moneda*1f;
		}
		System.out.println("Valor de la moneda :"+moneda);
		/*DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		DecimalFormat formateador = new DecimalFormat("####.####",simbolos);
		// Esto sale en pantalla con punto decimal, es decir, 3.4324,
		System.out.println (formateador.format (moneda));*/
		
		
		
		
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		DecimalFormat nformat = new DecimalFormat(decimal, symbols);
		System.out.println("Decimals: "+decimal);
		System.out.println("Formateig "+nformat.format(moneda));
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