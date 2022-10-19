package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	// beregn total distances (i meter)
	public double totalDistance() {

		double distance = 0;

		// TODO - START
		//double[] latitudeTabell = GPSUtils.getLatitudes(gpspoints);
		//double[] longitudeTabell = GPSUtils.getLongitudes(gpspoints);
		
		for(int i = 0; i < gpspoints.length-1; i++) {
			distance = distance + GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
		}
		return distance;

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	// beregn totale høydemeter (i meter)
	public double totalElevation() {

		double elevation = 0;

		// TODO - START
		double[] hoydeTabell = new double[gpspoints.length];
		for(int i = 0; i < gpspoints.length; i++) {
			hoydeTabell[i] = gpspoints[i].getElevation();
		}
		for(int q = 0; q < gpspoints.length-1; q++) {
			if(hoydeTabell[q] < hoydeTabell[q+1]) {
				elevation = elevation + (hoydeTabell[q+1] - hoydeTabell[q]);
			}
		}
		return elevation;

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	// beregn total tiden for hele turen (i sekunder)
	public int totalTime() {

		int[] timeTabell = new int[gpspoints.length];
		int starttid = gpspoints[0].getTime();
		int slutttid = gpspoints[gpspoints.length-1].getTime();
		int diff = slutttid - starttid;
		
		return diff;
		//throw new UnsupportedOperationException(TODO.method());

	}
		
	// beregn gjennomsnitshastighets mellom hver av gps punktene

	public double[] speeds() {
		
		// TODO - START		// OPPGAVE - START
		double[] gjennomsnitt = new double[gpspoints.length-1];
		
		
		for(int i = 0; i < gpspoints.length-1; i++) {
			gjennomsnitt[i] = GPSUtils.speed(gpspoints[i], gpspoints[i+1]);
		}
		
		return gjennomsnitt;
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		
		// TODO - START
		double[] gjennomsnittTabell = speeds();
		
		maxspeed = GPSUtils.findMax(gjennomsnittTabell);
		//throw new UnsupportedOperationException(TODO.method());
		return maxspeed;
		// TODO - SLUTT
		
	}

	public double averageSpeed() {

		double average = 0;
		// TODO - START
		double[] gjennomsnittTabell = speeds();
		
		for(int i = 0; i<gjennomsnittTabell.length; i++) {
			average =  average + gjennomsnittTabell[i];
		}
		average = average / gjennomsnittTabell.length;
		return average;
		
		/* gjennomsnittet av EXP_SPEEDS blir det samme som denne utregningen,
		 * men i testen så er EXP_AVERAGESPEED satt til 622.5 som ikke samsvarer med hva gjennomsnittshastig-
		 * heten skal være
		 */
		
		// TODO - SLUTT
		
	}

	/*
	 * bicycling, <10 mph, leisure, to work or for pleasure 4.0 bicycling,
	 * general 8.0 bicycling, 10-11.9 mph, leisure, slow, light effort 6.0
	 * bicycling, 12-13.9 mph, leisure, moderate effort 8.0 bicycling, 14-15.9
	 * mph, racing or leisure, fast, vigorous effort 10.0 bicycling, 16-19 mph,
	 * racing/not drafting or >19 mph drafting, very fast, racing general 12.0
	 * bicycling, >20 mph, racing, not drafting 16.0
	 */

	// conversion factor m/s to miles per hour
	public static double MS = 2.236936;

	// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {

		double kcal;

		// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)
		double met = 0;		
		double speedmph = speed * MS;

		// TODO - START
		if(speedmph <10.0) {
			met = 4.0;
		}
		else if (speedmph >= 10.0 && speedmph <= 11.9) {
			met = 6.0;
		}
		else if (speedmph >= 12.0 && speedmph <= 13.9) {
			met = 8.0;
		}
		else if (speedmph >= 14.0 && speedmph <= 15.9) {
			met = 10.0;
		}
		else if (speedmph >= 16.0 && speedmph <= 19.0) {
			met = 12.0;
		}
		else if (speedmph>=20.0) {
			met = 16.0;
		}

		kcal = met * weight * secs / 3600;
		
		return kcal;
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO - START
		double fart = averageSpeed();
		int tid = totalTime();
		totalkcal = kcal(weight, tid, fart);
		return totalkcal;
		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		System.out.println("==============================================");

		// TODO - START
		int sec = totalTime();
		String timeString = GPSUtils.formatTime(sec);
		System.out.println("Total Time     :    " + timeString);
		
		double distance = totalDistance();
		distance = distance/1000;
		System.out.println("Total Distance :    " + distance + " km");
		
		double elevation = totalElevation();
		System.out.println("Total Elevation:    " + elevation + " m");
		
		double maxFart = maxSpeed();
		System.out.println("Max Speed      :    " + maxFart + " km/t");
		
		double average = averageSpeed();
		average = average/1000;
		System.out.println("Average speed  :    " + average + " km/t");
		
		double energy = totalKcal(WEIGHT);
		System.out.println("Energy         :     " + energy + " kcal");

		System.out.println("==============================================");
		// TODO - SLUTT
		
	}

}
