package Users.Modules.User.Model.Classes;

import java.io.Serializable;
import java.text.ParseException;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import Users.Classes.fecha;
import Users.Classes.lenguage;
import Users.Classes.setting;
import Users.Main.menu4;
import Users.Modules.User.Model.Utils.fnes_v;
import Users.Modules.User.Model.Utils.func_fech;
import Users.Utils.format;
public class userad extends usu implements Serializable{
//Atributos
@XStreamAlias("sexo")
private String sexo="";
@XStreamAlias("username")
private String username="";
private fecha fant;
@XStreamAlias("antiguitat")
private int antiguitat=0;
@XStreamAlias("apto")
private String apto="";
@XStreamAlias("alta")
private String alta="";
@XStreamAlias("sou")
private double sou=0;
@XStreamAlias("salary")
private double salary=0;
@XStreamAlias("neto")
private double neto=0;
//Metodes
public userad (String nom, String dni, fecha f_nac, int edad,String email, String sex, String username,fecha fant, int antiguitat,double salary, String apto, String alta, double sou){
	super (nom,dni,f_nac,edad,email);
	this.sexo=sex;
	this.username=username;	
	this.fant=fant;
	this.antiguitat=antiguitat;
	this.salary=salary;
	this.apto=apto;
	this.alta=alta;
	this.sou=sou;
}

public userad(String DNI) {
	super(DNI);
}



//setters
public void setsex(String sexo){
	this.sexo=sexo;
	
}

public void setusername(String username){
	this.username=username;
	
}

public void setfant(fecha setfant){
	this.fant=setfant;
}
public void seteant(int antiguitat){
	this.antiguitat=antiguitat;
}
public void setsalary(int salary) {
	this.salary = salary;
}
public void setapto(String apto) {
	this.apto = apto;
}
public void setsou(int sou) {
	this.sou = sou;
}
public void setneto(double sou, double salary) {
	this.neto = this.getsalary()+this.getsou();
}


//Getters
public String getsexo(){
	String genero=fnes_v.genero(this.sexo);
	this.sexo=genero;
	return this.sexo;
}


public String getusername(){
	return this.username;
}


public fecha getfant() {
	return this.fant;
}
public int getAntiguitat() {
	return this.antiguitat;
}
public String getapto() {
	return apto;
}
public String getalta() {
	return alta;
}
public double getsou() {
	return sou;
}
public double getsalary() {
	return salary;
}
public double getneto(){
	return this.getsalary()+this.getsou();
}



public String toString (String DNI) {
	String cad="";
	
	cad=cad+(super.getdni()+"\n");
	
	return cad;
}
public String toString(){
	String coin=setting.getInstance().getcoin();
	String date=setting.getInstance().getffecha();

	System.out.println(this.getf_nac());
	String cad="";
	cad = cad + ("\n"+lenguage.getInstance().getProperty("tname")+" "+this.getnom()+"\n");
	cad = cad + ("DNI: "+this.getdni()+"\n");
	cad = cad + (lenguage.getInstance().getProperty("tfnac")+" "+this.getf_nac().toString(date)+"\n");
	cad = cad + (lenguage.getInstance().getProperty("tage")+" "+this.getedad()+"\n");
	cad = cad + (lenguage.getInstance().getProperty("tsex")+" "+this.getsexo()+"\n");
	cad = cad + (lenguage.getInstance().getProperty("temail")+" "+this.getemail()+"\n");
	cad = cad + (lenguage.getInstance().getProperty("tusername")+" "+this.getusername()+"\n");
	cad = cad + (lenguage.getInstance().getProperty("tfco")+" "+this.getfant().toString(date)+"\n");
	cad = cad + (lenguage.getInstance().getProperty("tcontra")+" "+this.getAntiguitat()+"\n");
	cad = cad + (lenguage.getInstance().getProperty("tapto")+" "+this.getapto()+"\n");
	cad = cad + (lenguage.getInstance().getProperty("tfalta")+" "+func_fech.toStringalta(this.getalta())+"\n");
	try {
		cad = cad + (lenguage.getInstance().getProperty("tsalariob")+" "+format.coins(this.getsou())+"\n");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		cad = cad + (lenguage.getInstance().getProperty("tplussal")+" "+format.coins(this.getsalary())+"\n");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		cad = cad + (lenguage.getInstance().getProperty("salarry")+" "+format.coins(this.getneto()));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cad;
}







}
