package no.hvl.dat100;

public class ObligatoriskO1 {
	public static void main(String[] args) {
		
		int[] heltall = {1,3,5,2};
		skrivUt(heltall);
		
		int[] nummer = {42, 67, 89};
		String tekst = tilStreng(nummer);
		System.out.println(tekst + " ");
		
		int[] testSum = {summer(heltall), summerWhile(heltall), summerUFor(heltall)};
		skrivUt(testSum);
	
		int finnesDette = 3;
		int finnesIkkeTest = 10;
		boolean finnes = finnesTall(heltall, finnesDette);
		boolean finnesIkke = finnesTall(heltall, finnesIkkeTest);
		System.out.println(finnes + " " + finnesIkke);
		
		int forsteIndex = 1;
		int ikkeForsteIndex = 3;
		int finnesForste = posisjonTall(heltall, forsteIndex);
		int finnesIkkeForste = posisjonTall(heltall, ikkeForsteIndex);
		System.out.println(finnesForste + " " + finnesIkkeForste);
		
		int [] reversertTabell = reverser(heltall);
		skrivUt(reversertTabell);
		
		int[] stigendeTabell = {1,2,3,4,5};
		boolean ikkeStigende = erSortert(heltall);
		boolean stigende = erSortert(stigendeTabell);
		System.out.println(ikkeStigende + " " + stigende);
		
		skrivUt(settSammen(heltall, nummer));

	}
	public static void skrivUt (int[] tabell) {
		for (int i = 0; i<tabell.length; i++) {
			System.out.print(tabell[i] + " ");
		}
		System.out.println();
	}
	public static String tilStreng(int[] tabell) {
		String nummerTilTekst = "";
		for(int i = 0; i<tabell.length; i++) {
			nummerTilTekst = nummerTilTekst + "," + Integer.toString(tabell[i]);
		}
		nummerTilTekst = "[" + nummerTilTekst + "]";
		StringBuilder tekst = new StringBuilder(nummerTilTekst);
		tekst.deleteCharAt(1);
		return tekst.toString();
		
	}
	public static int summer(int[] tabell) {
		int sumFor = 0;
		for(int i = 0; i<tabell.length; i++) {
			sumFor += tabell[i];
		}
		return sumFor;
	}
	public static int summerWhile(int[] tabell) {
		int k = 0;
		int sumWhile = 0;
		while(k<tabell.length) {
			sumWhile += tabell[k];
			k++;
		}
		return sumWhile;
	}
	public static int summerUFor(int [] tabell) {
		int sumUFor = 0;
		for(int j : tabell) {
			sumUFor += j;
		}
		return sumUFor;
	}
	
	public static boolean finnesTall(int[] tabell, int tall) {
		boolean finnes = false;
		for(int i = 0; i<tabell.length; i++) {
			if(tabell[i] == tall) {
				finnes = true;
			}
		}
		return finnes;
	}
	public static int posisjonTall(int[] tabell, int tall) {
		int indexNull = tabell[0];
		if(tabell[0] == tall) {
			return indexNull;
		}
		else {
			return -1;
		}
	}
	public static int[] reverser(int[] tabell) {
		int[] reverserTabell = new int[tabell.length];
		int j = tabell.length;
		for(int i = 0; i<tabell.length; i++) {
			reverserTabell[j-1] = tabell[i];
			j--;
		}
		return reverserTabell;
	}
	
	public static boolean erSortert(int[] tabell) {
		boolean sortert = true;
		for(int i = 0; i<tabell.length-1; i++) {
			if(tabell[i] > tabell[i+1]) {
				sortert = false;
			}
		}
		return sortert;
	}
	public static int[] settSammen(int[] tabell1, int[] tabell2) {
		int pos = 0;
		int[] sammenSatt = new int[tabell1.length + tabell2.length];
		for(int i = 0; i < tabell1.length; i++) {
			sammenSatt[pos] = tabell1[i];
			pos++;
		}
		for(int j = 0; j < tabell2.length; j++) {
			sammenSatt[pos] = tabell2[j];
			pos++;
		}
		return sammenSatt;
	}
}
