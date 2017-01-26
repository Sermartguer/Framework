package lib_fitxers;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;

import Users.Modules.User.Classes.Singleton;
import Users.Modules.User.Classes.userad;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class xml {
    private static final String ENCODING = "UTF-8";
    public static void generaxml() {
        String PATH=null;
		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, userad.class);

            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
            xstream.toXML(Singleton.useradmin, osw);
            StringBuffer xml = new StringBuffer();
            xml.append(header);
            xml.append(os.toString());
	    
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
            	File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH = PATH+".xml";
                
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xml.toString());
                fileXml.close();
                osw.close();
                os.close();
                JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
            }
	    }catch (Exception e1){
	    	JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
	    } 
    }
    
    public static ArrayList<userad> obri_xml() {
    	String PATH=null;
    	try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, userad.class);
 
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
            	File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                Singleton.useradmin = (ArrayList <userad>)xstream.fromXML(new FileReader(PATH));
            }
            
        } catch (Exception e1) {
        	JOptionPane.showMessageDialog(null, "Error al leer el XML", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return Singleton.useradmin;
    }
}
