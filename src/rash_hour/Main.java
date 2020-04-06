package rash_hour;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static String getPuzzleInputFile(String[] args) {
		String inputFilePath = "./rh.txt";
		if (args.length > 0) {
			try {
				inputFilePath = args[0];
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
			LOGGER.warning("You didn't pass input file for this application, using default input file");
		}
		LOGGER.info("Puzzle input file path is: " + inputFilePath);
		return inputFilePath;
	}
	
	public static void main(String[] args) {
		LOGGER.setLevel(Level.WARNING);
		ArrayList<RawPuzzleObject> rawPuzzles = InputHandler.getPuzzles(getPuzzleInputFile(args));
		LOGGER.info("Input file read successfully!");
	}
}
