import java.util.*;
import java.io.*;

public class USACO{

	public static int bronze(String filename){
		//USACO Bronze Mar08 Problem 12

		int row, col, depth, instructions;
		int[][] ok;		

		try{
			int[] info = new int[4];
			File file = new File(filename);
			Scanner scan = new Scanner(file);
			row = Integer.parseInt(scan.next());
			col = Integer.parseInt(scan.next());
			depth = Integer.parseInt(scan.next());
			instructions = Integer.parseInt(scan.next());
			//scan.nextLine();
			ok = new int[row][col];
			for (int r = 0; r < row; r++){
				for (int c = 0; c < col; c++){
					ok[r][c] = Integer.parseInt(scan.next());
				}
			}
			for (int i = 0; i < instructions; i++){
				int r = Integer.parseInt(scan.next()) - 1;
				int	c = Integer.parseInt(scan.next()) - 1;
				int amount = Integer.parseInt(scan.next());
				lower(r, c, amount, ok);
			}
			int sum = 0;
			for (int r = 0; r < row; r++){
				for (int c = 0; c < col; c++){
					if (depth - ok[r][c] > 0){
						sum += depth - ok[r][c];
					}
				}
			}
			return sum * 72 * 72;

			//System.out.println(scan.nextLine());
		}
		catch (FileNotFoundException e){
			System.out.println("File Not Found");
			System.exit(1);
		}
		return -1;
	}

	private static void lower(int r, int c, int amount, int [][] ok){
		int highest = 0;
		for (int i = r; i < r + 3; i++){
			for (int j = c; j < c + 3; j++){
				if (ok[i][j] > highest){
					highest = ok[i][j];
				}
			}
		}
		for (int i = r; i < r + 3; i++){
			for (int j = c; j < c + 3; j++){
				if (ok[i][j] > highest - amount){
					ok[i][j] = highest - amount;
				}
			}
		}
	}

	public static int silver(String filename){

		return -1;
	}

	public static void main(String[] args){
		System.out.println(USACO.bronze("makelake.in"));
	}

}