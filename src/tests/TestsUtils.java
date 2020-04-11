package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.List;

import rush_hour.Constants;
import rush_hour.Vehicle;

public final class TestsUtils {
	public static Vehicle getVehicle(char identifier, boolean orientation, int size, Point startPoint) {
		Vehicle vehicleToBuild = new Vehicle(identifier, startPoint);
		if (orientation == Constants.HORIZONTAL)
			vehicleToBuild.setEndPos(new Point((int) startPoint.getX(), (int) startPoint.getY() + size - 1));
		else
			vehicleToBuild.setEndPos(new Point((int) startPoint.getX() + size - 1, (int) startPoint.getY()));
		vehicleToBuild.setOrientation(orientation);
		vehicleToBuild.setSize(size);

		return vehicleToBuild;
	}

	public static void compareListCollections(List<Point> expected, List<Point> actual) {
		assertEquals(expected.size(), actual.size());

		for (Point expectedPoint : expected) {
			if (actual.indexOf(expectedPoint) == -1) {
				assertFalse("Point: " + expectedPoint + ", wasn't found at actualEmptySpots",
						actual.indexOf(expectedPoint) == -1);
			} else
				actual.remove(expectedPoint);
		}

		assertEquals(0, actual.size());
		assertTrue(actual.isEmpty());
	}
}
