package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {

		// TODO - START
		
		gpspoints = new GPSPoint[n];
		antall = 0;
		//throw new UnsupportedOperationException(TODO.construtor("GPSData"));

		// TODO - SLUTT
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {

		boolean inserted = false;
		
		// TODO - START

		if(antall < gpspoints.length){
			gpspoints[antall] = gpspoint;
			inserted = true;
			antall++;
			return inserted;
		}
		return inserted;
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;

		// TODO - START
		
		
		int timer = GPSDataConverter.toSeconds(time);
		double latitudes = Double.parseDouble(latitude);
		double longitudes = Double.parseDouble(longitude);
		double elevations = Double.parseDouble(elevation);
		
		gpspoint = new GPSPoint(timer, latitudes, longitudes, elevations); 
		
		boolean settInn = insertGPS(gpspoint);
		
		return settInn;
		
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		// TODO - START
		for(GPSPoint i : gpspoints) {
			System.out.println(i.toString());
		}

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
		System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
