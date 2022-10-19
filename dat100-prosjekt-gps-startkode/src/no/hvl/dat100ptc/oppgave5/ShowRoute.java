package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		double ystep;
		
		// TODO - START
		double maxLat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minLat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		
		ystep = MAPYSIZE / (Math.abs(maxLat-minLat));
		return ystep;
		//throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT
		
	}

	public void showRouteMap(int ybase) {

		// TODO - START
		int xPos = 30;
		int yPos = 600;
		double[] latitudeTabell = GPSUtils.getLatitudes(gpspoints);
		double[] longitudeTabell = GPSUtils.getLongitudes(gpspoints);
		int[] latNr = new int[latitudeTabell.length];
		int[] longNr = new int[longitudeTabell.length];
		double xEr = xstep();
		double yEr = ystep();
		for(int i= 0; i<latitudeTabell.length; i++) {
			double latitudeNr = yEr*(latitudeTabell[i]);
			int latitude = (int)Math.round(latitudeNr);
			double longitudeNr = xEr*(longitudeTabell[i]);
			int longitude = (int)Math.round(longitudeNr);
			
			latNr[i] = latitude;
			longNr[i] = longitude;
			

		}
		for(int q = 0; q < latNr.length-1; q++) {
			int plussMinus = latNr[q]-latNr[q+1];
			int longPlussMinus = (longNr[q]-longNr[q+1]);
			longPlussMinus *= -1;
			xPos = xPos + longPlussMinus;
			yPos = yPos + plussMinus;

			setColor(0,255,0);
			fillCircle(xPos/2, yPos/3, 3);
		}
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
		// TODO - START
		GPSComputer sec = new GPSComputer(gpspoints);
		String[][] stats = {
				{"total time", Integer.toString(sec.totalTime()/60) + " min" },
				{"total distance", Double.toString(sec.totalDistance()/1000) },
				{"total elevation", Double.toString(sec.totalElevation()) },
				{"max speed", Double.toString(sec.maxSpeed()) },
				{"average speed", Double.toString(sec.averageSpeed()) },
				{"energy", Double.toString(sec.totalKcal(50)) }
				};
		for(int i = 0; i < stats.length; i++) {
			String stringName = stats[i][0];
			String value = stats[i][1];
			String stringResult = stringName + ": " + value;
			drawString(stringResult, 20,30*i+10);
		}
		//throw new UnsupportedOperationException(TODO.method());
		
		// TODO - SLUTT;
	}

}
