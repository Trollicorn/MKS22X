public class KnightBoard{

	private int[][] board;                                                                      // _ 7 _ 0 _        
	private int[][] moves = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};          // 6 _ _ _ 1   
										                                                        // _ _ K _ _ 
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
		return solveHelp(row,col,1);
	}

	private boolean solveHelp(int row, int col, int level){
		if (level == board.length * board[0].length){
			return true;
		}
		board[row][col] = level;
		for (int mode = 0; mode < 8; mode++){
			int[] gather = moveKnight(row,col,level,mode);
			if (gather[0]==1){
				boolean ok = solveHelp(gather[1],gather[2],level+1);
				if (ok){
					return ok;
				}
				removeKnight(row,col,level,mode);
			}
	//		removeKnight(row,col,level,mode);	
		}
		return false;
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

	public static void main(String[] args){
		KnightBoard b = new KnightBoard(8, 8);
		System.out.println(b);
		System.out.println(b.solve(0,0));
		System.out.println(b);
	}


}