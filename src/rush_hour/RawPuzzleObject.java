package rush_hour;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Logger;

/**
 * This class Serializes and De-Serializes out puzzle object from String and to
 * String
 */
public class RawPuzzleObject {
	public static Logger LOGGER = Logger.getLogger(Main.class.getName());

	private char[][] puzzleBoard;

	private HashMap<Character, Vehicle> vehicles;
	private Collection<Point> emptySpots;
	private final int puzzleId;

	/**
	 * Construction of an instance out of puzzle string, read from input file
	 * 
	 * @param puzzleAsString - representation of current puzzle
	 */
	public RawPuzzleObject(String puzzleAsString, int puzzleID) {
		// Initialization of new char-board
		puzzleBoard = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		vehicles = new HashMap<Character, Vehicle>();
		emptySpots = new ArrayList<Point>();
		puzzleId = puzzleID;

		for (int row = 0; row < Constants.BOARD_SIZE; ++row)
			for (int col = 0; col < Constants.BOARD_SIZE; ++col)
				puzzleBoard[row][col] = puzzleAsString.charAt((row * Constants.BOARD_SIZE + col));
		buildVehiclesMap();
	}

	private void buildVehiclesMap() {
		for (int row = 0; row < Constants.BOARD_SIZE; ++row) {
			for (int col = 0; col < Constants.BOARD_SIZE; ++col) {
				char currentCellData = puzzleBoard[row][col];
				Point currentCoordinate = new Point(row, col);
				if (currentCellData != '.') {
					if (vehicles.containsKey(currentCellData))
						vehicles.get(currentCellData).updateVehicle(currentCoordinate);
					else
						vehicles.put(currentCellData, new Vehicle(currentCellData, currentCoordinate));
				} else
					emptySpots.add(currentCoordinate);
			}
		}
		LOGGER.info("Finished mapping cars");
	}

	public Collection<Point> getEmptySpots() {
		return emptySpots;
	}

	public void setEmptySpots(Collection<Point> emptySpots) {
		this.emptySpots = emptySpots;
	}

	public void setVehicles(HashMap<Character, Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public char[][] getPuzzleBoard() {
		return puzzleBoard;
	}

	@Override
	public boolean equals(Object o) {
		return isSameBoardRepresentation((RawPuzzleObject) o);
	}

	private boolean isSameBoardRepresentation(RawPuzzleObject other) {
		for (int row = 0; row < Constants.BOARD_SIZE; row++)
			for (int col = 0; col < Constants.BOARD_SIZE; col++)
				if (puzzleBoard[row][col] != other.getPuzzleBoard()[row][col])
					return false;
		return true;
	}

	public HashMap<Character, Vehicle> getVehiclesMapping() {
		return vehicles;
	}

	public Collection<Vehicle> getVehicles() {
		return vehicles.values();
	}

	public Set<Character> getVehiclesIdentifiers() {
		return vehicles.keySet();
	}

	public Vehicle getVehicle(char identifier) {
		return vehicles.get(identifier);
	}

	public int getPuzzleId() {
		return puzzleId;
	}
}