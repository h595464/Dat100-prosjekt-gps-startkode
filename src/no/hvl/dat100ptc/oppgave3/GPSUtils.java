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

		double latitude1 = toRadians(gpspoint1.getLatitude());
		double longitude1 = toRadians(gpspoint1.getLongitude());
	
		double latitude2 = toRadians(gpspoint2.getLatitude());
		double longitude2 = toRadians(gpspoint2.getLongitude());
		
		double deltaphi = latitude2-latitude1;
		double deltadelta = longitude2-longitude1;
		
		double a = compute_a(latitude1,latitude2,deltaphi,deltadelta);
		double c = compute_c(a);
		double  d = R*c;
	
		return d;
		
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
		
		double a = pow((sin(deltaphi/2)),2) + (cos(phi1) * cos(phi2) * pow((sin(deltadelta/2)),2));
		return a;
	}

	private static double compute_c(double a) {
		// skrev a-1 istedenfor 1-a og brukte over en time på å finne feilen;
		double c = 2*atan2(sqrt(a),sqrt(1-a));
		return c;
		
	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		
		double meter = distance(gpspoint1, gpspoint2);
		int secs = gpspoint2.getTime() - gpspoint1.getTime();
		double speed = meter/secs;
		return speed;

	}

	public static String formatTime(int secs) {
		
		int hours = secs / 3600;
	    int minutes = (secs % 3600) / 60; 
	    int seconds = secs % 60; 
		String TIMESEP = ":";
		String timestr = String.format("  %02d" + TIMESEP + "%02d" + TIMESEP + "%02d", hours, minutes, seconds);
		return timestr;

		
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {
	
		String str = String.format("      %.2f",d);
		return str;

	}
}
