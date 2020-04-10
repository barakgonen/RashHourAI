package tests;

import static org.junit.Assert.assertEquals;

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
import search_engine.astar.AStarSearchNode;

public class TestBoardCreation {
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

		RawPuzzleObject rawPuzzle = new RawPuzzleObject(puzzleAsString, 1);
		Set<Character> vehicles = rawPuzzle.getVehiclesIdentifiers();
		assertEquals(expectedIdentifiers, vehicles);
	}

	@Test
	public void testParsingAllPuzzlesFromInputFile() {
		ArrayList<String> rawPuzzlesAsString = GameUtils.getRawPuzzlesFromInputFile(new String[0]);
		for (String puzzle : rawPuzzlesAsString) {
			Set<Character> expectedIdentifiers = getCarsIdentifiers(puzzle);
			RawPuzzleObject rawPuzzle = new RawPuzzleObject(puzzle, 2);
			Set<Character> vehicles = rawPuzzle.getVehiclesIdentifiers();
			assertEquals(expectedIdentifiers, vehicles);
		}
	}

	@Test
	public void testParsedVerticalCarDataInSize3() {
		String puzzleAsString = "..OAAP..OB.PXXOB.PKQQQ..KDDEF.GG.EF.";
		RawPuzzleObject rawPuzzle = new RawPuzzleObject(puzzleAsString, 3);
		Vehicle expectedVehicle = TestsUtils.getVehicle('P', Constants.VERTICAL, 3, new Point(0, 5));

		assertEquals(expectedVehicle, rawPuzzle.getVehicle('P'));
	}

	@Test
	public void testParsedVerticalCarDataInSize2() {
		String puzzleAsString = "AABO..P.BO..PXXO..PQQQ...........RRR";
		RawPuzzleObject rawPuzzle = new RawPuzzleObject(puzzleAsString, 3);
		Vehicle expectedVehicle = TestsUtils.getVehicle('B', Constants.VERTICAL, 2, new Point(0, 2));

		assertEquals(expectedVehicle, rawPuzzle.getVehicle('B'));
	}

	@Test
	public void testParsedHorizontalCarDataInSize3() {
		String puzzleAsString = "OAAP..O..P..OXXP....BQQQ..B..E..RRRE";
		RawPuzzleObject rawPuzzle = new RawPuzzleObject(puzzleAsString, 3);
		Vehicle expectedVehicle = TestsUtils.getVehicle('Q', Constants.HORIZONTAL, 3, new Point(3, 3));

		assertEquals(expectedVehicle, rawPuzzle.getVehicle('Q'));
	}

	@Test
	public void testParsedHorizontalCarDataInSize2() {
		String puzzleAsString = "..OAAP..OB.PXXOB.PKQQQ..KDDEF.GG.EF.";
		RawPuzzleObject rawPuzzle = new RawPuzzleObject(puzzleAsString, 3);
		Vehicle expectedVehicle = TestsUtils.getVehicle('D', Constants.HORIZONTAL, 2, new Point(4, 1));

		assertEquals(expectedVehicle, rawPuzzle.getVehicle('D'));
	}

	@Test
	public void testCreateAnEmptyBoard() {
		String puzzleAsString = "............XX......................";
		RawPuzzleObject rawPuzzle = new RawPuzzleObject(puzzleAsString, 3);
		AStarSearchNode searchNode = new AStarSearchNode(rawPuzzle);

		assertEquals(21096, searchNode.getUUID());
	}
}
