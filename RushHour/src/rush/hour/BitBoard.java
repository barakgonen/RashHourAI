package rush.hour;

/*
 * This class represents minimized board
 */
public class BitBoard {
	public BitBoard() {
		
	}

}
/*
 *		INPUT BitBoard 							OUTPUT 

									         1 2 3 4 5 6
										   +-------------+ 
										 1 | O A A . B . | 
										 2 | O C D . B P | 
			?				->		 	 3 | O C D X X P 
										 4 | Q Q Q E . P | 
										 5 | . . F E G G | 
										 6 | H H F I I . | 
										   +-------------+ 
										     a b c d e f
	       
	    build a dictionary like that
	    0000 .
	    0001 A
	    .
	    .
	    .
	    1111 Q
	    
	    8 bits 1 byte
	    
	        row
	list<list<int>>
	need to define digit for each car color -> for O -> 1  binary representation for each car color 111
	assume we have 16 different car colors thus each list cell weights 4 bits
	4 * 36 = 144 bits
	16 * 36 = 576 bits
	for (cols )
		for (rows)
			System.out.orint(ConvertBinaryToCharacter(binary));

	
	
 */