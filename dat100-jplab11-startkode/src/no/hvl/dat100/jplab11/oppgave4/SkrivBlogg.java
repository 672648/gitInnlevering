package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		String fil = filnavn;
		PrintWriter writer;
		try {
			writer = new PrintWriter(fil);
		} catch (FileNotFoundException e) {
			System.out.print("filen finnes ikke");
			return false;
		}
		String bloggStreng = samling.toString();
		writer.println(bloggStreng);
		writer.close();
		return true;
		//throw new UnsupportedOperationException(TODO.method());
	}
}
