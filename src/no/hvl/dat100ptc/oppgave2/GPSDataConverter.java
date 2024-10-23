package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	//Oppgave a
	public static int toSeconds(String timestr) {
		int timer = Integer.parseInt(timestr.substring(11,13));
		int minutter = Integer.parseInt(timestr.substring(14,16));
		int sekunder = Integer.parseInt(timestr.substring(17,19));
		int minutterTilsekunder = minutter * 60;
		int timerTilSekunder = timer *3600;
		int totallAntallSekunder = sekunder + minutterTilsekunder + timerTilSekunder;
		

		
//		 int hr, min, sec;
		
		int hr = Integer.parseInt(timestr.substring(TIME_STARTINDEX,TIME_STARTINDEX + 2));
		int min = Integer.parseInt(timestr.substring(TIME_STARTINDEX + 3,TIME_STARTINDEX + 5));
		int sec = Integer.parseInt(timestr.substring(TIME_STARTINDEX + 6,TIME_STARTINDEX + 8));
		
		int secs = hr * 3600 + min * 60 + sec;
		
		return secs;
		
		// TODO
		// throw new UnsupportedOperationException(TODO.method());
		

		return totallAntallSekunder;

	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		int time = toSeconds(timeStr);
		double latitude = Double.parseDouble(latitudeStr);
		double longitude = Double.parseDouble(longitudeStr);
		double elevation = Double.parseDouble(elevationStr);

		
		
		GPSPoint gpspoint = new GPSPoint(time, latitude, longitude, elevation);
		
		return gpspoint;

		
		
		// TODO 
		// throw new UnsupportedOperationException(TODO.method());

		GPSPoint gpspoint = new GPSPoint(time,latitude,longitude,elevation); 

		
		return gpspoint;

	}
	
}
