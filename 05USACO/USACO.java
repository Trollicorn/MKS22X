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
			System.out.println(scan.nextLine());
		}
		catch (FileNotFoundException e){
			System.out.println("File Not Found");
			System.exit(1);
		}
		return -1;
	}

	public static int silver(String filename){

		return -1;
	}

	public static void main(String[] args){
		USACO.bronze("makelake.in");
	}

}