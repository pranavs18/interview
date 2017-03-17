import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval {
	int start;
	int end;
	public Interval(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	
	@Override
	public String toString() {
		
		return "Start " + this.start + " End " + this.end;
	}  
}

class IntervalComparator implements Comparator<Interval>{
	 @Override
		public int compare(Interval obj1, Interval obj2) {
			if(obj1.start <= obj2.start) return -1;
			
			if(obj1.start > obj2.start ) return 1;
			
			return 0;
		}
}

public class mergeInterval {
	
	private static void mergeOverLappingIntervals(ArrayList<Interval> intervals){
		
		ArrayList<Interval> res = new ArrayList<Interval>();
	
		Collections.sort(intervals,new IntervalComparator());
		int totalLen =0;
		Interval a= intervals.get(0);
		
		for(int i=1;i<intervals.size();i++){
			Interval b = intervals.get(i);
			
			if(a.end <= b.start){
				totalLen += b.end - b.start;
				res.add(b);
				a = b;
			}
			
			else if(b.start <= a.end && b.end <= a.end)
				continue;
			
			else if(b.start <= a.end){
				a = new Interval(Math.min(a.start,b.start),Math.max(a.end,b.end));
				totalLen += Math.max(a.end,b.end) - Math.min(a.start, b.start);
			    res.add(a);
			}
			
		}
		
		   System.out.println("MERGED INTERVAL");
		for(int j=0;j<res.size();j++){
			System.out.println(res.get(j).toString());
			
		}
		
		System.out.println("TOTAL LENGTH " + totalLen );
		   		
	}
	
	
	public static void main(String args[]){
		
		ArrayList<Interval> al = new ArrayList<Interval>();
		al.add(new Interval(3,6));
		al.add(new Interval(8,9));
		al.add(new Interval(1,5));
		al.add(new Interval(1,3));
		al.add(new Interval(1,8));
		al.add(new Interval(3,10));
		al.add(new Interval(15,25));
		
		for(int i=0;i<al.size();i++){
		System.out.println(al.get(i).toString());
		}
		mergeOverLappingIntervals(al);
		
		
	}
	
}