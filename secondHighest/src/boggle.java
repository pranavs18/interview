/**********************************************************************************************************************
 * 
 * @author - Pranav Saxena
 * Carnegie Mellon University
 * Finding all the words in a character matrix
 * 
 */

import java.util.ArrayList;
import java.util.HashSet;

class Point {
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
}

public class boggle{
	
	private static ArrayList<Point> getNeighbours(char matrix[][], int row, int col){
		ArrayList<Point> neighbour = new ArrayList<Point>();
		
		for(int i=row-1;i<=row+1;i++){
			if( i < 0 || i >= matrix.length)
				continue;
			for(int j=col-1;j<=col+1;j++){
				if(j < 0 || j>= matrix[0].length){
					continue;
				}
				if( i == row && j == col)
					continue;
				neighbour.add(new Point(i,j));
			}
		}
		
		return neighbour;
	}
	
	private static ArrayList<String> findWords(char[][] matrix, HashSet<String> dictionary){
		
		ArrayList<String> al = new ArrayList<String>();
		boolean replica[][] = new boolean[matrix.length][matrix[0].length];
		
		if(dictionary.size() == 0)
			return al;
		String prefix = "";
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				backTrack(i,j,prefix,matrix, replica,dictionary,al);
			}
		}	
		return al;
	}
	
	
	private static void backTrack(int row, int col, String prefix, char[][] matrix, boolean[][] replica, HashSet<String> dictionary, ArrayList<String> al){
		
		if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || replica[row][col]) 
			return;
		
		replica[row][col]= true;
		
		prefix += matrix[row][col];
		if(dictionary.contains(prefix)){
			al.add(prefix);
		}
		
		ArrayList<Point> temp = new ArrayList<Point>();
		temp = getNeighbours(matrix, row, col);
		for(int j=0;j<temp.size();j++){
			backTrack(temp.get(j).x, temp.get(j).y, prefix, matrix, replica, dictionary, al);
		}
		
		replica[row][col] = false;
		
	}
	
	public static void main(String args[]){
		
		char[][] matrix= new char[4][4];
		matrix[0][0]='t';
		matrix[0][1]='i';
		matrix[0][2]='m';
		matrix[0][3]='w';
		matrix[1][0]='z';
		matrix[1][1]='g';
		matrix[1][2]='a';
		matrix[1][3]='p';
		matrix[2][0]='f';
		matrix[2][1]='e';
		matrix[2][2]='r';
		matrix[2][3]='s';
		matrix[3][0]='a';
		matrix[3][1]='n';
		matrix[3][2]='s';
		matrix[3][3]='q';
		
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		HashSet<String> dictionary = new HashSet<String>();
		dictionary.add("tiger");
		dictionary.add("maps");
		dictionary.add("and");
		dictionary.add("tigers");
		dictionary.add("mars");
		// Matrix contains 6 valid occurences - Note "tigers" and "mars" are present two times. 
		
		ArrayList<String> result = new ArrayList<String>();
		result = findWords(matrix,dictionary);
		
		System.out.println("\n Words found " + result.size());
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i));
		}
	}
	
	
}