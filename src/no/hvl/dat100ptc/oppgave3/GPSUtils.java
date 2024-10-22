package no.hvl.dat100ptc.oppgave3;

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

		double min;
		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		return min;
		
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latitude = new double[gpspoints.length];
		for (int i = 0; i<gpspoints.length; i++) {
			latitude[i] = gpspoints[i].getLatitude();
		}
		return latitude;
		
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] longitude = new double[gpspoints.length];
		for (int i = 0; i<gpspoints.length; i++) {
			longitude[i] = gpspoints[i].getLongitude();
		}
		return longitude;

	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double latitude1 = gpspoint1.getLatitude();
		double longitude1 = gpspoint1.getLongitude();
		double latitude2 = gpspoint2.getLatitude();
		double longitude2 = gpspoint2.getLongitude();
		
		double deltaphi = latitude2-latitude1;
		double deltadelta = longitude2-longitude1;
		
		double a = compute_a(latitude1,latitude2,deltaphi,deltadelta);
		double c = compute_c(a);
		double  d = R*c;
		return d;
		
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
		
		phi1 = toRadians(phi1);
		phi2 =toRadians(phi2);
		deltaphi = toRadians(deltaphi);
		deltadelta = toRadians(deltadelta);

		double a = (sin(deltaphi/2))*(sin(deltaphi/2)) + cos(phi1) * cos(phi2) * ((sin(deltadelta/2))) * ((sin(deltadelta/2)));
		return a;
	}

	private static double compute_c(double a) {
		
		double c = 2*atan2(sqrt(a),sqrt(a-1));
		return c;
		
	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		
		throw new UnsupportedOperationException(TODO.method());
		
		// TODO

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		throw new UnsupportedOperationException(TODO.method());
		
		// TODO 
		
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		
		throw new UnsupportedOperationException(TODO.method());
		
		// TODO
		
	}
}
