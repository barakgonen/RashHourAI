package rash_hour;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This static class handles Input reading and parsing for the user, 
 * gets as an input the path of the file to read from, and defines API to get RawPuzzleObject
 */
public final class InputHandler {
    private static Logger LOGGER = Logger.getLogger(Main.class.getName());
	
	private InputHandler() {
	}
		
	/**
	 * Static function to get parsed puzzle from an input file
	 * @param inputFilePath - path to file to read from
	 * @return A list initialized with RawPuzzleObject which is parsed puzzle in raw condition from 
	 * 			input file.
	 */
	public static ArrayList<RawPuzzleObject> getPuzzles(String inputFilePath) {
		ArrayList<RawPuzzleObject> parsedPuzzles = new ArrayList<RawPuzzleObject>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(inputFilePath));
			String line = reader.readLine();
			while (line != null) {
				LOGGER.info("Read the following line from file: " + line);
				parsedPuzzles.add(new RawPuzzleObject(line, 1));
				LOGGER.info("Parsed puzzle successfully and added to list");
				line = reader.readLine();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
			LOGGER.severe("IOException had catched, exiting the application!");
			System.exit(-1);
		}
			
		return parsedPuzzles;
	}	
}



