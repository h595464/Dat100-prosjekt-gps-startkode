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

		
		int timer = secs/3600;
		double met = 0;		
		double speedmph = speed * MS;
		double kcal = met * weight * timer;
		while(speedmph<10)	{
			met = 4.0;
			break;
		}
		while(speedmph>10 && speedmph<12)	{
			met = 6.0;
			break;
		}
		while(speedmph>12 && speedmph<14)	{
			met = 8.0;
			break;
		}
		while(speedmph>14 && speedmph<16)	{
			met = 10.0;
			break;
		}
		while(speedmph>16 && speedmph<20)	{
			met = 12.0;
			break;
		}
		while(met>20)	{
			met = 16.0;
			break;
		}
		return kcal;
	}

	public double totalKcal(double weight) {

		double totalkcal = 0;
		for(int i = 0; i<gpspoints.length-1; i++)	{
			totalkcal += kcal(weight, gpspoints[i].getTime(),GPSUtils.speed(gpspoints[i],gpspoints[i+1]));
		}
		
		return totalkcal;
		
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}

}
