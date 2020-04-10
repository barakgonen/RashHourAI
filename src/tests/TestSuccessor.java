package tests;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
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
		Set<Point> firstSuccExpEmpPnts = new HashSet<>();
		firstSuccExpEmpPnts.add(new Point(4, 0));
		firstSuccExpEmpPnts.add(new Point(4, 1));
		firstSuccExpEmpPnts.add(new Point(1, 4));
		firstSuccExpEmpPnts.add(new Point(2, 4));
		firstSuccExpEmpPnts.add(new Point(3, 4));
		firstSuccExpEmpPnts.add(new Point(3, 3));
		firstSuccExpEmpPnts.add(new Point(5, 4));
		firstSuccExpEmpPnts.add(new Point(5, 5));
		HashMap<Character, Vehicle> firstSuccExpVhcMap = new HashMap<>();
		firstSuccExpVhcMap.put('O', TestsUtils.getVehicle('O', Constants.VERTICAL, 3, new Point(0, 0)));
		firstSuccExpVhcMap.put('P', TestsUtils.getVehicle('P', Constants.HORIZONTAL, 3, new Point(0, 1)));
		firstSuccExpVhcMap.put('E', TestsUtils.getVehicle('E', Constants.VERTICAL, 2, new Point(4, 2)));
		firstSuccExpVhcMap.put('G', TestsUtils.getVehicle('G', Constants.HORIZONTAL, 2, new Point(5, 0)));
		firstSuccExpVhcMap.put('Q', TestsUtils.getVehicle('Q', Constants.VERTICAL, 3, new Point(1, 5)));
		firstSuccExpVhcMap.put('X', TestsUtils.getVehicle('X', Constants.HORIZONTAL, 2, new Point(2, 2)));
		firstSuccExpVhcMap.put('B', TestsUtils.getVehicle('B', Constants.VERTICAL, 2, new Point(1, 1)));
		firstSuccExpVhcMap.put('R', TestsUtils.getVehicle('R', Constants.HORIZONTAL, 3, new Point(3, 0)));
		firstSuccExpVhcMap.put('F', TestsUtils.getVehicle('F', Constants.HORIZONTAL, 2, new Point(4, 4)));
		firstSuccExpVhcMap.put('A', TestsUtils.getVehicle('A', Constants.HORIZONTAL, 2, new Point(0, 4)));
		firstSuccExpVhcMap.put('C', TestsUtils.getVehicle('C', Constants.HORIZONTAL, 2, new Point(1, 2)));
		firstSuccExpVhcMap.put('D', TestsUtils.getVehicle('D', Constants.VERTICAL, 2, new Point(4, 3)));

		AStarSearchNode firstSuccessor = new AStarSearchNode(firstSuccExpEmpPnts, firstSuccExpVhcMap, puzzleID, 1, 1,
				1);

		// Second Successor
		Set<Point> secSuccExpEmpPnts = new HashSet<>();
		secSuccExpEmpPnts.add(new Point(1, 2));
		secSuccExpEmpPnts.add(new Point(2, 4));
		secSuccExpEmpPnts.add(new Point(3, 4));
		secSuccExpEmpPnts.add(new Point(4, 0));
		secSuccExpEmpPnts.add(new Point(4, 1));
		secSuccExpEmpPnts.add(new Point(5, 3));
		secSuccExpEmpPnts.add(new Point(5, 4));
		secSuccExpEmpPnts.add(new Point(5, 5));
		HashMap<Character, Vehicle> secSuccExpVhcMap = new HashMap<>();
		secSuccExpVhcMap.put('O', TestsUtils.getVehicle('O', Constants.VERTICAL, 3, new Point(0, 0)));
		secSuccExpVhcMap.put('P', TestsUtils.getVehicle('P', Constants.HORIZONTAL, 3, new Point(0, 1)));
		secSuccExpVhcMap.put('E', TestsUtils.getVehicle('E', Constants.VERTICAL, 2, new Point(4, 2)));
		secSuccExpVhcMap.put('G', TestsUtils.getVehicle('G', Constants.HORIZONTAL, 2, new Point(5, 0)));
		secSuccExpVhcMap.put('Q', TestsUtils.getVehicle('Q', Constants.VERTICAL, 3, new Point(1, 5)));
		secSuccExpVhcMap.put('X', TestsUtils.getVehicle('X', Constants.HORIZONTAL, 2, new Point(2, 2)));
		secSuccExpVhcMap.put('B', TestsUtils.getVehicle('B', Constants.VERTICAL, 2, new Point(1, 1)));
		secSuccExpVhcMap.put('R', TestsUtils.getVehicle('R', Constants.HORIZONTAL, 3, new Point(3, 0)));
		secSuccExpVhcMap.put('F', TestsUtils.getVehicle('F', Constants.HORIZONTAL, 2, new Point(4, 4)));
		secSuccExpVhcMap.put('A', TestsUtils.getVehicle('A', Constants.HORIZONTAL, 2, new Point(0, 4)));
		secSuccExpVhcMap.put('C', TestsUtils.getVehicle('C', Constants.HORIZONTAL, 2, new Point(1, 3)));
		secSuccExpVhcMap.put('D', TestsUtils.getVehicle('D', Constants.VERTICAL, 2, new Point(3, 3)));

		AStarSearchNode secondSuccessor = new AStarSearchNode(secSuccExpEmpPnts, secSuccExpVhcMap, puzzleID, 2, 1, 1);

		// Third Successor
		Set<Point> thrdSuccExpEmpPnts = new HashSet<>();
		thrdSuccExpEmpPnts.add(new Point(1, 4));
		thrdSuccExpEmpPnts.add(new Point(2, 2));
		thrdSuccExpEmpPnts.add(new Point(3, 4));
		thrdSuccExpEmpPnts.add(new Point(4, 0));
		thrdSuccExpEmpPnts.add(new Point(4, 1));
		thrdSuccExpEmpPnts.add(new Point(5, 3));
		thrdSuccExpEmpPnts.add(new Point(5, 4));
		thrdSuccExpEmpPnts.add(new Point(5, 5));
		HashMap<Character, Vehicle> thrdSuccExpVhcMap = new HashMap<>();
		thrdSuccExpVhcMap.put('O', TestsUtils.getVehicle('O', Constants.VERTICAL, 3, new Point(0, 0)));
		thrdSuccExpVhcMap.put('P', TestsUtils.getVehicle('P', Constants.HORIZONTAL, 3, new Point(0, 1)));
		thrdSuccExpVhcMap.put('E', TestsUtils.getVehicle('E', Constants.VERTICAL, 2, new Point(4, 2)));
		thrdSuccExpVhcMap.put('G', TestsUtils.getVehicle('G', Constants.HORIZONTAL, 2, new Point(5, 0)));
		thrdSuccExpVhcMap.put('Q', TestsUtils.getVehicle('Q', Constants.VERTICAL, 3, new Point(1, 5)));
		thrdSuccExpVhcMap.put('X', TestsUtils.getVehicle('X', Constants.HORIZONTAL, 2, new Point(2, 3)));
		thrdSuccExpVhcMap.put('B', TestsUtils.getVehicle('B', Constants.VERTICAL, 2, new Point(1, 1)));
		thrdSuccExpVhcMap.put('R', TestsUtils.getVehicle('R', Constants.HORIZONTAL, 3, new Point(3, 0)));
		thrdSuccExpVhcMap.put('F', TestsUtils.getVehicle('F', Constants.HORIZONTAL, 2, new Point(4, 4)));
		thrdSuccExpVhcMap.put('A', TestsUtils.getVehicle('A', Constants.HORIZONTAL, 2, new Point(0, 4)));
		thrdSuccExpVhcMap.put('C', TestsUtils.getVehicle('C', Constants.HORIZONTAL, 2, new Point(1, 2)));
		thrdSuccExpVhcMap.put('D', TestsUtils.getVehicle('D', Constants.VERTICAL, 2, new Point(3, 3)));

		AStarSearchNode thirdtSuccessor = new AStarSearchNode(thrdSuccExpEmpPnts, thrdSuccExpVhcMap, puzzleID, 3, 1, 1);

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
	public void testMovingOneStepEast() {
		List<Point> expectedEmptySpots = searchNode.getEmptySpots().stream().collect(Collectors.toList());
		AStarSearchNode actualNextStep = searchNode.getNextState('X', new Point(2, 4), 1);
		List<Point> actualEmptySpots = actualNextStep.getEmptySpots().stream().collect(Collectors.toList());
		actualEmptySpots.sort(Comparator.comparingDouble(p -> p.distance(0, 0)));

		expectedEmptySpots.remove(new Point(2, 4));
		expectedEmptySpots.add(new Point(2, 2));
		expectedEmptySpots.sort(Comparator.comparingDouble(p -> p.distance(0, 0)));
		assertEquals(expectedEmptySpots, actualEmptySpots);
		assertEquals(new Point(2, 3), actualNextStep.getVehicleByID('X').getStartPos());
		assertEquals(new Point(2, 4), actualNextStep.getVehicleByID('X').getEndPos());

		expectedEmptySpots = searchNode.getEmptySpots().stream().collect(Collectors.toList());
		actualNextStep = searchNode.getNextState('C', new Point(1, 4), 1);
		actualEmptySpots = actualNextStep.getEmptySpots().stream().collect(Collectors.toList());
		actualEmptySpots.sort(Comparator.comparingDouble(p -> p.distance(0, 0)));

		expectedEmptySpots.remove(new Point(1, 4));
		expectedEmptySpots.add(new Point(1, 2));
		expectedEmptySpots.sort(Comparator.comparingDouble(p -> p.distance(0, 0)));
		assertEquals(expectedEmptySpots, actualEmptySpots);
		assertEquals(new Point(1, 3), actualNextStep.getVehicleByID('C').getStartPos());
		assertEquals(new Point(1, 4), actualNextStep.getVehicleByID('C').getEndPos());
	}

	@Test
	public void testMovingOneStepWest() {
		rawPuzzleObject = new RawPuzzleObject("..ABB...A.J..DXXJ..DEEF..OOOF.......", 2);
		searchNode = new AStarSearchNode(rawPuzzleObject);

		List<Point> expectedEmptySpots = searchNode.getEmptySpots().stream().collect(Collectors.toList());
		expectedEmptySpots.add(new Point(4, 3));
		expectedEmptySpots.remove(new Point(4, 0));

		AStarSearchNode actualNextStep = searchNode.getNextState('O', new Point(4, 0), 1);
		List<Point> actualEmptySpots = actualNextStep.getEmptySpots().stream().collect(Collectors.toList());

		TestsUtils.compareListCollections(expectedEmptySpots, actualEmptySpots);

		assertEquals(new Point(4, 0), actualNextStep.getVehicleByID('O').getStartPos());
		assertEquals(new Point(4, 2), actualNextStep.getVehicleByID('O').getEndPos());
	}

	@Test
	public void testMovingOneStepNorth() {
		rawPuzzleObject = new RawPuzzleObject("..ABB...A.J..DXXJ..DEEF..OOOF.......", 2);
		searchNode = new AStarSearchNode(rawPuzzleObject);

		List<Point> expectedEmptySpots = searchNode.getEmptySpots().stream().collect(Collectors.toList());
		expectedEmptySpots.remove(new Point(0, 1));
		expectedEmptySpots.remove(new Point(1, 1));
		expectedEmptySpots.add(new Point(2, 1));
		expectedEmptySpots.add(new Point(3, 1));

		AStarSearchNode actualNextStep = searchNode.getNextState('D', new Point(0, 1), 1);
		List<Point> actualEmptySpots = actualNextStep.getEmptySpots().stream().collect(Collectors.toList());

		TestsUtils.compareListCollections(expectedEmptySpots, actualEmptySpots);

		assertEquals(new Point(0, 1), actualNextStep.getVehicleByID('D').getStartPos());
		assertEquals(new Point(1, 1), actualNextStep.getVehicleByID('D').getEndPos());
	}

	@Test
	public void testMovingOneStepSouth() {
		List<Point> expectedEmptySpots = searchNode.getEmptySpots().stream().collect(Collectors.toList());
		expectedEmptySpots.remove(new Point(5, 3));
		expectedEmptySpots.add(new Point(3, 3));

		AStarSearchNode actualNextStep = searchNode.getNextState('D', new Point(5, 3), 1);
		List<Point> actualEmptySpots = actualNextStep.getEmptySpots().stream().collect(Collectors.toList());

		TestsUtils.compareListCollections(expectedEmptySpots, actualEmptySpots);

		assertEquals(new Point(4, 3), actualNextStep.getVehicleByID('D').getStartPos());
		assertEquals(new Point(5, 3), actualNextStep.getVehicleByID('D').getEndPos());
	}

	@Test
	public void testMovingTwoStepsEast() {
		rawPuzzleObject = new RawPuzzleObject("..AOOO..AB..XXCB.RDDCEERFGHH.RFGII..", 4);
		searchNode = new AStarSearchNode(rawPuzzleObject);

		List<Point> expectedEmptySpots = searchNode.getEmptySpots().stream().collect(Collectors.toList());
		expectedEmptySpots.remove(new Point(5, 4));
		expectedEmptySpots.remove(new Point(5, 5));
		expectedEmptySpots.add(new Point(5, 2));
		expectedEmptySpots.add(new Point(5, 3));

		AStarSearchNode actualNextStep = searchNode.getNextState('I', new Point(5, 5), 2);
		List<Point> actualEmptySpots = actualNextStep.getEmptySpots().stream().collect(Collectors.toList());

		TestsUtils.compareListCollections(expectedEmptySpots, actualEmptySpots);

		assertEquals(new Point(5, 4), actualNextStep.getVehicleByID('I').getStartPos());
		assertEquals(new Point(5, 5), actualNextStep.getVehicleByID('I').getEndPos());
	}

	@Test
	public void testMovingTwoStepsWest() {
		rawPuzzleObject = new RawPuzzleObject("A..RRRA..B.PXX.BCPQQQDCP..EDFFIIEHH.", 3);
		searchNode = new AStarSearchNode(rawPuzzleObject);

		List<Point> expectedEmptySpots = searchNode.getEmptySpots().stream().collect(Collectors.toList());
		expectedEmptySpots.remove(new Point(0, 1));
		expectedEmptySpots.remove(new Point(0, 2));
		expectedEmptySpots.add(new Point(0, 4));
		expectedEmptySpots.add(new Point(0, 5));

		AStarSearchNode actualNextStep = searchNode.getNextState('R', new Point(0, 1), 2);
		List<Point> actualEmptySpots = actualNextStep.getEmptySpots().stream().collect(Collectors.toList());

		TestsUtils.compareListCollections(expectedEmptySpots, actualEmptySpots);

		assertEquals(new Point(0, 1), actualNextStep.getVehicleByID('R').getStartPos());
		assertEquals(new Point(0, 3), actualNextStep.getVehicleByID('R').getEndPos());
	}

	@Test
	public void testMovingThreeStepsNorth() {
		rawPuzzleObject = new RawPuzzleObject("..OAAP..OB.PXXOB.PKQQQ..KDDEF.GG.EF.", 35);
		searchNode = new AStarSearchNode(rawPuzzleObject);

		List<Point> expectedEmptySpots = searchNode.getEmptySpots().stream().collect(Collectors.toList());
		expectedEmptySpots.remove(new Point(1, 4));
		expectedEmptySpots.remove(new Point(2, 4));
		expectedEmptySpots.add(new Point(4, 4));
		expectedEmptySpots.add(new Point(5, 4));

		AStarSearchNode actualNextStep = searchNode.getNextState('F', new Point(1, 4), 3);
		List<Point> actualEmptySpots = actualNextStep.getEmptySpots().stream().collect(Collectors.toList());

		TestsUtils.compareListCollections(expectedEmptySpots, actualEmptySpots);

		assertEquals(new Point(1, 4), actualNextStep.getVehicleByID('F').getStartPos());
		assertEquals(new Point(2, 4), actualNextStep.getVehicleByID('F').getEndPos());
	}

	@Test
	public void testMovingThreeStepsSouth() {
		rawPuzzleObject = new RawPuzzleObject("..OAAP..OB.PXXOB.PKQQQ..KDDEF.GG.EF.", 35);
		searchNode = new AStarSearchNode(rawPuzzleObject);

		List<Point> expectedEmptySpots = searchNode.getEmptySpots().stream().collect(Collectors.toList());
		expectedEmptySpots.remove(new Point(3, 5));
		expectedEmptySpots.remove(new Point(4, 5));
		expectedEmptySpots.remove(new Point(5, 5));
		expectedEmptySpots.add(new Point(0, 5));
		expectedEmptySpots.add(new Point(1, 5));
		expectedEmptySpots.add(new Point(2, 5));

		AStarSearchNode actualNextStep = searchNode.getNextState('P', new Point(5, 5), 3);
		List<Point> actualEmptySpots = actualNextStep.getEmptySpots().stream().collect(Collectors.toList());

		TestsUtils.compareListCollections(expectedEmptySpots, actualEmptySpots);

		assertEquals(new Point(3, 5), actualNextStep.getVehicleByID('P').getStartPos());
		assertEquals(new Point(5, 5), actualNextStep.getVehicleByID('P').getEndPos());
	}

	@Test
	public void testGeneratingExpectedNumberOfSuccessors() {
		// This code should be long and "not smart", we manually generate successors for
		// a specific state - start node of specific puzzle
		assertEquals(3, searchNode.getSuccessors().size());
	}

	@Test
	public void testGeneratingSuccessorsForSpecificCaseAsExpected() {
		assertEquals(getSuccessors().size(), searchNode.getSuccessors().size());
	}

	@Test
	public void testGeneratingExpectedNumberOfSuccessorsFromAnotherPuzzle() {
		rawPuzzleObject = new RawPuzzleObject("AA...OP..Q.OPXXQ.OP..Q..B...CCB.RRR.", 4);
		searchNode = new AStarSearchNode(rawPuzzleObject);

		Collection<AStarSearchNode> actualSuccessors = searchNode.getSuccessors();
		assertEquals(11, actualSuccessors.size());
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
