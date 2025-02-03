import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] pre = new int[1000001];
		int[] post = new int[1000001];
		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int preStation = first;
		for(int i=1; i<N-1; i++) {
			int station = Integer.parseInt(st.nextToken());
			pre[station] = preStation;
			post[preStation] = station;
			preStation = station;
		}
		int last = Integer.parseInt(st.nextToken());
		post[preStation] = last;
		pre[last] = preStation;
		post[last] = first;
		pre[first] = last;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String constroduction = st.nextToken();
			int standarad = Integer.parseInt(st.nextToken());
			if(constroduction.equals("BN")) {
				int newStation = Integer.parseInt(st.nextToken());
				int nextStaion = post[standarad];
				sb.append(nextStaion).append('\n');
				post[standarad] = newStation;
				pre[newStation] = standarad;
				post[newStation] = nextStaion;
				pre[nextStaion] = newStation;
			}
			else if(constroduction.equals("BP")) {
				int newStation = Integer.parseInt(st.nextToken());
				int pastStaion = pre[standarad];
				sb.append(pastStaion).append('\n');
				post[pastStaion] = newStation;
				pre[newStation] = pastStaion;
				post[newStation] = standarad;
				pre[standarad] = newStation;
			}
			else if(constroduction.equals("CN")) {
				int nextStaion = post[standarad];
				sb.append(nextStaion).append('\n');
				int linked = post[nextStaion];
				post[standarad] = linked;
				pre[linked] = standarad;
			}
			else if(constroduction.equals("CP")) {
				int pastStaion = pre[standarad];
				sb.append(pastStaion).append('\n');
				int linked = pre[pastStaion];
				pre[standarad] = linked;
				post[linked] = standarad;
			}
		}
		System.out.println(sb);
	}
}