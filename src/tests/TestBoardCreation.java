package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import rash_hour.RawPuzzleObject;

class TestBoardCreation {

	@Test
	void testBoardCreation() {
		RawPuzzleObject rawPuzzle = new RawPuzzleObject("...AAO..BBCOXXDECOFFDEGGHHIPPPKKIQQQ\r\n");
		assertEquals(rawPuzzle, new RawPuzzleObject("...AAO..BBCOXXDECOFFDEGGHHIPPPKKIQQQ\r\n"));
	}

	@Test
	void testNotifyingDifferentBoards() {
		assertNotEquals(new RawPuzzleObject("...AAO..BBCOXXDECOFFDEGGHHIPPPKKIQQQ\r\n"),
				new RawPuzzleObject("A..OOOABBC..XXDC.P..D..P..EFFP..EQQQ"));
	}
}
