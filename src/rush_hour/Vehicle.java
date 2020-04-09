package rush_hour;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class represents a vehicle in our board game. Each vehicle built from
 * the following attributes: start&end position - car's position on board size -
 * size of the car orientation - orientation of the car - weather it's vertical
 * or horizontal. Identifier - id of the car
 */
public class Vehicle {
	public static Logger LOGGER = Logger.getLogger(Main.class.getName());

	private Point startPos;
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

	// Assuming input is correct, not trying to move to invalid position
	public Collection<Point> moveVehicle(Point pointToMoveTo) {
		List<Point> newEmptyPoints = new ArrayList<>();
		if (orientation == Constants.HORIZONTAL) {
			if (pointToMoveTo.getY() < startPos.getY()) {
				final int numberOfStepsToMove = (int) (startPos.getY() - pointToMoveTo.getY());
				final int tempEndPos = (int) endPos.getY();
				startPos = new Point(pointToMoveTo);
				endPos = new Point((int) endPos.getX(), (int) (endPos.getY() - numberOfStepsToMove));
				for (int endIndex = tempEndPos; endIndex > endPos.getY(); endIndex--) {
					newEmptyPoints.add(new Point((int) endPos.getX(), endIndex));
				}
			} else if (endPos.getY() < pointToMoveTo.getY()) {
				final int numberOfStepsToMove = (int) (pointToMoveTo.getY() - (int) endPos.getY());
				final int tempEndPos = (int) startPos.getY();
				endPos = new Point(pointToMoveTo);
				startPos = new Point((int) startPos.getX(), (int) (startPos.getY() + numberOfStepsToMove));
				for (int endIndex = tempEndPos; endIndex < startPos.getY(); endIndex++) {
					newEmptyPoints.add(new Point((int) endPos.getX(), endIndex));
				}
			}
		} else {
			if (pointToMoveTo.getX() < startPos.getX()) {
				// Moving NORTH
				final int numberOfStepsToMove = (int) (startPos.getX() - pointToMoveTo.getX());
				final int tempEndPos = (int) endPos.getX();
				startPos = new Point(pointToMoveTo);
				endPos = new Point((int) endPos.getY(), (int) (endPos.getX() - numberOfStepsToMove));
				for (int endIndex = tempEndPos; endIndex > endPos.getX(); endIndex--) {
					newEmptyPoints.add(new Point(endIndex, (int) endPos.getY()));
				}
			} else if (endPos.getX() < pointToMoveTo.getX()) {
				final int numberOfStepsToMove = (int) (pointToMoveTo.getX() - (int) endPos.getX());
				final int tempEndPos = (int) startPos.getX();
				endPos = new Point(pointToMoveTo);
				startPos = new Point((int) (startPos.getX() + numberOfStepsToMove), (int) startPos.getY());
				for (int endIndex = tempEndPos; endIndex < startPos.getX(); endIndex++) {
					newEmptyPoints.add(new Point((int) endPos.getY(), endIndex));
				}
			}
		}
		return newEmptyPoints;
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

	private boolean isHorizontalIntersection(Point pnt) {
		return ((pnt.getX() == startPos.getX()) && (pnt.getX() == endPos.getX()))
				&& (startPos.getY() < pnt.getY() && pnt.getY() < endPos.getY());
	}

	private boolean isVerticalIntersection(Point pnt) {
		return ((pnt.getY() == startPos.getY()) && (pnt.getY() == endPos.getY()))
				&& (startPos.getX() < pnt.getX() && pnt.getX() < endPos.getX());
	}

	private boolean isPointIntersectsWithTruck(Point pnt) {
		return (orientation == Constants.HORIZONTAL ? isHorizontalIntersection(pnt) : isVerticalIntersection(pnt));
	}

	public boolean isPointIntersectsWithMe(Point pnt) {
		return startPos.equals(pnt) || endPos.equals(pnt)
				|| (size == Constants.TRUCK_SIZE ? isPointIntersectsWithTruck(pnt) : false);
	}

	public List<Point> getLocations() {
		ArrayList<Point> toReturn = new ArrayList<Point>();
		toReturn.add(startPos);
		toReturn.add(endPos);
		if (size == 3)
			if (orientation == Constants.HORIZONTAL)
				toReturn.add(new Point((int) startPos.getX(), (int) startPos.getY() + 1));
			else
				toReturn.add(new Point((int) startPos.getX() + 1, (int) startPos.getY()));
		return toReturn;
	}
}
