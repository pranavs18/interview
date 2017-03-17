import java.util.ArrayList;
import java.util.HashSet;

public class commonCharacters {
	
	
	private static void findCommonCharacters(ArrayList<String> al){
	   if(al.size() == 0)
		   	return;
	   
	   char s[] = new char[26];
	   for(String str:al){
		   HashSet<Character> h = new HashSet<Character>();
		   for(int i=0;i< str.length();i++){
			   if(!h.contains(str.charAt(i))){
				   h.add(str.charAt(i));
				   s[(int)str.charAt(i) - 97] += 1;
			   }
				   
		   }
	   }
	   
	   int count =0;
	   for(int j=0;j<26;j++){
		   if(s[j] == al.size()){
			   count++;
		   }
	   }
	   System.out.println("Common characters " + count);
	}
	
	public static void main(String args[]){
		
		String a= "abcljjjjfgldjgorjfojfs";
		String b = "vbkjbsfsf";
		String c = "uiuwejdsf";
		ArrayList<String> al = new ArrayList<String>();
		al.add(a);
		al.add(b);
		al.add(c);
		findCommonCharacters(al);
		
	}
	
}