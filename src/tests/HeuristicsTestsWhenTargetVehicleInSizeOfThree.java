package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import rush_hour.Constants;
import rush_hour.Vehicle;
import search_engine.astar.TargetVehicleDistanceFromExitHeuristic;

public class HeuristicsTestsWhenTargetVehicleInSizeOfThree {

	private Collection<Vehicle> vehiclesMap;
	private TargetVehicleDistanceFromExitHeuristic calculator;

	@Before
	public void SetUp() {
		vehiclesMap = new ArrayList<>();
		calculator = new TargetVehicleDistanceFromExitHeuristic();
	}

	@Test
	public void testVehicleDistanceHeuristicDistanceZeroStepsVehicleSizeThree() {
		vehiclesMap.add(
				TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 3, new Point(2, 3)));
		assertEquals(0, calculator.calculateValue(vehiclesMap));
	}

	@Test
	public void testVehicleDistanceHeuristicDistanceOneStepVehicleSizeThree() {
		vehiclesMap.add(
				TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 3, new Point(2, 2)));
		assertEquals(1, calculator.calculateValue(vehiclesMap));
	}

	@Test
	public void testVehicleDistanceHeuristicDistanceTwoStepsVehicleSizeThree() {
		vehiclesMap.add(
				TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 3, new Point(2, 1)));
		assertEquals(2, calculator.calculateValue(vehiclesMap));
	}

	@Test
	public void testVehicleDistanceHeuristicDistanceFourStepsVehicleSizeThree() {
		vehiclesMap.add(
				TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 3, new Point(2, 0)));
		assertEquals(3, calculator.calculateValue(vehiclesMap));
	}

}
