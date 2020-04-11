package search_engine.astar;

import java.util.Collection;

import rush_hour.Vehicle;

public interface HeuristicsCalculator {
	String getName();

	double calculateValue(Collection<Vehicle> vehicles);
}
