package tests;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import rush_hour.Constants;
import rush_hour.RawPuzzleObject;
import rush_hour.Vehicle;
import search_engine.astar.AStarSearchNode;

public class TestSuccessor {

	private String puzzleAsString = "OPPPAAOBCC.QOBXX.QRRRD.Q..EDFFGGE...";
	private RawPuzzleObject rawPuzzleObject;
	private AStarSearchNode searchNode;
	private final int puzzleID = 2;

	private Set<AStarSearchNode> getSuccessors() {
		Set<AStarSearchNode> successors = new HashSet<>();

		// Collection<Point> emptySpots, HashMap<Character, Vehicle> vehicles
		// First successor
		Set<Point> firstSuccessorExpectedEmptySpots = new HashSet<>();
		firstSuccessorExpectedEmptySpots.add(new Point(4, 0));
		firstSuccessorExpectedEmptySpots.add(new Point(4, 1));
		firstSuccessorExpectedEmptySpots.add(new Point(1, 5));
		firstSuccessorExpectedEmptySpots.add(new Point(2, 5));
		firstSuccessorExpectedEmptySpots.add(new Point(3, 5));
		firstSuccessorExpectedEmptySpots.add(new Point(5, 3));
		firstSuccessorExpectedEmptySpots.add(new Point(5, 4));
		firstSuccessorExpectedEmptySpots.add(new Point(5, 5));
		HashMap<Character, Vehicle> firstSuccessorVehiclesMap = new HashMap<>();
		firstSuccessorVehiclesMap.put('O',
				TestsUtils.getVehicle('O', Constants.VERTICAL, 3, new Point(0, 0), new Point(2, 0)));
		firstSuccessorVehiclesMap.put('P',
				TestsUtils.getVehicle('P', Constants.HORIZONTAL, 3, new Point(0, 1), new Point(0, 3)));
		firstSuccessorVehiclesMap.put('E',
				TestsUtils.getVehicle('E', Constants.VERTICAL, 2, new Point(4, 2), new Point(5, 2)));
		firstSuccessorVehiclesMap.put('G',
				TestsUtils.getVehicle('G', Constants.HORIZONTAL, 2, new Point(5, 0), new Point(5, 1)));
		firstSuccessorVehiclesMap.put('Q',
				TestsUtils.getVehicle('Q', Constants.VERTICAL, 3, new Point(1, 4), new Point(3, 4)));
		firstSuccessorVehiclesMap.put('X',
				TestsUtils.getVehicle('X', Constants.HORIZONTAL, 2, new Point(2, 2), new Point(2, 3)));
		firstSuccessorVehiclesMap.put('B',
				TestsUtils.getVehicle('B', Constants.VERTICAL, 2, new Point(1, 1), new Point(2, 1)));
		firstSuccessorVehiclesMap.put('R',
				TestsUtils.getVehicle('R', Constants.HORIZONTAL, 3, new Point(3, 0), new Point(3, 2)));
		firstSuccessorVehiclesMap.put('F',
				TestsUtils.getVehicle('F', Constants.HORIZONTAL, 2, new Point(4, 4), new Point(4, 5)));
		firstSuccessorVehiclesMap.put('D',
				TestsUtils.getVehicle('D', Constants.VERTICAL, 2, new Point(3, 3), new Point(4, 3)));
		firstSuccessorVehiclesMap.put('C',
				TestsUtils.getVehicle('C', Constants.HORIZONTAL, 2, new Point(1, 2), new Point(1, 3)));
		firstSuccessorVehiclesMap.put('A',
				TestsUtils.getVehicle('A', Constants.HORIZONTAL, 2, new Point(0, 4), new Point(0, 5)));

		AStarSearchNode firstSuccessor = new AStarSearchNode(firstSuccessorExpectedEmptySpots,
				firstSuccessorVehiclesMap, puzzleID);

		// Second Successor
		Set<Point> secondSuccessorExpectedEmptySpots = new HashSet<>();
		secondSuccessorExpectedEmptySpots.add(new Point(1, 2));
		secondSuccessorExpectedEmptySpots.add(new Point(2, 4));
		secondSuccessorExpectedEmptySpots.add(new Point(3, 4));
		secondSuccessorExpectedEmptySpots.add(new Point(4, 0));
		secondSuccessorExpectedEmptySpots.add(new Point(4, 1));
		secondSuccessorExpectedEmptySpots.add(new Point(5, 3));
		secondSuccessorExpectedEmptySpots.add(new Point(5, 4));
		secondSuccessorExpectedEmptySpots.add(new Point(5, 5));
		HashMap<Character, Vehicle> secondSuccessorVehiclesMap = new HashMap<>();
		secondSuccessorVehiclesMap.put('O',
				TestsUtils.getVehicle('O', Constants.VERTICAL, 3, new Point(0, 0), new Point(2, 0)));
		secondSuccessorVehiclesMap.put('P',
				TestsUtils.getVehicle('P', Constants.HORIZONTAL, 3, new Point(0, 1), new Point(0, 3)));
		secondSuccessorVehiclesMap.put('E',
				TestsUtils.getVehicle('E', Constants.VERTICAL, 2, new Point(4, 2), new Point(5, 2)));
		secondSuccessorVehiclesMap.put('G',
				TestsUtils.getVehicle('G', Constants.HORIZONTAL, 2, new Point(5, 0), new Point(5, 1)));
		secondSuccessorVehiclesMap.put('Q',
				TestsUtils.getVehicle('Q', Constants.VERTICAL, 3, new Point(1, 5), new Point(3, 5)));
		secondSuccessorVehiclesMap.put('X',
				TestsUtils.getVehicle('X', Constants.HORIZONTAL, 2, new Point(2, 2), new Point(2, 3)));
		secondSuccessorVehiclesMap.put('B',
				TestsUtils.getVehicle('B', Constants.VERTICAL, 2, new Point(1, 1), new Point(2, 1)));
		secondSuccessorVehiclesMap.put('R',
				TestsUtils.getVehicle('R', Constants.HORIZONTAL, 3, new Point(3, 0), new Point(3, 2)));
		secondSuccessorVehiclesMap.put('F',
				TestsUtils.getVehicle('F', Constants.HORIZONTAL, 2, new Point(4, 4), new Point(4, 5)));
		secondSuccessorVehiclesMap.put('D',
				TestsUtils.getVehicle('D', Constants.VERTICAL, 2, new Point(3, 3), new Point(4, 3)));
		secondSuccessorVehiclesMap.put('C',
				TestsUtils.getVehicle('C', Constants.HORIZONTAL, 2, new Point(1, 3), new Point(1, 4)));
		secondSuccessorVehiclesMap.put('A',
				TestsUtils.getVehicle('A', Constants.HORIZONTAL, 2, new Point(0, 4), new Point(0, 5)));

		AStarSearchNode secondSuccessor = new AStarSearchNode(secondSuccessorExpectedEmptySpots,
				secondSuccessorVehiclesMap, puzzleID);

		// Third Successor
		Set<Point> thirdSuccessorExpectedEmptySpots = new HashSet<>();
		thirdSuccessorExpectedEmptySpots.add(new Point(2, 2));
		thirdSuccessorExpectedEmptySpots.add(new Point(1, 4));
		thirdSuccessorExpectedEmptySpots.add(new Point(3, 4));
		thirdSuccessorExpectedEmptySpots.add(new Point(4, 0));
		thirdSuccessorExpectedEmptySpots.add(new Point(4, 1));
		thirdSuccessorExpectedEmptySpots.add(new Point(5, 3));
		thirdSuccessorExpectedEmptySpots.add(new Point(5, 4));
		thirdSuccessorExpectedEmptySpots.add(new Point(5, 5));
		HashMap<Character, Vehicle> thirdSuccessorVehiclesMap = new HashMap<>();
		thirdSuccessorVehiclesMap.put('O',
				TestsUtils.getVehicle('O', Constants.VERTICAL, 3, new Point(0, 0), new Point(2, 0)));
		thirdSuccessorVehiclesMap.put('P',
				TestsUtils.getVehicle('P', Constants.HORIZONTAL, 3, new Point(0, 1), new Point(0, 3)));
		thirdSuccessorVehiclesMap.put('E',
				TestsUtils.getVehicle('E', Constants.VERTICAL, 2, new Point(4, 2), new Point(5, 2)));
		thirdSuccessorVehiclesMap.put('G',
				TestsUtils.getVehicle('G', Constants.HORIZONTAL, 2, new Point(5, 0), new Point(5, 1)));
		thirdSuccessorVehiclesMap.put('Q',
				TestsUtils.getVehicle('Q', Constants.VERTICAL, 3, new Point(1, 5), new Point(3, 5)));
		thirdSuccessorVehiclesMap.put('X',
				TestsUtils.getVehicle('X', Constants.HORIZONTAL, 2, new Point(2, 3), new Point(2, 4)));
		thirdSuccessorVehiclesMap.put('B',
				TestsUtils.getVehicle('B', Constants.VERTICAL, 2, new Point(1, 1), new Point(2, 1)));
		thirdSuccessorVehiclesMap.put('R',
				TestsUtils.getVehicle('R', Constants.HORIZONTAL, 3, new Point(3, 0), new Point(3, 2)));
		thirdSuccessorVehiclesMap.put('F',
				TestsUtils.getVehicle('F', Constants.HORIZONTAL, 2, new Point(4, 4), new Point(4, 5)));
		thirdSuccessorVehiclesMap.put('D',
				TestsUtils.getVehicle('D', Constants.VERTICAL, 2, new Point(3, 3), new Point(4, 3)));
		thirdSuccessorVehiclesMap.put('C',
				TestsUtils.getVehicle('C', Constants.HORIZONTAL, 2, new Point(1, 2), new Point(1, 3)));
		thirdSuccessorVehiclesMap.put('A',
				TestsUtils.getVehicle('A', Constants.HORIZONTAL, 2, new Point(0, 4), new Point(0, 5)));

		AStarSearchNode thirdtSuccessor = new AStarSearchNode(thirdSuccessorExpectedEmptySpots,
				thirdSuccessorVehiclesMap, puzzleID);

		// Forth Successor
		Set<Point> forthSuccessorExpectedEmptySpots = new HashSet<>();
		forthSuccessorExpectedEmptySpots.add(new Point(4, 0));
		forthSuccessorExpectedEmptySpots.add(new Point(4, 1));
		forthSuccessorExpectedEmptySpots.add(new Point(1, 4));
		forthSuccessorExpectedEmptySpots.add(new Point(2, 4));
		forthSuccessorExpectedEmptySpots.add(new Point(3, 4));
		forthSuccessorExpectedEmptySpots.add(new Point(3, 3));
		forthSuccessorExpectedEmptySpots.add(new Point(5, 4));
		forthSuccessorExpectedEmptySpots.add(new Point(5, 5));
		HashMap<Character, Vehicle> forthSuccessorVehiclesMap = new HashMap<>();
		forthSuccessorVehiclesMap.put('O',
				TestsUtils.getVehicle('O', Constants.VERTICAL, 3, new Point(0, 0), new Point(2, 0)));
		forthSuccessorVehiclesMap.put('P',
				TestsUtils.getVehicle('P', Constants.HORIZONTAL, 3, new Point(0, 1), new Point(0, 3)));
		forthSuccessorVehiclesMap.put('E',
				TestsUtils.getVehicle('E', Constants.VERTICAL, 2, new Point(4, 2), new Point(5, 2)));
		forthSuccessorVehiclesMap.put('G',
				TestsUtils.getVehicle('G', Constants.HORIZONTAL, 2, new Point(5, 0), new Point(5, 1)));
		forthSuccessorVehiclesMap.put('Q',
				TestsUtils.getVehicle('Q', Constants.VERTICAL, 3, new Point(1, 5), new Point(3, 5)));
		forthSuccessorVehiclesMap.put('X',
				TestsUtils.getVehicle('X', Constants.HORIZONTAL, 2, new Point(2, 2), new Point(2, 3)));
		forthSuccessorVehiclesMap.put('B',
				TestsUtils.getVehicle('B', Constants.VERTICAL, 2, new Point(1, 1), new Point(2, 1)));
		forthSuccessorVehiclesMap.put('R',
				TestsUtils.getVehicle('R', Constants.HORIZONTAL, 3, new Point(3, 0), new Point(3, 2)));
		forthSuccessorVehiclesMap.put('F',
				TestsUtils.getVehicle('F', Constants.HORIZONTAL, 2, new Point(4, 4), new Point(4, 5)));
		forthSuccessorVehiclesMap.put('D',
				TestsUtils.getVehicle('D', Constants.VERTICAL, 2, new Point(4, 3), new Point(5, 3)));
		forthSuccessorVehiclesMap.put('C',
				TestsUtils.getVehicle('C', Constants.HORIZONTAL, 2, new Point(1, 2), new Point(1, 3)));
		forthSuccessorVehiclesMap.put('A',
				TestsUtils.getVehicle('A', Constants.HORIZONTAL, 2, new Point(0, 4), new Point(0, 5)));

		AStarSearchNode forthSuccessor = new AStarSearchNode(forthSuccessorExpectedEmptySpots,
				forthSuccessorVehiclesMap, puzzleID);

		successors.add(firstSuccessor);
		successors.add(secondSuccessor);
		successors.add(thirdtSuccessor);
		successors.add(forthSuccessor);
		return successors;
	}

	@Before
	public void SetUp() {
		rawPuzzleObject = new RawPuzzleObject(puzzleAsString, puzzleID);
		searchNode = new AStarSearchNode(rawPuzzleObject);
	}

	@Test
	public void testGeneratingExpectedNumberOfSuccessors() {
		// This code should be long and "not smart", we manually generate successors for
		// a specific state - start node of specific puzzle
		assertEquals(4, searchNode.getSuccessors().size());
	}

	@Test
	public void testGeneratingSuccessorsForSpecificCaseAsExpected() {
		// This code should be long and "not smart", we manually generate successors for
		// a specific state - start node of specific puzzle
		assertEquals(getSuccessors(), searchNode.getSuccessors());
	}

	@Test
	public void testGenerationOfTargetVehiclePath() {
		ArrayList<Point> exitPath = new ArrayList<>();
		exitPath.add(new Point(2, 0));
		exitPath.add(new Point(2, 1));
		exitPath.add(new Point(2, 2));
		exitPath.add(new Point(2, 3));
		exitPath.add(new Point(2, 4));
		exitPath.add(new Point(2, 5));
		assertEquals(exitPath, Constants.TARGET_VEHICLE_EXIT_PATH);
	}
}
