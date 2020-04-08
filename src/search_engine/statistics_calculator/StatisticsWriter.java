package search_engine.statistics_calculator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import rush_hour.Constants;

/**
 * This class handles writing statistics to an output file
 *
 */
public class StatisticsWriter<T extends GeneralSolutionStatisticsData> {
	protected Collection<T> solutionsDataCollection;
	protected String outputFilePath;

	public StatisticsWriter(String outPutFilePath) {
		solutionsDataCollection = new ArrayList<>();
		outputFilePath = outPutFilePath;
	}

	public void storeResult(T result) {
		solutionsDataCollection.add(result);
	}

	public void writeOutputFile() {
		// Check if output directory exists
		File directory = new File(Constants.STATISTICS_CSV_OUTPUT_PATH);
		if (!directory.exists()) {
			directory.mkdir();
		}
		try {
			FileWriter myWriter = new FileWriter(outputFilePath + ".csv");
			for (T solution : solutionsDataCollection) {
				/// write to output file
				myWriter.write(solution.getCsvHeader());
				continue;
			}

			for (T solution : solutionsDataCollection) {
				solution.getData();
				myWriter.write(solution.getCsvHeader());
			}

			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred while writing output file");
			e.printStackTrace();
		}
	}
}
