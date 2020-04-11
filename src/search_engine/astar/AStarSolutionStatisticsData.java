package search_engine.astar;

import search_engine.statistics_calculator.GeneralSolutionStatisticsData;

public class AStarSolutionStatisticsData extends GeneralSolutionStatisticsData {
	protected double penetrance;
	protected double branchingFactor;
	protected int numberOfNodes;
	protected double avgHeuristic;
	protected int totalStepsPassed;
	protected int avgCounter;
	protected double avgSum;
	protected double avgDepth;
	protected long startTime;
	protected long endTime;
	protected int minDepth;
	protected int maxDepth;
	protected String puzzleSolution;
	protected String heuristicName;
	protected String hasSolved;

	public AStarSolutionStatisticsData(int solutionID, String hName) {
		super(solutionID);
		penetrance = 0;
		branchingFactor = 0;
		numberOfNodes = 0;
		avgHeuristic = 0;
		avgSum = 0;
		avgDepth = 0;
		startTime = System.currentTimeMillis();
		minDepth = Integer.MAX_VALUE;
		maxDepth = 0;
		puzzleSolution = "";
		heuristicName = hName;
		hasSolved = "N";

	}

	public void setNumberOfPassedMoves(int passedMoves) {
		totalStepsPassed = passedMoves;
	}

	public int getNumberOfNodes() {
		return numberOfNodes;
	}

	public void increaseNumberOfNodes() {
		numberOfNodes++;
	}

	public void setNumberOfNodes(int numOfNodes) {
		numberOfNodes = numOfNodes;
	}

	public void increaseHeuristicCounter(double currentNodesHeuristics) {
		avgHeuristic += currentNodesHeuristics;
	}

	public void setBranchingFactor(int closedListSize) {
		computeBranchingFactor(closedListSize);
	}

	public void setPenetrance(double numberOfNodesPassed) {
		penetrance = totalStepsPassed / numberOfNodesPassed;
	}

	public void increaseAvgCounter() {
		avgCounter++;
	}

	public void increaseAvgSum(int val) {
		avgSum += val;
	}

	public void calculateFinalData() {
		if (avgCounter != 0)
			avgDepth = (avgSum / avgCounter);
		if (numberOfNodes != 0)
			avgHeuristic /= numberOfNodes;
		endTime = System.currentTimeMillis();
	}

	public long getTotalRunningTimeForSolution() {
		return endTime - startTime;
	}

	public void setMinDepthIfNeeded(int possibleMinDepth) {
		if (minDepth > possibleMinDepth)
			minDepth = possibleMinDepth;
	}

	public void setMaxDepthIfNeeded(int possibleMaxDepth) {
		if (maxDepth < possibleMaxDepth)
			maxDepth = possibleMaxDepth;
	}

	public void setPuzzleSolution(String solution) {
		puzzleSolution = solution;
		hasSolved = "Y";
	}

	@Override
	public String getCsvHeader() {
		// TODO Auto-generated method stub
		return "Problem,HeuristicName,N,d/N,Success(Y/N),Time(ms),EBF,avg H value, min Depth, max Depth,Puzzle-Solution\n";
	}

	@Override
	public String getData() {
		// TODO Auto-generated method stub
		return solutionIdentifier + "," + heuristicName + "," + numberOfNodes + "," + penetrance + "," + hasSolved + ","
				+ (endTime - startTime) + "," + branchingFactor + "," + avgHeuristic + "," + minDepth + "," + maxDepth
				+ "," + puzzleSolution + "\n";
	}

	private void computeBranchingFactor(int epandedNodesCounter) {
		double n = epandedNodesCounter;

		double b_lo = 1.;
		double f_lo = 1. + this.maxDepth;
		double b_hi = b_lo;
		double f_hi = f_lo;

		while (f_hi < n) {
			b_hi *= 2.;
			f_hi = geo_sum(b_hi, this.maxDepth);
		}

		while (b_hi - b_lo > 0.00001) {
			double b_mid = (b_hi + b_lo) * 0.5;
			double f_mid = geo_sum(b_mid, this.maxDepth);

			if (f_mid > n) {
				b_hi = b_mid;
				f_hi = f_mid;
			} else {
				b_lo = b_mid;
				f_lo = f_mid;
			}
		}

		branchingFactor = b_lo;
	}

	private static double geo_sum(double b, int d) {
		double s = 1.;

		for (int i = 0; i < d; i++) {
			s = s * b + 1.;
		}

		return s;
	}
}
