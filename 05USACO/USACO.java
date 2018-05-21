import java.util.*;
import java.io.*;

public class USACO{

	public static int bronze(String filename){
		//USACO Bronze Mar08 Problem 12

		int row, col, depth, instructions;
		int[][] ok;		

		try{
		//	int[] info = new int[4];
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
		int rows, cols, time, r1, c1, r2, c2;
		char[][] map;
		int[][] past, present;		

		try{
			File file = new File(filename);
			Scanner scan = new Scanner(file);
			rows = Integer.parseInt(scan.next());
			cols = Integer.parseInt(scan.next());
			time = Integer.parseInt(scan.next());
			map = new char[rows][cols];
			past = new int[rows][cols];
			present = new int[rows][cols];
			for (int r = 0; r < rows; r++){
				String word = scan.next();
				for (int c = 0; c < cols; c++){
					map[r][c] = word.charAt(c);
				}
			}
			//start 
			r1 = Integer.parseInt(scan.next()) - 1;
			c1 = Integer.parseInt(scan.next()) - 1;
			past[r1][c1] = 1;
			//end
			r2 = Integer.parseInt(scan.next()) - 1;
			c2 = Integer.parseInt(scan.next()) - 1;

			for (int t = 0; t < time; t++){
				for (int r = 0; r < rows; r++){
					for (int c = 0; c < cols; c++){
						if (map[r][c] != '*'){
							if (present[r][c] == 0){
								if (r - 1 > -1){
									present[r][c] += past[r-1][c];
								}
								if (r + 1 < rows){
									present[r][c] += past[r+1][c];
								}
								if (c - 1 > -1){
									present[r][c] += past[r][c-1];
								}
								if (c + 1 > cols){
									present[r][c] += past[r][c+1];
								}
							}
							else{
								present[r][c] = 0;
							}
						}
					}
				}
				for (int r = 0; r < rows; r++){
					for (int c = 0; c < cols; c++){
						past[r][c] = present[r][c];
					}
				}
			}
			return present[r2][c2];
		}catch (FileNotFoundException e){
			System.out.println("File Not Found");
			System.exit(1);
		}
		return -1;
	}

	public static void main(String[] args){
		//System.out.println(USACO.bronze("makelake.in"));
		System.out.println(USACO.silver("ctravel.in"));
	}

}