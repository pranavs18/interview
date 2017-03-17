class flipTree {
	flipTree left;
	flipTree right;
	int val;
	public flipTree(int val){
		this.val = val;
	}
}

public class FlipBinaryTree {
	
	private static flipTree flip(flipTree root){
		
		if(root == null)
			return root;
		
		if(root.left == null && root.right == null)
			return root;
		
		flipTree newRoot = flip(root.left);
		
		root.left.left = root.right;
		root.left.right = root;
		root.right = null;
		root.left = null;
	    
		
		return newRoot;
	}
	
	private static void printTree(flipTree root){
		if(root == null)
			return;
		System.out.println(root.val);
		printTree(root.left);
		printTree(root.right);
	}
	
	public static void main(String args[]){
	  flipTree root = new flipTree(1);
	  root.left = new flipTree(2);
	  root.right = new flipTree(3);
	  root.left.left = new flipTree(4);
	  root.left.right = new flipTree(5);
	  
	  root.left.left.left = new flipTree(6);
	  root.left.left.right = new flipTree(7);
	
	
	printTree(root);
	root = flip(root);
	System.out.println("FLIPPED TREE \n");
	printTree(root);
    
	}
}