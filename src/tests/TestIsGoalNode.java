package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.Collections;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import rush_hour.Constants;
import rush_hour.Vehicle;
import search_engine.astar.AStarSearchNode;
import search_engine.astar.TargetVehicleDistanceFromExitHeuristic;

class TestIsGoalNode {

	private TargetVehicleDistanceFromExitHeuristic calculator;

	@Before
	public void SetUp() {
		calculator = new TargetVehicleDistanceFromExitHeuristic();
	}

	@Test
	public void testIsGoalNodeWhenArrivedToIt() {
		HashMap<Character, Vehicle> vehicles = new HashMap<>();
		vehicles.put(Constants.TARGET_VEHICLE_IDENTIFIER, TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER,
				Constants.HORIZONTAL, 2, new Point(Constants.EXIT_RAW, Constants.BOARD_SIZE - 2)));
		int puzzleID = 1;
		AStarSearchNode currentSearchNode = new AStarSearchNode(Collections.emptyList(), vehicles, puzzleID, 1, 0, 0,
				calculator);
		assertTrue(currentSearchNode.isGoalNode());
	}

	@Test
	public void testIsGoalNodeWhenIdentifiengEmptyPathToItIn() {
		HashMap<Character, Vehicle> vehicles = new HashMap<>();
		vehicles.put(Constants.TARGET_VEHICLE_IDENTIFIER, TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER,
				Constants.HORIZONTAL, 2, new Point(Constants.EXIT_RAW, Constants.BOARD_SIZE - 3)));
		int puzzleID = 1;
		AStarSearchNode currentSearchNode = new AStarSearchNode(Collections.emptyList(), vehicles, puzzleID, 2, 0, 0,
				calculator);
		assertTrue(currentSearchNode.isGoalNode());
	}

	@Test
	public void testIsGoalNodeWhenIdentifiengEmptyPathOfWholeRow() {
		HashMap<Character, Vehicle> vehicles = new HashMap<>();
		vehicles.put(Constants.TARGET_VEHICLE_IDENTIFIER, TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER,
				Constants.HORIZONTAL, 2, new Point(Constants.EXIT_RAW, 0)));
		int puzzleID = 1;
		AStarSearchNode currentSearchNode = new AStarSearchNode(Collections.emptyList(), vehicles, puzzleID, 2, 0, 0,
				calculator);
		assertTrue(currentSearchNode.isGoalNode());
	}

	@Test
	public void testIsGoalNodeWhenThereIsOneHorizontalBlocker() {
		HashMap<Character, Vehicle> vehicles = new HashMap<>();
		vehicles.put(Constants.TARGET_VEHICLE_IDENTIFIER, TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER,
				Constants.HORIZONTAL, 2, new Point(Constants.EXIT_RAW, 0)));
		vehicles.put('B', TestsUtils.getVehicle('B', Constants.HORIZONTAL, 2, new Point(Constants.EXIT_RAW, 3)));
		int puzzleID = 1;
		AStarSearchNode currentSearchNode = new AStarSearchNode(Collections.emptyList(), vehicles, puzzleID, 2, 0, 0,
				calculator);
		assertFalse(currentSearchNode.isGoalNode());
	}

	@Test
	public void testIsGoalNodeWhenThereIsOneVerticalBlocker() {
		HashMap<Character, Vehicle> vehicles = new HashMap<>();
		vehicles.put(Constants.TARGET_VEHICLE_IDENTIFIER, TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER,
				Constants.HORIZONTAL, 2, new Point(Constants.EXIT_RAW, 0)));
		vehicles.put('B', TestsUtils.getVehicle('B', Constants.VERTICAL, 2, new Point(1, 3)));
		int puzzleID = 1;
		AStarSearchNode currentSearchNode = new AStarSearchNode(Collections.emptyList(), vehicles, puzzleID, 2, 0, 0,
				calculator);
		assertFalse(currentSearchNode.isGoalNode());
	}

	@Test
	public void testIsGoalNodeWhenThereAreMultipleBlockers() {
		HashMap<Character, Vehicle> vehicles = new HashMap<>();
		vehicles.put(Constants.TARGET_VEHICLE_IDENTIFIER, TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER,
				Constants.HORIZONTAL, 2, new Point(Constants.EXIT_RAW, 0)));
		vehicles.put('B', TestsUtils.getVehicle('B', Constants.VERTICAL, 2,
				new Point(Constants.EXIT_RAW - 1, Constants.BOARD_SIZE)));
		vehicles.put('B', TestsUtils.getVehicle('C', Constants.HORIZONTAL, 2, new Point(Constants.EXIT_RAW, 3)));
		int puzzleID = 1;
		AStarSearchNode currentSearchNode = new AStarSearchNode(Collections.emptyList(), vehicles, puzzleID, 2, 0, 0,
				calculator);
		assertFalse(currentSearchNode.isGoalNode());
	}
}
