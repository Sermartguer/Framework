package Users.Modules.User.Model.BLL.BLL_users.Files_Users.Admin.Utils_Files;

import java.awt.HeadlessException;
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

import Users.Classes.lenguage;
import Users.Modules.User.Model.Classes.Singleton;
import Users.Modules.User.Model.Classes.userad;

public class Save_Admin {
	private static final String ENCODING = "UTF-8";
	
	//AUTO
	public static void savejson_admin() {
		String PATH = null;
	     
        try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/Users/Modules/User/Model/Files/Admin/Files/json/admin.json";
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (Singleton.useradmin.size() > 0) {
	        try {
	        	XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
		          xstreamjson.setMode(XStream.NO_REFERENCES);
		          xstreamjson.alias("Admin", userad.class);
		          System.out.println("1");
		          	Gson gson = new Gson();
			          System.out.println("2");
		            //String json = gson.toJson(Singleton.useradmin);
			          System.out.println("3");
		            FileWriter fileXml = new FileWriter(PATH);
			          System.out.println("4");
	                fileXml.write(Singleton.useradmin.toString());
			          System.out.println("5");
	                fileXml.close(); 
		          
	        } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null,  lenguage.getInstance().getProperty("err_json_save"), "Error", JOptionPane.ERROR_MESSAGE);
	        }
        } else {
            File path = new File(PATH);

            path.delete();
        }
	}
	public static void savexml_admin() {
        String PATH=null;
		
        try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/Users/Modules/User/Model/Files/Admin/Files/xml/admin.xml";
        } catch (IOException e) {
            e.printStackTrace();
        }
		System.out.println("Tamayo de el array "+Singleton.useradmin.size());
		System.out.println("1");
        if (Singleton.useradmin.size() > 0) {
	        try {
	    		System.out.println("2");
				OutputStream OS = new ByteArrayOutputStream();
				OutputStreamWriter OSW = new OutputStreamWriter(OS);
				XStream xstream = new XStream();
				Annotations.configureAliases(xstream, userad.class);
				System.out.println("3");
	            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
	            xstream.toXML(Singleton.useradmin, OSW);
	            StringBuffer xml = new StringBuffer();
	            xml.append(header);
	            xml.append(OS.toString());
	            System.out.println("4");
	            FileWriter fileXml = new FileWriter(PATH);
	            System.out.println("5");
	            fileXml.write(xml.toString());
	            fileXml.close();
	            OSW.close();
	            OS.close();
	            
		    }catch (Exception e){
		    	JOptionPane.showMessageDialog(null,  lenguage.getInstance().getProperty("err_xml_save"), "Error", JOptionPane.ERROR_MESSAGE);
		    }
        } else {
            File path = new File(PATH);

            path.delete();
        }
    }
	public static void savetxt_admin() {
        String PATH = null;
        
        try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/Users/Modules/User/Model/Files/Admin/Files/txt/admin.txt";
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (Singleton.useradmin.size() > 0) {
	        try {
	            File file;
	            
	            file = new File(PATH);
	            
	            FileOutputStream FOS=new FileOutputStream(file);
				ObjectOutputStream OOS=new ObjectOutputStream(FOS);
				OOS.writeObject(Singleton.useradmin);
				OOS.close();
	            
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null,  lenguage.getInstance().getProperty("err_txt_save"), "Error", JOptionPane.ERROR_MESSAGE);
	        }
        } else {
            File path = new File(PATH);

            path.delete();
        }
    }
	//ON-DEMAND
	public static void savejson_admin_ondemmand() {
        String PATH = null;
	      try {
	          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
	          xstreamjson.setMode(XStream.NO_REFERENCES);
	          xstreamjson.alias("Admin", userad.class);
	          	          
	          JFileChooser fileChooser = new JFileChooser();
	          
	          fileChooser.setAcceptAllFileFilterUsed(false);
	            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
	            
	          int selection = fileChooser.showSaveDialog(null);
	          if (selection == JFileChooser.APPROVE_OPTION) {
	                File JFC = fileChooser.getSelectedFile();
	                PATH = JFC.getAbsolutePath();
	                PATH=PATH+ ".json";
	                
	                Gson gson = new Gson();
		            String json = gson.toJson(Singleton.useradmin);
		            FileWriter fileXml = new FileWriter(PATH);
	                fileXml.write(json.toString());
	                fileXml.close(); 
	                
	                JOptionPane.showMessageDialog(null,  lenguage.getInstance().getProperty("sucsess_json"), "JSON", JOptionPane.INFORMATION_MESSAGE);
	          }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("err_json_save"), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	public static void savexml_admin_ondemmand() {
        String PATH=null;
		try {
			OutputStream OS = new ByteArrayOutputStream();
			OutputStreamWriter OSW = new OutputStreamWriter(OS);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, userad.class);

            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
            xstream.toXML(Singleton.useradmin, OSW);
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
                JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("sucsess_xml"), "XML", JOptionPane.INFORMATION_MESSAGE);
            }
	    }catch (Exception e){
	    	JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("err_xml_save"), "XML", JOptionPane.ERROR_MESSAGE);
	    } 
    }
	 public static void savetxt_admin_ondemmand() {
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
					OOS.writeObject(Singleton.useradmin);
					OOS.close();
	                JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("sucsess_txt"), "TXT", JOptionPane.INFORMATION_MESSAGE);
	            }
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, lenguage.getInstance().getProperty("err_txt_save"), "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
		
}
