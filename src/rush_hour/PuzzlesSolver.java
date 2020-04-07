package rush_hour;

import java.util.ArrayList;
import java.util.logging.Logger;

import search_engine.astar.AStar;
import search_engine.astar.AStarSearchNode;
import search_engine.astar.AStarSolutionStatisticsData;
import search_engine.astar.SolvedAstarPuzzle;
import search_engine.statistics_calculator.StatisticsWriter;

public class PuzzlesSolver {
	private static Logger LOGGER = Logger.getLogger(Main.class.getName());

	protected StatisticsWriter<AStarSolutionStatisticsData> statisticsWriter;
	protected ArrayList<RawPuzzleObject> puzzlesToSolve;

	public PuzzlesSolver(StatisticsWriter<AStarSolutionStatisticsData> statisticsWriter_,
			ArrayList<RawPuzzleObject> puzzlesToSolve_) {
		statisticsWriter = statisticsWriter_;
		puzzlesToSolve = puzzlesToSolve_;
	}

	public void startSolve() {
		for (RawPuzzleObject rawPuzzle : puzzlesToSolve) {
			solveSinglePuzzle(rawPuzzle);
		}
		statisticsWriter.writeOutputFile();
	}

	private void solveSinglePuzzle(RawPuzzleObject rawPuzzle) {
		AStar<AStarSearchNode> searcher = new AStar<AStarSearchNode>();
		SolvedAstarPuzzle result = searcher.getBestSolution(new AStarSearchNode(rawPuzzle));
		statisticsWriter.storeResult(result.getStatisticsData());
	}
}
