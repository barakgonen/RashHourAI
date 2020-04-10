package rush_hour;

import java.awt.Point;

public class Movement {
	private Character vehicleIdentifier;
	private Direction movementDirection;
	private int movementSize;

	public Movement(Point oldStartPos, Point newStartPos, Character vehicleID, boolean vehicleOrientation) {
		vehicleIdentifier = vehicleID;
		if (vehicleOrientation == Constants.HORIZONTAL) {
			if (oldStartPos.getY() < newStartPos.getY())
				movementDirection = Direction.E;
			else
				movementDirection = Direction.W;
			movementSize = Math.abs((int) (oldStartPos.getY() - newStartPos.getY()));
		} else {
			if (oldStartPos.getX() < newStartPos.getX())
				movementDirection = Direction.N;
			else
				movementDirection = Direction.S;
			movementSize = Math.abs((int) (oldStartPos.getX() - newStartPos.getX()));
		}
	}

	@Override
	public String toString() {
		return " " + vehicleIdentifier + movementDirection + movementSize + " -->";
	}

	public Direction getMovementDirection() {
		return movementDirection;
	}

	public Character getVehicleIdentifier() {
		return vehicleIdentifier;
	}
}
