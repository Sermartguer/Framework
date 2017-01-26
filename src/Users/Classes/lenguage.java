package Users.Classes;
import java.io.IOException;
import java.util.Properties;

public class lenguage extends Properties{
private static final long serialVersionUID = 1L;
private String idioma="";

public lenguage (String idioma){
	this.idioma=idioma;
    switch(idioma){
    case "English":
        getProperties("english.properties");
        break;
    case "Spanish":
        getProperties("spanish.properties");
        break;
    case "Valencia":
        getProperties("valencia.properties");
        break;
    default:
        getProperties("english.properties");
    }
}
public String getIdioma() {
	return idioma;
}

public void setIdioma(String idioma) {
	this.idioma = idioma;
	switch(idioma){
    case "English":
        getProperties("english.properties");
        break;
    case "Spanish":
        getProperties("spanish.properties");
        break;
    case "Valencia":
        getProperties("valencia.properties");
        break;
    default:
        getProperties("english.properties");
	}
}

public void getProperties(String idioma) {
    try {
        this.load( getClass().getResourceAsStream(idioma) );
    } catch (IOException ex) {
    }
}
}
