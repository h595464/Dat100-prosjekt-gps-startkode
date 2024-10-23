package no.hvl.dat100ptc.oppgave3;

import no.hvl.dat100ptc.TODO;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.TODO;

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

		double min = da[0];

		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;
		
		// TODO 
		// throw new UnsupportedOperationException(TODO.method());
		
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		
		double[] latitudes = new double[gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i++) {
			latitudes[i] =gpspoints[i].getLatitude();
		}
		
		return latitudes;

		// throw new UnsupportedOperationException(TODO.method());
		
		// TODO
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		
		double[] longitudes = new double[gpspoints.length];
		
		for (int i = 0; i < gpspoints.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		
		return longitudes;

		
		// throw new UnsupportedOperationException(TODO.method());
		
		// TODO 

	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double latitude1 = Math.toRadians(gpspoint1.getLatitude());
		double longitude1 = Math.toRadians(gpspoint1.getLongitude());
		double latitude2 = Math.toRadians(gpspoint2.getLatitude());
		double longitude2 = Math.toRadians(gpspoint2.getLongitude());
		
		double deltaphi = latitude2 - latitude1;
		double Dlambda = longitude2 - longitude1;
		
		double a = compute_a(latitude1, latitude2, deltaphi, Dlambda);
		
		double c = compute_c(a);
		
		double d = R * c;
		
		return d;

		// throw new UnsupportedOperationException(TODO.method());

		// TODO 
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
		
		return Math.pow(Math.sin(deltaphi / 2), 2) + 
				Math.cos(phi1) * Math.cos(phi2) * 
				Math.pow(Math.sin(deltadelta / 2), 2);
	
		// throw new UnsupportedOperationException(TODO.method());
		
		// TODO 

	}

	private static double compute_c(double a) {
		return 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

		
		// throw new UnsupportedOperationException(TODO.method());
		
		
		// TODO 

	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double Meter = distance(gpspoint1, gpspoint2);
		
		int time1 = gpspoint1.getTime();
		int time2 = gpspoint2.getTime();
		
		int secs = time2 - time1;
		
		if (secs <= 0) {
			return 0.0;
		}
		
		double speed = Meter / secs;
		return speed;
		
		// throw new UnsupportedOperationException(TODO.method());
		
		// TODO

	}

	public static String formatTime(int secs) {
		
		int timer = secs/3600;
		int minutter = (secs % 3600) / 60;
		int sekunder = secs % 60;

		String TIMESEP = ":";
		
		String timestr = String.format(timer+TIMESEP+minutter+TIMESEP+sekunder);
		
		return String.format("%10s", timestr);

		// throw new UnsupportedOperationException(TODO.method());
		
		// TODO 
		
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str = String.format("%.2f", d);
		
		return String.format("%10s", str);

		
		// throw new UnsupportedOperationException(TODO.method());
		
		// TODO
		
	}
}
