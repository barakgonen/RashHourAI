package search_engine.astar;

import search_engine.SearchAlgorithmSolver;

/**
 * this class performs BFS search
 *
 */
public class IterativeDeepeningDFS implements SearchAlgorithmSolver {

	private double timeToSolve;

	public IterativeDeepeningDFS(double timeLimit) {
		// TODO Auto-generated constructor stub
		timeToSolve = timeLimit;
	}

	@Override
	public SolvedPuzzle getBestSolution(AStarSearchNode start) {
		int s = 1;
		AStarSearchNode goal = null;
		long startTime = System.currentTimeMillis();
		while (s != 0) {

			goal = DLC(start, s, startTime);
			if (goal != null) {
				System.out.println(start.getPuzzleSolution());
				return null;
			}
			long currentTime = System.currentTimeMillis() - startTime;
			if (goal == null && currentTime > timeToSolve) {
				System.out.println("FAILED");
				break;
			}

			s++;
		}

		return null;
	}

	private AStarSearchNode DLC(AStarSearchNode current, int depth, long startTime) {
		long currentTime = System.currentTimeMillis() - startTime;

		if (currentTime > timeToSolve)
			return null;
		if (depth == 1 && current.isGoalNode()) {
			return current;
		}
		if (depth > 1) {
			for (AStarSearchNode searchNode : current.getSuccessors()) {
				AStarSearchNode temp = DLC(searchNode, depth - 1, startTime);
				if (temp != null)
					return temp;
			}
		}
		return null;
	}
}
