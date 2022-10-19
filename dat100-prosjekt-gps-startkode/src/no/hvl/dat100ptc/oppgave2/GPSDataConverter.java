package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	private static int TIME_STARTINDEX = 11; // posisjon for start av tidspunkt i timestr

	public static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
		
		// TODO
		// OPPGAVE - START
		String timerMinuttSekund = timestr.substring(TIME_STARTINDEX, 21);
		String bareTimer = timerMinuttSekund.substring(0,2);
		String bareMinutt = timerMinuttSekund.substring(3,5);
		String bareSekund = timerMinuttSekund.substring(6,8);
		
		hr = Integer.parseInt(bareTimer);
		min = Integer.parseInt(bareMinutt);
		sec = Integer.parseInt(bareSekund);
		
		hr = hr*3600;
		min = min*60;
		
		secs = hr+min+sec;
		
		return secs;
		//throw new UnsupportedOperationException(TODO.method());

		// OPPGAVE - SLUTT
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint;

		// TODO - START ;
		int time = toSeconds(timeStr);
		double latitude = Double.parseDouble(latitudeStr);
		double longitude = Double.parseDouble(longitudeStr);
		double elevation = Double.parseDouble(elevationStr);
		
		gpspoint = new GPSPoint(time, latitude, longitude, elevation);
		
		return gpspoint;
		
		//throw new UnsupportedOperationException(TODO.method());

		// OPPGAVE - SLUTT ;
	    
	}
	
}
