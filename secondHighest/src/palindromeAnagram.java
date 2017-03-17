public class palindromeAnagram {
	
	private static boolean isAnagramPalindrome(String s){
		int temp[] = new int[26];
		boolean palindrome= false;
		for(int i=0;i<s.length();i++){
		  int x = s.charAt(i) - 'a';
		  temp[x]++;
		
		}	
		for(int i=0;i<temp.length;i++){
			if(temp[i] %2 == 1){
				if(palindrome)
					return false;
				else
					palindrome = true;
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		String s = "abca";
		boolean x= isAnagramPalindrome(s);
		if(x)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}