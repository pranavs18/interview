import java.util.TreeMap;

public class Trie {
	
	class TrieNode{
		
	boolean isLeaf;
	public TreeMap<Character, TrieNode> map ;
	public int count;
	
	public TrieNode(){
		this.isLeaf = false;
		this.map = new TreeMap<Character,TrieNode>();
		this.count = 0;
	}
	public TrieNode(boolean isLeaf, TreeMap<Character, TrieNode> map, int count){
		this.isLeaf = isLeaf;
		this.map = map;
		this.count = count;
	}
	
	}
	
	TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}
	
	public void insert(String s){
		TrieNode current = root;
		for(int i=0;i< s.length();i++){
			char t = s.charAt(i);
			if(!current.map.containsKey(t)){
				current.map.put(t, new TrieNode());
			}
			current = current.map.get(t);
		}
		current.count++;
		current.isLeaf = true;
	}
	
	public void printTrie(TrieNode root){
		String s = "";
		if(root == null)
			return;
		for(Character c:root.map.keySet()){
			System.out.println(s+ c);
		}
	}
}