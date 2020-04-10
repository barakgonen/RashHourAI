package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.Collections;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import rush_hour.Constants;
import rush_hour.Vehicle;
import search_engine.astar.AStarSearchNode;

class TestIsGoalNode {

	@Test
	void testIsGoalNodeWhenArrivedToIt() {
		HashMap<Character, Vehicle> vehicles = new HashMap<>();
		vehicles.put(Constants.TARGET_VEHICLE_IDENTIFIER,
				TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 2,
						new Point(Constants.EXIT_RAW, Constants.BOARD_SIZE - 2),
						new Point(Constants.EXIT_RAW, Constants.BOARD_SIZE - 1)));
		int puzzleID = 1;
		AStarSearchNode currentSearchNode = new AStarSearchNode(Collections.emptyList(), vehicles, puzzleID, 1, 0, 0);
		assertTrue(currentSearchNode.isGoalNode());
	}

	@Test
	void testIsGoalNodeWhenIdentifiengEmptyPathToItIn() {
		HashMap<Character, Vehicle> vehicles = new HashMap<>();
		vehicles.put(Constants.TARGET_VEHICLE_IDENTIFIER,
				TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 2,
						new Point(Constants.EXIT_RAW, Constants.BOARD_SIZE - 3),
						new Point(Constants.EXIT_RAW, Constants.BOARD_SIZE - 2)));
		int puzzleID = 1;
		AStarSearchNode currentSearchNode = new AStarSearchNode(Collections.emptyList(), vehicles, puzzleID, 2, 0, 0);
		assertTrue(currentSearchNode.isGoalNode());
	}

	@Test
	void testIsGoalNodeWhenIdentifiengEmptyPathOfWholeRow() {
		HashMap<Character, Vehicle> vehicles = new HashMap<>();
		vehicles.put(Constants.TARGET_VEHICLE_IDENTIFIER, TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER,
				Constants.HORIZONTAL, 2, new Point(Constants.EXIT_RAW, 0), new Point(Constants.EXIT_RAW, 1)));
		int puzzleID = 1;
		AStarSearchNode currentSearchNode = new AStarSearchNode(Collections.emptyList(), vehicles, puzzleID, 2, 0, 0);
		assertTrue(currentSearchNode.isGoalNode());
	}

	@Test
	void testIsGoalNodeWhenThereIsOneHorizontalBlocker() {
		HashMap<Character, Vehicle> vehicles = new HashMap<>();
		vehicles.put(Constants.TARGET_VEHICLE_IDENTIFIER, TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER,
				Constants.HORIZONTAL, 2, new Point(Constants.EXIT_RAW, 0), new Point(Constants.EXIT_RAW, 1)));
		vehicles.put('B', TestsUtils.getVehicle('B', Constants.HORIZONTAL, 2, new Point(Constants.EXIT_RAW, 3),
				new Point(Constants.EXIT_RAW, 4)));
		int puzzleID = 1;
		AStarSearchNode currentSearchNode = new AStarSearchNode(Collections.emptyList(), vehicles, puzzleID, 2, 0, 0);
		assertFalse(currentSearchNode.isGoalNode());
	}

	@Test
	void testIsGoalNodeWhenThereIsOneVerticalBlocker() {
		HashMap<Character, Vehicle> vehicles = new HashMap<>();
		vehicles.put(Constants.TARGET_VEHICLE_IDENTIFIER, TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER,
				Constants.HORIZONTAL, 2, new Point(Constants.EXIT_RAW, 0), new Point(Constants.EXIT_RAW, 1)));
		vehicles.put('B',
				TestsUtils.getVehicle('B', Constants.VERTICAL, 2, new Point(1, 3), new Point(Constants.EXIT_RAW, 3)));
		int puzzleID = 1;
		AStarSearchNode currentSearchNode = new AStarSearchNode(Collections.emptyList(), vehicles, puzzleID, 2, 0, 0);
		assertFalse(currentSearchNode.isGoalNode());
	}

	@Test
	void testIsGoalNodeWhenThereAreMultipleBlockers() {
		HashMap<Character, Vehicle> vehicles = new HashMap<>();
		vehicles.put(Constants.TARGET_VEHICLE_IDENTIFIER, TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER,
				Constants.HORIZONTAL, 2, new Point(Constants.EXIT_RAW, 0), new Point(Constants.EXIT_RAW, 1)));
		vehicles.put('B',
				TestsUtils.getVehicle('B', Constants.VERTICAL, 2,
						new Point(Constants.EXIT_RAW - 1, Constants.BOARD_SIZE),
						new Point(Constants.EXIT_RAW + 1, Constants.BOARD_SIZE)));
		vehicles.put('B', TestsUtils.getVehicle('C', Constants.HORIZONTAL, 2, new Point(Constants.EXIT_RAW, 3),
				new Point(Constants.EXIT_RAW, 4)));
		int puzzleID = 1;
		AStarSearchNode currentSearchNode = new AStarSearchNode(Collections.emptyList(), vehicles, puzzleID, 2, 0, 0);
		assertFalse(currentSearchNode.isGoalNode());
	}
}
