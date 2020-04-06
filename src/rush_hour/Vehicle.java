package rush_hour;

import java.awt.Point;
import java.util.logging.Logger;

/**
 * This class represents a vehicle in our board game. Each vehicle built from
 * the following attributes: start&end position - car's position on board size -
 * size of the car orientation - orientation of the car - weather it's vertical
 * or horizontal. Identifier - id of the car
 */
public class Vehicle {
	public static Logger LOGGER = Logger.getLogger(Main.class.getName());

	private final Point startPos;
	private Point endPos;
	private int size;
	private boolean orientation;
	private final char identifier;

	public Vehicle(char carIdentifier, Point startPosition) {
		identifier = carIdentifier;
		startPos = startPosition;
		size = 1;
	}

	public void updateVehicle(Point endPos) {
		// Need to understand weather car orientation is vertical or horizontal
		if (startPos.x != endPos.x && startPos.y == endPos.y) {
			orientation = Constants.VERTICAL;
			size += 1;
		} else if (startPos.x == endPos.x && startPos.y != endPos.y) {
			orientation = Constants.HORIZONTAL;
			size += 1;
		} else {
			LOGGER.warning("There is a bug, the car is not vertical and not horizontal!");
		}

	}
}
