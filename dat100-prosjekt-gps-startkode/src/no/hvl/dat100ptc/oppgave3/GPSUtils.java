package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import java.util.Locale;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		// TODO - START
		min = da[0];
		
		for (double i : da) {
			if(i < min) {
				min = i;
			}
		}
		
		return min;

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUT

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double[] latitudeTabell = new double[gpspoints.length];
		//throw new UnsupportedOperationException(TODO.method());
		for(int i = 0; i < gpspoints.length; i++) {
			latitudeTabell[i] = gpspoints[i].getLatitude();
		}
		return latitudeTabell;
		// TODO - SLUTT
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START
		double[] longitudeTabell = new double[gpspoints.length];
		
		for(int i = 0; i < gpspoints.length; i++) {
			longitudeTabell[i] = gpspoints[i].getLongitude();
		}
		return longitudeTabell;

		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START
		latitude1 = gpspoint1.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		latitude2 = gpspoint2.getLatitude();
		longitude2 = gpspoint2.getLongitude();
		
		latitude1 = Math.toRadians(latitude1);
		longitude1 = Math.toRadians(longitude1);
		latitude2 = Math.toRadians(latitude2);
		longitude2 = Math.toRadians(longitude2);
		
		double deltaLamba = longitude2 - longitude1;
		double deltaSigma = latitude2 - latitude1;
		
		double a = (sin(deltaSigma/2))*sin(deltaSigma/2)+cos(latitude1)*cos(latitude2)*(sin(deltaLamba/2))
				*(sin(deltaLamba/2));
		
		double c = 2*Math.atan2(sqrt(a), sqrt(1-a));
		d = 6371000 * c;
		
		return d;

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		// TODO - START
		int tiden1 = gpspoint1.getTime();
		int tiden2 = gpspoint2.getTime();
		
		secs = tiden2-tiden1;
		
		double avstand = distance(gpspoint1, gpspoint2); 
		
		speed = avstand / secs;
		speed = speed * 3.6;
		return speed;

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START
		int timer = secs/3600;
		int minutter = (secs % 3600)/60;
		int sekunder = secs % 60;
		
		timestr = String.format("  %02d"+TIMESEP+"%02d"+TIMESEP+"%02d", timer, minutter, sekunder);
		return timestr;

		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START
		str = String.format((Locale.US),"      " + "%.2f", d);
		
		return str;

		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}
}
