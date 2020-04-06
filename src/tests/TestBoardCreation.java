package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.Test;

import rush_hour.Constants;
import rush_hour.GameUtils;
import rush_hour.RawPuzzleObject;
import rush_hour.Vehicle;

public class TestBoardCreation {

//	private static RawPuzzleObject buildRawPuzzleObject(String boardAsString) {
//		RawPuzzleObject rawPuzzle = new RawPuzzleObject();
//		int counter = 0;
//		char board[][] = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
//
//		// histogram array for calculating most of the params, such as numOfcars,
//		// carOrient, cPosition ..etc.
//		int[][] histogram = new int[26][5];
//
//		// loop for building init board[][]
//		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
//			for (int j = 0; j < Constants.BOARD_SIZE; j++) {
//				board[i][j] = boardAsString.charAt(counter);
//				counter++;
//			}
//		}
//
//		// loops for building other parameters using the histogram array .. ( the arrays
//		// of positions ..etc)
//		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
//			for (int j = 0; j < Constants.BOARD_SIZE; j++) {
//
//				if (board[i][j] != '.')
//					histogram[(board[i][j]) - 'A'][0]++;
//				if (histogram[(board[i][j]) - 'A'][0] == 1) {
//					histogram[(board[i][j]) - 'A'][3] = i;
//					histogram[(board[i][j]) - 'A'][4] = j;
//				}
//				if (('A' <= board[i][j]) && (board[i][j] < 'O')) {
//					histogram[(board[i][j]) - 'A'][2] = 2;
//				}
//				if (('O' <= board[i][j]) && (board[i][j] <= 'Z') && (board[i][j] != 'X')) {
//					histogram[(board[i][j]) - 'A'][2] = 3;
//				}
//
//				histogram[(board[i][j]) - 'A'][0] = 2;
//				if (((0 < j) && (j < Constants.BOARD_SIZE - 1))
//						&& ((board[i][j] == board[i][j - 1]) || board[i][j] == board[i][j + 1])) {
//
//					histogram[(board[i][j]) - 'A'][1] = 0;
//				}
//				if (((0 < i) && (i < Constants.BOARD_SIZE))
//						&& ((board[i][j] == board[i - 1][j]) || (board[i][j] == board[i + 1][j]))) {
//
//					histogram[(board[i][j]) - 'A'][1] = 1;
//
//				}
//
//			}
//		}
//
//		counter = 0;
//		for (int i = 0; i < 26; i++) {
//			if (histogram[i][0] != 0) {
//				counter++;
//			}
//		}
//
//		int numOfCars = counter;
//		int[] fixedPosition = new int[numOfCars];
//		int[] carOrient = new int[numOfCars];
//		int[] carSize = new int[numOfCars];
//		int[] cPosition = new int[numOfCars];
//		char[] carSymbol = new char[numOfCars];
//
//		counter = 1;
//		int tymp = 0;
//		// filling all the params accoording to the histogram.
//		for (int i = 0; i < 26; i++) {
//			if ((histogram[i][0] != 0) && ((i + 'A') != 'X')) {
//				tymp = i + 'A';
//
//				carSymbol[counter] = (char) tymp;
//				carSize[counter] = histogram[i][2];
//				carOrient[counter] = histogram[i][1];
//				if (carOrient[counter] == 0) {
//					fixedPosition[counter] = histogram[i][3];
//					cPosition[counter] = histogram[i][4];
//				} else {
//					fixedPosition[counter] = histogram[i][4];
//					cPosition[counter] = histogram[i][3];
//				}
//				counter++;
//			} else if ((i + 'A') == 'X') {
//				carSymbol[0] = 'X';
//				carSize[0] = 2;
//				carOrient[0] = 0;
//				fixedPosition[0] = histogram[i][3];
//				cPosition[0] = histogram[i][4];
//			}
//		}
//
//		rawPuzzle.setCarOrient(carOrient);
//		rawPuzzle.setNumOfCars(numOfCars);
//		rawPuzzle.setPuzzleBoard(board);
//		rawPuzzle.setCarSymbol(carSymbol);
//		rawPuzzle.setcPosition(cPosition);
//		rawPuzzle.setCarSize(carSize);
//		rawPuzzle.setFixedPosition(fixedPosition);
//		return rawPuzzle;
//	}

	Vehicle getVehicle(char identifier, boolean orientation, int size, Point startPoint, Point endPoint) {
		Vehicle vehicleToBuild = new Vehicle(identifier, startPoint);
		vehicleToBuild.setEndPos(endPoint);
		vehicleToBuild.setOrientation(orientation);
		vehicleToBuild.setSize(size);

		return vehicleToBuild;
	}

