package search_engine.statistics_calculator;

/**
 * This interface describes how any statistics object should do - write it's
 * header in CSV format and write data
 */
public interface SolutionStatisticsData {

	public String getCsvHeader();

	public String getData();
}
