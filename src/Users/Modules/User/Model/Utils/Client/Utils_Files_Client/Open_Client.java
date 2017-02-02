package Users.Modules.User.Model.Utils.Client.Utils_Files_Client;
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

import Users.Classes.lenguage;
import Users.Modules.User.Model.Classes.Singleton;
import Users.Modules.User.Model.Classes.userad;
import Users.Modules.User.Model.Classes.usercl;
import Users.Modules.User.Model.Classes.usern;
public class Open_Client {
	public static ArrayList<usercl> openjson_client() {
    	String PATH = null;
    	usercl a1=null;
    	
	        try {
	        	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
		          xstream.setMode(XStream.NO_REFERENCES);
				  xstream.alias("Client", usercl.class);
				  
				  PATH = new java.io.File(".").getCanonicalPath()+ "/src/Users/Modules/User/Model/Utils/Client/Client/json/client.json";
		               
		                Singleton.userclient.clear();
		                
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
		            		a1 = json.fromJson(elemento, usercl.class);
		            		Singleton.userclient.add(a1);
		            	}
		           
	
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("err_json"), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        return Singleton.userclient;
	    
        
    }
	public static void openxml_client() {
    	String PATH=null;
    	try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, usercl.class);
 
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/Users/Modules/User/Model/Utils/Client/Files_Client/xml/client.xml";
            
            Singleton.userclient = (ArrayList <usercl>)xstream.fromXML(new FileReader(PATH));
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("err_xml"), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	public static void opentxt_client() {
    	String PATH = null;
        try {
            File file;
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/Users/Modules/User/Model/Utils/Client/Files_Client/txt/client.txt";
            file = new File(PATH);
            
            FileInputStream FIS=new FileInputStream(file);
    		ObjectInputStream OIS=new ObjectInputStream(FIS);
    		Singleton.userclient = (ArrayList<usercl>)OIS.readObject();
    		OIS.close();
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("err_txt"), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	
	
	
	//ON-DEMAND
			public static ArrayList<usercl> obri_json_ondemmand() {
		    	String PATH = null;
		    	usercl e1=new usercl("");
		    	
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
			               
			                Singleton.userclient.clear();
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
			            		e1 = json.fromJson(elemento, usercl.class);
			            		Singleton.userclient.add(e1);
			            	}
			          } 
		        } catch (Exception e) {
		        	JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("err_json"), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        return Singleton.userclient;
		    }
			
			public static ArrayList<usercl> obri_xml_ondemand() {
		    	String PATH=null;
		    	try {
		            XStream xstream = new XStream();
		            Annotations.configureAliases(xstream, usercl.class);
		 
		            JFileChooser fileChooser = new JFileChooser();
		            fileChooser.setAcceptAllFileFilterUsed(false);
		            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
		            int seleccion = fileChooser.showOpenDialog(null);
		           
		            if (seleccion == JFileChooser.APPROVE_OPTION) {
		            	File JFC = fileChooser.getSelectedFile();
		                PATH = JFC.getAbsolutePath();
		                Singleton.userclient = (ArrayList <usercl>)xstream.fromXML(new FileReader(PATH));
		            }
		            
		        } catch (Exception e1) {
		        	JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("err_xml"), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        return Singleton.userclient;
		    }
			public static ArrayList<usercl> obri_txt_ondemand() {
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
		    			Singleton.userclient = (ArrayList<usercl>)oi.readObject();
		    			oi.close();
		            }
		        } catch (Exception e) {
		        	JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("err_txt"), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    	return Singleton.userclient;
		    }
}
