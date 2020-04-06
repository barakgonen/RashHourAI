package rush_hour;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	public static Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		LOGGER.setLevel(Level.WARNING);
		String inputFileName = GameUtils.getPuzzleInputFile(args);
		ArrayList<String> rawPuzzlesAsString = GameUtils.getRawPuzzlesFromInputFile(inputFileName);
		GameUtils.parsePuzzlesToCsv(rawPuzzlesAsString);
		ArrayList<RawPuzzleObject> rawPuzzles = InputHandler.getPuzzles(rawPuzzlesAsString);
		LOGGER.info("Input file read successfully!");
	}
}
