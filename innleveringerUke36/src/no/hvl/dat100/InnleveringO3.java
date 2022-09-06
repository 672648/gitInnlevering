package no.hvl.dat100;

import static javax.swing.JOptionPane.*;

public class InnleveringO3 {
	
	public static void main(String[] args) {
		int n = Integer.parseInt(showInputDialog("Skriv inn et heltall: ") );
		
		if (n>0) {
			int multiplisere = 1;
			for (int ganger = 1; ganger <= n; ganger++) {
				multiplisere *= ganger;
			}
			System.out.println(multiplisere);
		}
		
		
		else {
			System.out.println("ugyldig tall");
		}
		
	}
}

