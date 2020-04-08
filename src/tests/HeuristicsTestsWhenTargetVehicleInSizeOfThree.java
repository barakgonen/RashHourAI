package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import rush_hour.Constants;
import rush_hour.Vehicle;
import search_engine.astar.HeuristicFunCalculator;

public class HeuristicsTestsWhenTargetVehicleInSizeOfThree {

	private Collection<Vehicle> vehiclesMap;

	@Before
	public void Setup() {
		vehiclesMap = new ArrayList<>();
//		vehiclesMap.
	}

	@Test
	void testVehicleDistanceHeuristicDistanceZeroStepsVehicleSizeThree() {
		assertEquals(0, HeuristicFunCalculator.targetVehiclDistanceFromExit(TestsUtils.getVehicle(
				Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 3, new Point(2, 3), new Point(2, 5))));
	}

	@Test
	void testVehicleDistanceHeuristicDistanceOneStepVehicleSizeThree() {
		assertEquals(1, HeuristicFunCalculator.targetVehiclDistanceFromExit(TestsUtils.getVehicle(
				Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 3, new Point(2, 2), new Point(2, 4))));
	}

	@Test
	void testVehicleDistanceHeuristicDistanceTwoStepsVehicleSizeThree() {
		assertEquals(2, HeuristicFunCalculator.targetVehiclDistanceFromExit(TestsUtils.getVehicle(
				Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 3, new Point(2, 1), new Point(2, 3))));
	}

	@Test
	void testVehicleDistanceHeuristicDistanceFourStepsVehicleSizeThree() {
		assertEquals(3, HeuristicFunCalculator.targetVehiclDistanceFromExit(TestsUtils.getVehicle(
				Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 3, new Point(2, 0), new Point(2, 2))));
	}

}
