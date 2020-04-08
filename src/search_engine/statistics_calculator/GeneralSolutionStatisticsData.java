package search_engine.statistics_calculator;

public class GeneralSolutionStatisticsData implements SolutionStatisticsData {

	int solutionIdentifier;

	// Will be extanded in the future with more than 1 StatisticsData object
	public GeneralSolutionStatisticsData(int solutionId) {
		solutionIdentifier = solutionId;
	}

	@Override
	public String getCsvHeader() {
		// TODO Auto-generated method stub
		return "\n";
	}

	@Override
	public String getData() {
		// TODO Auto-generated method stub
		return "\n";
	}

	public int getSolutionIdentifier() {
		return solutionIdentifier;
	}

}
