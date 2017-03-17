import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/*
// second highest freuqnt number
public class secondHighest {
	
 private static int findSecondMax(int count[]){
	 
	  int i=0;
	  int MAX = count[0];
	  int index=0;
	  int maxindex=0;
	  int secondMax = 0;
	  for(i=1;i< count.length;i++){
		  if(count[i] > MAX ){
			  if(i!=1){
			  secondMax = MAX;
			  index = maxindex;
			  }
			  MAX = count[i];
			  maxindex = i;
		  }
		  else{
			 if(count[i] < MAX && count[i] > secondMax){
				 secondMax = count[i];
				 index = i;
			 }
		  }
	  }
	 return index; 
 }
  public static void main(String args[]){
	  
	  String s = "aaaaac";
	  
	  if(s.length() <= 1){
		  System.out.println(s);
	  }
	  int count[] = new int[256];
	  for(int i=0;i<s.length();i++){
		  
			  count[(int)s.charAt(i) -97]++;  
		  }
	  
	  int c=  findSecondMax(count);
	  System.out.println("second highest frequency " + (char)(c+97));
  }
} */

// Rotated sorted array
/*
  public class secondHighest {
 
	
	public static void main(String args[]){
		int  a[]= {10,12,56,58,3,8};
		int target = 3;
		 int start = 0;
			int end = a.length-1;
			while(start <= end){
				int mid = (start + end)/2;
				if(a[mid] == target){
					System.out.println(mid);
					return;
				}
				else if(a[start] <= a[mid] ){
					if(target < a[start] || target > a[mid]){
				
					    start = mid +1;
					}
					else
						end = mid;
				}
				else if(a[start] > a[mid] ){
					if(target > a[mid] && target < a[start]){
						start = mid +1;
					}
					else
						end = mid;
				}
				
			}
		  return ;	
	}
	
	
}


*/
/*
public class secondHighest {
	static HashMap<String,String> memoized = new HashMap<String,String>();
	
	public static String generateString(String str, HashSet<String> dictionary){
		if (dictionary.contains(str)) 
			return str;
		if(memoized.containsKey(str)){
			return memoized.get(str);
		}
		for(int i=0;i< str.length();i++){
			
			String prefix= str.substring(0, i);
			if(dictionary.contains(prefix)){
				String suffix = str.substring(i,str.length());
				String seg = generateString(suffix,dictionary);
				if(seg != null){
					memoized.put(str, prefix + " " + seg);
					return prefix + " " + seg;
				}
			}
		}
		return null;
	}
	public static void main(String args[]){
		HashSet<String> s = new HashSet<String>();
		s.add("from");
		s.add("waterloo");
		s.add("hi");
		s.add("i");
		s.add("a");
		s.add("student");
		s.add("hii");
		s.add("am");
		s.add("water");
		
		String str = "hiiamastudentfromwaterloo";
		
		String result = generateString(str,s);
		System.out.println(result);
		
		
		
	}
}*/

/*
public class secondHighest {
	
	public static void findTriplets(int []num){
		
		ArrayList<ArrayList<Integer>> fi = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
        for(int i=0;i< num.length-2 ;i++){
        	int start = i+1;
        	int end = num.length - 1;
        	while(start < end){
        		int sum = num[i] + num[start] + num[end];
        		if(sum > 0)
        			end --;
        		else if(sum < 0)
        			start++;
        		else{
        			ArrayList<Integer> al = new ArrayList<Integer>();
        			al.add(num[i]);
        			al.add(num[start]);
        			al.add(num[end]);
        			fi.add(al);
        			start++;
        			end--;
        		}
        	
        	}
        }
		
		System.out.println(fi);
		
	}
	
	public static void main(String args[]){
		int num[] = {-1, 0, 1, 2, -3};
		
		findTriplets(num);
	}
	
} */


// zig zag traversal

/*
class TreeNode{
   int val;
   TreeNode left;
   TreeNode right;
   public TreeNode(int x){
	   this.val = x;
   }
}

public class secondHighest{
	
	private static void printTree(TreeNode root){
	    if(root == null )
	    	return;
	    System.out.println(root.val);
	    printTree(root.left);
	    printTree(root.right);
	      
	}
	
	private static void printZigZag(TreeNode root){
		ArrayList<ArrayList<Integer>> fl = new ArrayList<ArrayList<Integer>>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		
			
	}
	
	public static void main(String args[]){
		
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(1);
      root.right = new TreeNode(5);
      root.left.right = new TreeNode(2);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(7);

	  printTree(root);
	  printZigZag(root);
	}
	
}*/

