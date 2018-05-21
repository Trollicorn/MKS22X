public class KnightBoard{

	private int[][] board;                                                                      // _ 7 _ 0 _        
	private int[][] moves = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};          // 6 _ _ _ 1   
	private int solutions;				                                                        // _ _ K _ _ 
																				          		// 5 _ _ _ 2
																				                // _ 4 _ 3 _
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
			for (int c = 0; c < board[0].length; c++){
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
		boolean ok = solveHelp(row,col,1);
		board[row][col] = 0;
		return ok;
	}

	private boolean solveHelp(int row, int col, int level){
		board[row][col] = level; 
		if (level == board.length * board[0].length){
			return true;
		}
		for (int mode = 0; mode < 8; mode++){
			int r = row + moves[mode][0];
			int c = col + moves[mode][1];

			if (r > -1 && r < board.length && c > -1 && c < board.length && board[r][c] == 0){
				if (solveHelp(r,c,level+1)){
					return true;
				}
				board[r][c] = 0;
			}
		}
		return false;
	}

	private void reset(){
		for (int r = 0; r < board.length; r++){
			for (int c = 0; c < board[0].length; c++){
				board[r][c] = 0;
			}
		}
	}


	public int countSolutions(int row, int col){
		if (isBad()){
			throw new IllegalStateException();
		}
		solutions = 0;
		countHelp(row, col, 1);
		board[row][col] = 0;
		return solutions;
	}

	private void countHelp(int row, int col, int level){
		board[row][col] = level; 
		if (level == board.length * board[0].length){
			solutions += 1;
		}
		for (int mode = 0; mode < 8; mode++){
			int r = row + moves[mode][0];
			int c = col + moves[mode][1];

			if (r > -1 && r < board.length && c > -1 && c < board.length && board[r][c] == 0){
				countHelp(r,c,level+1);
				board[r][c] = 0;
			}
		}
		return;
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


	public static void main(String[] args){
		KnightBoard b = new KnightBoard(5, 5);
		System.out.println(b);
	//	System.out.println(b.solve(0,0));
		System.out.println(b.countSolutions(1,1));
		System.out.println(b);

		KnightBoard c = new KnightBoard(5,5);
		int totalSol = 0; 
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				totalSol+= c.countSolutions(i,j);
			}
		}
		System.out.println(totalSol);

		KnightBoard d = new KnightBoard(5,5);
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				d.solve(i,j);
				d.reset();
			}
		}
				
	}


}