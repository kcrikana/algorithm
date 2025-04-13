import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Node> stack = new Stack<>();
		long count = 0;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			Node node = new Node(num, 1);
			while(!stack.isEmpty() && stack.peek().height <= num) {
				Node now = stack.pop();
				count += now.count;
				if(now.height == num) node.count += now.count;
			}
			if(!stack.isEmpty()) count++;
			stack.push(node);
		}
		System.out.println(count);
	}
}

class Node {
	int height, count;
	Node(int height, int count) {
		this.height = height;
		this.count = count;
	}

}
