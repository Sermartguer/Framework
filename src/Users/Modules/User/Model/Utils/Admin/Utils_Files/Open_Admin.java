package Users.Modules.User.Model.Utils.Admin.Utils_Files;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import Users.Classes.lenguage;
import Users.Main.menu4;
import Users.Modules.User.Model.Classes.Singleton;
import Users.Modules.User.Model.Classes.userad;
import Users.Modules.User.Model.Classes.usu;

public class Open_Admin {
	
	//AUTO
	public static ArrayList<userad> openjson_admin() {
		String PATH = null;
	      
        try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/Users/Modules/User/Model/Utils/Admin/Files/Admin/json/admin.json";
        } catch (IOException e) {
            e.printStackTrace();
        }

        //if (Singleton.useradmin.size() > 0) {
	        try {
		          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
		          xstreamjson.setMode(XStream.NO_REFERENCES);
		          xstreamjson.alias("Client", userad.class);
		          
		          Gson gson = new Gson();
			      String json = gson.toJson(Singleton.useradmin);
			      FileWriter fileXml = new FileWriter(PATH);
		          fileXml.write(json.toString());
		          fileXml.close(); 
		          
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("err_json"), "Error", JOptionPane.ERROR_MESSAGE);
	        }
        //} else {
            File path = new File(PATH);

            path.delete();
       // }
	        return Singleton.useradmin;
	    
        
    }
	public static void openxml_admin() {
    	String PATH=null;
    	try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, userad.class);
 
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/Users/Modules/User/Model/Utils/Admin/Files/xml/admin.xml";
            
            Singleton.useradmin = (ArrayList <userad>)xstream.fromXML(new FileReader(PATH));
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("err_xml"), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public static void opentxt_admin() {
    	String PATH = null;
        try {
            File file;
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/Users/Modules/User/Model/Utils/Admin/Files/txt/admin.txt";
            file = new File(PATH);
            
            FileInputStream FIS=new FileInputStream(file);
    		ObjectInputStream OIS=new ObjectInputStream(FIS);
    		Singleton.useradmin = (ArrayList<userad>)OIS.readObject();
    		OIS.close();
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("err_txt"), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	
	
	//ON-DEMAND
	public static ArrayList<userad> obri_json() {
    	String PATH = null;
    	userad e1=new userad("");
    	
        try {
        	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
	          xstream.setMode(XStream.NO_REFERENCES);
			  xstream.alias("userad", userad.class);
			  
			  JFileChooser fileChooser = new JFileChooser();
			  fileChooser.setAcceptAllFileFilterUsed(false);
	           fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
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
        	JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("err_json"), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return Singleton.useradmin;
    }
	
	public static ArrayList<userad> obri_xml() {
    	String PATH=null;
    	try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, userad.class);
 
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
            int seleccion = fileChooser.showOpenDialog(null);
           
            if (seleccion == JFileChooser.APPROVE_OPTION) {
            	File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                Singleton.useradmin = (ArrayList <userad>)xstream.fromXML(new FileReader(PATH));
            }
            
        } catch (Exception e1) {
        	JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("err_xml"), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return Singleton.useradmin;
    }
	
	public static ArrayList<userad> obri_txt() {
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
    			Singleton.useradmin = (ArrayList<userad>)oi.readObject();
    			oi.close();
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("err_txt"), "Error", JOptionPane.ERROR_MESSAGE);
        }
    	return Singleton.useradmin;
    }
	
	
}
