public class reverseStringRecursive {
	
	
	private static void reverse(char[] s,int start,int end){
		
		if(start > end){
			System.out.println("Reversed String " + String.valueOf(s));
			return;
		}
		if(start == end)
			return;
		
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			reverse(s,start+1,end-1);
			
		
	}
	
	public static void main(String args[]){
		
		String s = "This is a test";
		char []temp = s.toCharArray();
		reverse(temp,0,temp.length-1);
		System.out.println(s);
	}
	
}