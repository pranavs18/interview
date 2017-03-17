import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode{
	int val;
	int ListIndex;
	public ListNode(int val,int index){
		this.val = val;
		this.ListIndex = index;
	}
}

class mergeKlists {
	
	public static void main(String args[]){
		ArrayList<ArrayList<ListNode>> lists = new ArrayList<ArrayList<ListNode>>();
		
		ArrayList<ListNode> a = new ArrayList<ListNode>();
		ListNode l1 = new ListNode(1,0);
		a.add(l1);
		ListNode l2 = new ListNode(3,0);
		a.add(l2);
		ListNode l3 = new ListNode(9,0);
		a.add(l3);
		ArrayList<ListNode> b = new ArrayList<ListNode>();
		ListNode l4 = new ListNode(2,1);
		b.add(l4);
		ListNode l5 = new ListNode(4,1);
		b.add(l5);
		ArrayList<ListNode> c = new ArrayList<ListNode>();
		ListNode l6 = new ListNode(0,2);
		ListNode l7 = new ListNode(5,2);
		ListNode l8 = new ListNode(6,2);
		ListNode l9 = new ListNode(10,2);
		c.add(l6);
		c.add(l7);
		c.add(l8);
		c.add(l9);
		
		lists.add(a);
		lists.add(b);
		lists.add(c);
		
		mergeKlist(lists,3);
	}
	
	private static Comparator<ListNode> comparator = new Comparator<ListNode>() {  
	     @Override  
	     public int compare(ListNode n1, ListNode n2) {  
	       if (n1.val < n2.val) return -1;  
	       if (n1.val > n2.val) return 1;  
	       return 0;  
	     }  
	   };  
	   
	private static void mergeKlist(ArrayList<ArrayList<ListNode>> lists, int K){
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),comparator);
		ArrayList<ListNode> res = new ArrayList<ListNode>();
		for(ArrayList<ListNode> al: lists){
			pq.add(al.get(0));
			al.remove(0);
		}
		
		while(!pq.isEmpty()){
			ListNode l = pq.poll();
			res.add(l);
			int arrayIndex = l.ListIndex;
			if(lists.get(arrayIndex).size() > 0){
				pq.add(lists.get(arrayIndex).get(0));
				lists.get(arrayIndex).remove(0);
			}
		}
		
		for(ListNode x:res){
			System.out.println(x.val);
		}
	}
	
}