package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg {

	// TODO: objektvariable 
	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		//throw new UnsupportedOperationException(TODO.constructor("Blogg"));
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
		//throw new UnsupportedOperationException(TODO.constructor("Blogg"));
	}

	public int getAntall() {
		return nesteledig;
		//throw new UnsupportedOperationException(TODO.method());
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
		//throw new UnsupportedOperationException(TODO.method());

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		boolean fins = false; 
		int posisjon = 0;
		while(posisjon<nesteledig && !fins) {
			if(innleggtabell[posisjon].erLik(innlegg)) {
				fins = true;
			}
			else {
				posisjon++;
			}
		}
		if(fins) {
			return posisjon;
		}
		else {
			return -1;
		}

		//throw new UnsupportedOperationException(TODO.method());
	}

	public boolean finnes(Innlegg innlegg) {
		int pos = finnInnlegg(innlegg);
		if(pos >=0) {
			return true;
		}
		
		return false;
		//throw new UnsupportedOperationException(TODO.method());
	}

	public boolean ledigPlass() {
		Innlegg[] nyTabell = getSamling();
		if(nesteledig<nyTabell.length) {
			return true;
		}
		else {
		return false;
		}
		//throw new UnsupportedOperationException(TODO.method());

	}
	
	public boolean leggTil(Innlegg innlegg) {
		boolean fins = finnInnlegg(innlegg) == -1;
		if(fins && nesteledig < innleggtabell.length) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		else {
			return false;
		}

		//throw new UnsupportedOperationException(TODO.method());
	}
	
	public String toString() {
		String streng = "";
		for(int i = 0; i < innleggtabell.length; i++) {
		streng += innleggtabell[i] + "";
		}
		streng = nesteledig + "\n" + streng;
		
		return streng;
		//throw new UnsupportedOperationException(TODO.method());
	}

	// valgfrie oppgaver nedenfor
	

	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}