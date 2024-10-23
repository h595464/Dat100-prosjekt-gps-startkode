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

		double totalDistance = 0;
		for (int i = 0; i<gpspoints.length - 1; i++)	{
			totalDistance += GPSUtils.distance(gpspoints[i],gpspoints[i+1]);
		}
		return totalDistance;

	}

	public double totalElevation() {
		
		double totalElevation = gpspoints[0].getElevation();
		for (int i = 0; i<gpspoints.length - 1; i++)	{
			double elevationDiff = gpspoints[i+1].getElevation() - gpspoints[i].getElevation();
			if(elevationDiff > 0) {
				totalElevation += elevationDiff;
			}
		}
		return totalElevation;
	}

	public int totalTime() {
		
		if (gpspoints.length < 2) {
			return 0;
		}
		
	
		int startTime = gpspoints[0].getTime();
		int endTime = gpspoints[gpspoints.length - 1].getTime();

		return endTime - startTime;
	}
		

	public double[] speeds() {

		double[] speeds = new double[gpspoints.length-1];
		for (int i = 0; i<gpspoints.length - 1; i++)	{
			
			double distance = GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
			
			int timeDifference = gpspoints[i+1].getTime() - gpspoints[i].getTime();
			
			if (timeDifference > 0) {
			speeds[i] = distance /timeDifference;
			} else {
				speeds[i] = 0;
				
			}
		}
		return speeds;
		
	}
	
	public double maxSpeed() {
		
		double[] speeds = speeds();
		
		double maxSpeed = 0;
		
		for (double speed : speeds) {
			if (speed > maxSpeed) {
				maxSpeed = speed;
			}
		}
		
		return maxSpeed;
	
	}

	public double averageSpeed() {

		double totalDistance = totalDistance();
		int totalTime = totalTime();
		
		if (totalTime > 0) {
			return totalDistance / totalTime;
		} else {
			return 0.0;
		}
		
		// TODO
		// throw new UnsupportedOperationException(TODO.method());
		
	}


	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {

		double speedMph = speed * MS;
		
		double met;
		if (speedMph < 10) {
	        met = 4.0;
	    } else if (speedMph >= 10 && speedMph < 12) {
	        met = 6.0;
	    } else if (speedMph >= 12 && speedMph < 14) {
	        met = 8.0;
	    } else if (speedMph >= 14 && speedMph < 16) {
	        met = 10.0;
	    } else if (speedMph >= 16 && speedMph < 20) {
	        met = 12.0;
	    } else {
	        met = 16.0;
	    }
		
		double hours = secs / 3600.0;
		double kcal = met * weight * hours;
		
		return kcal;

		// TODO 
		// throw new UnsupportedOperationException(TODO.method());
		
	}

	public double totalKcal(double weight) {

		double totalKcal = 0.0;
		
		for (int i = 0; i < gpspoints.length - 1; i++) {
			GPSPoint startPoint = gpspoints[i];
			GPSPoint endPoint = gpspoints[i+1];
			
			int timeInSecs = endPoint.getTime() - startPoint.getTime();
			
			double speed = GPSUtils.speed(startPoint, endPoint);
			
			totalKcal += kcal(weight, timeInSecs, speed);
		}
		
		return totalKcal;
		

		// TODO 
		// throw new UnsupportedOperationException(TODO.method());
		
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


