package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

import no.hvl.dat100ptc.TODO;

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
	
	public double totalDistance() {

		double distance = 0;
		for (int i = 1; i<gpspoints.length; i++)	{
			distance += GPSUtils.distance(gpspoints[i],gpspoints[i-1]);
		}
		return distance;

	}

	public double totalElevation() {
		
		double elevation = gpspoints[0].getElevation();
		for (int i = 1; i<gpspoints.length; i++)	{
			if(elevation < gpspoints[i].getElevation())
			elevation = gpspoints[i].getElevation();
		}
		return elevation;
	}

	public int totalTime() {
	
		int time;
		time = gpspoints[gpspoints.length-1].getTime() - gpspoints[0].getTime();

		return time;
	}
		

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length-1];
		for (int i = 0; i<speeds.length;i++)	{
			speeds[i] = GPSUtils.speed(gpspoints[i],gpspoints[i+1]);
		}
		return speeds;
		
	}
	
	public double maxSpeed() {
		
		double maxspeed = 0;
		maxspeed = GPSUtils.findMax(speeds());
	
		return maxspeed;
	
	}

	public double averageSpeed() {

		double distance = totalDistance();
		int time = totalTime();
		double averageSpeed = distance/time;
		return averageSpeed;
	}


	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {
	
		double timer = secs/3600.0;
		double met;	
		double speedmph = speed * MS;
		
		if(speedmph<=10)	{
			met = 4.0;	
		}
		else if(speedmph>10 && speedmph<12)	{
			met = 6.0;
		}
		else if (speedmph>12 && speedmph<14)	{
			met = 8.0;
		}
		else if(speedmph>14 && speedmph<16)	{
			met = 10.0;
		}
		else if(speedmph>16 && speedmph<20)	{
			met = 12.0;
		}
		else {
			met = 16.0;
		}
		double kcal = met * weight * timer;
		return kcal;
	}

	public double totalKcal(double weight) {
		// er overbevist om at dette er riktig;
		double totalkcal = 0.0;
		for(int i = 0; i<gpspoints.length-1; i++)	{
			GPSPoint endpoint = gpspoints[i+1];
			GPSPoint startpoint = gpspoints[i];
			
			int tidISec = endpoint.getTime() - startpoint.getTime();
			double speed = GPSUtils.speed(startpoint,endpoint);
			
			totalkcal += kcal(weight,tidISec,speed);
		
		}
		
		return totalkcal;
		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {
		
		int totalTime = totalTime();
		double totalDistance = totalDistance()/1000;
		double totalElevation = totalElevation();
		double maxSpeed = maxSpeed() * 3.6;
		double averageSpeed = averageSpeed() * 3.6;
		double totalKcal = totalKcal(WEIGHT);
		
		System.out.println("==============================================");
	    System.out.printf("Total Time     : %s%n", GPSUtils.formatTime(totalTime));
	    System.out.printf("Total distance : %10.2f km%n", totalDistance);
	    System.out.printf("Total elevation: %10.2f m%n", totalElevation);
	    System.out.printf("Max speed      : %10.2f km/t%n", maxSpeed);
	    System.out.printf("Average speed  : %10.2f km/t%n", averageSpeed);
	    System.out.printf("Energy         : %10.2f kcal%n", totalKcal);
	    System.out.println("==============================================");
	}

		// TODO 
		// throw new UnsupportedOperationException(TODO.method());
		
	
}

