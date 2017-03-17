import java.util.ArrayList;
import java.util.Arrays;
class ITree{
	ITree left;
	ITree right;
	String x;
	public ITree(String x){
		this.x = x;
	}
	
}

public class possibleInterpretation {
	
	 private static final String[] alphabet = {"", "a", "b", "c", "d", "e",
	        "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
	        "s", "t", "u", "v", "w", "x", "v", "z"};
	 
	
	private static ITree generateInterpretations(int num[],String res,int index){
		if(index > 26)
			return null;
		String temp = res + alphabet[index];
		ITree root = new ITree(temp);
		
		if(num.length!=0){
		index = num[0];
		int newNum[]= Arrays.copyOfRange(num, 1, num.length);	
		root.left = generateInterpretations(newNum, temp , index);
		
		if(num.length > 1){
			newNum = Arrays.copyOfRange(num, 2, num.length);
			root.right = generateInterpretations(newNum, temp, 10*num[0]+num[1]);
	    
		 }
		
		}
		return root;
	}
	
	private static void printLeafNodes(ITree root){
		if(root == null)
			return ;
		
		if(root.left == null && root.right == null){
			System.out.println(root.x + " ");
		}
		
		printLeafNodes(root.left);
		printLeafNodes(root.right);
	}
	
	
	public static void main(String args[]){
	  int num[] ={1,2,1};
	  
	  ITree root = generateInterpretations(num, "", 0);
	  printLeafNodes(root);
	}
}