package Users.Utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import Users.Classes.setting;
import Users.Modules.User.Model.Classes.userad;

public class JSON_Setting {
	public static void savejson_config() {
        String PATH = null;
	     
        try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/Users/Files_Config/config.json";
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	    try {
		    XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
		    xstreamjson.setMode(XStream.NO_REFERENCES);
		    xstreamjson.alias("setting", setting.class);
		    Gson gson = new Gson();
		    String json = gson.toJson(setting.getInstance());
		    FileWriter fileXml = new FileWriter(PATH);
		    fileXml.write(json.toString());
		    fileXml.close();
		    
		    
	    } catch (Exception e) {
	     	JOptionPane.showMessageDialog(null, "Error al guardar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	public static void openjson_config() {
    	String PATH = null;
    	setting config = null;
    	
        try {
        	XStream xstream = new XStream(new JettisonMappedXmlDriver());
	        xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Admin", userad.class);
			
			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/Users/Files_Config/config.json";
	        
	        JsonReader reader = new JsonReader(new FileReader(PATH));
	        JsonParser parser = new JsonParser();
	        JsonElement root = parser.parse(reader);
	        
	        Gson json = new Gson();
	        config = json.fromJson(root, setting.class);
	        setting.getInstance().setcoin(config.getcoin());
	        setting.getInstance().setffecha(config.getffecha());
	        setting.getInstance().setdecimal(config.getdecimal());
	        setting.getInstance().setfile(config.getfile());
	        setting.getInstance().setlang(config.getlang());
	        //setting.getInstance().setTheme(config.getTheme());
	        
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error al obrir el JSON", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
