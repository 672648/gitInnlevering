package no.hvl.dat102;

import no.hvl.data102.adt.FilmarkivADT;
import java.util.Scanner;

public class Tekstgrensesnittt {
	public Film lesFilm() {
		// TODO
		Film ff = new Film();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Skriv inn filmnummer");
		ff.setFilmnr(Integer.parseInt(input.nextLine()));
		
		System.out.print("Skriv inn produsent");
		ff.setFilmskaper(input.nextLine());
		
		System.out.print("Skriv inn filmnavn");
		ff.setTittel(input.nextLine());
		
		System.out.print("Skriv inn årstall");
		ff.setAr(Integer.parseInt(input.nextLine()));
		
		System.out.print("Skriv inn sjanger");
		String sjnger = input.nextLine();
		ff.setSjanger(Sjanger.valueOf(sjnger.toUpperCase()));
		
		System.out.print("Skriv inn filmselskap");
		ff.setFilmselskap(input.nextLine());
		
	
		return ff;
	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {
		// TODO
		System.out.println(film.getFilmnr() + film.getFilmskaper() + film.getTittel() + film.getAr()
				+ film.getSjanger().toString() + film.getFilmselskap());
	}

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film filmer[] = filma.soekTittel(delstreng);

		for (int i = 0; i < filmer.length; i++) {
			visFilm(filmer[i]);
		}
		// TODO
	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		// TODO Denne gjør tilsvarende som metoden over
		Film filmer[] = filma.soekProdusent(delstreng);

		for (int i = 0; i < filmer.length; i++) {
			visFilm(filmer[i]);
		}

	}

	// Skrive ut en enkel statistikk som inneholder antall Filmer totalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FilmarkivADT filma) {
		// TODO
		System.out.println("Det er totalt " + filma.antall() + " filmer");
		
		for(Sjanger sjanger : Sjanger.values()){
			System.out.println("Det er: " + filma.antall(sjanger) + " filmer i sjangerern " + sjanger);
		}
	}
}
