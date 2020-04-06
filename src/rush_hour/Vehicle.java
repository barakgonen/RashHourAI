package rush_hour;
/*
* @param x:	The x coordinate where the vehicle is.
* @param y:	The y coordinate where the vehicle is.
* @param length: The length of the car
* @param orientation: The orientation of the vehicle (Horizontal or Vertical).
* @param name: The character associated to this vehicle.
*/
public class Vehicle {
	private int x; 
	private int y;
	private int length;
	private boolean orient;
	public static char name = 'a';
	public static final boolean HORIZONTAL = true;
	public static final boolean VERTICAL   = false;
	
	public Vehicle(int x, int y, int length, boolean orient, char name) {
		this.x = x;
		this.y = y;
		this.length = length;
		this.orient = orient;
		this.name = name;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isOrient() {
		return this.orient;
	}

	public void setOrient(boolean orient) {
		this.orient = orient;
	}

	public char getName() {
		return this.name;
	}

	public void setName(char name) {
		Vehicle.name = name;
	}
	
	
	
	
	
	
}
