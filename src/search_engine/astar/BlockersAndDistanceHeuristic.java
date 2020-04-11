package search_engine.astar;

import java.util.Collection;

import rush_hour.Vehicle;

public class BlockersAndDistanceHeuristic implements HeuristicsCalculator {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Blockers&TargetVehicleDist";
	}

	@Override
	public double calculateValue(Collection<Vehicle> vehicles) {
		BlockersHeuristicCalculator calc = new BlockersHeuristicCalculator();
		TargetVehicleDistanceFromExitHeuristic targetV = new TargetVehicleDistanceFromExitHeuristic();
		// TODO Auto-generated method stub
		return calc.calculateValue(vehicles) + targetV.calculateValue(vehicles);
	}

}
