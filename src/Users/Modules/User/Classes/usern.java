package Users.Modules.User.Classes;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import Users.Classes.fecha;
@XStreamAlias("usern")
public class usern extends usu implements Serializable{
	@XStreamAlias("points")
private int points=0;
	@XStreamAlias("n_comentarios")
private int n_com=0;
	@XStreamAlias("karma")
private String karma="";

public usern (String nom, String dni, fecha f_nac, int edad,int n_com,String karma,int punts){
	super (nom, dni,f_nac,edad);
	this.points=punts;
	this.n_com=n_com;
	this.karma=karma;

}
public usern(String DNI) {
	super(DNI);
}
//getters
public int getpunts(){
	return this.points;
}
public int getn_com(){
	return this.n_com;
}
public String getkarma(){
	return this.karma;
}

//setters
public void setpunts(int punts){
	this.points=punts;
}
public void setn_com(int n_com){
	this.n_com=n_com;
}
public void setkarma(String karma){
	this.karma=karma;
}

public String toString (String DNI) {
	String cad="";
	
	cad=cad+(super.getdni()+"\n");
	
	return cad;
}

public String toString(){
	String date=Singleton.config.getffecha();
	String decimal= Singleton.config.getdecimal();
	String cad="";
	cad = cad + ("\n" + Singleton.language.getProperty("tname")+this.getnom());
	cad = cad + ("\n" + "Dni: "+this.getdni());
	cad = cad + ("\n" + Singleton.language.getProperty("tfnac")+this.getf_nac().toString(date));
	cad = cad + ("\n" + Singleton.language.getProperty("tage")+this.getedad());
	cad = cad + ("\n" + Singleton.language.getProperty("tn_com")+this.getn_com());
	cad = cad + ("\n" + "Karma: "+this.getkarma());
	cad = cad + ("\n" + Singleton.language.getProperty("tpoints")+this.getpunts());


	return cad;
}

}
