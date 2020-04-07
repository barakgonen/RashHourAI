package rush_hour;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import search_engine.astar.AStarSolutionStatisticsData;
import search_engine.statistics_calculator.StatisticsWriter;

public class Main {
	public static Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		LOGGER.setLevel(Level.WARNING);
		ArrayList<String> rawPuzzlesAsString = GameUtils.getRawPuzzlesFromInputFile(args);
		ArrayList<RawPuzzleObject> rawPuzzles = InputHandler.getPuzzles(rawPuzzlesAsString);
		LOGGER.info("Input file read successfully!");
		PuzzlesSolver solver = new PuzzlesSolver(new StatisticsWriter<AStarSolutionStatisticsData>(), rawPuzzles);
		solver.startSolve();
	}
}
