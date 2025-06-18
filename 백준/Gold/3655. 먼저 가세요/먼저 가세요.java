import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			HashMap<Character, Integer> counts = new HashMap<>();
			HashMap<Character, Integer> lastIdx = new HashMap<>();
			for(int i=0; i<N; i++) {
				counts.put(arr[i], counts.getOrDefault(arr[i],0)+1);
				lastIdx.put(arr[i], i);
			}
			List<Node> list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				list.add(new Node(arr[i], lastIdx.get(arr[i])));
			}
			Collections.sort(list);
			int result = 0;
			for(int i=0; i<N; i++) {
				char now = list.get(i).group;
				int count = counts.get(now);
				int idx = i+count-1;
				i = idx;
				result += 5*(lastIdx.get(now)-idx)*count;
			}
			sb.append(result).append('\n');
		}

		System.out.println(sb);
	}
}

class Node implements Comparable<Node> {
	char group;
	int idx;
	public Node(char group, int idx) {
		this.group =  group;
		this.idx = idx;
	}

	@Override
	public int compareTo(Node o) {
		return this.idx - o.idx;
	}
}