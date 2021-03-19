import static java.lang.Math.abs;

/**
 * Celestial Body class for NBody
 * @author Marcus Deans (md374)
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	//CelestialBody b = new cb(10,10...);
	public CelestialBody(double xp, double yp, double xv,
						 double yv, double mass, String filename){
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;
		// TODO: complete constructor
	}

	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 * @param b used to initialize this body
	 */
	public CelestialBody(CelestialBody b){
		myXPos = b.myXPos;
		myYPos = b.myYPos;
		myXVel = b.myXVel;
		myYVel = b.myYVel;
		myMass = b.myMass;
		myFileName = b.myFileName;
		// TODO: complete constructor
	}

	/**
	 * Getter Method for x-position
	 * @return value of x position of this body
	 */
	public double getX() {
		// TODO: complete method
		return myXPos;
	}
	/**
	 * Getter Method for y-position
	 * @return value of y position of this body
	 */
	public double getY() {
		// TODO: complete method
		return myYPos;
	}
	/**
	 * Getter Method for x-velocity
	 * @return value of x-velocity of this body
	 */
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Getter Method for y-velocity
	 * @return value of y-velocity of this body
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel;
	}
	/**
	 * Getter Method for mass
	 * @return value of mass of this body
	 */
	public double getMass() {
		// TODO: complete method
		return myMass;
	}
	/**
	 * Getter Method for name
	 * @return value of name of this body
	 */
	public String getName() {
		// TODO: complete method
		//return "";
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		// TODO: complete method
		return Math.sqrt((Math.pow((myXPos-b.myXPos),2))+(Math.pow((myYPos - b.myYPos), 2)));
	}

	/**
	 * Return the force exerted on this body by another
	 * @param b the other body which exerts the force
	 * @return force exerted on this body by b
	 */
	public double calcForceExertedBy(CelestialBody b) {
		// TODO: complete method
		return ((6.67*1e-11*myMass*b.myMass)/(Math.pow(calcDistance(b),2)));
	}
	/**
	 * Return the force exerted on this body by another in the x axis
	 * @param b the other body which exerts the force
	 * @return force exerted on this body by b in the x axis
	 */
	public double calcForceExertedByX(CelestialBody b) {
		// TODO: complete method
		return ((calcForceExertedBy(b)*((b.myXPos-myXPos)))/calcDistance(b));
	}
	/**
	 * Return the force exerted on this body by another in the y axis
	 * @param b the other body which exerts the force
	 * @return force exerted on this body by b in the y axis
	 */
	public double calcForceExertedByY(CelestialBody b) {
		// TODO: complete method
		return ((calcForceExertedBy(b)*((b.myYPos-myYPos)))/calcDistance(b));
	}

	/**
	 * Method to find the net force exerted by all the celestial bodies in the x axis
	 * @param bodies are all the celestial bodies in an array
	 * @return the value of the total force exerted by the bodies in the x axis
	 */
	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double fina = 0.0;
		for(CelestialBody b : bodies){
			if (! b.equals(this)){
				fina += calcForceExertedByX(b);
			}
		}
		return fina;
	}

	/**
	 * Method to find the net force exerted by all the celestial bodies in the y axis
	 * @param bodies are all the celestial bodies in an array
	 * @return the value of the total force exerted by the bodies in the y axis
	 */
	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		// TODO: complete method
		double fina = 0.0;
		for (CelestialBody b : bodies){
			if (! b.equals(this)){
				fina += calcForceExertedByY(b);
			}
		}
		return fina;
	}

	/**
	 * Mutator method to update force/velocity values for each body with time
	 * @param deltaT time elapsed between prior increment
	 * @param xforce value of force in x direction
	 * @param yforce value of force in y direction
	 */
	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
		double ax = xforce/myMass;
		double ay = yforce/myMass;
		double nvx = myXVel + deltaT*ax;
		double nvy = myYVel + deltaT*ay;
		double nx = myXPos + deltaT*nvx;
		double ny = myYPos + deltaT*nvy;
		myXPos = nx;
		myYPos = ny;
		myXVel = nvx;
		myYVel = nvy;
	}

	/**
	 * Method to draw out each celestial body in real time
	 */
	public void draw() {
		// TODO: complete method
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
