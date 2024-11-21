package no.hvl.dat100ptc.oppgave1;

import static java.lang.System.*;


public class Main {
	
	public static void main(String[] args) {

		
		// TODO 
		GPSPoint v1 = new GPSPoint(1, 2.0, 3.0, 5.0);
		
		out.println(v1.getTime());
		v1.setTime(2);
		out.println(v1.toString());

		GPSPoint gps = new GPSPoint(1,3.0,2.0,5.0);
		System.out.println(gps.toString());

		
	}

}
