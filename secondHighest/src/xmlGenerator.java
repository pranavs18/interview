import java.util.ArrayList;

class nTree{
	char val;
	ArrayList<nTree> children;
	public nTree(char val, ArrayList<nTree> children){
		this.val = val;
		this.children = children;
	}
}

public class xmlGenerator {
	
	private static void generateXML(nTree root){
		if(root == null)
			return;
		else {
			String s = xml(root,"");
			System.out.println(s);
			}
			
	}
	
	private static String xml(nTree root, String s){
		
		if(root.children.size() == 0){
			s += "</" + root.val + ">";
			return s;
		}
		
		else {
			s += "<" + root.val + ">";
			for(int i=0;i<root.children.size();i++){
				s = xml(root.children.get(i),s);
			 }
			s += "</" + root.val + ">";
		}
		
		return s;
	}

	public static void main(String args[]){
		
		ArrayList<nTree> dl = new ArrayList<nTree>();
		ArrayList<nTree> al = new ArrayList<nTree>();
		nTree c1 = new nTree('c', new ArrayList<nTree>());
		nTree c2 = new nTree('d', dl);
		nTree c3 = new nTree('e', new ArrayList<nTree>());
		nTree c4 = new nTree('f', new ArrayList<nTree>());
		nTree c5 = new nTree('g', new ArrayList<nTree>());
		
		al.add(c1);
		al.add(c2);
		al.add(c3);
		al.add(c4);
		dl.add(c5);
		nTree root = new nTree('a',al);
		generateXML(root);
		
		/*
		 *       a
		 *     / | \ \ 
		 *    c  d  e f
		 *       |
		 *       g
		 *   <a> </c> <d></g> </d> </e> </f> </a>
		 */
		 
		
	}
}