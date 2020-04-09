package rush_hour;

import java.awt.Point;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Constants {
	public static final int BOARD_SIZE = 6;
	public static final int CAR_SIZE = 2;
	public static final int TRUCK_SIZE = 3;
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
	public static final Point GOAL_STATE_POS = new Point(EXIT_RAW, BOARD_SIZE - 1);
	public static final Map<Point, Integer> STATIC_POINT_TO_VALUE = Stream
			.of(new Object[][] { { new Point(0, 0), 1 }, { new Point(0, 1), 2 }, { new Point(0, 2), 3 },
					{ new Point(0, 3), 4 }, { new Point(0, 4), 5 }, { new Point(0, 5), 6 }, { new Point(1, 0), 7 },
					{ new Point(1, 1), 8 }, { new Point(1, 2), 9 }, { new Point(1, 3), 10 }, { new Point(1, 4), 11 },
					{ new Point(1, 5), 12 }, { new Point(2, 0), 13 }, { new Point(2, 1), 14 }, { new Point(2, 2), 15 },
					{ new Point(2, 3), 16 }, { new Point(2, 4), 17 }, { new Point(2, 5), 18 }, { new Point(3, 0), 19 },
					{ new Point(3, 1), 20 }, { new Point(3, 2), 21 }, { new Point(3, 3), 22 }, { new Point(3, 4), 23 },
					{ new Point(3, 5), 24 }, { new Point(4, 0), 25 }, { new Point(4, 1), 26 }, { new Point(4, 2), 27 },
					{ new Point(4, 3), 28 }, { new Point(4, 4), 29 }, { new Point(4, 5), 30 }, { new Point(5, 0), 31 },
					{ new Point(5, 1), 32 }, { new Point(5, 2), 33 }, { new Point(5, 3), 34 }, { new Point(5, 4), 35 },
					{ new Point(5, 5), 36 } })
			.collect(Collectors.toMap(data -> (Point) data[0], data -> (Integer) data[1]));
}
