package search_engine.astar;

import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import rush_hour.Constants;
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
	protected int id = 1; // Think about it, it's not relevant to any A*, just for specific
	protected Collection<Point> emptySpots;
	protected HashMap<Character, Vehicle> vehicles;
	final protected int puzzleID;

	public AStarSearchNode(RawPuzzleObject obj) {
		emptySpots = obj.getEmptySpots();
		vehicles = obj.getVehiclesMapping();
		puzzleID = obj.getPuzzleId();
	}

	public AStarSearchNode(Collection<Point> emptySpots, HashMap<Character, Vehicle> vehicles, int puzzleID) {
		this.emptySpots = emptySpots;
		this.vehicles = vehicles;
		this.puzzleID = puzzleID;
	}

	public boolean isGoalNode() {
		return vehicles.get(Constants.TARGET_VEHICLE_IDENTIFIER).getEndPos().equals(Constants.GOAL_STATE_POS);
	}

	// 1. test isGoalNode
	// 2. test canNeighborMoveHere
	// 2. Implement successor
	public Set<AStarSearchNode> getSuccessors() {
		Set<AStarSearchNode> successors = new HashSet<>();
		for (Point emptySpot : emptySpots) {
			for (Character carIdentifier : getNeighbors(emptySpot)) {
				if (canNeighborMoveHere(emptySpot, carIdentifier)) {
					// Implement successor
					// Need to construct new AStarSearchNode with new board order - new emptySpots &
					// new vehicles position according to movement
				}
			}
		}
		return successors;
	}

	private Set<Character> getNeighbors(Point currentEmptySpot) {
		Set<Character> toReturn = new HashSet<>();
		toReturn.add(getNorthestNeighbor(currentEmptySpot));
		toReturn.add(getSouthestNeighbor(currentEmptySpot));
		toReturn.add(getEastestNeighbor(currentEmptySpot));
		toReturn.add(getWestestNeighbor(currentEmptySpot));
		return toReturn;
	}

	private Character getCarIdentifier(Point currentEmptySpot) {
		return vehicles.keySet().stream().filter(v -> vehicles.get(v).isPointIntersectsWithMe(currentEmptySpot))
				.findAny().orElse(Constants.UKNOWN_IDENTIFIER);
	}

	private Character getNorthestNeighbor(Point currentEmptySpot) {
		Character carIdentifier = getCarIdentifier(currentEmptySpot);
		if (currentEmptySpot.getX() <= 0 || carIdentifier != Constants.UKNOWN_IDENTIFIER)
			return carIdentifier;
		return getNorthestNeighbor(new Point((int) currentEmptySpot.getX() - 1, (int) currentEmptySpot.getY()));
	}

	private Character getSouthestNeighbor(Point currentEmptySpot) {
		Character carIdentifier = getCarIdentifier(currentEmptySpot);
		if (currentEmptySpot.getX() > Constants.BOARD_SIZE || carIdentifier != Constants.UKNOWN_IDENTIFIER)
			return carIdentifier;
		return getNorthestNeighbor(new Point((int) currentEmptySpot.getX() + 1, (int) currentEmptySpot.getY()));
	}

	private Character getEastestNeighbor(Point currentEmptySpot) {
		Character carIdentifier = getCarIdentifier(currentEmptySpot);
		if (currentEmptySpot.getY() < Constants.BOARD_SIZE || carIdentifier != Constants.UKNOWN_IDENTIFIER)
			return carIdentifier;
		return getNorthestNeighbor(new Point((int) currentEmptySpot.getX(), (int) currentEmptySpot.getY() + 1));
	}

	private Character getWestestNeighbor(Point currentEmptySpot) {
		Character carIdentifier = getCarIdentifier(currentEmptySpot);
		if (currentEmptySpot.getY() >= 0 || carIdentifier != Constants.UKNOWN_IDENTIFIER)
			return carIdentifier;
		return getNorthestNeighbor(new Point((int) currentEmptySpot.getX(), (int) currentEmptySpot.getY() - 1));
	}

	private boolean canNeighborMoveHere(Point emptySpot, Character carIdentifier) {
		Vehicle neighborVehicle = vehicles.get(carIdentifier);
		if ((emptySpot.getX() == neighborVehicle.getStartPos().getX())
				&& (emptySpot.getX() == neighborVehicle.getEndPos().getX())) {
			return true;
		}
		if ((emptySpot.getY() == neighborVehicle.getStartPos().getY())
				&& (emptySpot.getY() == neighborVehicle.getEndPos().getY())) {
			return true;
		}
		return false;
	}

	public double getEvaluationFunc() {
		return evaluationFunc;
	}

	public long getId() {
		return id;
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
		return true;
	}

