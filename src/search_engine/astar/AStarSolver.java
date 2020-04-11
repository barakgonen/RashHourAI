package search_engine.astar;

import search_engine.SearchAlgorithmSolver;

public class AStarSolver implements SearchAlgorithmSolver {

	private HeuristicsCalculator calculator;
	private double timeLimit;

	public AStarSolver(HeuristicsCalculator calc, double timeLimitForPuzzle) {
		// TODO Auto-generated constructor stub
		calculator = calc;
		timeLimit = timeLimitForPuzzle;
	}

	@Override
	public SolvedPuzzle getBestSolution(AStarSearchNode start) {
		AStar searcher = new AStar();
		return searcher.getBestSolution(start, calculator, timeLimit);
	}
}
