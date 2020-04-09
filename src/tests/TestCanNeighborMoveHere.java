package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import rush_hour.Constants;
import rush_hour.Vehicle;
import search_engine.astar.AStarSearchNode;

public class TestCanNeighborMoveHere {

	private List<Point> emptySpots;
	private HashMap<Character, Vehicle> vehiclesMap;
	private int puzzleID;
	Character carIdentifier;

	@Before
	public void SetUp() {
		emptySpots = new ArrayList<>();
		vehiclesMap = new HashMap<>();
		Random random = new Random();
		puzzleID = random.nextInt();
		carIdentifier = (char) (random.nextInt(26) + 65);
		vehiclesMap.put(Constants.TARGET_VEHICLE_IDENTIFIER, TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER,
				Constants.HORIZONTAL, 2, new Point(Constants.EXIT_RAW, 0), new Point(Constants.EXIT_RAW, 1)));
	}

	@Test
	public void testSimpleValidHorizontalToEastWithSizeTwoVehicleMovement() {
		vehiclesMap.put(carIdentifier,
				TestsUtils.getVehicle(carIdentifier, Constants.HORIZONTAL, 2, new Point(4, 3), new Point(4, 4)));
		AStarSearchNode currentSearchNode = new AStarSearchNode(emptySpots, vehiclesMap, puzzleID, 1, 0, 0);
		assertTrue(currentSearchNode.canNeighborMoveHere(new Point(4, 5), carIdentifier));
	}

	@Test
	public void testSimpleValidHorizontalToEastWithSizeThreeVehicleMovement() {
		vehiclesMap.put(carIdentifier,
				TestsUtils.getVehicle(carIdentifier, Constants.HORIZONTAL, 3, new Point(1, 1), new Point(1, 3)));
		AStarSearchNode currentSearchNode = new AStarSearchNode(emptySpots, vehiclesMap, puzzleID, 1, 0, 0);
		assertTrue(currentSearchNode.canNeighborMoveHere(new Point(1, 5), carIdentifier));
	}

	@Test
	public void testSimpleInValidHorizontalToEastWithSizeTwoVehicleMovement() {
		vehiclesMap.put(carIdentifier,
				TestsUtils.getVehicle(carIdentifier, Constants.HORIZONTAL, 2, new Point(4, 3), new Point(4, 4)));
		AStarSearchNode currentSearchNode = new AStarSearchNode(emptySpots, vehiclesMap, puzzleID, 1, 0, 0);
		assertFalse(currentSearchNode.canNeighborMoveHere(new Point(4, 7), carIdentifier));
	}

	@Test
	public void testSimpleInValidHorizontalToEastWithSizeThreeVehicleMovement() {
		vehiclesMap.put(carIdentifier,
				TestsUtils.getVehicle(carIdentifier, Constants.HORIZONTAL, 3, new Point(1, 1), new Point(1, 3)));
		AStarSearchNode currentSearchNode = new AStarSearchNode(emptySpots, vehiclesMap, puzzleID, 1, 0, 0);
		assertFalse(currentSearchNode.canNeighborMoveHere(new Point(0, 4), carIdentifier));
	}

	@Test
	public void testSimpleValidHorizontalToWestWithSizeTwoVehicleMovement() {
		vehiclesMap.put(carIdentifier,
				TestsUtils.getVehicle(carIdentifier, Constants.HORIZONTAL, 2, new Point(2, 2), new Point(2, 3)));
		AStarSearchNode currentSearchNode = new AStarSearchNode(emptySpots, vehiclesMap, puzzleID, 1, 0, 0);
		assertTrue(currentSearchNode.canNeighborMoveHere(new Point(2, 0), carIdentifier));
	}

	@Test
	public void testSimpleValidHorizontalToWestWithSizeThreeVehicleMovement() {
		vehiclesMap.put(carIdentifier,
				TestsUtils.getVehicle(carIdentifier, Constants.HORIZONTAL, 3, new Point(0, 3), new Point(0, 5)));
		AStarSearchNode currentSearchNode = new AStarSearchNode(emptySpots, vehiclesMap, puzzleID, 1, 0, 0);
		assertTrue(currentSearchNode.canNeighborMoveHere(new Point(0, 0), carIdentifier));
	}

	@Test
	public void testSimpleInValidHorizontalToWestWithSizeTwoVehicleMovement() {
		vehiclesMap.put(carIdentifier,
				TestsUtils.getVehicle(carIdentifier, Constants.HORIZONTAL, 2, new Point(5, 2), new Point(5, 3)));
		AStarSearchNode currentSearchNode = new AStarSearchNode(emptySpots, vehiclesMap, puzzleID, 1, 0, 0);
		assertFalse(currentSearchNode.canNeighborMoveHere(new Point(-1, 2), carIdentifier));
	}

	@Test
	public void testSimpleInValidHorizontalToWestWithSizeThreeVehicleMovement() {
		vehiclesMap.put(carIdentifier,
				TestsUtils.getVehicle(carIdentifier, Constants.HORIZONTAL, 3, new Point(2, 3), new Point(2, 5)));
		AStarSearchNode currentSearchNode = new AStarSearchNode(emptySpots, vehiclesMap, puzzleID, 1, 0, 0);
		assertFalse(currentSearchNode.canNeighborMoveHere(new Point(3, 1), carIdentifier));
	}

	@Test
	public void testSimpleValidVerticalToNorthWithSizeTwoVehicleMovement() {
		vehiclesMap.put(carIdentifier,
				TestsUtils.getVehicle(carIdentifier, Constants.VERTICAL, 2, new Point(4, 5), new Point(5, 5)));
		AStarSearchNode currentSearchNode = new AStarSearchNode(emptySpots, vehiclesMap, puzzleID, 1, 0, 0);
		assertTrue(currentSearchNode.canNeighborMoveHere(new Point(3, 5), carIdentifier));
	}

	@Test
	public void testSimpleValidVerticalToNorthWithSizeThreeVehicleMovement() {
		vehiclesMap.put(carIdentifier,
				TestsUtils.getVehicle(carIdentifier, Constants.VERTICAL, 3, new Point(1, 4), new Point(3, 4)));
		AStarSearchNode currentSearchNode = new AStarSearchNode(emptySpots, vehiclesMap, puzzleID, 1, 0, 0);
		assertTrue(currentSearchNode.canNeighborMoveHere(new Point(0, 4), carIdentifier));
	}

	@Test
	public void testSimpleInValidVerticalToNorthWithSizeTwoVehicleMovement() {
		vehiclesMap.put(carIdentifier,
				TestsUtils.getVehicle(carIdentifier, Constants.VERTICAL, 2, new Point(3, 2), new Point(4, 2)));
		AStarSearchNode currentSearchNode = new AStarSearchNode(emptySpots, vehiclesMap, puzzleID, 1, 0, 0);
		assertFalse(currentSearchNode.canNeighborMoveHere(new Point(-1, 1), carIdentifier));
	}

	@Test
	public void testSimpleInValidVerticalToNorthWithSizeThreeVehicleMovement() {
		vehiclesMap.put(carIdentifier,
				TestsUtils.getVehicle(carIdentifier, Constants.VERTICAL, 3, new Point(0, 5), new Point(2, 5)));
		AStarSearchNode currentSearchNode = new AStarSearchNode(emptySpots, vehiclesMap, puzzleID, 1, 0, 0);
		assertFalse(currentSearchNode.canNeighborMoveHere(new Point(-1, 0), carIdentifier));
	}

	@Test
	public void testSimpleValidVerticalToSouthWithSizeTwoVehicleMovement() {
		vehiclesMap.put(carIdentifier,
				TestsUtils.getVehicle(carIdentifier, Constants.VERTICAL, 2, new Point(2, 0), new Point(3, 0)));
		AStarSearchNode currentSearchNode = new AStarSearchNode(emptySpots, vehiclesMap, puzzleID, 1, 0, 0);
		assertTrue(currentSearchNode.canNeighborMoveHere(new Point(4, 0), carIdentifier));
	}

	@Test
	public void testSimpleValidVerticalToSouthWithSizeThreeVehicleMovement() {
		vehiclesMap.put(carIdentifier,
				TestsUtils.getVehicle(carIdentifier, Constants.VERTICAL, 3, new Point(2, 1), new Point(4, 1)));
		AStarSearchNode currentSearchNode = new AStarSearchNode(emptySpots, vehiclesMap, puzzleID, 1, 0, 0);
		assertTrue(currentSearchNode.canNeighborMoveHere(new Point(5, 1), carIdentifier));
	}

	@Test
	public void testSimpleInValidVerticalToSouthWithSizeTwoVehicleMovement() {
		vehiclesMap.put(carIdentifier,
				TestsUtils.getVehicle(carIdentifier, Constants.VERTICAL, 2, new Point(2, 0), new Point(3, 0)));
		AStarSearchNode currentSearchNode = new AStarSearchNode(emptySpots, vehiclesMap, puzzleID, 1, 0, 0);
		assertFalse(currentSearchNode.canNeighborMoveHere(new Point(Constants.BOARD_SIZE + 1, 0), carIdentifier));
	}

	@Test
	public void testSimpleInValidVerticalToSouthWithSizeThreeVehicleMovement() {
		vehiclesMap.put(carIdentifier,
				TestsUtils.getVehicle(carIdentifier, Constants.VERTICAL, 3, new Point(2, 1), new Point(4, 1)));
		AStarSearchNode currentSearchNode = new AStarSearchNode(emptySpots, vehiclesMap, puzzleID, 1, 0, 0);
		assertFalse(currentSearchNode.canNeighborMoveHere(new Point(Constants.BOARD_SIZE, 1), carIdentifier));
	}
}
