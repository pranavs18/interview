import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

 class TreeNode{
	TreeNode left;
	TreeNode right;
	TreeNode next;
	int data;
	public TreeNode(int val){
		this.data  =val;
		this.left = null;
		this.right = null;
		this.next = null;
	}
	 
 }
 
 class Solution{
	 
	 public static void main(String args[]){
		 
		 TreeNode root = new TreeNode(5);
		 root.left = new TreeNode(3);
		 root.right = new TreeNode(7);
		 root.left.left = new TreeNode(1);
		 root.left.right = new TreeNode(4);
		 root.right.right = new TreeNode(9);
		 root.right.left = new TreeNode(6);
		// root.right.left.left = new TreeNode(5);
		 printTreeRecursive(root);
		 System.out.println("\n ITERATIVE VERSION ");
		 printTreeIterative( root);
		 populateNextPointers(root);
	 }
	 
	 private static void printTreeRecursive(TreeNode root){
		 if(root == null)
			 return;
		 printTreeRecursive(root.left);
		 System.out.println(root.data);
		 printTreeRecursive(root.right);
	 }
	 
	 private static void printTreeIterative(TreeNode root){
		 
		 Stack<TreeNode> s = new Stack<TreeNode>();
		 TreeNode temp = root;
		 s.push(root);
		while(!s.isEmpty()){ 
		 while(temp.left != null){
			 temp = temp.left;
			 s.push(temp);
			 
		 }
			 TreeNode elem = s.pop();
			 System.out.println(elem.data);
			 if(elem.right != null){
				s.push(elem.right);
				temp = elem.right;
			}			
		 }
		 
	 }
	 
	 private static void populateNextPointers(TreeNode root){
		 root.next = null;
		 Queue<TreeNode> q = new LinkedList<TreeNode>();
		 q.add(root);
		 q.add(null);
		 while(!q.isEmpty()){
			 TreeNode temp = q.remove();
			 TreeNode temp1 = temp;
			 while(temp1 != null){
				 if(temp1.left != null)
					 q.add(temp1.left);
				 if(temp1.right != null)
					 q.add(temp1.right);
				 temp1.next= q.remove();
				 if(temp1.next != null)
					 System.out.println(temp1.data + "POINTS TO " + temp1.next.data );
				 else
					 System.out.println(temp1.data + "POINTS TO NULL" );
				 temp1 = temp1.next;
			 }
			 if(q.size()> 0)
				 q.add(null);
		 }
		 System.out.println("NEXT POINTERS POPULATED");
	 }
	
	 private static void findCousins(TreeNode root , int val1 , int val2){
		 if(root == null)
			 return;
		 Queue<TreeNode> q = new LinkedList<TreeNode>();
		 q.add(root);
		 q.add(null);
		 int level =0;
		 int level1 = 0;
		 int level2 = 0;
		 while(!q.isEmpty()){
			 TreeNode temp = q.remove();
			 q.remove();
			 level++;
			 if(temp.data == val1){
				  level1 = level;
			 }
			 if(temp.data == val2){
				  level2 = level;
			 }
			 if(temp.left != null){
				 q.add(temp.left);
			 }
			 if(temp.right != null){
				 q.add(temp.right);
			 }
			 if(q.size() > 0)
				 q.add(null);
			 
		 }
		 
		 int parent1level = level1--;
		 int parent2level = level2--;
		 if(parent1level == parent2level){
		 
		q.add(root);
		q.add(null);
	    level=0;
		while(!q.isEmpty()){
			TreeNode temp = q.remove();
			level++;
			if(level == parent1level && temp == root){
				System.out.println("Not cousins");
				break;
			}
			else if(level == parent1level){
				if(temp.left.data == val1 || temp.right.data == val1){
				// LOOP UNTIL NULL 
				/*if(temp1.left.data == val2 || temp1.right.data == val2){
					System.out.println("COUSINS FOUND");
				}*/
				}
			}
			 if(temp.left != null){
				 q.add(temp.left);
			 }
			 if(temp.right != null){
				 q.add(temp.right);
			 }
			 if(q.size() > 0)
				 q.add(null);
		}
		 
		 }
		 else{
			 System.out.println("Not cousins");
		 }
	 }
	 
	 
 }