package Users.Main;
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
import javax.swing.JOptionPane;

import Users.Classes.fecha;
public class Main_Test {
	private static final char[] LETRAS_NIF = { 'T', 'R', 'W', 'A', 'G', 'M',
            'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
            'L', 'C', 'K', 'E' };
    
    public static String generaNif (String seed) {
        if (seed != null) {
            try {
                Integer.parseInt(seed);
            } catch (NumberFormatException ex) {
                return "KO";
            }
        } else {
            seed = "";
        }
        String numeroDNI = String.valueOf(Math.random()).concat(seed);
        String fullDNI = numeroDNI.substring(numeroDNI.length() - 8);

        int dniInt = Integer.valueOf(fullDNI);
        fullDNI = fullDNI + LETRAS_NIF[dniInt % 23];
        return fullDNI;
    }
    public static String calculaLetra(String nif) {
        if (nif.length() != 8) {
            return ("Nif Inválido");
        }
        return generaNif(nif).substring(8);
    }

    public static String validaNif(String nif) {
        if (nif.substring(0, 8).length() == 8) {
            return nif.equalsIgnoreCase(generaNif(nif.substring(0, 8))) ? "OK"
                    : "KO";
        } else {
            return ("Nif Inválido");
        }
    }			   
	public static void main(String[] args) {
	
		Random rnd = new Random(); 

		
		rnd.setSeed(System.currentTimeMillis()); 

		
		int al6 = 10000000 + rnd.nextInt(90000000); 

		System.out.println("Aleatorio de 6 cifras : " + al6); 
		} 
	
}

