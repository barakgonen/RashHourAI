package rush_hour;

import java.util.ArrayList;
import java.util.logging.Logger;

import search_engine.SearchAlgorithmSolver;
import search_engine.astar.AStarSearchNode;
import search_engine.astar.AStarSolutionStatisticsData;
import search_engine.astar.HeuristicsCalculator;
import search_engine.astar.SolvedPuzzle;
import search_engine.statistics_calculator.StatisticsWriter;

public class PuzzlesSolver {
	private static Logger LOGGER = Logger.getLogger(Main.class.getName());

	protected StatisticsWriter<AStarSolutionStatisticsData> statisticsWriter;
	protected ArrayList<RawPuzzleObject> puzzlesToSolve;
	private HeuristicsCalculator calculator;
	private SearchAlgorithmSolver puzzleSolver;

	public PuzzlesSolver(StatisticsWriter<AStarSolutionStatisticsData> statisticsWriter_,
			ArrayList<RawPuzzleObject> puzzlesToSolve_, HeuristicsCalculator calculator_,
			SearchAlgorithmSolver puzzleSolver_) {
		statisticsWriter = statisticsWriter_;
		puzzlesToSolve = puzzlesToSolve_;
		calculator = calculator_;
		puzzleSolver = puzzleSolver_;
	}

	public void startSolve() {
		for (RawPuzzleObject rawPuzzle : puzzlesToSolve) {
			solveSinglePuzzle(rawPuzzle);
		}
		statisticsWriter.writeOutputFile();
	}

	private void solveSinglePuzzle(RawPuzzleObject rawPuzzle) {
		SolvedPuzzle result = puzzleSolver.getBestSolution(new AStarSearchNode(rawPuzzle, calculator));
		if (result != null)
			statisticsWriter.storeResult(result.getStatisticsData());
	}
}
