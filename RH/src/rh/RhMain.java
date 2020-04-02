package rh;

import java.io.IOException;

public class RhMain {
	public static void main(String[] args) throws IOException {
		ReadPuzzle puzzle= new ReadPuzzle();
		//System.out.println(puzzle.getPuzzle().get(1));
		int index=1;
		for (String line : puzzle.getPuzzle()) {
		System.out.println("Puzzle " + index + " = " + line + "\n");
		index++;
		}
	}
}
