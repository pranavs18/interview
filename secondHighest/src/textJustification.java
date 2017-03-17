import java.util.ArrayList;

public class textJustification {
	
	private static ArrayList<String> textJustify(String s, int limit){
		
		String []words = s.split(" ");
		
		StringBuilder sb = new StringBuilder();
		ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String> res = new ArrayList<String>();
		int curr =0;
		int i=0;
		while(curr < words.length ){
			sb.setLength(0);
			temp.clear();
			//append the first word
			sb.append(words[curr]);
			i = words[curr].length();
			curr++;
			while(  curr < words.length && i + 1+ words[curr].length() <= limit){
				// check if more words can be appeneded , put them into a list
				temp.add(" "+ words[curr]);
				i += words[curr].length() + 1;
				curr++;
			}
			
			if(curr < words.length && temp.size() > 0){
				// check for spaces which can be inserted
				int total = limit - i;
				int avg = total/ temp.size();
				int rem = total%temp.size();
				for(int j=0;j<temp.size();j++){
					insertSpaces(sb,j<rem?avg+1:avg);
				    sb.append(temp.get(j));
				}
			}

			
			else{
				for(int j=0;j<temp.size();j++){
					sb.append(temp.get(j));
				}
					insertSpaces(sb, limit - i);
				
			}
			
			res.add(sb.toString());
			
		}
		
	  
		return res;
	}
	
	private static void insertSpaces(StringBuilder sb, int num){
		for(int i=0;i<num;i++)
			sb.append(" ");
	}
	
	public static void main(String args[]){
		
		String s = "This is an example of text justification";
		int L = 16;
		ArrayList<String> res = new ArrayList<String>();
		res = textJustify(s,L);
		for(int i=0;i<res.size();i++)
			System.out.println(res.get(i));
		
	}
	
}