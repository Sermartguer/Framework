package lib_fitxers;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Users.Modules.User.Classes.Singleton;
import Users.Modules.User.Classes.userad;


public class txt {
    public static void generatxt() {
        String PATH = null;
        try {
            File f;
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH=PATH+ ".txt";
                f = new File(PATH);
                
                FileOutputStream fo=new FileOutputStream(f);
				ObjectOutputStream o=new ObjectOutputStream(fo);
				o.writeObject(Singleton.useradmin);
				o.close();
                JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static ArrayList<userad> obri_txt() {
    	String PATH = null;
        try {
            File f;
            JFileChooser fileChooser = new JFileChooser();
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
        	JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    	return Singleton.useradmin;
    }
}
