package no.hvl.dat102;

import no.hvl.data102.adt.FilmarkivADT;

public class Meny {
	private Tekstgrensesnittt tekstgr;  
	private FilmarkivADT filmarkiv;  
	  
	 public Meny(FilmarkivADT filmarkiv){ 
	  tekstgr = new Tekstgrensesnittt();  
	  this.filmarkiv = filmarkiv; 
	 } 
	  
	 public void start(){ 
	             // legg inn en del forhåndsdefinerte filmer for å teste metodene 
	  // TODO 
		 Film jason = new Film(1, "Paul Greengrass", "Jason Bourne", 2002, Sjanger.ACTION, "Universal Pictures");
		 Film harry = new Film(2, "Chris Columbus", "Harry Potter", 2001, Sjanger.FANTASY, "Warner Bros. Pictures");
		 Film shrek = new Film(3, "Andrew Adamson", "Shrek", 2001, Sjanger.ANIMATION, "Dreamworks Pictures");

		 filmarkiv.leggTilFilm(jason);
		 filmarkiv.leggTilFilm(harry);
		 filmarkiv.leggTilFilm(shrek);
		 //alle skal bli skrevet ut
		 tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, "o");
		 System.out.println();
		 //film 1 og 3 skal bli skrevet ut
		 tekstgr.skrivUtFilmProdusent(filmarkiv, "C");
		 
		 //skriv filmnummer 5 for å slette
		 //filmarkiv.leggTilFilm(tekstgr.lesFilm());
		 //System.out.println(filmarkiv.antall() + "\n");
		 filmarkiv.slettFilm(3);
		 tekstgr.skrivUtStatistikk(filmarkiv);
		 //System.out.println(filmarkiv.antall());
		 //System.out.println();
		 
		 
		 
		
		 
		 
	 }
}
