package no.hvl.dat102;

import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	
	public Film filmtab[];
	public int pos;
	
	public Filmarkiv(int nr) {
		filmtab = new Film[nr];
		pos = 0;
	}
	
	private void utvid() {
		Film[] nytab = new Film[(filmtab.length + 1) * 2];
		
		for(int i = 0; i<filmtab.length; i++) {
			nytab[i] = filmtab[i];
		}
		filmtab = nytab; 
	}

	@Override
	public Film finnFilm(int nr) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i<filmtab.length; i++ ) {
			if(filmtab[i].getFilmnr() == nr);{
				filmtab = trimTab(filmtab, pos);
				return filmtab[i];
			}
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		// TODO Auto-generated method stub
		
			if(pos>=filmtab.length) {
			utvid();
		}
		
		filmtab[pos] = nyFilm;
		pos++;
		
		if(filmtab.length>pos) {
			filmtab = trimTab(filmtab, pos);
		}

	}

	@Override
	public boolean slettFilm(int filmnr) {
		// TODO Auto-generated method stub
		boolean finnes = false;
		
		for(int i = 0; (i<filmtab.length) && (!finnes); i++) {
			if(filmtab[i].getFilmnr() == filmnr) {
				
				filmtab[i] = filmtab[pos - 1];
				filmtab[pos - 1] = null;
				pos--;
				return true;
				
			};
		}
		
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		// TODO Auto-generated method stub
		Film delfilm[] = new Film[pos];
		int delpos = 0;
		
		for(int i = 0; i<filmtab.length; i++) {
			if(filmtab[i].getTittel().contains(delstreng)) {
				delfilm[delpos] = filmtab[i];
				delpos++; 
			}
		}
		delfilm = trimTab(delfilm, delpos);
		
		return delfilm;
	}
	
	@Override
	public Film[] soekProdusent(String delstreng) {
		Film delfilm[] = new Film[pos];
		int delpos = 0;
		
		for(int i = 0; i<filmtab.length; i++) {
			if(filmtab[i].getFilmskaper().contains(delstreng)) {
				delfilm[delpos] = filmtab[i];
				delpos++;
				
				
			}
		}
		delfilm = trimTab(delfilm, delpos);
		return delfilm;
	}
	

	@Override
	public int antall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		int antall = 0;
		
		for(int i = 0; i<filmtab.length; i++) {
			if(filmtab[i].getSjanger().equals(sjanger)) {
				antall++;
			}
		}
		
		return antall;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return pos;
	}
	
	private Film[] trimTab(Film[] tab, int n) {
		Film[] nytab = new Film[n];
		int i = 0;
		while(i<n) {
			nytab[i] = tab[i];
			i++;
		}
		return nytab;
	}
	

}
