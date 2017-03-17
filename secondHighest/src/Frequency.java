import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
class MapData{
	int num;
	int frequency;
	public MapData(int num, int frequency){
		this.num = num;
		this.frequency = frequency;
	}
	
}



public class Frequency {
	
	private static void findTopKElements(ArrayList<Integer> al, int k){
		 ArrayList<Integer> res = new ArrayList<Integer>();
		 
	     if(k == 0)
	        return ;
	     if(al.size() == 0)
	        return ;
	    
	  
	    ConcurrentHashMap<Integer, MapData> h = new ConcurrentHashMap<Integer,MapData>();
	  
	    for(int i=0;i<al.size();i++){
	        
	        if(!h.containsKey(al.get(i))){
	             h.put(al.get(i),new MapData(al.get(i),1));
	         }
	         else{
	             int freq = h.get(al.get(i)).frequency;
	             h.put(al.get(i),new MapData(al.get(i),++freq));
	         }
	    }
	    

	    Comparator<MapData> comparator = new Comparator<MapData>(){
           public int compare(MapData n1, MapData n2){
               if(n1.frequency < n2.frequency) return -1;
               if(n1.frequency > n2.frequency) return 1;
               return 0;
               
           }
         
	    };
	    
	    PriorityQueue<MapData> pq = new  PriorityQueue<MapData>(k,comparator);
	    
	    int i=0;
	    for(Integer x:h.keySet()) {
	    	if(i < k){
	    	pq.add(h.get(x));
	    	h.remove(x);
	    	i++;
	    	}
	    	else{
	    		break;
	    	}
	    	
	    }
	    
	    for(Integer x:h.keySet()){
	    	
	        if(pq.peek().frequency < h.get(x).frequency){
	            pq.remove();
	            pq.add(h.get(x));
	            
	        }
	        
	    } 
	     
	    while(!pq.isEmpty()){
	        res.add(pq.remove().num);
	          
	    }
	    
	    for(int n=0;n<res.size();n++){
	    	System.out.println(res.get(n));
	    }
	    
	
	     
		
	}
	
	public static void main(String args[]){
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(1);
		al.add(2);
		al.add(2);
		al.add(2);
		al.add(2);
		al.add(3);
		al.add(3);
		al.add(4);
		al.add(4);
		al.add(4);
		al.add(4);
		al.add(4);
		al.add(4);
		int k =2;
		
		findTopKElements(al,k);
		
	}
	
}