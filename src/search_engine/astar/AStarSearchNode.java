package search_engine.astar;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import rush_hour.Constants;
import rush_hour.Movement;
import rush_hour.RawPuzzleObject;
import rush_hour.Vehicle;

/**
 * This class implements the search node in our game, Search node construct from
 * raw board data which read from an input file and each node knows how to build
 * it's valid successors
 */
public class AStarSearchNode {
	protected AStarSearchNode parent;
	protected int depthInGraph;
	protected double heuristicValue;
	protected int numberOfMoves;
	protected double evaluationFunc;
	protected Collection<Point> emptySpots;
	protected HashMap<Character, Vehicle> vehicles;
	final protected int puzzleID;
	protected final int successorIndex;
	protected final long boardIdentifier;
	private Movement movement;

	public AStarSearchNode(RawPuzzleObject obj) {
		this(obj.getEmptySpots(), obj.getVehiclesMapping(), obj.getPuzzleId(), 0, 0, 0);
	}

	public AStarSearchNode(Collection<Point> emptySpots, HashMap<Character, Vehicle> vehicles, int puzzleID,
			int successorIndex, int numberOfMoves, int depthInGraph) {
		this.emptySpots = emptySpots;
		this.vehicles = vehicles;
		this.puzzleID = puzzleID;
		this.parent = null;
		this.successorIndex = successorIndex;
		heuristicValue = HeuristicFunCalculator.getCalculatedHeuristicValueForState(this.vehicles.values());
		this.numberOfMoves = numberOfMoves;
		this.evaluationFunc = this.heuristicValue + this.numberOfMoves;
		this.depthInGraph = depthInGraph;
		this.boardIdentifier = this.generateStateIdentifier();
	}

	private AStarSearchNode(Collection<Point> emptySpots, HashMap<Character, Vehicle> vehicles, int puzzleID,
			AStarSearchNode parentNode, int successorIndex, Movement movementLeadToThisState) {
		this(emptySpots, vehicles, puzzleID, successorIndex, parentNode.numberOfMoves + 1, parentNode.depthInGraph + 1);
		this.parent = parentNode;
		movement = movementLeadToThisState;

	}

	public boolean isGoalNode() {
		for (int targetVehicleEndPos = (int) vehicles.get(Constants.TARGET_VEHICLE_IDENTIFIER).getEndPos()
				.getY(); targetVehicleEndPos < Constants.BOARD_SIZE; targetVehicleEndPos++) {
			Character identifierAtPosition = getCarIdentifier(new Point(Constants.EXIT_RAW, targetVehicleEndPos));
			if (identifierAtPosition != Constants.UKNOWN_IDENTIFIER
					&& identifierAtPosition != Constants.TARGET_VEHICLE_IDENTIFIER)
				return false;
		}
		return true;
	}

	public Set<AStarSearchNode> getSuccessors() {
		Set<AStarSearchNode> successors = new HashSet<>();
		int successorIndex = 0;
		for (Point emptySpot : emptySpots)
			for (Character carIdentifier : getNeighbors(emptySpot))
				if (canNeighborMoveHere(emptySpot, carIdentifier))
					successors.add(getNextState(carIdentifier, emptySpot, ++successorIndex));
		return successors;
	}

