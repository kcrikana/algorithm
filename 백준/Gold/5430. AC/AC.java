import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-->0) {
			String commands = br.readLine();
			boolean isForward = true;
			boolean isTruth = true;
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine().replace("[","").replace("]","");
			Deque<String> deq = new ArrayDeque<>();
			for(String num : str.split(",")) {
				if(N == 0) break;
				deq.offer(num);
			}
			for(char command : commands.toCharArray()) {
				if(command == 'R') isForward = !isForward;
				else {
					if(deq.isEmpty()) {
						isTruth = false;
						break;
					}
					else if(isForward) deq.pollFirst();
					else deq.pollLast();
				}
			}
			if(!isTruth) sb.append("error").append('\n');
			else {
				boolean isString = false;
				sb.append('[');
				if(isForward) {
					while(!deq.isEmpty()) {
						if(!isString) isString = true;
						sb.append(deq.pollFirst()).append(',');
					}
				}
				else {
					while(!deq.isEmpty()) {
						if(!isString) isString = true;
						sb.append(deq.pollLast()).append(',');
					}
				}
				if(isString) sb.deleteCharAt(sb.length()-1);
				sb.append(']').append('\n');
			}
		}
		System.out.println(sb);
	}
}