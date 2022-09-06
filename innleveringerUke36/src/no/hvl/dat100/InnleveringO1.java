package no.hvl.dat100;
import static javax.swing.JOptionPane.*;

public class InnleveringO1 {
	public static void main(String[] args) {
		
		int lonn = Integer.parseInt(showInputDialog("Skriv inn lønn ") );
		double skatt = 0;
		
		if (lonn <= 164100) {
			System.out.println("Du må betale " + skatt + "kr i skatt.");
		}
		else if (lonn >= 164101 && lonn <= 230950) {
			skatt = 0.0093;
			System.out.println("Du må betale " + skatt * lonn + "kr i skatt." );
		}
		else if (lonn >= 230951 && lonn <= 580650) {
			skatt = 0.0241;
			System.out.println("Du må betale " + skatt * lonn + "kr i skatt");
		}
		else if (lonn >= 580651 && lonn <= 934050) {
			skatt = 0.1152;
			System.out.println("Du må betale " + skatt * lonn + "kr i skatt");
		}
		else {
			skatt = 0.1452;
			System.out.println("Du må betale " + skatt * lonn + "kr i skatt");
		}
}

}