//	/*
//	 * this method is for printing the solution moves, by going up to the parent
//	 * each time.
//	 * 
//	 * @start - the father / not neccessary can be done untill null found.
//	 * 
//	 * @bestGoal - the best board solution
//	 */
//
//	public void printSolution(Node start, Node bestGoal) {
//		Node currentw = new Node(bestGoal);
//		Node parent;
//		ArrayList<String> moves = new ArrayList<String>();
//		while (currentw.getId() != start.getId()) {
//
//			StringBuilder sb = new StringBuilder();
//			int index = 0;
//			char carSymbol;
//			char direction;
//			int carOrient;
//			int steps = 0;
//			String move;
//			parent = currentw.getParent();
//			if (parent == null)
//				break;
//			for (int i = 0; i < currentw.getPuz().getNumOfCars(); i++) {
//
//				if (currentw.getPuz().getcPosition()[i] != parent.getPuz().getcPosition()[i]) {
//					index = i;
//					steps = Math.abs(currentw.getPuz().getcPosition()[i] - parent.getPuz().getcPosition()[i]);
//
//				}
//			}
//			carSymbol = currentw.getPuz().getCarSymbol()[index];
//			carOrient = currentw.getPuz().getCarOrient()[index];
//
//			if (carOrient == 1) {
//				if (currentw.getPuz().getcPosition()[index] > parent.getPuz().getcPosition()[index])
//					direction = 'D';
//				else
//					direction = 'U';
//
//			} else {
//				if (currentw.getPuz().getcPosition()[index] > parent.getPuz().getcPosition()[index])
//					direction = 'R';
//				else
//					direction = 'L';
//			}
//
//			sb.append(carSymbol);
//			sb.append(direction);
//			sb.append(steps);
//			sb.append(' ');
//			move = sb.toString();
//
//			moves.add(move);
//			currentw = parent;
//		}
//		int countX = 0;
//		while ((bestGoal.getPuz().getcPosition()[0] + countX) < bestGoal.getPuz().getSize()) {
//			countX++;
//		}
//
//		for (int i = moves.size() - 1; 0 <= i; i--) {
//			System.out.print(moves.get(i));
//
//		}
//
//		System.out.print("XR" + countX);
//
//		System.out.println();
//	}

