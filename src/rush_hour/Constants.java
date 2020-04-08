package rush_hour;

import java.awt.Point;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Constants {
	public static final int BOARD_SIZE = 6;
	public static final int EXIT_RAW = BOARD_SIZE / 3; // In assignment it says in the upper 1/3 of the board, means raw
														// 2
	public static final char TARGET_VEHICLE_IDENTIFIER = 'X';
	public static final boolean HORIZONTAL = true;
	public static final boolean VERTICAL = false;
	public static final String RAW_CSV_PUZZELS_OUTPUT_PATH = "./rawPuzzlesAsCsv/";
	public static final String STATISTICS_CSV_OUTPUT_PATH = "./statisticsResults/";
	public static final Character UKNOWN_IDENTIFIER = ' ';
	public static final Collection<Point> TARGET_VEHICLE_EXIT_PATH = IntStream.rangeClosed(0, BOARD_SIZE - 1)
			.mapToObj(v -> new Point(EXIT_RAW, v)).collect(Collectors.toList());
}
