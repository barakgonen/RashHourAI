package search_engine.astar;

import java.awt.Point;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import rush_hour.Constants;
import rush_hour.Vehicle;

public class BlockersHeuristicCalculator implements HeuristicsCalculator {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "BlockingCars";
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
	@Override
	public double calculateValue(Collection<Vehicle> vehicles) {
		Set<Vehicle> blockingVehicles = new HashSet<>();
		for (Point emptySpot : getExitPathOfTargetVehicle(vehicles)) {
			for (Vehicle v : vehicles) {
				if (v.getOrientation() == Constants.VERTICAL && v.isPointIntersectsWithMe(emptySpot))
					blockingVehicles.add(v);
			}
		}
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
