import java.util.HashSet;

class permutation {
	
	public static void main(String args[]){
		
		String s= "tree";
		HashSet<String> h = new HashSet<String>();
		permute("",s, h);
	}
	
	private static void permute(String prefix, String s, HashSet<String> h){
		
		int n  =s.length();
		if(n == 0){
			if(!h.contains(prefix)){
			 h.add(prefix);
			 System.out.println(prefix);
			}
		}
		else{
			for(int i=0;i<n;i++){
				permute(prefix + s.charAt(i),s.substring(0,i) + s.substring(i+1, n),h);
			}
		}
	}
	
}