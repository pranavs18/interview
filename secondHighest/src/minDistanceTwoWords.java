public class minDistanceTwoWords {
	
	
	private static void findMin(String[] str, String s1, String s2){
		
		if(str.length == 0)
			return;
		if(s1 == null || s2 == null)
			return;
		
		int s1Index = -1;
		int s2Index = -1;
		int diff = Integer.MAX_VALUE;
		for(int i=0;i<str.length;i++){
			
			if(str[i].equals(s1)){
				s1Index = i;
			}
			
			if(str[i].equals(s2)){
				s2Index = i;
			}
			
			if(s1Index >= 0 && s2Index >= 0 && Math.abs(s1Index - s2Index) < diff)
				diff = Math.abs(s1Index - s2Index);
			
				
		}
		
		if(diff == Integer.MAX_VALUE)
			System.out.println("Minimum distance -1 ...word not found" );
		else
			System.out.println("Minimum distance " + diff);
	}
	
	public static void main(String args[]){
		
		String s= "hello I am you are with yes hello I am here you go hello with that practice terms hello";
	   // String s ="hello";
		String str[] = s.split(" ");
	    String s1 ="hello";
	    String s2 = "you";
	    findMin(str,s1,s2);
	}
}