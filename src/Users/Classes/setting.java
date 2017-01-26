package Users.Classes;

public class setting {
private String language;
private String decimal;
private String formato_fecha;
private String coin;
private String file;
private boolean dummies;
public setting (String language, String decimal, String formato_fecha, String coin,String file,boolean dummies){
	super();
	this.coin=coin;
	this.language=language;
	this.decimal=decimal;
	this.formato_fecha=formato_fecha;
	this.file=file;
	this.dummies=dummies;
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
//SETTERS
public void setlang(String lang){
	this.language=lang;
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
@Override
public String toString(){
	return "Settings: "+"\n"+"Language: "+this.language+"\n"+"Decimals: "+this.decimal+"\n"+"Formato fecha : "+this.formato_fecha+"\n"+"Coin : "+this.coin+"\n"+"File : "+this.file+"\n"+"Dummies : "+this.dummies;
}
}
