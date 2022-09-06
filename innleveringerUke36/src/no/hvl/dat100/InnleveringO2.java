package no.hvl.dat100;

import static javax.swing.JOptionPane.*;

public class InnleveringO2 {
public static void main(String[] args) {
		
		for (int student = 1; student <=10; student++) {
			
		
			int poeng = Integer.parseInt(showInputDialog("Skriv inn poeng ") );
		
			if (poeng >= 90 && poeng <= 100){
				System.out.println("Karakter A");
			}
			else if (poeng >=80 && poeng <= 89) {
				System.out.println ("Karakter B");
			}
			else if (poeng >=60 && poeng <=79) {
				System.out.println ("Karakter C");
			}
			else if (poeng >=50 && poeng <= 59) {
				System.out.println ("Karakter D");
			}
			else if (poeng >=40 && poeng <= 49) {
				System.out.println ("Karakter E");
			}
			else if (poeng >=0 && poeng <= 39) {
				System.out.println ("Karakter F");
			}
			else {
				System.out.println("ikke gyldig nummer. Skriv inn på nytt");
				student -= 1;
				
			}
		
		}

	}


}
