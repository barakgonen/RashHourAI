package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import rush_hour.GameUtils;

public class OutputFileNameTests {

	@Test
	void testOutputFileNameSetCorrectlyWhenThereAreNoArgumentsToProgram() {
		assertEquals("rh", GameUtils.getOutputFileName(new String[] {}));
	}

	@Test
	void testOutputFileNameSetCorrectlyWhenPassingArgumentsToProgram() {
		String inputFileName = "blablabla.txt";
		assertEquals(inputFileName.substring(0, inputFileName.indexOf('.')),
				GameUtils.getOutputFileName(new String[] { inputFileName }));
	}

	@Test
	void testOutputFileNameSetCorrectlyWhenPassingRealativePathAsArgumentToProgram() {
		String inputFileName = "C:/Users/barak/Documents/HaifaUniversity/AiLab/blablabla.txt";
		assertEquals("C:/Users/barak/Documents/HaifaUniversity/AiLab/blablabla",
				GameUtils.getOutputFileName(new String[] { inputFileName }));
	}

}
