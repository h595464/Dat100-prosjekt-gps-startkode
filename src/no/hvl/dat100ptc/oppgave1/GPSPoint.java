package no.hvl.dat100ptc.oppgave1;

import no.hvl.dat100ptc.TODO;


public class GPSPoint {


	// TODO - objektvar
	
	private int time;				//angir tiden i sekunder
	private double latitude;		//angir breddegrad
	private double longitude;		//angir lengdegrad
	private double elevation;		//angir høyde i meter

	
	public GPSPoint(int time, double latitude, double longitude, double elevation) {

		// TODO - konstruktu
		
		this.time = time;		this.latitude = latitude;  			//
		this.longitude = longitude;		this.elevation = elevation; //

		// throw new UnsupportedOperationException(TODO.construtor("GPSPoint"));

	private int time;
	private double latitude, longitude, elevation;
	public GPSPoint(int time, double latitude, double longitude, double elevation) {
		
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		//throw new UnsupportedOperationException(TODO.construtor("GPSPoint"));

		
	}

	public int getTime() {

		
		return time;	//
		
		// throw new UnsupportedOperationException(TODO.method());

		return time;
		//throw new UnsupportedOperationException(TODO.method());

		
	}

	public void setTime(int time) {

		
		this.time = time;	//
				
		// throw new UnsupportedOperationException(TODO.method());

		this.time = time;
		//throw new UnsupportedOperationException(TODO.method());

		
	}

	public double getLatitude() {

		
		return latitude;	//
		
		// throw new UnsupportedOperationException(TODO.method());

		return latitude;
		//throw new UnsupportedOperationException(TODO.method());

		
		
	}

	public void setLatitude(double latitude) {

		
		this.latitude = latitude;	//
		
		// throw new UnsupportedOperationException(TODO.method());

		this.latitude = latitude;
		//throw new UnsupportedOperationException(TODO.method());

		
	}

	public double getLongitude() {

		
		return longitude;	//
		
		// throw new UnsupportedOperationException(TODO.method());

		return longitude;
		//throw new UnsupportedOperationException(TODO.method());

		
	}

	public void setLongitude(double longitude) {

		
		this.longitude = longitude;
		
		// throw new UnsupportedOperationException(TODO.method());

		this.longitude = longitude;
		//throw new UnsupportedOperationException(TODO.method());

		
	}

	public double getElevation() {

		
		return elevation;	//
		
		// throw new UnsupportedOperationException(TODO.method());

		return elevation;
		//throw new UnsupportedOperationException(TODO.method());

		
	}

	public void setElevation(double elevation) {

		
		this.elevation = elevation;
		
		// throw new UnsupportedOperationException(TODO.method());

		this.elevation = elevation;
		//throw new UnsupportedOperationException(TODO.method());

		
	}
	
	public String toString() {
		
		String str = time + " (" + latitude + "," + longitude + ") " + elevation + "\n";
		return str;
		

		// throw new UnsupportedOperationException(TODO.method());

		//throw new UnsupportedOperationException(TODO.method());


		
	}
}




// kmmoonsss


