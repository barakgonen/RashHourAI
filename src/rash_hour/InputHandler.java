package rash_hour;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class InputHandler {

	public ArrayList<String> getPuzzle() throws IOException {
		ArrayList<String> allLines = (ArrayList<String>) Files.readAllLines(Paths.get("C:\\Users\\yasseen\\eclipse-workspace\\RH\\rh.txt"));
		/*for (String line : allLines) {
			System.out.println(line);
		}*/
		//int index =0;
		//System.out.println("line 1 = " +allLines.get(index));	
		return allLines;
	}	
}



