package rash_hour;

/**
 * This class Serializes and De-Serializes out puzzle object from String and to
 * String
 */
public class RawPuzzleObject {

	/**
	 * Construction of an instance out of puzzle string, read from input file
	 * 
	 * @param puzzleAsString - representation of current puzzle
	 */
	private char[][] puzzleBoard;

	public RawPuzzleObject(String puzzleAsString) {
		puzzleBoard = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		for (int row = 0; row < Constants.BOARD_SIZE; ++row)
			for (int col = 0; col < Constants.BOARD_SIZE; ++col)
				puzzleBoard[row][col] = puzzleAsString.charAt((row * Constants.BOARD_SIZE + col));
	}

	public char[][] getPuzzleBoard() {
		return puzzleBoard;
	}

	@Override
	public boolean equals(Object o) {
		return isSameBoardRepresentation((RawPuzzleObject) o);
	}

	private boolean isSameBoardRepresentation(RawPuzzleObject other) {
		for (int row = 0; row < Constants.BOARD_SIZE; row++)
			for (int col = 0; col < Constants.BOARD_SIZE; col++)
				if (puzzleBoard[row][col] != other.getPuzzleBoard()[row][col])
					return false;
		return true;
	}
}
/*
 * 
 * int counter=0; this.board = new char[size][size];
 * 
 * // histogram array for calculating most of the params, such as numOfcars,
 * carOrient, cPosition ..etc. int[][] histogram = new int[26][5];
 * 
 * // loop for building init board[][] for(int i = 0 ; i<this.size ; i++) {
 * for(int j = 0 ; j<this.size ; j++) { this.board[i][j] = init.charAt(counter);
 * counter++; } }
 * 
 * // loops for building other parameters using the histogram array .. ( the
 * arrays of positions ..etc) for(int i = 0 ; i<this.size ; i++) { for(int j = 0
 * ; j<this.size ; j++) {
 * 
 * if(this.board[i][j] != '.' ) {
 * 
 * histogram[(this.board[i][j]) - 'A'][0]++; if(histogram[(this.board[i][j]) -
 * 'A'][0] == 1) { histogram[(this.board[i][j]) - 'A'][3] = i;
 * histogram[(this.board[i][j]) - 'A'][4] = j; } if( ('A' <= this.board[i][j])
 * && (this.board[i][j] < 'O') ) { histogram[(this.board[i][j]) - 'A'][2] = 2; }
 * if( ('O' <= this.board[i][j]) && (this.board[i][j] <= 'Z') &&
 * (this.board[i][j] != 'X') ) { histogram[(this.board[i][j]) - 'A'][2] = 3; }
 * 
 * histogram[(this.board[i][j]) - 'A'][0] = 2; if(((0<j) && (j<this.size-1)) &&
 * ((this.board[i][j] == this.board[i][j-1]) || this.board[i][j] ==
 * this.board[i][j+1])) {
 * 
 * histogram[(this.board[i][j]) - 'A'][1] = 0;
 * 
 * } if(((0<i) && (i<this.size -1)) && ((this.board[i][j] == this.board[i-1][j])
 * || (this.board[i][j] == this.board[i+1][j]))) {
 * 
 * histogram[(this.board[i][j]) - 'A'][1] = 1;
 * 
 * }
 * 
 * } } }
 * 
 * 
 * counter = 0; for(int i =0; i< 26 ; i++) { if(histogram[i][0] != 0) {
 * counter++; } } numOfCars = counter; fixedPosition = new int[numOfCars];
 * carOrient = new int[numOfCars]; carSize = new int[numOfCars]; cPosition = new
 * int[numOfCars]; carSymbol = new char[numOfCars]; counter =1; int tymp=0;
 * 
 * //filling all the params accoording to the histogram. for(int i =0; i< 26 ;
 * i++) { if((histogram[i][0] != 0) && ((i+'A')!= 'X')) { tymp = i+'A';
 * 
 * carSymbol[counter] = (char) tymp; carSize[counter] = histogram[i][2];
 * carOrient[counter] = histogram[i][1]; if(carOrient[counter] == 0) {
 * fixedPosition[counter] = histogram[i][3]; cPosition[counter] =
 * histogram[i][4]; } else { fixedPosition[counter] = histogram[i][4];
 * cPosition[counter] = histogram[i][3]; } counter++; } else if((i+'A') == 'X')
 * { carSymbol[0] = 'X'; carSize[0] = 2; carOrient[0] = 0; fixedPosition[0] =
 * histogram[i][3]; cPosition[0] = histogram[i][4]; } }
 * 
 * }
 */
