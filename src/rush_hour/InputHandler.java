package rush_hour;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * This static class handles Input reading and parsing for the user, gets as an
 * input the path of the file to read from, and defines API to get
 * RawPuzzleObject
 */
public final class InputHandler {
	private static Logger LOGGER = Logger.getLogger(Main.class.getName());

	private InputHandler() {
	}

	/**
	 * Static function to get parsed puzzle from an input file
	 * 
	 * @param inputFilePath - path to file to read from
	 * @return A list initialized with RawPuzzleObject which is parsed puzzle in raw
	 *         condition from input file.
	 */
	public static ArrayList<RawPuzzleObject> getPuzzles(ArrayList<String> rawPuzzles) {
		ArrayList<RawPuzzleObject> parsedPuzzles = new ArrayList<RawPuzzleObject>();
		rawPuzzles.forEach(rawPuzzle -> parsedPuzzles.add(new RawPuzzleObject(rawPuzzle)));
		return parsedPuzzles;
	}
}
