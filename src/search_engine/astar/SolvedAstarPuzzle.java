package search_engine.astar;

import java.util.logging.Logger;

import rush_hour.Main;

public class SolvedAstarPuzzle {
	private static Logger LOGGER = Logger.getLogger(Main.class.getName());

	protected AStarSearchNode searchNode;
	protected AStarSolutionStatisticsData statisticsData;

	public SolvedAstarPuzzle(AStarSearchNode searchNode_, AStarSolutionStatisticsData statisticsData_) {
		searchNode = searchNode_;
		statisticsData = statisticsData_;
	}

	public AStarSearchNode getSearchNode() {
		return searchNode;
	}

	public void setSearchNode(AStarSearchNode searchNode) {
		this.searchNode = searchNode;
	}

	public AStarSolutionStatisticsData getStatisticsData() {
		return statisticsData;
	}

	public void setStatisticsData(AStarSolutionStatisticsData statisticsData) {
		this.statisticsData = statisticsData;
	}

}
