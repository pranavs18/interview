import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


class BTree {
	
	BTree left;
	BTree right;
	int val;
	
	public BTree(int val){
		this.val=val;
	}
	
}

public class verticalTree{
	
	static HashMap<Integer,ArrayList<BTree>> h = new HashMap<Integer,ArrayList<BTree>>();
	
	private static void verticalPosition(BTree root, int offset){
		if(root == null)
			return;
		
		if(!h.containsKey(offset)){
			ArrayList<BTree> al = new ArrayList<BTree>();
			al.add(root);
			h.put(offset,al);
		}
		else{
			ArrayList<BTree> bl = h.get(offset);
			bl.add(root);
			h.put(offset, bl);
		}
		
		verticalPosition(root.left , offset-1);
		verticalPosition(root.right, offset +1);
		
	}
	
	public static void main(String args[]){
		
		  BTree root = new BTree(7);
		  root.left = new BTree(4);
		  root.right = new BTree(9);
		  root.left.left = new BTree(1);
		  root.left.right = new BTree(6);
		  
		  root.right.right = new BTree(11);
		  root.right.left = new BTree(8);
		  root.right.right.right = new BTree(13);
		  verticalPosition(root,0);
		  
		  for(Entry<Integer, ArrayList<BTree>> e: h.entrySet()){
			  System.out.print("Vertical Position " + e.getKey() + " Nodes -> ");
			  for(int i=0;i<e.getValue().size();i++){
				  System.out.print(e.getValue().get(i).val + " ");
			  }
			  System.out.println();
		  }
		
	}
	
}