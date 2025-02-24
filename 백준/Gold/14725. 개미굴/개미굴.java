import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TreeMap<String, Node> map = new TreeMap<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			ArrayList<String> list = new ArrayList<>();
			for(int j=0; j<K; j++) list.add(st.nextToken());
			if(!map.containsKey(list.get(0))) map.put(list.get(0), new Node(list.get(0), new TreeMap<String, Node>()));
			tree(1, K, list, map.get(list.get(0)));
		}
		for(String str : map.keySet()) {
			sb.append(str).append('\n');
			trie(1, map.get(str));
		}
		System.out.println(sb);
	}

	static void tree(int depth, int K, ArrayList<String> list, Node now) {
		if(K == depth) return;
		if(!now.map.containsKey(list.get(depth))) now.map.put(list.get(depth), new Node(list.get(depth), new TreeMap<String, Node>()));
		tree(depth+1, K, list, now.map.get(list.get(depth)));
	}

	static void trie(int depth, Node now) {
		if(now.map.isEmpty()) return;
		for(String str : now.map.keySet()) {
			for(int i=0; i<depth; i++) sb.append("--");
			sb.append(str).append('\n');
			trie(depth+1, now.map.get(str));
		}
	}
}

class Node{
	String name;
	TreeMap<String, Node> map;
	public Node(String name, TreeMap<String, Node> map) {
		this.name = name;
		this.map = map;
	}
}