	public Set<Character> getCarsIdentifiers(String puzzle) {
		SortedSet<Character> identifiers = new TreeSet<>();
		for (char c : puzzle.toCharArray()) {
			if (c != '.') {
				identifiers.add(c);
			}
		}
		return identifiers;
	}

	@Test
	public void testIdentifiersParserFunc() {
		String puzzleAsString = ".AR.BB.AR...XXR...IDDEEPIFFGHPQQQGHP";
		Set<Character> expectedIdentifiers = getCarsIdentifiers(puzzleAsString);
		Character[] expectedManualIdentifiers = { 'A', 'R', 'B', 'P', 'H', 'G', 'Q', 'F', 'D', 'E', 'I', 'X' };
		List<Character> l1 = new ArrayList<Character>(Arrays.asList(expectedManualIdentifiers));
		l1 = l1.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
		assertEquals(expectedIdentifiers.toArray(), l1.toArray());
	}

	@Test
	public void testIdentifyingCarKeys() {
		String puzzleAsString = ".AR.BB.AR...XXR...IDDEEPIFFGHPQQQGHP";
		Set<Character> expectedIdentifiers = getCarsIdentifiers(puzzleAsString);

		RawPuzzleObject rawPuzzle = new RawPuzzleObject(puzzleAsString);
		Set<Character> vehicles = rawPuzzle.getVehiclesIdentifiers();
		assertEquals(expectedIdentifiers, vehicles);
	}

	@Test
	public void testParsingAllPuzzlesFromInputFile() {
		ArrayList<String> rawPuzzlesAsString = GameUtils
				.getRawPuzzlesFromInputFile(GameUtils.getPuzzleInputFile(new String[0]));
		for (String puzzle : rawPuzzlesAsString) {
			Set<Character> expectedIdentifiers = getCarsIdentifiers(puzzle);
			RawPuzzleObject rawPuzzle = new RawPuzzleObject(puzzle);
			Set<Character> vehicles = rawPuzzle.getVehiclesIdentifiers();
			assertEquals(expectedIdentifiers, vehicles);
		}
	}

	@Test
	public void testParsedVerticalCarDataInSize3() {
		String puzzleAsString = "..OAAP..OB.PXXOB.PKQQQ..KDDEF.GG.EF.";
		RawPuzzleObject rawPuzzle = new RawPuzzleObject(puzzleAsString);
		Vehicle expectedVehicle = getVehicle('P', Constants.VERTICAL, 3, new Point(0, 5), new Point(2, 5));
		Vehicle actualVehicle = rawPuzzle.getVehicle('P');
		assertTrue(expectedVehicle.equals(actualVehicle));
	}

	@Test
	public void testParsedVerticalCarDataInSize2() {
		String puzzleAsString = "AABO..P.BO..PXXO..PQQQ...........RRR";
		RawPuzzleObject rawPuzzle = new RawPuzzleObject(puzzleAsString);
		Vehicle expectedVehicle = getVehicle('B', Constants.VERTICAL, 2, new Point(0, 2), new Point(1, 2));

		assertEquals(expectedVehicle, rawPuzzle.getVehicle('B'));
	}

	@Test
	public void testParsedHorizontalCarDataInSize3() {
		String puzzleAsString = "OAAP..O..P..OXXP....BQQQ..B..E..RRRE";
		RawPuzzleObject rawPuzzle = new RawPuzzleObject(puzzleAsString);
		Vehicle expectedVehicle = getVehicle('Q', Constants.HORIZONTAL, 3, new Point(3, 3), new Point(3, 5));

		assertEquals(expectedVehicle, rawPuzzle.getVehicle('Q'));
	}

	@Test
	public void testParsedHorizontalCarDataInSize2() {
		String puzzleAsString = "..OAAP..OB.PXXOB.PKQQQ..KDDEF.GG.EF.";
		RawPuzzleObject rawPuzzle = new RawPuzzleObject(puzzleAsString);
		Vehicle expectedVehicle = getVehicle('D', Constants.HORIZONTAL, 2, new Point(4, 1), new Point(4, 2));

		assertEquals(expectedVehicle, rawPuzzle.getVehicle('D'));
	}

//	@Test
//	void testBoardCreation() {
//		String puzzleAsString = "...AAO..BBCOXXDECOFFDEGGHHIPPPKKIQQQ\r\n";
//		RawPuzzleObject rawPuzzle = new RawPuzzleObject(puzzleAsString);
//		assertEquals(rawPuzzle, buildRawPuzzleObject(puzzleAsString));
//	}

//	@Test
//	void testNotifyingDifferentBoards() {
//		assertNotEquals(new RawPuzzleObject("...AAO..BBCOXXDECOFFDEGGHHIPPPKKIQQQ\r\n"),
//				buildRawPuzzleObject("A..OOOABBC..XXDC.P..D..P..EFFP..EQQQ"));
//	}
}
