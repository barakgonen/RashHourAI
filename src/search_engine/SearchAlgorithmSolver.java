package search_engine;

import search_engine.astar.AStarSearchNode;
import search_engine.astar.SolvedPuzzle;

public interface SearchAlgorithmSolver {
	SolvedPuzzle getBestSolution(AStarSearchNode start);
}
