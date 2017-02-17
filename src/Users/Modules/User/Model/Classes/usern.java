package Users.Modules.User.Model.Classes;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import Users.Classes.fecha;
import Users.Classes.lenguage;
import Users.Classes.setting;
@XStreamAlias("usern")
public class usern extends usu implements Serializable{
	@XStreamAlias("points")
private int points=0;
	@XStreamAlias("n_comentarios")
private int n_com=0;
	@XStreamAlias("karma")
private String karma="";

public usern (String nom, String dni, fecha f_nac, int edad,String email,int n_com,String karma,int punts){
	super (nom, dni,f_nac,edad,email);
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
	String date=setting.getInstance().getffecha();

	String cad="";
	cad = cad + ("\n" + lenguage.getInstance().getProperty("tname")+" "+this.getnom());
	cad = cad + ("\n" + "Dni: "+this.getdni());
	cad = cad + ("\n" + lenguage.getInstance().getProperty("tfnac")+" "+this.getf_nac().toString(date));
	cad = cad + ("\n" + lenguage.getInstance().getProperty("tage")+" "+this.getedad());
	cad = cad + ("\n" + lenguage.getInstance().getProperty("temail")+" "+this.getemail());
	cad = cad + ("\n" + lenguage.getInstance().getProperty("tn_com")+" "+this.getn_com());
	cad = cad + ("\n" + "Karma: "+this.getkarma());
	cad = cad + ("\n" + lenguage.getInstance().getProperty("tpoints")+" "+this.getpunts());


	return cad;
}

}
