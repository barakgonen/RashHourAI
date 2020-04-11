package search_engine.astar;

import java.util.Collection;

import rush_hour.Constants;
import rush_hour.Vehicle;

public class TargetVehicleDistanceFromExitHeuristic implements HeuristicsCalculator {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "TargetVehicleDistance";
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
	@Override
	public double calculateValue(Collection<Vehicle> vehicles) {
		// TODO Auto-generated method stub
		return (Constants.BOARD_SIZE - 1)
				- (int) (vehicles.stream().filter(v -> v.getIdentifier() == Constants.TARGET_VEHICLE_IDENTIFIER)
						.findFirst().get().getEndPos().getY());
	}
}
