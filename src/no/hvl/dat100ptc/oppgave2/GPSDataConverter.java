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
		
		return totallAntallSekunder;
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		int time = toSeconds(timeStr);
		double latitude = Double.parseDouble(latitudeStr);
		double longitude = Double.parseDouble(longitudeStr);
		double elevation = Double.parseDouble(elevationStr);
		GPSPoint gpspoint = new GPSPoint(time,latitude,longitude,elevation); 
		
		return gpspoint;

	}
	
}
