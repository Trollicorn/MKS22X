public class QueenBoard{

	private int[][] board;
	private int sum;

	public QueenBoard(int size){
		board = new int[size][size];
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){
				board[i][j] = 0;
			}
		}
	}

	private boolean addQueen(int r, int c){
		if (board[r][c] != 0){
			return false;
		}
		board[r][c] = -1;
		int increment = 1; 
		for (int i = c+1; i < board.length; i++){
			board[r][i]+=1;
			if (r+increment < board.length){
				board[r+increment][i]+=1;
			}
			if (r-increment > -1){
				board[r-increment][i]+=1;
			}
			increment += 1;
		}
		return true;
	}

	private boolean removeQueen(int r, int c){
		if (board[r][c] != -1){
			return false;
		}
		board[r][c] = 0;
		int increment = 1; 
		for (int i = c+1; i < board.length; i++){
			board[r][i]-=1;
			if (r+increment < board.length){
				board[r+increment][i]-=1;
			}
			if (r-increment > -1){
				board[r-increment][i]-=1;
			}
			increment += 1;
		}
		return true;
	}

	public String toString(){
		String str = "";
		for (int r = 0; r < board.length; r++){
			for (int c = 0; c < board.length; c++){
				if (board[r][c] == -1){
					str += "Q ";
				}
				else {
					str += "_ ";
				}
			}
			str += "\n";
		}
		return str;
	}

	public boolean solve(){
		if (isBad()){
			throw new IllegalStateException();
		}
		return solveHelp(0);
	}

	private boolean solveHelp(int c){
		if (c == board.length){
			return true;
		}
		for (int r = 0; r < board.length; r++){
			if (addQueen(r,c)){
				if (solveHelp(c+1)){
					return true;
				}
				removeQueen(r,c);
			}
		}
		return false;
	}

	public int countSolutions(){
		if (isBad()){
			throw new IllegalStateException();
		}
		sum = 0;
		countHelp(0);
		return sum;
	}

	private void countHelp(int c){
		if (c == board.length){
			sum += 1;
			return;
		}
		for (int r = 0; r < board.length; r++){
			if (addQueen(r,c)){
				countHelp(c+1);
				removeQueen(r,c);
			}
		}
	}


	private boolean isBad(){
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board.length; j++){
				if (board[i][j] != 0){
					return true;
				}
			}
		}
		return false;
	}


/*	public static void main(String[] args){
		QueenBoard board = new QueenBoard(8);
	//	board.addQueen(4,4);
	//	board.removeQueen(1,1);
		System.out.println(board.countSolutions());
		System.out.println(board.solve());
		System.out.println(board);
	}
*/


	// THE FOLLOWING MAIN METHOD WAS CONTRIBUTED BY A FELLOW STUDENT

	public static void main(String[] args){
		QueenBoard b = new QueenBoard(4);

 	    System.out.println(b.solve()); //prints true
		System.out.println(b); //prints a valid solution

		try{
			b.solve();
		}catch(IllegalStateException e){
			System.out.println("Error: The board contains non-zero values");
    	} //prints "Error: The board contains non-zero values"

    	try{
    		b.countSolutions();
    	}catch(IllegalStateException e){
    		System.out.println("Error: The board contains non-zero values");
	    } //prints "Error: The board contains non-zero values"

	    for (int i = 0; i < 12; i++){
	    	QueenBoard a = new QueenBoard(i);
	    	System.out.println("# of Solutions for " + i + ": " + a.countSolutions());

	      /*          Expected Values
	       i --> # of Solutions   i --> # of Solutions
	      0 --> 1                      6 --> 4
	      1 --> 1                      7 --> 40
	      2 --> 0                      8 --> 92
	      3 --> 0                      9 --> 352
	      4 --> 2                    10 --> 724
	      5 --> 10                  11 --> 2680
	      */
	      System.out.println(a); //prints out an empty i by i grid of underscores
	    }
	}

}