//unix path
/*
public class secondHighest {
	
	private static void simplifyPath(String path){
		if(path.length() == 0)
	        return;
	        String res = "";
	        String words[] = path.split("/");
	        
	        for(int i=0;i<words.length;i++){
	            if(!words[i].equals("") && !words[i].equals("..")&& !words[i].equals(".")){
	   
	            	res = res + "/" + words[i];
	            }
	            else if(words[i].contains("..")){
	            	String temp = "";
	            	int len=0;
	            	int j=0;
	            	for( j=0;j<=i-1;j++){
	            		if(!words[j].equals("") && !words[j].equals(".")){
	            			 len = words[j].length();
	            			temp = temp + "/" + words[j];
	            			
	            		}
	            	}
	                if(res.length() > 0)
	                	temp = temp.substring(0, temp.length()-len-1);
	            	words[j]="";
	            	res = "";
	            	res = res + temp;
	            }
	            else if(words[i].equals(".")){
	            	continue;
	            }
	            	
	        }
	        if(res.equals("")){
	         res = res + "/";
	        }
	        System.out.println(res);
	       
	}
	
	public static void main(String args[]){
		//String path = "/../../home//run";
		String path = "/a/./b/../../c/";
		//String path = "/home/foo/./../.ssh2/authorized_keys/";
	    //String path = "/home/../../..";
		simplifyPath(path);
	}
} 
*/

/*
// string compression
public class secondHighest {
	
	public static void main(String args[]) throws IOException{
		String s = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		
		int i=0;
		int count =1;
		
		StringBuilder res = new StringBuilder();
		if(s == null)
			return;
		
		while(i < s.length()){
			
			int j=i+1;
			if(j == s.length()){
				res.append(s.charAt(i));
				res.append(count);
				break;
			}
			else{
				if(s.charAt(i) != s.charAt(j)){
				res.append(s.charAt(i));
				res.append(count);
				count =1;
				i=j;
				}
				else{
					count++;
					i++;
				}
			}
			
		}
		System.out.println(res);
	}
}*/

/*
public class secondHighest {
	public static void main(String args[]){
		  int[] num={-1, 2, 1, -4};
		  int target =1;
		  Arrays.sort(num);
	        
	        int start =0;
	        int res=0;
	        int min = Integer.MAX_VALUE;
	        int end = num.length-1;
	        if(num.length < 3)
	            return ;
	        for(int i=0;i< num.length;i++){
	            int closest = target - num[i];
	            start =i+1;
	            while(start < end){
	                int sum = num[start] + num[end];
	                int diff = closest - sum;
	                if(diff < min || diff == 0){
	                    min = diff;
	                     res = num[i] + num[start] + num[end];
	                     if(min== 0)
	                        break;
	                }
	                if(sum < target)
	                    start++;
	                else
	                    end--;
	                
	            }
	        }
	      System.out.println("SUM " + res);  
		
		
	}
	
}*/

class Node{
  Node next;
  int val;
  public Node(int val){
	  this.val =val;
  }
}
	
 public class secondHighest{
	 
	 public static void printList(Node head){
		 Node temp = head;
		 System.out.println("\n LIST IS AS FOLLOWS ");
		 while(temp != null){
			 System.out.print(temp.val +" --> " );
			 temp = temp.next;
		 }
		 if( temp == null)
			 System.out.print("NULL");
	 }
	 
	 public static Node reverseList(Node head, int m , int n){
		 int count =0;
		 Node temp = head;
		 Node prev = null;
		 Node fh = null;
		 Node sh = null;
		 Node th = null;
		 if(head.next == null || n==0)
			 return head;
		 
		 while(temp.next != null){
			 if(count >= m){
				 if(fh.next != null)
					 th = fh.next;
				 fh.next = temp;
				 temp = fh;
				 fh = th;
				 count ++;
				 if(count == n){
					 prev.next = temp;
					 sh.next = fh;
					 break;
				 }
			 }
			 else {
				 prev = temp;
				 sh = prev.next;
				 temp = temp.next;
				 fh = temp.next;
				 count++;
			 }
		 }
		 return head;
	 }
	 
	 public static void main(String args[]){
		 
		 int m = 2;
		 int n = 4;
		 Node head = new Node(1);
		 Node temp = head;
		 for(int i=2;i<=5;i++){
			 temp.next = new Node(i);
			 temp = temp.next;
		 }
		printList(head);
	    head = reverseList(head,m-1,n-1);
		printList(head);
	 } 
 }
