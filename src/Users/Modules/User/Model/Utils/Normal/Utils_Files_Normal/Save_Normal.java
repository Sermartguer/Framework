package Users.Modules.User.Model.Utils.Normal.Utils_Files_Normal;
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
import Users.Modules.User.Model.Classes.usern;
public class Save_Normal {
	private static final String ENCODING = "UTF-8";
	//AUTO
		public static void savejson_normal() {
			 String PATH = null;
		      try {
		          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
		          xstreamjson.setMode(XStream.NO_REFERENCES);
		          xstreamjson.alias("Normal", usern.class);
		          
		         System.out.println("hola");
		          PATH = new java.io.File(".").getCanonicalPath()
		            		+ "/src/Users/Modules/User/Model/Utils/Normal/Files_Normal/json/normal.json";
		          System.out.println("hola2");

		                
		                //xstreamjson.toXML(Singleton.useradmin, new FileOutputStream(PATH)); //NO VA
		                
		               /* // TAMPOC VA
		                StringBuffer json = new StringBuffer();
		                for (int i = 0; i < Singleton.useradmin.size(); i++) {
		                    json.append(xstreamjson.toXML(Singleton.useradmin.get(i)));
		                }
		                FileWriter fileXml = new FileWriter(PATH);
		                fileXml.write(json.toString());
		                fileXml.close();*/
		                
		              /*  Gson gson = new Gson();
			            String json = gson.toJson(Singleton.useradmin);
			            FileWriter fileXml = new FileWriter(PATH);
		                fileXml.write(json.toString());
		                fileXml.close();*/
		                
		                JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
		          
	      } catch (Exception e) {
	      	JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
	      }
		}
		
		
		public static void savexml_normal() {
	        String PATH=null;
			
	        try {
	            PATH = new java.io.File(".").getCanonicalPath()
	                    + "/src/Users/Modules/User/Model/Utils/Normal/Files_Normal/xml/normal.xml";
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        if (Singleton.userregister.size() > 0) {
		        try {
					OutputStream OS = new ByteArrayOutputStream();
					OutputStreamWriter OSW = new OutputStreamWriter(OS);
					XStream xstream = new XStream();
					Annotations.configureAliases(xstream, usern.class);
		
		            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
		            xstream.toXML(Singleton.userregister, OSW);
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
		public static void savetxt_normal() {
	        String PATH = null;
	        
	        try {
	            PATH = new java.io.File(".").getCanonicalPath()
	                    + "/src/Users/Modules/User/Model/Utils/Normal/Files_Normal/txt/normal.txt";
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        if (Singleton.userregister.size() > 0) {
		        try {
		            File file;
		            
		            file = new File(PATH);
		            
		            FileOutputStream FOS=new FileOutputStream(file);
					ObjectOutputStream OOS=new ObjectOutputStream(FOS);
					OOS.writeObject(Singleton.userregister);
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
		public static void savejson_normal_ondemmand() {
	        String PATH = null;
		      try {
		          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
		          xstreamjson.setMode(XStream.NO_REFERENCES);
		          xstreamjson.alias("Normal", usern.class);
		          	          
		          JFileChooser fileChooser = new JFileChooser();
		          
		          fileChooser.setAcceptAllFileFilterUsed(false);
		            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
		            
		          int selection = fileChooser.showSaveDialog(null);
		          if (selection == JFileChooser.APPROVE_OPTION) {
		                File JFC = fileChooser.getSelectedFile();
		                PATH = JFC.getAbsolutePath();
		                PATH=PATH+ ".json";
		                
		                Gson gson = new Gson();
			            String json = gson.toJson(Singleton.userregister);
			            FileWriter fileXml = new FileWriter(PATH);
		                fileXml.write(json.toString());
		                fileXml.close(); 
		                
		                JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
		          }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error al guardar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
		public static void savexml_normal_ondemmand() {
	        String PATH=null;
			try {
				OutputStream OS = new ByteArrayOutputStream();
				OutputStreamWriter OSW = new OutputStreamWriter(OS);
				XStream xstream = new XStream();
				Annotations.configureAliases(xstream, usern.class);

	            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
	            xstream.toXML(Singleton.userregister, OSW);
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
		 public static void savetxt_normal_ondemmand() {
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
						OOS.writeObject(Singleton.userregister);
						OOS.close();
		                JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
		            }
		        } catch (Exception e) {
		        	JOptionPane.showMessageDialog(null, "Error al guardar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
}
