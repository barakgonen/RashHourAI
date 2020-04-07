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

	public AStarSolutionStatisticsData() {
		super();
		penetrance = 0;
		branchingFactor = 0;
		numberOfNodes = 0;
		avgHeuristic = 0;
		avgSum = 0;
		avgDepth = 0;
		startTime = System.currentTimeMillis();
		minDepth = Integer.MAX_VALUE;
		maxDepth = 0;
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

	public void setBranchingFactor(int numberOfNodesPassed) {
		branchingFactor = Math.pow(numberOfNodesPassed, 1 / totalStepsPassed);
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

	@Override
	public String getCsvHeader() {
		// TODO Auto-generated method stub
		return "numberOfNodes,AverageDepth,MaxDepth,Average-Heuristic,Penetrance,Branching-Factor,TotalCalculationTime\n";
	}

	@Override
	public String getData() {
		// TODO Auto-generated method stub
		return numberOfNodes + "," + avgDepth + "," + maxDepth + "," + avgHeuristic + "," + penetrance + ","
				+ branchingFactor + "," + (endTime - startTime) + "\n";
	}
}