//	public void setBoard(String mov, int index) {
//		int step = (mov.charAt(2) - '0');
//		if (this.carOrient[index] == 0) {
//			for (int i = 0; i < this.carSize[index]; i++) {
//				this.board[this.fixedPosition[index]][this.cPosition[index] + i] = '.';
//			}
//		} else if (this.carOrient[index] == 1) {
//			for (int i = 0; i < this.carSize[index]; i++) {
//				this.board[this.cPosition[index] + i][this.fixedPosition[index]] = '.';
//			}
//		}
//		if (mov.charAt(0) == 'X' && mov.charAt(1) == 'R') {
//			if (this.getcPosition()[0] + step > 5) {
//				return;
//			} else if (this.getcPosition()[0] + step == 5) {
//
//				this.board[this.fixedPosition[0]][5] = mov.charAt(0);
//				return;
//			}
//		}
//		switch (mov.charAt(1)) {
//		case 'L':
//
//			for (int i = 0; i < this.carSize[index]; i++) {
//				this.board[this.fixedPosition[index]][this.cPosition[index] - step + i] = mov.charAt(0);
//			}
//			break;
//		case 'R':
//			for (int i = this.cPosition[index]; i < this.carSize[index] + this.cPosition[index]; i++) {
//				this.board[this.fixedPosition[index]][i + step] = mov.charAt(0);
//			}
//
//			break;
//		case 'U':
//			for (int i = 0; i < this.carSize[index]; i++) {
//				this.board[this.cPosition[index] - step + i][this.fixedPosition[index]] = mov.charAt(0);
//			}
//
//			break;
//		case 'D':
//			for (int i = this.cPosition[index]; i < this.carSize[index] + this.cPosition[index]; i++) {
//				this.board[i + step][this.fixedPosition[index]] = mov.charAt(0);
//			}
//
//			break;
//		}
//
//	}
//
//	// for setPosition we only add or substract the length of move made.
//	public void setcPosition(String mov, int index) {
//		int step = (mov.charAt(2) - '0');
//		switch (mov.charAt(1)) {
//		case 'L':
//			this.cPosition[index] -= step;
//			break;
//		case 'R':
//			this.cPosition[index] += step;
//			break;
//		case 'U':
//			this.cPosition[index] -= step;
//			break;
//		case 'D':
//			this.cPosition[index] += step;
//			break;
//		}
//	}
//
//	/*
//	 * Legal Function - for checking if the move gives with the current board is
//	 * legal to be done or not meaning nothing blocking a car way, or its not out of
//	 * bounds.
//	 * 
//	 * in this method, decode the move to direction and car symbol and length of
//	 * leap. and by it cheak each parameter if legal.
//	 * 
//	 * @param
//	 * 
//	 * @index - the index of the car in the arrays for easy calculating.
//	 * 
//	 * @mov - the mov given which is build of 2 letters and a numbers example: "AL2"
//	 */
//
//	public boolean legal(String mov, int index) {
//
//		int step = (mov.charAt(2) - '0');
//		if ((mov.charAt(1) == 'L' || mov.charAt(1) == 'R') && (this.getCarOrient()[index] == 1))
//			return false;
//
//		else if ((mov.charAt(1) == 'U' || mov.charAt(1) == 'D') && (this.getCarOrient()[index] == 0))
//			return false;
//
//		else if (((mov.charAt(1) == 'L') && ((this.getcPosition()[index] - step) < 0)) || ((mov.charAt(1) == 'R')
//				&& ((this.getcPosition()[index] + this.getCarSize()[index] - 1 + step) >= this.getSize()))) {
//			return false;
//		} else if (((mov.charAt(1) == 'U') && ((this.getcPosition()[index] - step) < 0)) || ((mov.charAt(1) == 'D')
//				&& ((this.getcPosition()[index] + this.getCarSize()[index] - 1 + step) >= this.getSize()))) {
//			return false;
//		}
//
//		// checking if the way not blocked by another car using the board[][]
//		switch (mov.charAt(1)) {
//		case 'L':
//			for (int i = this.cPosition[index] - step; i < this.cPosition[index]; i++) {
//
//				if (board[this.fixedPosition[index]][i] != '.'
//						&& (board[this.fixedPosition[index]][i] != mov.charAt(0)))
//					return false;
//			}
//			break;
//		case 'R':
//			for (int i = 0; i < step; i++) {
//
//				if (board[this.fixedPosition[index]][this.cPosition[index] + this.carSize[index] + i] != '.'
//						&& (board[this.fixedPosition[index]][this.cPosition[index] + this.carSize[index] + i] != mov
//								.charAt(0)))
//					return false;
//			}
//			break;
//		case 'U':
//			for (int i = this.cPosition[index] - step; i < this.cPosition[index]; i++) {
//
//				if (board[i][this.fixedPosition[index]] != '.'
//						&& (board[i][this.fixedPosition[index]] != mov.charAt(0)))
//					return false;
//			}
//			break;
//		case 'D':
//			for (int i = 0; i < step; i++) {
//
//				if (board[this.cPosition[index] + this.carSize[index] + i][this.fixedPosition[index]] != '.'
//						&& (board[this.cPosition[index] + this.carSize[index] + i][this.fixedPosition[index]] != mov
//								.charAt(0)))
//					return false;
//			}
//			break;
//		}
//
//		return true;
//	}
}
