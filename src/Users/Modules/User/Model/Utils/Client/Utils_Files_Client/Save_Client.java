package Users.Modules.User.Model.Utils.Client.Utils_Files_Client;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
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

import Users.Modules.User.Model.Classes.Singleton;
import Users.Modules.User.Model.Classes.userad;
import Users.Modules.User.Model.Classes.usercl;
import Users.Modules.User.Model.Classes.usern;
public class Save_Client {
	private static final String ENCODING = "UTF-8";
	//AUTO
		public static void savejson_client() {
			String PATH = null;
		     
	        try {
	            PATH = new java.io.File(".").getCanonicalPath()
	                    + "/src/Users/Modules/User/Utils/Client/Files_Client/json/client.json";
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        if (Singleton.userclient.size() > 0) {
		        try {
			          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			          xstreamjson.setMode(XStream.NO_REFERENCES);
			          xstreamjson.alias("Client", usercl.class);
			          
			          Gson gson = new Gson();
				      String json = gson.toJson(Singleton.userclient);
				      FileWriter fileXml = new FileWriter(PATH);
			          fileXml.write(json.toString());
			          fileXml.close(); 
			          
		        } catch (Exception e) {
			    	JOptionPane.showMessageDialog(null, "Error al guardar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
		        }
	        } else {
	            File path = new File(PATH);

	            path.delete();
	        }
	    }
		
		public static void savexml_client() {
	        String PATH=null;
			
	        try {
	            PATH = new java.io.File(".").getCanonicalPath()
	                    + "/src/Users/Modules/User/Utils/Client/Files_Client/xml/client.xml";
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        if (Singleton.userclient.size() > 0) {
		        try {
					OutputStream OS = new ByteArrayOutputStream();
					OutputStreamWriter OSW = new OutputStreamWriter(OS);
					XStream xstream = new XStream();
					Annotations.configureAliases(xstream, usercl.class);
		
		            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
		            xstream.toXML(Singleton.userclient, OSW);
		            StringBuffer xml = new StringBuffer();
		            xml.append(header);
		            xml.append(OS.toString());
		            
		            FileWriter fileXml = new FileWriter(PATH);
		            fileXml.write(xml.toString());
		            fileXml.close();
		            OSW.close();
		            OS.close();
		            
			    }catch (Exception e){
			    	JOptionPane.showMessageDialog(null, "Error al guardar el XML", "Error", JOptionPane.ERROR_MESSAGE);
			    }
	        } else {
	            File path = new File(PATH);

	            path.delete();
	        }
	    }
		public static void savetxt_client() {
	        String PATH = null;
	        
	        try {
	            PATH = new java.io.File(".").getCanonicalPath()
	                    + "/src/Users/Modules/User/Utils/Client/Files_Client/txt/client.txt";
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        if (Singleton.userclient.size() > 0) {
		        try {
		            File file;
		            
		            file = new File(PATH);
		            
		            FileOutputStream FOS=new FileOutputStream(file);
					ObjectOutputStream OOS=new ObjectOutputStream(FOS);
					OOS.writeObject(Singleton.userclient);
					OOS.close();
		            
		        } catch (Exception e) {
		        	JOptionPane.showMessageDialog(null, "Error al guardar TXT", "Error", JOptionPane.ERROR_MESSAGE);
		        }
	        } else {
	            File path = new File(PATH);

	            path.delete();
	        }
	    }
		
		
		
		//ON-DEMAND
				public static void savejson_client_ondemmand() {
			        String PATH = null;
				      try {
				          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				          xstreamjson.setMode(XStream.NO_REFERENCES);
				          xstreamjson.alias("Normal", usercl.class);
				          	          
				          JFileChooser fileChooser = new JFileChooser();
				          
				          fileChooser.setAcceptAllFileFilterUsed(false);
				            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
				            
				          int selection = fileChooser.showSaveDialog(null);
				          if (selection == JFileChooser.APPROVE_OPTION) {
				                File JFC = fileChooser.getSelectedFile();
				                PATH = JFC.getAbsolutePath();
				                PATH=PATH+ ".json";
				                
				                Gson gson = new Gson();
					            String json = gson.toJson(Singleton.userclient);
					            FileWriter fileXml = new FileWriter(PATH);
				                fileXml.write(json.toString());
				                fileXml.close(); 
				                
				                JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
				          }
			        } catch (Exception e) {
			        	JOptionPane.showMessageDialog(null, "Error al guardar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			    }
				
				public static void savexml_client_ondemmand() {
			        String PATH=null;
					try {
						OutputStream OS = new ByteArrayOutputStream();
						OutputStreamWriter OSW = new OutputStreamWriter(OS);
						XStream xstream = new XStream();
						Annotations.configureAliases(xstream, usercl.class);

			            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			            xstream.toXML(Singleton.userclient, OSW);
			            StringBuffer xml = new StringBuffer();
			            xml.append(header);
			            xml.append(OS.toString());
				    
			            JFileChooser fileChooser = new JFileChooser();
			            
			            fileChooser.setAcceptAllFileFilterUsed(false);
			            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
			            
			            int selection = fileChooser.showSaveDialog(null);
			            if (selection == JFileChooser.APPROVE_OPTION) {
			            	File JFC = fileChooser.getSelectedFile();
			                PATH = JFC.getAbsolutePath();
			                PATH = PATH+".xml";
			                
			                FileWriter fileXml = new FileWriter(PATH);
			                fileXml.write(xml.toString());
			                fileXml.close();
			                OSW.close();
			                OS.close();
			                JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
			            }
				    }catch (Exception e){
				    	JOptionPane.showMessageDialog(null, "Error al guardar el XML", "XML", JOptionPane.ERROR_MESSAGE);
				    } 
			    }
				 public static void savetxt_client_ondemmand() {
				        String PATH = null;
				        try {
				            File file;
				            JFileChooser fileChooser = new JFileChooser();
				            
				            fileChooser.setAcceptAllFileFilterUsed(false);
				            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Texto (*.txt)", "txt"));
				            
				            int selection = fileChooser.showSaveDialog(null);
				            if (selection == JFileChooser.APPROVE_OPTION) {
				                File JFC = fileChooser.getSelectedFile();
				                PATH = JFC.getAbsolutePath();
				                PATH=PATH+ ".txt";
				                file = new File(PATH);
				                
				                FileOutputStream FOS=new FileOutputStream(file);
								ObjectOutputStream OOS=new ObjectOutputStream(FOS);
								OOS.writeObject(Singleton.userclient);
								OOS.close();
				                JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
				            }
				        } catch (Exception e) {
				        	JOptionPane.showMessageDialog(null, "Error al guardar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
				        }
				    }
}
