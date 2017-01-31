package Users.Modules.User.Classes;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import Users.Classes.fecha;
public abstract class usu implements Comparable<usu>,Serializable{
@XStreamAlias("nom")
private String nom="";
@XStreamAlias("dni")
private String dni="";
private fecha f_nac;
@XStreamAlias("edad")
private int edad=0;
@XStreamAlias("email")
private String email="";
public usu(String nom,String dni,fecha f_nac,int edad,String email){
	this.nom=nom;
	this.dni=dni;
	this.f_nac=f_nac;
	this.edad=edad;
	this.email=email;
}
public usu (){
	
}
public usu(fecha f_nac){
	this.f_nac=f_nac;
	
}
public usu(String dni) {
	this.dni = dni;
}
//setters
public void setnom(String nom){
	this.nom=nom;
}

public void setdni(String dni){
	this.dni=dni;
}

public void setf_nac(fecha setf_nac){
	this.f_nac=setf_nac;
}
public void setedad(int edad){
	this.edad=edad;
}
public void setemail(String email){
	this.email=email;
}

//getters
public String getnom(){
	return this.nom;
}
public String getdni(){
	return this.dni;
}
public fecha getf_nac(){
	return f_nac;
}
public int getedad(){
	return this.edad;
}
public String getemail(){
	return this.email;
}
public int compareTo(usu param) {//para ordenar los empleados por nombre
	if(this.getdni().compareTo(param.getdni())>0)
		return 1;
	if(this.getdni().compareTo(param.getdni())<0)
		return -1;
	return 0;
  }

public boolean equals(Object param){
	return getdni().equals(((usu)param).getdni());
}		




//tostring
public String toString (String DNI) {
	String cad="";
	
	cad=cad+(this.getdni()+"\n");
	
	return cad;
}

public abstract String toString();
}
