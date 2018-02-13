public class KnightBoard{

	private int[][] board;

	public KnightBoard(int startingRows, int startingCols){
		if (startingRows < 0 || startingCols < 0){
			throw new IllegalArgumentException();
		}
		board = new int[startingRows][startingCols];
		for (int r = 0; r < startingRows; r++){
			for (int c = 0; c < startingCols; c++){
				board[r][c] = 0;
			}
		}
	}

	public String toString(){
		String gather = "";
		for (int r = 0; r < board.length; r++){
			for (int c = 0; c < board.length; c++){
				if (board[r][c] / 10 == 0){
					gather += " ";
				}
				gather += board[r][c] + " ";
			}
			gather += "\n";
		}
		return gather;
	}

	public boolean solve(int row, int col){
		if (isBad()){
			throw new IllegalStateException();
		}
		return solveHelp(row,col,1);
	}

	private boolean solveHelp(int row, int col, int level){
		if (level == board.length * board[0].length){
			return true;
		}
		board[row][col] = level;
		for (int mode = 0; mode < 8; mode++){
			if (moveKnight(row,col,level,mode)){
				return solveHelp(row,col,level+1);				
			}
		}

	}

	private boolean moveKnight(int row, int col, int level, int mode){
		int rowInc = 0;
		int colInc = 0;          // _ 7 _ 0 _        
		if (mode == 0){          // 6 _ _ _ 1   
			rowInc = -2;         // _ _ K _ _ 
			colInc = 1;          // 5 _ _ _ 2
		}                        // _ 4 _ 3 _
		if (mode == 1){
			rowInc = -1; 
			colInc = 2;
		}
		if (mode == 2){
			rowInc = 1; 
			colInc = 2;
		}
		if (mode == 3){
			rowInc = 2; 
			colInc = 1;
		}
		if (mode == 4){
			rowInc = 2; 
			colInc = -1;
		}
		if (mode == 5){
			rowInc = 1; 
			colInc = -2;
		}
		if (mode == 6){
			rowInc = -1; 
			colInc = -2;
		}
		if (mode == 7){
			rowInc = -2; 
			colInc = -1;
		}
		int moveRow = row + rowInc;
		int moveCol = col + colInc;
		if (moveRow >= board.length    || moveRow < 0 ||
			moveCol >= board[0].length || moveCol < 0 ||
			board[moveRow][moveCol] != 0){
			return false;
	}
	board[row][col] = level;
	return true;
}

public int countSolutions(){
	return 1;
}

private boolean isBad(){
	for (int r = 0; r < board.length; r++){
		for (int c = 0; c < board.length; c++){
			if (board[r][c] != 0){
				return true;
			}
		}
	}
	return false;
}

}