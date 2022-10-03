package no.hvl.dat100;

public class Obligatorisk01B {
	public static void main(String[] args) {
		
		int[][] matrise = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
				};
		
		int[][] ulikMatrise = {
				{1,3,3},
				{2,5,6},
				{7,8,9}
				};
		int[][] likMatrise = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
				};
	
		
		skrivUtv1(matrise);
		System.out.println();
		
		String streng = tilStreng(matrise);
		System.out.println(streng);
		
		int[][] skaler = skaler(2, matrise);
		skrivUtv1(skaler);
		
		boolean ulik = erLik(matrise, ulikMatrise);
		boolean heltLik = erLik(matrise, likMatrise);
		System.out.print(ulik + " " + heltLik);
	}
	
	public static void skrivUtv1(int[][] matrise) {
		for(int[]x:matrise) {
			for(int y:x) {
				System.out.print(y + " ");
			}
		}
	}
	public static String tilStreng(int[][] matrise) {
		String streng = "";
		for(int i = 0; i<matrise.length; i++) {
			for(int q = 0; q<matrise[i].length; q++) {
				streng = streng + matrise[i][q];
			}
			streng = streng + "\n";
		}
		return streng;
	}
	
	public static int[][] skaler(int tall, int[][] matrise){
		int[][] skalert = new int[3][3];
		for(int i = 0; i<matrise.length; i++) {
			for(int q = 0; q<matrise[i].length; q++) {
				skalert[i][q] = matrise[i][q]*2;
			}
		}
		return skalert;
	}
	public static boolean erLik(int[][] mat1, int[][] mat2) {
		boolean lik = true;
		for(int i = 0; i<mat1.length; i++) {
			for(int q = 0; q<mat1.length; q++) {
				if(mat1[i][q] != mat2[i][q]) {
					lik = false;
					return lik;
				}
			}
		}
		return lik;
	}
}
