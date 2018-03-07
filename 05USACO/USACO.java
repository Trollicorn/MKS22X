import java.util.*;
import java.io.*;

public class USACO{

	public static int bronze(String filename){
		//USACO Bronze Mar08 Problem 12

		int[][] ok;
		
		try{
			int[] info = new int[4];
			File file = new File(filename);
			Scanner scan = new Scanner(file);
			String line = scan.nextLine();
			String num = "";
			for (int i = 0; i < line.length(); i++){
				if (line.charAt(i) == ' '){
					
				}
				num += line.charAt(i);
			}
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

}