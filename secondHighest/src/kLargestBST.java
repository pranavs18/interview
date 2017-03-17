
class btree1{
	btree1 left;
	btree1 right;
	int val;
	public btree1(int val){
		this.val = val;
	}
}

public class kLargestBST {
  
  static int i=0;
  private static void kLargest(btree1 root, int k){
	  
	  if(root == null){
		  return;
	  }
	  
	  kLargest(root.right,k);
	  if(++i == k){
		  System.out.println(root.val);
	  }
	  kLargest(root.left, k);
	  
  }
	 
  public static void main(String args[]){
	  btree1 root = new btree1(7);
	  root.left = new btree1(4);
	  root.right = new btree1(9);
	  root.left.left = new btree1(1);
	  root.left.right = new btree1(6);
	  
	  root.right.right = new btree1(11);
	  root.right.left = new btree1(8);
	  root.right.right.right = new btree1(13);
	  int k = 6;
	  kLargest(root,k);
	
  }
}