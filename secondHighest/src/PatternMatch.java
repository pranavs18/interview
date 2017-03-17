import java.util.HashMap;
import java.util.HashSet;

public class PatternMatch {
	
	private static boolean isMatch(String s, String p){
		
		if(s == null || p == null)
			return false;
		if(p.length() == 0 && s.length() == 0)
			return true;
		if(p.length() == 0 && s.length() != 0)
			return false;
		
		if(p.length() == 1 ||  p.charAt(1) != '*'){
			if(s.length() == 1 || (p.charAt(0) !='.' && s.charAt(0) != p.charAt(0)))
				return false;
			else
				return isMatch(s.substring(1), p.substring(1));
		}
		else{
			int len = s.length();
			int i=-1;
			while(i < len && (i<0 || p.charAt(0)== '.' ||  p.charAt(0) == s.charAt(i))){
				if(isMatch(s.substring(i+1),p.substring(2)))
					return true;
				i++;
			}
		}
		
		return false;
	}
	
	public static void main(String args[]){
		
		String s = "aab";
		String p = "a*b*";
		boolean result = isMatch(s,p);
		System.out.println("Pattern Matched " + result);
	}
}