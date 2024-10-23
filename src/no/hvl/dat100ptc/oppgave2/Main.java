package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {


	public static void main(String[] args) {
		
		GPSPoint gps1 = new GPSPoint(7777, 77.777777, 7.666777, 67.6);
		GPSPoint gps2 = new GPSPoint(9999, 79.999999, 9.999999, 96.9);
		
		GPSData gpsData = new GPSData(2);
		
		gpsData.insertGPS(gps1);
		gpsData.insertGPS(gps2);
		
		gpsData.print();

	
	

		

		// TODO
		
	}
}
