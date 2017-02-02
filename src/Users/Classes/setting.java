package Users.Classes;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import Users.Modules.User.Model.Classes.Singleton;
import Users.Modules.User.Model.Classes.userad;
import Users.Modules.User.Model.Classes.usercl;
import Users.Modules.User.Model.Classes.usern;
import Users.Modules.User.Model.Utils.Functions_theme;
import Users.Modules.User.Model.Utils.CRUD.Functions_open_auto;

public class setting {
@XStreamAlias("language")
private String language;
@XStreamAlias("decimal")
private String decimal;
@XStreamAlias("formato_fecha")
private String formato_fecha;
@XStreamAlias("coin")
private String coin;
@XStreamAlias("file")
private String file;
@XStreamAlias("dummies")
private boolean dummies;
private String theme;
@XStreamAlias("instance")
private static setting instance;

public setting (String language, String decimal, String formato_fecha, String coin,String file,boolean dummies,String theme){
	super();
	this.coin=coin;
	this.language=language;
	this.decimal=decimal;
	this.formato_fecha=formato_fecha;
	this.file=file;
	this.dummies=dummies;
	this.theme=theme;
}
public setting () {
	this.coin = "euro";
	this.language = "English";
	this.decimal = ".0";
	this.formato_fecha = "dd/mm/yyyy";
	this.file="XML";
	this.dummies=true;
	this.theme="METAL";
}

public static setting getInstance () {
	if (instance == null){
		instance = new setting ();
		//Language_general.getInstance();
		//Language_user.getInstance();
		Singleton.useradmin = new ArrayList <userad> ();
		Singleton.userclient = new ArrayList <usercl> ();
		Singleton.userregister = new ArrayList <usern> ();
		Functions_theme.theme();
		Functions_open_auto.open();
		lenguage.getInstance();
		

		
	}
	return instance;
}

//GETTERS
public String getlang(){
	return language;
}
public String getdecimal(){
	return decimal;
}

public String getffecha(){
	return formato_fecha;
}
public String getcoin(){
	return coin;
}
public String getfile(){
	return file;
}
public boolean getdummies(){
	return dummies;
}
public String gettheme(){
	return theme;
}
//SETTERS
public void setlang(String lang){
	this.language=lang;
	lenguage.getInstance().setIdioma(lang);
}
public void setdecimal(String decimal){
	this.decimal=decimal;
}
public void setffecha(String formato_fecha){
	this.formato_fecha=formato_fecha;
}
public void setcoin(String coin){
	this.coin=coin;
}
public void setfile(String file){
	this.file=file;
}
public void setdummies(boolean dummies){
	this.dummies=dummies;
}
public void settheme(String theme){
	this.theme=theme;
	Functions_theme.theme();
}
@Override
public String toString(){
	return "Settings: "+"\n"+
			"Language: "+this.language+"\n"+
			"Decimals: "+this.decimal+"\n"+
			"Formato fecha : "+this.formato_fecha+"\n"+
			"Coin : "+this.coin+"\n"+
			"File : "+this.file+"\n"+
			"Dummies : "+this.dummies+"\n"+
			"Tema : "+this.theme;
}
}
