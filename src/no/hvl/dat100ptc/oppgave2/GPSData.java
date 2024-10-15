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
		
		int timeTall = Integer.parseInt(time);
		double latitudeTall = Double.parseDouble(latitude);
		double longitudeTall = Double.parseDouble(latitude);
		double elevationTall = Double.parseDouble(elevation);
		GPSPoint gpspoint = new GPSPoint(timeTall, latitudeTall, longitudeTall,elevationTall);
		insertGPS(gpspoint);
		
		
		// TODO
		throw new UnsupportedOperationException(TODO.method());
	}

	public void print() {

		throw new UnsupportedOperationException(TODO.method());

		// TODO
	}
}
