package Users.Classes;
import java.io.IOException;
import java.util.Properties;

public class lenguage extends Properties{
private static final long serialVersionUID = 1L;
private String idioma="";	
private static lenguage instance;


public lenguage (){
	idioma=setting.getInstance().getlang();
	//this.idioma=idioma;
	
		switch(idioma){
	    case "English":
	        getProperties("lenguage_properties/english.properties");
	        break;
	    case "Spanish":
	        getProperties("lenguage_properties/spanish.properties");
	        break;
	    case "Valencia":
	        getProperties("lenguage_properties/valencia.properties");
	        break;
	    case "Italiano":
	        getProperties("lenguage_properties/italian.properties");
	        break;
	    case "Portuges":
	        getProperties("lenguage_properties/portuges.properties");
	        break;
	    default:
	        getProperties("lenguage_properties/english.properties");
	    }
    
}
public String getIdioma() {
	return idioma;
}

public void setIdioma(String idioma) {
	this.idioma = idioma;
	
	switch(idioma){
    case "English":
        getProperties("lenguage_properties/english.properties");
        break;
    case "Spanish":
        getProperties("lenguage_properties/spanish.properties");
        break;
    case "Valencia":
        getProperties("lenguage_properties/valencia.properties");
        break;
    case "Italiano":
        getProperties("lenguage_properties/italian.properties");
        break;
    case "Portuges":
        getProperties("lenguage_properties/portuges.properties");
        break;
    default:
        getProperties("lenguage_properties/english.properties");
	}
}
public static lenguage getInstance () {
	if (instance==null){
		instance = new lenguage();
	}
	return instance;
}

public void getProperties(String idioma) {
    try {
        this.load( getClass().getResourceAsStream(idioma) );
    } catch (IOException ex) {
    }
}
}
