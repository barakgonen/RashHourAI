package search_engine.statistics_calculator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class handles writing statistics to an output file
 *
 */
public class StatisticsWriter<T extends GeneralSolutionStatisticsData> {
	protected Collection<T> solutionsDataCollection;

	public StatisticsWriter() {
		solutionsDataCollection = new ArrayList<>();
	}

	public void storeResult(T result) {
		solutionsDataCollection.add(result);
	}

	public void writeOutputFile() {
		for (T solution : solutionsDataCollection) {
			/// write to output file
			solution.getCsvHeader();
			solution.getData();
		}
	}
}
