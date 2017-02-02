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
		double moneda=3.43242383;
		moneda = moneda*1f;
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		DecimalFormat formateador = new DecimalFormat("####.####",simbolos);

		// Esto sale en pantalla con punto decimal, es decir, 3.4324,
		System.out.println (formateador.format (moneda));


	        
	    }
		
	
}

