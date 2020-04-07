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

	public void updateVehicle(Point _endPos) {
		if (startPos.x != _endPos.x && startPos.y == _endPos.y) {
			orientation = Constants.VERTICAL;
			size += 1;
			endPos = _endPos;
		} else if (startPos.x == _endPos.x && startPos.y != _endPos.y) {
			orientation = Constants.HORIZONTAL;
			size += 1;
			endPos = _endPos;
		} else {
			LOGGER.warning("There is a bug, the car is not vertical and not horizontal!");
		}
	}

	public Point getEndPos() {
		return endPos;
	}

	public int getSize() {
		return size;
	}

	public boolean getOrientation() {
		return orientation;
	}

	public Point getStartPos() {
		return startPos;
	}

	public char getIdentifier() {
		return identifier;
	}

	public void setEndPos(Point endPos) {
		this.endPos = endPos;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setOrientation(boolean orientation) {
		this.orientation = orientation;
	}

	@Override
	public boolean equals(Object o) {
		Vehicle comp = (Vehicle) o;
		return startPos.equals(comp.getStartPos()) && endPos.equals(comp.getEndPos()) && size == comp.getSize()
				&& orientation == comp.orientation && identifier == comp.identifier;
	}

	public boolean isPointIntersectsWithMe(Point pnt) {
		return (startPos.getX() <= pnt.getX() && pnt.getX() <= endPos.getX())
				|| (endPos.getX() <= pnt.getX() && pnt.getX() <= endPos.getX());
	}
}
