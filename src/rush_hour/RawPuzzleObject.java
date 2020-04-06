package rush_hour;

import java.awt.Point;
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

	/**
	 * Construction of an instance out of puzzle string, read from input file
	 * 
	 * @param puzzleAsString - representation of current puzzle
	 */
	public RawPuzzleObject(String puzzleAsString) {
		// Initialization of new char-board
		puzzleBoard = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		vehicles = new HashMap<Character, Vehicle>();

		for (int row = 0; row < Constants.BOARD_SIZE; ++row)
			for (int col = 0; col < Constants.BOARD_SIZE; ++col)
				puzzleBoard[row][col] = puzzleAsString.charAt((row * Constants.BOARD_SIZE + col));
		setVehiclesMap();

	}

	private void setVehiclesMap() {
		char currentCellData;
		for (int row = 0; row < Constants.BOARD_SIZE; ++row) {
			for (int col = 0; col < Constants.BOARD_SIZE; ++col) {
				currentCellData = puzzleBoard[row][col];
				if (currentCellData != '.') {
					if (vehicles.containsKey(currentCellData))
						vehicles.get(currentCellData).updateVehicle(new Point(row, col));
					else
						vehicles.put(currentCellData, new Vehicle(currentCellData, new Point(row, col)));
				}
			}
		}
		LOGGER.info("Finished mapping cars");
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

	public Collection<Vehicle> getVehicles() {
		return vehicles.values();
	}

	public Set<Character> getVehiclesIdentifiers() {
		return vehicles.keySet();
	}

	public Vehicle getVehicle(char identifier) {
		return vehicles.get(identifier);
	}
}