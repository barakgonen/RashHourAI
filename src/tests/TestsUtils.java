package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import rush_hour.Constants;
import rush_hour.Vehicle;
import search_engine.astar.AStarSearchNode;

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

	public static AStarSearchNode getSearchNode() {
		Set<Point> firstSuccessorExpectedEmptySpots = new HashSet<>();
		firstSuccessorExpectedEmptySpots.add(new Point(4, 0));
		firstSuccessorExpectedEmptySpots.add(new Point(4, 1));
		firstSuccessorExpectedEmptySpots.add(new Point(1, 4));
		firstSuccessorExpectedEmptySpots.add(new Point(2, 4));
		firstSuccessorExpectedEmptySpots.add(new Point(3, 4));
		firstSuccessorExpectedEmptySpots.add(new Point(3, 3));
		firstSuccessorExpectedEmptySpots.add(new Point(5, 4));
		firstSuccessorExpectedEmptySpots.add(new Point(5, 5));
		HashMap<Character, Vehicle> firstSuccessorVehiclesMap = new HashMap<>();
		firstSuccessorVehiclesMap.put('O', TestsUtils.getVehicle('O', Constants.VERTICAL, 3, new Point(0, 0)));
		firstSuccessorVehiclesMap.put('P', TestsUtils.getVehicle('P', Constants.HORIZONTAL, 3, new Point(0, 1)));
		firstSuccessorVehiclesMap.put('E', TestsUtils.getVehicle('E', Constants.VERTICAL, 2, new Point(4, 2)));
		firstSuccessorVehiclesMap.put('G', TestsUtils.getVehicle('G', Constants.HORIZONTAL, 2, new Point(5, 0)));
		firstSuccessorVehiclesMap.put('Q', TestsUtils.getVehicle('Q', Constants.VERTICAL, 3, new Point(1, 5)));
		firstSuccessorVehiclesMap.put('X', TestsUtils.getVehicle('X', Constants.HORIZONTAL, 2, new Point(2, 2)));
		firstSuccessorVehiclesMap.put('B', TestsUtils.getVehicle('B', Constants.VERTICAL, 2, new Point(1, 1)));
		firstSuccessorVehiclesMap.put('R', TestsUtils.getVehicle('R', Constants.HORIZONTAL, 3, new Point(3, 0)));
		firstSuccessorVehiclesMap.put('F', TestsUtils.getVehicle('F', Constants.HORIZONTAL, 2, new Point(4, 4)));
		firstSuccessorVehiclesMap.put('A', TestsUtils.getVehicle('A', Constants.HORIZONTAL, 2, new Point(0, 4)));
		firstSuccessorVehiclesMap.put('C', TestsUtils.getVehicle('C', Constants.HORIZONTAL, 2, new Point(1, 2)));
		firstSuccessorVehiclesMap.put('D', TestsUtils.getVehicle('D', Constants.VERTICAL, 2, new Point(4, 3)));

		return new AStarSearchNode(firstSuccessorExpectedEmptySpots, firstSuccessorVehiclesMap, 1, 1, 1, 1);
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
