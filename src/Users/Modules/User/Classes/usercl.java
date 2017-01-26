package Users.Modules.User.Classes;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import Users.Classes.fecha;
import Users.Main.menu4;
import Users.Utils.format;
@XStreamAlias("Client")
public class usercl extends usu implements Serializable{
@XStreamAlias("ptos")
private int ptos=0;
@XStreamAlias("descuentos")
private int descuentos=0;
@XStreamAlias("n_compras")
private int n_comp=0;

public usercl (String nom, String dni,fecha f_nac, int edad, int n_comp,int descuentos){
	super (nom, dni,f_nac,edad);
	this.n_comp=n_comp;
	this.descuentos=descuentos;

	
}
public usercl(String DNI) {
	super(DNI);
}
//getters

public int getn_comp(){
	return this.n_comp;
}
public int getdes(){
	return this.descuentos;
}

//setters

public void setn_comp(int n_comp){
	this.n_comp=n_comp;
	
}
public void setdes(int descuentos){
	this.descuentos=descuentos;
	
}


public String toString (String DNI) {
	String cad="";
	
	cad=cad+(super.getdni()+"\n");
	
	return cad;
}

public String toString(){
	String decimal= Singleton.config.getdecimal();
	String date=Singleton.config.getffecha();
	String cad="";
	cad = cad + ("\n"+Singleton.language.getProperty("tname")+this.getnom()+"\n");
	cad = cad + ("Dni: "+this.getdni()+"\n");
	cad = cad + (Singleton.language.getProperty("tfnac")+this.getf_nac().toString(date)+"\n");
	cad = cad + (Singleton.language.getProperty("tage")+this.getedad()+"\n");
	cad = cad + (Singleton.language.getProperty("tn_comp")+this.getn_comp()+"\n");
	cad = cad + (Singleton.language.getProperty("tdescuento")+format.por(this.getdes())+"\n");
	return cad;

}
}
