package Users.Modules.User.Utils.Normal.Utils_Files_Normal;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import Users.Modules.User.Classes.Singleton;
import Users.Modules.User.Classes.userad;
import Users.Modules.User.Classes.usern;
public class Open_Normal {
	public static ArrayList<usern> openjson_normal() {
    	String PATH = null;
    	usern a1=null;
    	
	        try {
	        	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
		          xstream.setMode(XStream.NO_REFERENCES);
				  xstream.alias("Normal", usern.class);
				  
				  PATH = new java.io.File(".").getCanonicalPath()+ "/src/Users/Modules/User/Utils/Normal/Files_Normal/json/normal.json";
		               
		                Singleton.userregister.clear();
		                
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
		            		a1 = json.fromJson(elemento, usern.class);
		            		Singleton.userregister.add(a1);
		            	}
		           
	
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, Singleton.language.getProperty("err_json"), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        return Singleton.userregister;
	    
        
    }
	public static void openxml_normal() {
    	String PATH=null;
    	try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, usern.class);
 
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/Users/Modules/User/Utils/Normal/Files_Normal/xml/normal.xml";
            
            Singleton.userregister = (ArrayList <usern>)xstream.fromXML(new FileReader(PATH));
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, Singleton.language.getProperty("err_xml"), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	public static void opentxt_normal() {
    	String PATH = null;
        try {
            File file;
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/Users/Modules/User/Utils/Normal/Files_Normal/txt/normal.txt";
            file = new File(PATH);
            
            FileInputStream FIS=new FileInputStream(file);
    		ObjectInputStream OIS=new ObjectInputStream(FIS);
    		Singleton.userregister = (ArrayList<usern>)OIS.readObject();
    		OIS.close();
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, Singleton.language.getProperty("err_txt"), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	
	
	
	//ON-DEMAND
		public static ArrayList<usern> obri_json_ondemmand() {
	    	String PATH = null;
	    	usern e1=new usern("");
	    	
	        try {
	        	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
		          xstream.setMode(XStream.NO_REFERENCES);
				  xstream.alias("Normal", usern.class);
				  
				  JFileChooser fileChooser = new JFileChooser();
				  fileChooser.setAcceptAllFileFilterUsed(false);
		           fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
		          int seleccion = fileChooser.showOpenDialog(null);
		          if (seleccion == JFileChooser.APPROVE_OPTION) {
		                File JFC = fileChooser.getSelectedFile();
		                PATH = JFC.getAbsolutePath();
		               
		                Singleton.userregister.clear();
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
		            		e1 = json.fromJson(elemento, usern.class);
		            		Singleton.userregister.add(e1);
		            	}
		          } 
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, Singleton.language.getProperty("err_json"), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        return Singleton.userregister;
	    }
		public static ArrayList<usern> obri_xml_ondemand() {
	    	String PATH=null;
	    	try {
	            XStream xstream = new XStream();
	            Annotations.configureAliases(xstream, usern.class);
	 
	            JFileChooser fileChooser = new JFileChooser();
	            fileChooser.setAcceptAllFileFilterUsed(false);
	            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
	            int seleccion = fileChooser.showOpenDialog(null);
	           
	            if (seleccion == JFileChooser.APPROVE_OPTION) {
	            	File JFC = fileChooser.getSelectedFile();
	                PATH = JFC.getAbsolutePath();
	                Singleton.userregister = (ArrayList <usern>)xstream.fromXML(new FileReader(PATH));
	            }
	            
	        } catch (Exception e1) {
	        	JOptionPane.showMessageDialog(null, Singleton.language.getProperty("err_xml"), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        return Singleton.userregister;
	    }
		public static ArrayList<usern> obri_txt_ondemand() {
	    	String PATH = null;
	        try {
	            File f;
	            JFileChooser fileChooser = new JFileChooser();
	            fileChooser.setAcceptAllFileFilterUsed(false);
	            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Texto (*.txt)", "txt"));

	            int seleccion = fileChooser.showOpenDialog(null);
	            if (seleccion == JFileChooser.APPROVE_OPTION) {
	                File JFC = fileChooser.getSelectedFile();
	                PATH = JFC.getAbsolutePath();
	                f = new File(PATH);
	                
	                FileInputStream fi=new FileInputStream(f);
	    			ObjectInputStream oi=new ObjectInputStream(fi);
	    			Singleton.userregister = (ArrayList<usern>)oi.readObject();
	    			oi.close();
	            }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, Singleton.language.getProperty("err_txt"), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    	return Singleton.userregister;
	    }
}
