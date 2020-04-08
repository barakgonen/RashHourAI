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
		AStarSearchNode currentSearchNode = new AStarSearchNode(Collections.emptyList(), vehicles, puzzleID);
		assertTrue(currentSearchNode.isGoalNode());
	}

	@Test
	void testIsGoalNodeWhenNotArrivedToIt() {
		HashMap<Character, Vehicle> vehicles = new HashMap<>();
		vehicles.put(Constants.TARGET_VEHICLE_IDENTIFIER,
				TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 2,
						new Point(Constants.EXIT_RAW, Constants.BOARD_SIZE - 3),
						new Point(Constants.EXIT_RAW, Constants.BOARD_SIZE - 2)));
		int puzzleID = 1;
		AStarSearchNode currentSearchNode = new AStarSearchNode(Collections.emptyList(), vehicles, puzzleID);
		assertFalse(currentSearchNode.isGoalNode());
	}
}
