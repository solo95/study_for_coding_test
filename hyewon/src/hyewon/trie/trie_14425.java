package hyewon.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class trie_14425 {
	static class TrieNode{
		TrieNode[] child;
		boolean isEnd;
		
		public TrieNode(){
			this.child = new TrieNode[26];
			this.isEnd = false;
		}
	}
	static TrieNode root;
	
	static void insert(String word){
		TrieNode trie = root;  
		int length = word.length();
		int level,index;
		
		for(level=0; level<length; level++){
			index = word.charAt(level) - 'a';  // 알파벳 소문자로만 이루어져 있음
			if(trie.child[index] == null){
				trie.child[index] = new TrieNode();
			}
			trie = trie.child[index];
		}
		trie.isEnd = true;
	}
	static boolean search(String key){
		TrieNode trie = root;
		int length = key.length();
		int level,index;

		for(level=0; level<length; level++){
			index = key.charAt(level) - 'a';
			if(trie.child[index] == null)
				return false;
			
			trie = trie.child[index];
		}if(trie!=null&&trie.isEnd){
			return true;
		}else{
			return false;
		}
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt =0;
		root = new TrieNode();   // 루트 노드 생성
		String[] s = new String[n];
		String[] check = new String[m];
		
		
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine());
			s[i] = st.nextToken();
			insert(s[i]);
		}
		
		for(int i=0; i<m; i++){
			st = new StringTokenizer(br.readLine());
			check[i] = st.nextToken();
			if(search(check[i])==true){
				cnt++;
			}else{
				continue;
			}
		}
		
		System.out.println(cnt);
		

	}

}
