package search_engine.astar;

import java.util.logging.Logger;

import rush_hour.Main;

public class SolvedPuzzle {
	private static Logger LOGGER = Logger.getLogger(Main.class.getName());

	protected AStarSolutionStatisticsData statisticsData;

	public SolvedPuzzle(AStarSolutionStatisticsData statisticsData_) {
		statisticsData = statisticsData_;
	}

	public AStarSolutionStatisticsData getStatisticsData() {
		return statisticsData;
	}

	public void setStatisticsData(AStarSolutionStatisticsData statisticsData) {
		this.statisticsData = statisticsData;
	}

}
