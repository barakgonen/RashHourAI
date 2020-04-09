package tests;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

		// First successor
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
		firstSuccessorVehiclesMap.put('O',
				TestsUtils.getVehicle('O', Constants.VERTICAL, 3, new Point(0, 0), new Point(2, 0)));
		firstSuccessorVehiclesMap.put('P',
				TestsUtils.getVehicle('P', Constants.HORIZONTAL, 3, new Point(0, 1), new Point(0, 3)));
		firstSuccessorVehiclesMap.put('E',
				TestsUtils.getVehicle('E', Constants.VERTICAL, 2, new Point(4, 2), new Point(5, 2)));
		firstSuccessorVehiclesMap.put('G',
				TestsUtils.getVehicle('G', Constants.HORIZONTAL, 2, new Point(5, 0), new Point(5, 1)));
		firstSuccessorVehiclesMap.put('Q',
				TestsUtils.getVehicle('Q', Constants.VERTICAL, 3, new Point(1, 5), new Point(3, 5)));
		firstSuccessorVehiclesMap.put('X',
				TestsUtils.getVehicle('X', Constants.HORIZONTAL, 2, new Point(2, 2), new Point(2, 3)));
		firstSuccessorVehiclesMap.put('B',
				TestsUtils.getVehicle('B', Constants.VERTICAL, 2, new Point(1, 1), new Point(2, 1)));
		firstSuccessorVehiclesMap.put('R',
				TestsUtils.getVehicle('R', Constants.HORIZONTAL, 3, new Point(3, 0), new Point(3, 2)));
		firstSuccessorVehiclesMap.put('F',
				TestsUtils.getVehicle('F', Constants.HORIZONTAL, 2, new Point(4, 4), new Point(4, 5)));
		firstSuccessorVehiclesMap.put('A',
				TestsUtils.getVehicle('A', Constants.HORIZONTAL, 2, new Point(0, 4), new Point(0, 5)));
		firstSuccessorVehiclesMap.put('C',
				TestsUtils.getVehicle('C', Constants.HORIZONTAL, 2, new Point(1, 2), new Point(1, 3)));
		firstSuccessorVehiclesMap.put('D',
				TestsUtils.getVehicle('D', Constants.VERTICAL, 2, new Point(4, 3), new Point(5, 3)));

		AStarSearchNode firstSuccessor = new AStarSearchNode(firstSuccessorExpectedEmptySpots,
				firstSuccessorVehiclesMap, puzzleID, 1);

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
		secondSuccessorVehiclesMap.put('A',
				TestsUtils.getVehicle('A', Constants.HORIZONTAL, 2, new Point(0, 4), new Point(0, 5)));
		secondSuccessorVehiclesMap.put('C',
				TestsUtils.getVehicle('C', Constants.HORIZONTAL, 2, new Point(1, 3), new Point(1, 4)));
		secondSuccessorVehiclesMap.put('D',
				TestsUtils.getVehicle('D', Constants.VERTICAL, 2, new Point(3, 3), new Point(4, 3)));

		AStarSearchNode secondSuccessor = new AStarSearchNode(secondSuccessorExpectedEmptySpots,
				secondSuccessorVehiclesMap, puzzleID, 2);

		// Third Successor
		Set<Point> thirdSuccessorExpectedEmptySpots = new HashSet<>();
		thirdSuccessorExpectedEmptySpots.add(new Point(1, 4));
		thirdSuccessorExpectedEmptySpots.add(new Point(2, 2));
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
		thirdSuccessorVehiclesMap.put('A',
				TestsUtils.getVehicle('A', Constants.HORIZONTAL, 2, new Point(0, 4), new Point(0, 5)));
		thirdSuccessorVehiclesMap.put('C',
				TestsUtils.getVehicle('C', Constants.HORIZONTAL, 2, new Point(1, 2), new Point(1, 3)));
		thirdSuccessorVehiclesMap.put('D',
				TestsUtils.getVehicle('D', Constants.VERTICAL, 2, new Point(3, 3), new Point(4, 3)));

		AStarSearchNode thirdtSuccessor = new AStarSearchNode(thirdSuccessorExpectedEmptySpots,
				thirdSuccessorVehiclesMap, puzzleID, 3);

		successors.add(firstSuccessor);
		successors.add(secondSuccessor);
		successors.add(thirdtSuccessor);
		return successors;
	}

	@Before
	public void SetUp() {
		rawPuzzleObject = new RawPuzzleObject(puzzleAsString, puzzleID);
		searchNode = new AStarSearchNode(rawPuzzleObject);
	}

	@Test
	public void testGetVehicleIdentifierByPoint() {
		assertEquals((char) 'O', (char) searchNode.getCarIdentifier(new Point(0, 0)));
		assertEquals((char) 'P', (char) searchNode.getCarIdentifier(new Point(0, 1)));
		assertEquals((char) 'P', (char) searchNode.getCarIdentifier(new Point(0, 2)));
		assertEquals((char) 'P', (char) searchNode.getCarIdentifier(new Point(0, 3)));
		assertEquals((char) 'A', (char) searchNode.getCarIdentifier(new Point(0, 4)));
		assertEquals((char) 'A', (char) searchNode.getCarIdentifier(new Point(0, 5)));
		assertEquals((char) 'O', (char) searchNode.getCarIdentifier(new Point(1, 0)));
		assertEquals((char) 'B', (char) searchNode.getCarIdentifier(new Point(1, 1)));
		assertEquals((char) 'C', (char) searchNode.getCarIdentifier(new Point(1, 2)));
		assertEquals((char) 'C', (char) searchNode.getCarIdentifier(new Point(1, 3)));
		assertEquals((char) Constants.UKNOWN_IDENTIFIER, (char) searchNode.getCarIdentifier(new Point(1, 4)));
		assertEquals((char) 'Q', (char) searchNode.getCarIdentifier(new Point(1, 5)));
		assertEquals((char) 'O', (char) searchNode.getCarIdentifier(new Point(2, 0)));
		assertEquals((char) 'B', (char) searchNode.getCarIdentifier(new Point(2, 1)));
		assertEquals((char) 'X', (char) searchNode.getCarIdentifier(new Point(2, 2)));
		assertEquals((char) 'X', (char) searchNode.getCarIdentifier(new Point(2, 3)));
		assertEquals((char) Constants.UKNOWN_IDENTIFIER, (char) searchNode.getCarIdentifier(new Point(2, 4)));
		assertEquals((char) 'Q', (char) searchNode.getCarIdentifier(new Point(2, 5)));
		assertEquals((char) 'R', (char) searchNode.getCarIdentifier(new Point(3, 0)));
		assertEquals((char) 'R', (char) searchNode.getCarIdentifier(new Point(3, 1)));
		assertEquals((char) 'R', (char) searchNode.getCarIdentifier(new Point(3, 2)));
		assertEquals((char) 'D', (char) searchNode.getCarIdentifier(new Point(3, 3)));
		assertEquals((char) Constants.UKNOWN_IDENTIFIER, (char) searchNode.getCarIdentifier(new Point(3, 4)));
		assertEquals((char) 'Q', (char) searchNode.getCarIdentifier(new Point(3, 5)));
		assertEquals((char) Constants.UKNOWN_IDENTIFIER, (char) searchNode.getCarIdentifier(new Point(4, 0)));
		assertEquals((char) Constants.UKNOWN_IDENTIFIER, (char) searchNode.getCarIdentifier(new Point(4, 1)));
		assertEquals((char) 'E', (char) searchNode.getCarIdentifier(new Point(4, 2)));
		assertEquals((char) 'D', (char) searchNode.getCarIdentifier(new Point(4, 3)));
		assertEquals((char) 'F', (char) searchNode.getCarIdentifier(new Point(4, 4)));
		assertEquals((char) 'F', (char) searchNode.getCarIdentifier(new Point(4, 5)));
		assertEquals((char) 'G', (char) searchNode.getCarIdentifier(new Point(5, 0)));
		assertEquals((char) 'G', (char) searchNode.getCarIdentifier(new Point(5, 1)));
		assertEquals((char) 'E', (char) searchNode.getCarIdentifier(new Point(5, 2)));
		assertEquals((char) Constants.UKNOWN_IDENTIFIER, (char) searchNode.getCarIdentifier(new Point(5, 3)));
		assertEquals((char) Constants.UKNOWN_IDENTIFIER, (char) searchNode.getCarIdentifier(new Point(5, 4)));
		assertEquals((char) Constants.UKNOWN_IDENTIFIER, (char) searchNode.getCarIdentifier(new Point(5, 5)));
	}

	@Test
	public void testGetNorthestNeighbor() {
		assertEquals('A', (char) searchNode.getNorthestNeighbor(new Point(1, 4)));
		assertEquals('A', (char) searchNode.getNorthestNeighbor(new Point(2, 4)));
		assertEquals('A', (char) searchNode.getNorthestNeighbor(new Point(3, 4)));
		assertEquals('D', (char) searchNode.getNorthestNeighbor(new Point(5, 3)));
		assertEquals('F', (char) searchNode.getNorthestNeighbor(new Point(5, 4)));
		assertEquals('F', (char) searchNode.getNorthestNeighbor(new Point(5, 5)));
		assertEquals('R', (char) searchNode.getNorthestNeighbor(new Point(4, 0)));
		assertEquals('R', (char) searchNode.getNorthestNeighbor(new Point(4, 1)));
	}

	@Test
	public void testGetSouthestNeighbor() {
		assertEquals('F', (char) searchNode.getSouthestNeighbor(new Point(1, 4)));
		assertEquals('F', (char) searchNode.getSouthestNeighbor(new Point(2, 4)));
		assertEquals('F', (char) searchNode.getSouthestNeighbor(new Point(3, 4)));
		assertEquals(Constants.UKNOWN_IDENTIFIER, searchNode.getSouthestNeighbor(new Point(5, 3)));
		assertEquals(Constants.UKNOWN_IDENTIFIER, searchNode.getSouthestNeighbor(new Point(5, 4)));
		assertEquals(Constants.UKNOWN_IDENTIFIER, searchNode.getSouthestNeighbor(new Point(5, 5)));
		assertEquals('G', (char) searchNode.getSouthestNeighbor(new Point(4, 0)));
		assertEquals('G', (char) searchNode.getSouthestNeighbor(new Point(4, 1)));
	}

	@Test
	public void testGetEastesttNeighbor() {
		assertEquals('Q', (char) searchNode.getEastestNeighbor(new Point(1, 4)));
		assertEquals('Q', (char) searchNode.getEastestNeighbor(new Point(2, 4)));
		assertEquals('Q', (char) searchNode.getEastestNeighbor(new Point(3, 4)));
		assertEquals(Constants.UKNOWN_IDENTIFIER, searchNode.getEastestNeighbor(new Point(5, 3)));
		assertEquals(Constants.UKNOWN_IDENTIFIER, searchNode.getEastestNeighbor(new Point(5, 4)));
		assertEquals(Constants.UKNOWN_IDENTIFIER, searchNode.getEastestNeighbor(new Point(5, 5)));
		assertEquals('E', (char) searchNode.getEastestNeighbor(new Point(4, 0)));
		assertEquals('E', (char) searchNode.getEastestNeighbor(new Point(4, 1)));
	}

	@Test
	public void testGetWestestttNeighbor() {
		assertEquals('C', (char) searchNode.getWestestNeighbor(new Point(1, 4)));
		assertEquals('X', (char) searchNode.getWestestNeighbor(new Point(2, 4)));
		assertEquals('D', (char) searchNode.getWestestNeighbor(new Point(3, 4)));
		assertEquals('E', (char) searchNode.getWestestNeighbor(new Point(5, 3)));
		assertEquals('E', (char) searchNode.getWestestNeighbor(new Point(5, 4)));
		assertEquals('E', (char) searchNode.getWestestNeighbor(new Point(5, 5)));
		assertEquals(Constants.UKNOWN_IDENTIFIER, searchNode.getWestestNeighbor(new Point(4, 0)));
		assertEquals(Constants.UKNOWN_IDENTIFIER, searchNode.getWestestNeighbor(new Point(4, 1)));
	}

	@Test
	public void testGeneratingExpectedNumberOfSuccessors() {
		// This code should be long and "not smart", we manually generate successors for
		// a specific state - start node of specific puzzle
		assertEquals(3, searchNode.getSuccessors().size());
	}

	@Test
	public void testGeneratingSuccessorsForSpecificCaseAsExpected() {
		// This code should be long and "not smart", we manually generate successors for
		// a specific state - start node of specific puzzle
		List<AStarSearchNode> expectedSuccessors = getSuccessors().stream().collect(Collectors.toList());
		expectedSuccessors.sort(Comparator.comparing(AStarSearchNode::getSuccessorIndex));

		List<AStarSearchNode> actualSuccessors = searchNode.getSuccessors().stream().collect(Collectors.toList());
		actualSuccessors.sort(Comparator.comparing(AStarSearchNode::getSuccessorIndex));

		assertEquals(expectedSuccessors, actualSuccessors);
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
