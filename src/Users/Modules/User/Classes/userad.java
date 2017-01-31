package Users.Modules.User.Classes;

import java.io.Serializable;
import java.text.ParseException;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import Users.Classes.fecha;
import Users.Classes.lenguage;
import Users.Classes.setting;
import Users.Main.menu4;
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
	String idioma=lenguage.getInstance().getIdioma();
	String sex=this.sexo;
	if(idioma=="English"){
		System.out.println("sex"+sex);
		if(((sex.equals("Man")))||((sex.equals("Hombre")))||((sex.equals("Home")))){
			sex="Man";
		}else if(((sex.equals("Woman")))||((sex.equals("Mujer")))||((sex.equals("Dona")))){
			sex="Woman";
		}else if(((sex.equals("Other")))||((sex.equals("Otra")))||((sex.equals("Altre")))){
			sex="Other";
		}
	}else if(idioma=="Valencia"){
		if(((sex.equals("Man")))||((sex.equals("Hombre")))||((sex.equals("Home")))){
			sex="Home";
		}else if(((sex.equals("Woman")))||((sex.equals("Mujer")))||((sex.equals("Dona")))){
			sex="Dona";
		}else if(((sex.equals("Other")))||((sex.equals("Otra")))||((sex.equals("Altre")))){
			sex="Altre";
		}
	}else if(idioma=="Spanish"){
		if(((sex.equals("Man")))||((sex.equals("Hombre")))||((sex.equals("Home")))){
			sex="Hombre";
		}else if(((sex.equals("Woman")))||((sex.equals("Mujer")))||((sex.equals("Dona")))){
			sex="Mujer";
		}else if(((sex.equals("Other")))||((sex.equals("Otra")))||((sex.equals("Altre")))){
			sex="Otro";
		}
		}
	this.sexo=sex;
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
	cad = cad + ("\n"+lenguage.getInstance().getProperty("tname")+this.getnom()+"\n");
	cad = cad + ("DNI: "+this.getdni()+"\n");
	cad = cad + (lenguage.getInstance().getProperty("tfnac")+this.getf_nac().toString(date)+"\n");
	cad = cad + ("EDAD: "+this.getedad()+"\n");
	cad = cad + ("SEXE: "+this.getsexo()+"\n");
	cad = cad + ("EMAIL: "+this.getemail()+"\n");
	cad = cad + ("USERNAME: "+this.getusername()+"\n");
	cad = cad + ("FECHA DE CONTRATACIO: "+this.getfant().toString(date)+"\n");
	cad = cad + ("ANTIGUITAT: "+this.getAntiguitat()+"\n");
	cad = cad + ("APTO PARA EL TRABAJO: "+this.getapto()+"\n");
	cad = cad + ("FECHA DE ALTA: "+this.getalta()+"\n");
	try {
		cad = cad + ("SALARI BRUTO: "+format.coins(this.getsou())+"\n");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		cad = cad + ("BONIFICACIO SALARI: "+format.coins(this.getsalary())+"\n");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		cad = cad + ("SALARY NETO: "+format.coins(this.getneto()));
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return cad;
}







}
