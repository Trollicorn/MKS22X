public class QueenBoard{

	private int[][] board;

	public QueenBoard(int size){
		board = new int[size][size];
	}

	private boolean addQueen(int r, int c){
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
				else if (board[r][c] == 0){
					str += "_ ";
				}
				else{
					str += "X ";
				}
			}
			str += "\n";
		}
		return str;
	}

	public boolean solve(){
		return solveHelp();
	}

	private boolean solveHelp(int prevRow, int prevCol, int r, int c, int placed){
		if (c == board.length){
			if (placed != board.length){
				removeQueen(prevRow,prevCol);
			}
		}
		return 
	}

	public int countSolutions(){
		return 1;
	}

	public static void main(String[] args){
		QueenBoard board = new QueenBoard(8);
	//	board.addQueen(1,1);
	//	board.removeQueen(1,1);
		System.out.println(board);
	}


}



