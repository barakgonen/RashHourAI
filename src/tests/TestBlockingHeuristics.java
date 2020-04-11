package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import rush_hour.Constants;
import rush_hour.Vehicle;
import search_engine.astar.BlockersHeuristicCalculator;

public class TestBlockingHeuristics {
	private BlockersHeuristicCalculator calculator;
	private Collection<Vehicle> vehiclesMap;

	@Before
	public void SetUp() {
		calculator = new BlockersHeuristicCalculator();
		vehiclesMap = new ArrayList<>();
		vehiclesMap.add(
				TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 2, new Point(2, 0)));
	}

	@Test
	public void testBlockingVehiclesHeuristicCalculationWithOneVerticalBlocker() {
		vehiclesMap.add(TestsUtils.getVehicle('K', Constants.VERTICAL, 3, new Point(1, 3)));
		vehiclesMap.add(TestsUtils.getVehicle('Q', Constants.VERTICAL, 2, new Point(4, 5)));
		vehiclesMap.add(TestsUtils.getVehicle('M', Constants.HORIZONTAL, 2, new Point(5, 0)));
		assertEquals(1, calculator.calculateValue(vehiclesMap));
	}

	@Test
	public void testBlockingVehiclesHeuristicCalculationWithOneHorizontalBlocker() {
		vehiclesMap.add(TestsUtils.getVehicle('A', Constants.VERTICAL, 2, new Point(0, 1)));
		vehiclesMap.add(TestsUtils.getVehicle('N', Constants.VERTICAL, 2, new Point(4, 5)));
		vehiclesMap.add(TestsUtils.getVehicle('R', Constants.HORIZONTAL, 2, new Point(3, 2)));
		assertEquals(0, calculator.calculateValue(vehiclesMap));
	}

	@Test
	public void testBlockingVehiclesHeuristicCalculationWithTwoVerticalBlockers() {
		vehiclesMap.add(TestsUtils.getVehicle('L', Constants.VERTICAL, 3, new Point(1, 3)));
		vehiclesMap.add(TestsUtils.getVehicle('S', Constants.VERTICAL, 2, new Point(2, 4)));
		vehiclesMap.add(TestsUtils.getVehicle('C', Constants.HORIZONTAL, 2, new Point(5, 0)));
		assertEquals(2, calculator.calculateValue(vehiclesMap));
	}

	// We assume all puzzles are solvable! thus, vehicles A & B wan't be in that
	// places
	@Test
	public void testBlockingVehiclesHeuristicCalculationWithTwoHorizontalBlockers() {
		vehiclesMap.add(TestsUtils.getVehicle('N', Constants.VERTICAL, 2, new Point(0, 3)));
		vehiclesMap.add(TestsUtils.getVehicle('A', Constants.HORIZONTAL, 2, new Point(2, 2)));
		vehiclesMap.add(TestsUtils.getVehicle('B', Constants.HORIZONTAL, 2, new Point(2, 4)));
		vehiclesMap.add(TestsUtils.getVehicle('P', Constants.HORIZONTAL, 3, new Point(4, 1)));
		assertEquals(0, calculator.calculateValue(vehiclesMap));
	}

	@Test
	public void testBlockingVehiclesHeuristicCalculationWithThreeVerticalBlockers() {
		vehiclesMap.add(TestsUtils.getVehicle('L', Constants.VERTICAL, 3, new Point(2, 2)));
		vehiclesMap.add(TestsUtils.getVehicle('S', Constants.VERTICAL, 3, new Point(1, 3)));
		vehiclesMap.add(TestsUtils.getVehicle('B', Constants.VERTICAL, 3, new Point(1, 5)));
		vehiclesMap.add(TestsUtils.getVehicle('C', Constants.HORIZONTAL, 3, new Point(5, 3)));
		assertEquals(3, calculator.calculateValue(vehiclesMap));
	}

	// A is not in valid place, discarding it
	@Test
	public void testBlockingVehiclesHeuristicCalculationWithOneHorizontalAndTwoVertiaclBlockers() {
		vehiclesMap.add(TestsUtils.getVehicle('B', Constants.HORIZONTAL, 2, new Point(0, 0)));
		vehiclesMap.add(TestsUtils.getVehicle('A', Constants.HORIZONTAL, 2, new Point(2, 2)));
		vehiclesMap.add(TestsUtils.getVehicle('P', Constants.VERTICAL, 2, new Point(2, 4)));
		vehiclesMap.add(TestsUtils.getVehicle('N', Constants.VERTICAL, 3, new Point(0, 5)));
		vehiclesMap.add(TestsUtils.getVehicle('S', Constants.HORIZONTAL, 2, new Point(4, 0)));
		assertEquals(2, calculator.calculateValue(vehiclesMap));
	}

	public void testBlockingVehiclesHeuristicCalculationWithFourVerticalBlockers() {
		vehiclesMap.add(TestsUtils.getVehicle('L', Constants.VERTICAL, 3, new Point(2, 2)));
		vehiclesMap.add(TestsUtils.getVehicle('S', Constants.VERTICAL, 3, new Point(2, 3)));
		vehiclesMap.add(TestsUtils.getVehicle('B', Constants.VERTICAL, 2, new Point(1, 4)));
		vehiclesMap.add(TestsUtils.getVehicle('A', Constants.VERTICAL, 3, new Point(0, 5)));
		vehiclesMap.add(TestsUtils.getVehicle('W', Constants.HORIZONTAL, 2, new Point(0, 1)));
		vehiclesMap.add(TestsUtils.getVehicle('Z', Constants.HORIZONTAL, 2, new Point(5, 1)));
		assertEquals(4, calculator.calculateValue(vehiclesMap));
	}

	@Test
	public void testBlockingVehiclesHeuristicCalculationWithThreeHorizontalAndOneVertical() {
		vehiclesMap.add(TestsUtils.getVehicle('B', Constants.HORIZONTAL, 2, new Point(1, 1)));
		vehiclesMap.add(TestsUtils.getVehicle('A', Constants.HORIZONTAL, 2, new Point(2, 2)));
		vehiclesMap.add(TestsUtils.getVehicle('N', Constants.VERTICAL, 3, new Point(3, 3)));
		vehiclesMap.add(TestsUtils.getVehicle('S', Constants.HORIZONTAL, 2, new Point(2, 4)));
		assertEquals(0, calculator.calculateValue(vehiclesMap));
	}
}
