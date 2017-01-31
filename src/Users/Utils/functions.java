package Users.Utils;
import javax.swing.JOptionPane;

import Users.Classes.lenguage;
import Users.Modules.User.Model.Classes.Singleton;

public class functions {
	
	/*----------------------VALIDA INT----------------------*/
	public static int vint(String message, String title ){
//Variables
	String s=" ";
	int a = 0;
	boolean correct=true;
	

//Operations
		do{
			try{
				s=JOptionPane.showInputDialog(null, message, title,JOptionPane.QUESTION_MESSAGE);
				if(s==null){
					JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("int1"),lenguage.getInstance().getProperty("warning"),JOptionPane.INFORMATION_MESSAGE);
					correct = false;
				}else {
					a = Integer.parseInt(s);
					correct = true;
				}
			}catch(Exception e){
				
				
				JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("int1"),"ERROR",JOptionPane.ERROR_MESSAGE);
				correct = false;
			}
		}while(correct==false);
		return a;

	}

/*----------------------VALIDA FLOAT----------------------*/
public static float vfloat( String message, String title ){
//Varibles
	String s=" ";
	float f = 0.0f;
	boolean correct=true;
//Operations
	do{
			try{
				s=JOptionPane.showInputDialog(null, message, title,JOptionPane.QUESTION_MESSAGE);
				if(s==null){
					JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("float1"),lenguage.getInstance().getProperty("warning"),JOptionPane.INFORMATION_MESSAGE);
					correct = false;
				}else {
					f = Float.parseFloat(s);
					correct = true;
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("float1"), "ERROR",JOptionPane.ERROR_MESSAGE);
				correct = false;
			}
		}while(correct==false);
		return f;

}
/*----------------------VALIDA CHAR----------------------*/
public static char vchar(String message, String title){
//Varibles
	String s=" ";
	char c=0;
	boolean correct=true;
//Operations
			do{
				try{
					s=JOptionPane.showInputDialog(null, message, title,JOptionPane.QUESTION_MESSAGE);
					if(s==null){
						JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("char1"),lenguage.getInstance().getProperty("warning"),JOptionPane.INFORMATION_MESSAGE);
						correct = false;
					}else {
						c=s.charAt(0);
						correct = true;
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("char1"), "ERROR",JOptionPane.ERROR_MESSAGE);
					correct = false;
				}
			}while(correct==false);
			return c;

}
/*----------------------VALIDA STRING----------------------*/
public static String vString(String message, String title){
//Variables
	String s=" ";
	boolean correct=true;
//Operations
			do{
				try{
					s = JOptionPane.showInputDialog(null, message, title,JOptionPane.QUESTION_MESSAGE);
					correct = true;
					if (s==null){
						JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("string1"),lenguage.getInstance().getProperty("warning"),JOptionPane.INFORMATION_MESSAGE);
						correct = false;
					}
					if(s.equals("")){
						JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("string2"),"ERROR",JOptionPane.ERROR_MESSAGE);
						correct = false;
					}
				}catch(Exception e){
					JOptionPane.showMessageDialog(null,lenguage.getInstance().getProperty("string1"), "ERROR",JOptionPane.ERROR_MESSAGE);
					correct = false;
				}
			}while(correct==false);
			return s;
}
/*----------------------MENÚ Option----------------------*/
public static int menuo(String[] options, String message, String title){
/*En el main te que haber una variable 	String [ ] operaciones= {"suma","resta","producto","divisi�n", "hola"}; */
//Variables
	int option=0;
//Operations
	option=JOptionPane.showOptionDialog(null, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
	return option;
}

/*----------------------Menú Option----------------------*/
public static String menucombox(String[] options, String message, String title){
/*En el main te que haber una variable 	String [ ] operaciones= {"suma","resta","producto","divisi�n", "hola"}; */
//Variables
	String cad=" ";
//Operations
	Object opcion=JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE,null,  options,0);
	try{
		cad=opcion.toString();
	} catch (Exception e) {
		cad="null";
	
	}
	
	return cad;
}


}