	public static <T> Map<Integer, List<T>> deepCopyStreamWorkAround(Map<Integer, List<T>> original) {
		return original.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, valueMapper -> new ArrayList<>(valueMapper.getValue())));
	}

	public AStarSearchNode getNextState(Character carToMoveID, Point destenationToMove, int successorIndex) {
		Set<Point> newEmptySpots = emptySpots.stream().collect(Collectors.toSet());
		Map<Character, Vehicle> newVehicleMap = vehicles.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, valueMapper -> new Vehicle(valueMapper.getValue())));

		Vehicle updatedVehicle = newVehicleMap.get(carToMoveID);
		Point oldStartPoint = new Point(updatedVehicle.getStartPos());
		Collection<Point> newEmptyPoints = updatedVehicle.moveVehicle(destenationToMove);
		// Here you do know which vehicle should go to where!
		Movement movement = new Movement(oldStartPoint, new Point(updatedVehicle.getStartPos()), carToMoveID,
				updatedVehicle.getOrientation());
		newEmptySpots.addAll(newEmptyPoints);
		newEmptySpots.removeAll(updatedVehicle.getLocations());
		char[][] nextStateBoard = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

		for (Point empty : newEmptySpots) {
			nextStateBoard[(int) empty.getX()][(int) empty.getY()] = '.';
		}
		for (Vehicle newVehicle : newVehicleMap.values()) {
			for (Point pos : newVehicle.getLocations())
				nextStateBoard[(int) pos.getX()][(int) pos.getY()] = newVehicle.getIdentifier();
		}
		return new AStarSearchNode(newEmptySpots, (HashMap<Character, Vehicle>) newVehicleMap, puzzleID, this,
				successorIndex, movement);
	}

	private Set<Character> getNeighbors(Point currentEmptySpot) {
		Set<Character> toReturn = new HashSet<>();
		toReturn.add(getWestestNeighbor(currentEmptySpot));
		toReturn.add(getEastestNeighbor(currentEmptySpot));
		toReturn.add(getNorthestNeighbor(currentEmptySpot));
		toReturn.add(getSouthestNeighbor(currentEmptySpot));
		return toReturn.stream().filter(c -> c != Constants.UKNOWN_IDENTIFIER).collect(Collectors.toSet());
	}

	public Character getCarIdentifier(Point currentEmptySpot) {
		return vehicles.keySet().stream().filter(v -> vehicles.get(v).isPointIntersectsWithMe(currentEmptySpot))
				.findAny().orElse(Constants.UKNOWN_IDENTIFIER);
	}

	public Character getNorthestNeighbor(Point currentEmptySpot) {
		Character carIdentifier = getCarIdentifier(currentEmptySpot);
		if (currentEmptySpot.getX() <= 0 || carIdentifier != Constants.UKNOWN_IDENTIFIER)
			return carIdentifier;
		return getNorthestNeighbor(new Point((int) currentEmptySpot.getX() - 1, (int) currentEmptySpot.getY()));
	}

	public Character getSouthestNeighbor(Point currentEmptySpot) {
		Character carIdentifier = getCarIdentifier(currentEmptySpot);
		if (currentEmptySpot.getX() > Constants.BOARD_SIZE || carIdentifier != Constants.UKNOWN_IDENTIFIER)
			return carIdentifier;
		return getSouthestNeighbor(new Point((int) currentEmptySpot.getX() + 1, (int) currentEmptySpot.getY()));
	}

	public Character getEastestNeighbor(Point currentEmptySpot) {
		Character carIdentifier = getCarIdentifier(currentEmptySpot);
		if (currentEmptySpot.getY() >= Constants.BOARD_SIZE || carIdentifier != Constants.UKNOWN_IDENTIFIER)
			return carIdentifier;
		return getEastestNeighbor(new Point((int) currentEmptySpot.getX(), (int) currentEmptySpot.getY() + 1));
	}

	public Character getWestestNeighbor(Point currentEmptySpot) {
		Character carIdentifier = getCarIdentifier(currentEmptySpot);
		if (currentEmptySpot.getY() <= 0 || carIdentifier != Constants.UKNOWN_IDENTIFIER)
			return carIdentifier;
		return getWestestNeighbor(new Point((int) currentEmptySpot.getX(), (int) currentEmptySpot.getY() - 1));
	}

	public boolean canNeighborMoveHere(Point emptySpot, Character carIdentifier) {
		Vehicle neighborVehicle = vehicles.get(carIdentifier);
		if (neighborVehicle.getOrientation() == Constants.HORIZONTAL)
			return (emptySpot.getX() == neighborVehicle.getStartPos().getX()
					&& (emptySpot.getX() == neighborVehicle.getEndPos().getX()))
					&& (0 <= (int) emptySpot.getY() && (int) emptySpot.getY() < Constants.BOARD_SIZE);
		else
			return (emptySpot.getY() == neighborVehicle.getStartPos().getY()
					&& (emptySpot.getY() == neighborVehicle.getEndPos().getY()))
					&& (0 <= (int) emptySpot.getX() && (int) emptySpot.getX() < Constants.BOARD_SIZE);
	}

	public double getEvaluationFunc() {
		return evaluationFunc;
	}

	public long getUUID() {
		return boardIdentifier;
	}

	public double getHeuristicsValue() {
		return heuristicValue;
	}

	public int getDepth() {
		return depthInGraph;
	}

	public int getPuzzleID() {
		return puzzleID;
	}

	@Override
	public boolean equals(Object o) {
		return this.depthInGraph == ((AStarSearchNode) o).depthInGraph
				&& this.heuristicValue == ((AStarSearchNode) o).heuristicValue
				&& this.numberOfMoves == ((AStarSearchNode) o).numberOfMoves
				&& this.evaluationFunc == ((AStarSearchNode) o).evaluationFunc
				&& this.emptySpots.equals(((AStarSearchNode) o).emptySpots)
				&& this.vehicles.equals(((AStarSearchNode) o).vehicles)
				&& this.puzzleID == ((AStarSearchNode) o).puzzleID
				&& this.successorIndex == ((AStarSearchNode) o).successorIndex
				&& ((this.parent != null && ((AStarSearchNode) o).parent != null)
						? this.parent.equals(((AStarSearchNode) o).parent)
						: true);
	}

	public int getSuccessorIndex() {
		return successorIndex;
	}

	private long generateStateIdentifier() {
		long id = 1;
		id = id * 10;
		id += vehicles.get(Constants.TARGET_VEHICLE_IDENTIFIER).getStartPos().getY();
		List<Vehicle> withoutTargetVehicle = vehicles.values().stream()
				.filter(v -> v.getIdentifier() != Constants.TARGET_VEHICLE_IDENTIFIER).collect(Collectors.toList());
		for (Vehicle v : withoutTargetVehicle) {
			id = id * 10;
			if (v.getOrientation() == Constants.HORIZONTAL)
				id += v.getStartPos().getY();
			else
				id += v.getStartPos().getX();
		}
		return id;
	}

	// remove me
	public Collection<Point> getEmptySpots() {
		return emptySpots;
	}

	public Vehicle getVehicleByID(Character id) {
		return vehicles.get(id);
	}

	public int getNumberOfPassedMoves() {
		return this.numberOfMoves;
	}

	private void setWholeSolution(ArrayList<AStarSearchNode> wholeSolution) {
		AStarSearchNode currentParent = this.parent;
		while (currentParent != null) {
			wholeSolution.add(currentParent);
			currentParent = currentParent.parent;
		}
		Collections.reverse(wholeSolution);
	}

	public String getPuzzleSolution() {
		// First of all, need to get all board from the beggining to the end
		String puzzleSolution = "";
		ArrayList<AStarSearchNode> wholeSolution = new ArrayList<AStarSearchNode>();
		setWholeSolution(wholeSolution);
		for (AStarSearchNode node : wholeSolution)
			puzzleSolution += (node.movement != null) ? node.movement : "";
		puzzleSolution += " END";
		return puzzleSolution;
	}
}
