package rush_hour;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import search_engine.astar.AStarSolutionStatisticsData;
import search_engine.astar.AStarSolver;
import search_engine.astar.BlockersAndDistanceHeuristic;
import search_engine.statistics_calculator.StatisticsWriter;

public class Main {
	public static Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		LOGGER.setLevel(Level.WARNING);
		double timeLimitForPuzzle = GameUtils.getTimeLimitFromCommandLine(args);
		ArrayList<String> rawPuzzlesAsString = GameUtils.getRawPuzzlesFromInputFile(args);
		ArrayList<RawPuzzleObject> rawPuzzles = InputHandler.getPuzzles(rawPuzzlesAsString);
		LOGGER.info("Input file read successfully!");
		StatisticsWriter<AStarSolutionStatisticsData> statisticsWriter = new StatisticsWriter<>(
				GameUtils.getOutputFileName(args));
//		BlockersHeuristicCalculator h = new BlockersHeuristicCalculator();
		BlockersAndDistanceHeuristic h = new BlockersAndDistanceHeuristic();
//		TargetVehicleDistanceFromExitHeuristic h = new TargetVehicleDistanceFromExitHeuristic();

		AStarSolver searchAlgorithm = new AStarSolver(h, timeLimitForPuzzle);
//		IterativeDeepeningDFS searchAlgorithm = new IterativeDeepeningDFS(timeLimitForPuzzle);

		PuzzlesSolver solver = new PuzzlesSolver(statisticsWriter, rawPuzzles, h, searchAlgorithm);
		solver.startSolve();
	}
}
