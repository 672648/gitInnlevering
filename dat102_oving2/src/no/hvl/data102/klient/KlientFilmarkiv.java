package no.hvl.data102.klient;

import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.Filmarkiv2;
import no.hvl.dat102.Meny;
import no.hvl.data102.adt.FilmarkivADT;

public class KlientFilmarkiv {
	public static void main(String[] args) { 
		  FilmarkivADT filma = new Filmarkiv(100);  
		  FilmarkivADT filmaa = new Filmarkiv2();
		  Meny meny = new Meny(filma);
		  Meny meny2 = new Meny(filmaa);
		  //meny.start(); 
		  meny2.start();
		 } 
		 
		} 
