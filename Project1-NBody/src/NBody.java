	

/**
 * @author YOUR NAME THE STUDENT IN 201
 * 
 * Simulation program for the NBody assignment
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NBody {
	
	/**
	 * Read the specified file and return the radius
	 * @param fname is name of file that can be open
	 * @return the radius stored in the file
	 * @throws FileNotFoundException if fname cannot be open
	 */
	public static double readRadius(String fname) throws FileNotFoundException  {
		Scanner s = new Scanner(new File(fname));

		int bodyno = s.nextInt();
		double unirad = s.nextDouble();
		// TODO: read values at beginning of file to
		// find the radius
		
		s.close();
		
		// TODO: return radius read
		return unirad;
	}
	
	/**
	 * Read all data in file, return array of Celestial Bodies
	 * read by creating an array of Body objects from data read.
	 * @param fname is name of file that can be open
	 * @return array of Body objects read
	 * @throws FileNotFoundException if fname cannot be open
	 */
	public static CelestialBody[] readBodies(String fname) throws FileNotFoundException {
		
			Scanner s = new Scanner(new File(fname));
			
			// TODO: read # bodies, create array, ignore radius
			int nb = s.nextInt(); // # bodies to be read
			CelestialBody[] dat = new CelestialBody[nb];
			s.nextDouble();
			for(int k=0; k < nb; k++) {
				double curx = s.nextDouble();
				double cury = s.nextDouble();
				double xvel = s.nextDouble();
				double yvel = s.nextDouble();
				double curmass = s.nextDouble();
				String imname = s.next();
				dat[k] =  new CelestialBody(curx,cury,xvel,yvel,curmass,imname);
				// TODO: read data for each body
				// construct new body object and add to array
			}
			
			s.close();
			
			// TODO: return array of body objects read
			return dat;
	}

	/**
	 * Main function to run simulation and call other methods
	 * @param args are the parameters for the simulation
	 * @throws FileNotFoundException if data cannot be parsed
	 */
	public static void main(String[] args) throws FileNotFoundException{
		double totalTime = 39447000.0;
		double dt = 25000.0;
		
		String fname= "./data/kaleidoscope.txt";
		if (args.length > 2) {
			totalTime = Double.parseDouble(args[0]);
			dt = Double.parseDouble(args[1]);
			fname = args[2];
		}	
		
		CelestialBody[] bodies = readBodies(fname);
		double radius = readRadius(fname);

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0,0,"images/starfield.jpg");
		//StdAudio.play("images/2001.wav");
	
		// run simulation until time up

		for(double t = 0.0; t < totalTime; t += dt) {
			
			// TODO: create double arrays xforces and yforces
			// to hold forces on each body
			double[] xforces = new double[bodies.length];
			double[] yforces = new double[bodies.length];
			
			// TODO: loop over all bodies, calculate netForcesX and Y
			// net forces and store in xforces and yforces
			for(int x = 0; x < bodies.length; x++){
				xforces[x] = bodies[x].calcNetForceExertedByX(bodies);
				yforces[x] = bodies[x].calcNetForceExertedByY(bodies);
			}

			// TODO: loop over all bodies and call update
			// with dt and corresponding xforces, yforces values
			for(int x = 0; x < bodies.length; x++){
				bodies[x].update(dt, xforces[x], yforces[x]);
				//call update
			}
			
			StdDraw.picture(0,0,"images/starfield.jpg");
			
			// TODO: loop over all bodies and call draw on each one
			for(int x = 0; x < bodies.length; x++){
				bodies[x].draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
		}
		
		// prints final values after simulation
		
		System.out.printf("%d\n", bodies.length);
		System.out.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
		    System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		   		              bodies[i].getX(), bodies[i].getY(), 
		                      bodies[i].getXVel(), bodies[i].getYVel(), 
		                      bodies[i].getMass(), bodies[i].getName());	
		}
	}
}
