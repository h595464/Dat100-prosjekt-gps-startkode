package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {
		gpspoints = new GPSPoint[n];
		antall = 0;
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}

	protected boolean insertGPS(GPSPoint gpspoint) {
		boolean inserted;
		if (antall < gpspoints.length) {
			gpspoints[antall] = gpspoint;
			inserted = true;
		} else {
			inserted = false;
		}
		antall++;
		return inserted;
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {
		
		int timeTall = GPSDataConverter.toSeconds(time);
		double latitudeTall = Double.parseDouble(latitude);
		double longitudeTall = Double.parseDouble(longitude);
		double elevationTall = Double.parseDouble(elevation);
		GPSPoint gpspoint = new GPSPoint(timeTall, latitudeTall, longitudeTall,elevationTall);
		return insertGPS(gpspoint);
	}

	public void print() {
		System.out.println("====== GPS Data - START ======");
		for (int i = 0; i<antall; i++)	{
			System.out.print(gpspoints[i].toString());
		}
		System.out.print("====== GPS Data - SLUTT ======");

	}
}
