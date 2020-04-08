package search_engine.astar;

import java.awt.Point;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import rush_hour.Constants;
import rush_hour.Main;
import rush_hour.Vehicle;

/**
 * This class has a few heuristic functions calculations
 *
 */
public final class HeuristicFunCalculator {
	public static Logger LOGGER = Logger.getLogger(Main.class.getName());

	private HeuristicFunCalculator() {
	}

	/**
	 * This heuristic calculates the minimum number of actions we have to perform in
	 * order to get to goal node. our goal node is a node which the target vehicle
	 * exits the board. This is an admissible heuristic since the number of
	 * movements to perform is at least the distance of the target vehicle from the
	 * exit
	 * 
	 * @param redVehicle - target vehicle
	 * @return (Horizontal) distance of targetVehicle from exit
	 */
	public static int targetVehiclDistanceFromExit(Vehicle redVehicle) {
		return (Constants.BOARD_SIZE - 1) - (int) redVehicle.getEndPos().getY();
	}

	/**
	 * Admissible heuristic since the number of blocking cars is lower equal to the
	 * distance of the target car from the exit, thus it's lower or equal to the
	 * number of actions we have to perform
	 * 
	 * @param emptyCells - empty cells on the board
	 * @param vehicles   - vehicles on map
	 * @return number of blockers
	 */
	public static int numberOfBlockingVehicles(Collection<Vehicle> vehicles) {
		Set<Vehicle> blockingVehicles = new HashSet<>();
		for (Point emptySpot : getExitPathOfTargetVehicle(vehicles)) {
			for (Vehicle v : vehicles) {
				if (v.isPointIntersectsWithMe(emptySpot))
					blockingVehicles.add(v);
			}
		}
		blockingVehicles.removeIf(vehicle -> vehicle.getIdentifier() == Constants.TARGET_VEHICLE_IDENTIFIER);
		return blockingVehicles.size();
	}

	public static List<Point> getExitPathOfTargetVehicle(Collection<Vehicle> vehicles) {
		final int targetVehicleEndIndex = (int) vehicles.stream()
				.filter(vehicle -> vehicle.getIdentifier() == Constants.TARGET_VEHICLE_IDENTIFIER).findAny()
				.orElse(null).getEndPos().getY();
		return Constants.TARGET_VEHICLE_EXIT_PATH.stream().filter(p -> (int) p.getY() > targetVehicleEndIndex)
				.collect(Collectors.toList());
	}
}
