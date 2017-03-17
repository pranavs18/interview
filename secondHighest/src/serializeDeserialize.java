import java.util.ArrayList;


class Tree {
	
	Tree left;
	Tree right;
	int val;
	
	public Tree(int val){
		this.val=val;
	}
	
}

public class serializeDeserialize {
	static ArrayList<Integer> al = new ArrayList<Integer>();
	
	public static ArrayList<Integer> serializeTree(Tree root){
	    if(root == null){
	    	al.add(-1);
	    	return al;
	    }
		
	    al.add(root.val);
		serializeTree(root.left);
		serializeTree(root.right);
		return al;
	}
	
	static int i=0;

	
	public static Tree deserializeTree(ArrayList<Integer> al) {
		
		if(al.get(i) == -1){
			i++;
			return null;
		}
		
		else{
			Tree node = new Tree(al.get(i++));
			node.left = deserializeTree(al);
			node.right = deserializeTree(al);
		
		return node;
		}
	}
	
	public static void printTree(Tree root){
		if(root == null)
			return;
		System.out.println(root.val);
		printTree(root.left);
		printTree(root.right);
				
	}
	
	public static void main(String args[]){
		Tree root = new Tree(7);
		root.left = new Tree(4);
		root.right = new Tree(10);
		root.left.right = new Tree(5);
		root.right.left = new Tree(8);
		
		printTree(root);
		
		System.out.println("\n SERIALIZED TREE ");
		al = serializeTree(root);
		for(int i=0;i< al.size();i++){
			
			System.out.print(al.get(i)+ " ");
		}
		System.out.println("\n DESERIALIZED TREE ");
		root = deserializeTree(al);
		
		printTree(root);
	}
	
}