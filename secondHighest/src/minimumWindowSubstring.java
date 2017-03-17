import java.util.HashMap;

public class minimumWindowSubstring {
	
	private static String minimumWindow(String S, String T){
	
		int count =0;
		HashMap<Character, Integer> h = new HashMap<Character,Integer>();
		
		for(int i=0;i<T.length();i++){
			if(!h.containsKey(T.charAt(i))){
				h.put(T.charAt(i), 1);
			}
			else{
				int val  = h.get(T.charAt(i));
				h.put(T.charAt(i),++val);
			}
		}
		
		int low =0;
		int start = 0;
		int minLength = Integer.MAX_VALUE;
		for(int j=0;j<S.length();j++){
			
			if(h.containsKey(S.charAt(j))){
				int val = h.get(S.charAt(j));
				h.put(S.charAt(j), --val);
				if(val >= 0){
				 count++;	
				}
				
				while(count == T.length()){
				if(j-low+1 < minLength){
					minLength = j-low+1;
					 start = low;
				}
				
				if (h.containsKey(S.charAt(low))) {
					h.put(S.charAt(low), h.get(S.charAt(low))+1);
					if(h.get(S.charAt(low)) > 0){
						--count;
					}
				}
				low++;
				}
				
			}
			
		}
		System.out.println("start " + start + " end " + (start+minLength-1));
		return S.substring(start,start+minLength);
	}
	
	public static void main(String args[]){
		
		String S = "aabcda";
		String T = "abcd";
		String res = minimumWindow(S,T);
		System.out.println(res);
	}
	
}