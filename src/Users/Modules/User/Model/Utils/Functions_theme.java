package Users.Modules.User.Model.Utils;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Users.Classes.setting;

public class Functions_theme {
public static void theme (){
		
		//Obtener lista look&feel disponibles en el SO
		//http://www.codigofantasma.com/blog/java-look-feel-parte-1/
		try {
			switch (setting.getInstance().gettheme()){
			case "METAL":// Metal
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				break;

			case "GTK":// GTK
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				break;

			case "MOTIF":// Motif
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				break;

			case "NINBUS":
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				break;	
				
			/*case "WINDOWS95":// WINDOWS 95
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
				break;*/
				
			/*case "WINDOWS":// WINDOWS
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				break;*/
				
			/*case "MAC OS":// MAC OS
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.mac.MacLookAndFeel");
				break;*/
				
			/*case "MAC OS X":// MAC OS X
				UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
				break;*/
			}
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
