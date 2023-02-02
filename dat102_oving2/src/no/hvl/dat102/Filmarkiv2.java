package no.hvl.dat102;

import java.lang.Throwable;
import no.hvl.data102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv2() {
		antall = 0;
		start = null;
	}
	
	@Override
	public Film finnFilm(int nr) {
		// TODO Auto-generated method stub
		boolean funnet = false;
		LinearNode<Film> finne = start;
		while(finne != null && !funnet) {
			if(finne.getElement().getFilmnr() == nr) {
				funnet = true;
				return finne.getElement();
			}
			else {
				finne = finne.getNeste();
			}
		}
		
		return null;
	}
	@Override
	public void leggTilFilm(Film nyFilm) {
		// TODO Auto-generated method stub
		LinearNode<Film> leggTil = new LinearNode<Film>(nyFilm);
		leggTil.setNeste(start);
		start = leggTil;
		antall++;
	}
	@Override
	public boolean slettFilm(int filmnr) {
		// TODO Auto-generated method stub
		boolean slettet = false;
		if(antall == 0) {
			System.out.println("Ingen filmer i arkivet");
		}
		else {
		LinearNode<Film> forrige, aktuell;
		forrige = start;
		if(start.getElement().getFilmnr() == filmnr) {
			start = start.getNeste();
			antall--;
			slettet = true;
		}
		else {
		aktuell = start.getNeste();
		for(int i = 0; i <= antall; i++) {
			if(aktuell.getElement().getFilmnr() == filmnr) {
				forrige.setNeste(aktuell.getNeste());
				start = forrige;
				antall--;
				slettet = true;
			}
			else {
				forrige = aktuell;
				aktuell = start.getNeste();
			}
		}
		}
		}
		return slettet;
	}
	@Override
	public Film[] soekTittel(String delstreng) {
		// TODO Auto-generated method stub
		LinearNode<Film> temp = start;
		Film tittelSoek[] = new Film[antall];
		int lengdeTeller = 0;
		for(int i = 0; i < antall; i++) {
			if(temp.getElement().getTittel().contains(delstreng)) {
				tittelSoek[lengdeTeller] = temp.getElement();
				lengdeTeller++;
				temp = temp.getNeste();
				
			}
			else {
				temp = temp.getNeste();
			}
		}
		tittelSoek = trimTab(tittelSoek, lengdeTeller);
		return tittelSoek;
	}
	@Override
	public Film[] soekProdusent(String delstreng) {
		// TODO Auto-generated method stub
		Film produSoek[] = new Film[antall];
		LinearNode<Film> temp = start;
		int lengdeTeller = 0;
		for(int i = 0; i < antall; i++) {
			if(temp.getElement().getFilmskaper().contains(delstreng)) {
				produSoek[lengdeTeller] = temp.getElement();
				lengdeTeller++;
				temp = temp.getNeste();
				
			}
			else {
				temp = temp.getNeste();
			}
		}
		produSoek = trimTab(produSoek, lengdeTeller);
		return produSoek;
	}
	@Override
	public int antall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		int lengdeTeller = 0;
		for(int i = 0; i <= antall; i++) {
			if(start.getElement().getSjanger().equals(sjanger)) {
				lengdeTeller++;
				if(start.getNeste() == null) {
					return lengdeTeller;
				}
				else {
				start = start.getNeste();
				}
			}
			else {
				if(start.getNeste() == null) {
					return lengdeTeller;
				}
				start = start.getNeste();
			}
		}
		
		return lengdeTeller;
	}
	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return antall;
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
