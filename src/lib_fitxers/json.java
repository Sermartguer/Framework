package lib_fitxers;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import Users.Modules.User.Classes.Singleton;
import Users.Modules.User.Classes.userad;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class json {
    public static void generajson() {
        String PATH = null;
	      try {
	          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
	          xstreamjson.setMode(XStream.NO_REFERENCES);
	          xstreamjson.alias("userad", userad.class);
	          
	          JFileChooser fileChooser = new JFileChooser();
	          int seleccion = fileChooser.showSaveDialog(null);
	          if (seleccion == JFileChooser.APPROVE_OPTION) {
	                File JFC = fileChooser.getSelectedFile();
	                PATH = JFC.getAbsolutePath();
	                PATH=PATH+ ".json";
	                
	                //xstreamjson.toXML(AlistEF.efi, new FileOutputStream(PATH)); //NO VA
	                
	                /* TAMPOC VA
	                StringBuffer json = new StringBuffer();
	                for (int i = 0; i < AlistEF.efi.size(); i++) {
	                    json.append(xstreamjson.toXML(AlistEF.efi.get(i)));
	                }
	                FileWriter fileXml = new FileWriter(PATH);
	                fileXml.write(json.toString());
	                fileXml.close();*/
	                
	                Gson gson = new Gson();
		            String json = gson.toJson(Singleton.useradmin);
		            FileWriter fileXml = new FileWriter(PATH);
	                fileXml.write(json.toString());
	                fileXml.close(); 
	                
	                JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
	          }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static ArrayList<userad> obri_json() {
    	String PATH = null;
    	userad e1=new userad("");
    	
        try {
        	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
	          xstream.setMode(XStream.NO_REFERENCES);
			  xstream.alias("userad", userad.class);
			  
			  JFileChooser fileChooser = new JFileChooser();
	          int seleccion = fileChooser.showOpenDialog(null);
	          if (seleccion == JFileChooser.APPROVE_OPTION) {
	                File JFC = fileChooser.getSelectedFile();
	                PATH = JFC.getAbsolutePath();
	               
	                Singleton.useradmin.clear();
	                //AlistEF.efi = (ArrayList<empleafijo>)xstream.fromXML(new FileReader(PATH)); //NO VA
	                /* TAMPOC VA
	                for (int i = 0; i < size; i++) {
	                	e1 = (empleafijo)xstream.fromXML(new FileReader(PATH));    
	                	AlistEF.efi.add(e1);
	                }*/
	              
	                JsonReader lector = new JsonReader(new FileReader(PATH));
	                JsonParser parseador = new JsonParser();
	                JsonElement raiz = parseador.parse(lector);
	            		  
	            	Gson json = new Gson();
	            	JsonArray lista = raiz.getAsJsonArray();
	            	for (JsonElement elemento : lista) {
	            		e1 = json.fromJson(elemento, userad.class);
	            		Singleton.useradmin.add(e1);
	            	}
	          } 
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error al leer el JSON", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return Singleton.useradmin;
    }
}
