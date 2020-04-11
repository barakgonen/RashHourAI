package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import rush_hour.Constants;
import rush_hour.Vehicle;
import search_engine.astar.TargetVehicleDistanceFromExitHeuristic;

public class HeuristicsTestWhenTargetVehicleInSizeOfTwo {

	private ArrayList<Vehicle> vehiclesMap;
	private TargetVehicleDistanceFromExitHeuristic calculator;

	@Before
	public void SetUp() {
		vehiclesMap = new ArrayList<>();
		calculator = new TargetVehicleDistanceFromExitHeuristic();
	}

	@Test
	public void testVehicleDistanceHeuristicDistanceFourStepsVehicleSizeTwo() {
		vehiclesMap.add(
				TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 2, new Point(2, 0)));
		assertEquals(4, calculator.calculateValue(vehiclesMap));
	}

	@Test
	public void testVehicleDistanceHeuristicDistanceZeroStepsVehicleSizeTwo() {
		vehiclesMap.add(
				TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 2, new Point(2, 4)));
		assertEquals(0, calculator.calculateValue(vehiclesMap));
	}

	@Test
	public void testVehicleDistanceHeuristicDistanceOneStepVehicleSizeTwo() {
		vehiclesMap.add(
				TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 2, new Point(2, 3)));
		assertEquals(1, calculator.calculateValue(vehiclesMap));
	}

	@Test
	public void testVehicleDistanceHeuristicDistanceTwoStepsVehicleSizeTwo() {
		vehiclesMap.add(
				TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 2, new Point(2, 2)));
		assertEquals(2, calculator.calculateValue(vehiclesMap));
	}

	@Test
	public void testVehicleDistanceHeuristicDistanceThreeStepsVehicleSizeTwo() {
		vehiclesMap.add(
				TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 2, new Point(2, 1)));
		assertEquals(3, calculator.calculateValue(vehiclesMap));
	}
}
