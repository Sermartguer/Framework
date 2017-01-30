package Users.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Users.Classes.fecha;
public class Main_Test {

	public static void main(String[] args) {
	
		/*JFrame frame = new JFrame("ExETesT");
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(400,350);
	    JPanel panel = new JPanel ();
	    frame.add(panel);
	    JButton button = new JButton("Click me");
	    panel.add(button);
	    button.addActionListener(new Action());*/

	

	            String[] names = {"Abraham", "Adán", "Agapito", "Cristobal", "Alex", "Cristian", "Custodio", "David", "Danilo", "Dani"};
	            String[] names2 = {"Ylos", "zzzzz", "sdsd", "OK"};
	            String[] names3 = {"Hei", "ok", "jadd", "så drar vi", "det var det"};

	            int random = (int) (Math.random()*names.length);
	           //int random2 = (int) (Math.random()*names2.length);
	           //int random3 = (int) (Math.random()*names3.length);

	            System.out.println("Your clan name is: "  + names[random]);


	        
	    }
		
	
}

