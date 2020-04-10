package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import rush_hour.Constants;
import rush_hour.Vehicle;
import search_engine.astar.HeuristicFunCalculator;

public class TestGenerationOfTargetCarExitPath {
	@Test
	public void testGenerationFromIndexZero() {
		Vehicle targetVehicle = TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 2,
				new Point(2, 0));
		List<Point> exitPath = new ArrayList<>();
		exitPath.add(new Point(2, 2));
		exitPath.add(new Point(2, 3));
		exitPath.add(new Point(2, 4));
		exitPath.add(new Point(2, 5));
		assertEquals(exitPath, HeuristicFunCalculator.getExitPathOfTargetVehicle(Collections.singleton(targetVehicle)));
	}

	@Test
	public void testGenerationFromIndexOne() {
		Vehicle targetVehicle = TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 2,
				new Point(2, 1));
		List<Point> exitPath = new ArrayList<>();
		exitPath.add(new Point(2, 3));
		exitPath.add(new Point(2, 4));
		exitPath.add(new Point(2, 5));
		assertEquals(exitPath, HeuristicFunCalculator.getExitPathOfTargetVehicle(Collections.singleton(targetVehicle)));
	}

	@Test
	public void testGenerationFromIndexTwo() {
		Vehicle targetVehicle = TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 2,
				new Point(2, 2));
		List<Point> exitPath = new ArrayList<>();
		exitPath.add(new Point(2, 4));
		exitPath.add(new Point(2, 5));
		assertEquals(exitPath, HeuristicFunCalculator.getExitPathOfTargetVehicle(Collections.singleton(targetVehicle)));
	}

	@Test
	public void testGenerationFromIndexThree() {
		Vehicle targetVehicle = TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 2,
				new Point(2, 3));
		List<Point> exitPath = new ArrayList<>();
		exitPath.add(new Point(2, 5));
		assertEquals(exitPath, HeuristicFunCalculator.getExitPathOfTargetVehicle(Collections.singleton(targetVehicle)));
	}

	@Test
	public void testGenerationFromIndexFour() {
		Vehicle targetVehicle = TestsUtils.getVehicle(Constants.TARGET_VEHICLE_IDENTIFIER, Constants.HORIZONTAL, 2,
				new Point(2, 4));
		List<Point> exitPath = new ArrayList<>();
		assertEquals(exitPath, HeuristicFunCalculator.getExitPathOfTargetVehicle(Collections.singleton(targetVehicle)));
	}
}
