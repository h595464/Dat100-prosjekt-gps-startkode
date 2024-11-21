package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;
import no.hvl.dat100ptc.TODO;

public class ShowSpeed extends EasyGraphics {
			
	private static final long serialVersionUID = 1L;
	
	private static int MARGIN = 50;
	private static int BARHEIGHT = 100; 

	private GPSComputer gpscomputer;
	
	public ShowSpeed() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Speed profile", 
				2 * MARGIN + 
				2 * gpscomputer.speeds().length, 2 * MARGIN + BARHEIGHT);
		
		showSpeedProfile(MARGIN + BARHEIGHT);
	}
	
	public void showSpeedProfile(int ybase) {
		
		double[] speeds = gpscomputer.speeds();
		for (int i = 0; i < speeds.length; i++) {
			speeds[i] = speeds[i] * 3.6;
		}
		
		
		double averageSpeed = gpscomputer.averageSpeed() * 3.6;
		
		int x = MARGIN;
		for (int i = 0; i < speeds.length; i++) {
			int y = ybase -(int) speeds[i];
			
			drawLine (x, ybase, x, y);
			
			x += 2;
		}
		
		int avgY = ybase - (int) averageSpeed;
		setColor(0, 255, 0);
		drawLine(MARGIN, avgY, MARGIN + 2 * speeds.length, avgY);
	
		// TODO
		// throw new UnsupportedOperationException(TODO.method());
		
	}
}
