import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long[][] command;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long curAtk = Long.parseLong(st.nextToken());
		command = new long[N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			command[i][0] = Long.parseLong(st.nextToken()); // 종류
			command[i][1] = Long.parseLong(st.nextToken()); // 공격력
			command[i][2] = Long.parseLong(st.nextToken()); // 생명력, 포션
		}
		long start = 1;
		long end = Long.MAX_VALUE;
		while(start <= end) {
			long mid = (start+end)/2l;
			boolean isTruth = calc(curAtk, mid);
			if(isTruth) start = mid + 1;
			else end = mid - 1;
		}
		System.out.println(start);
	}

	static boolean calc(long curAtk, long maxHp) {
		long curHp = maxHp;
		for(int i=0; i<N; i++) {
			if(command[i][0] == 2) {
				curHp += command[i][2];
				if(curHp >= maxHp) curHp = maxHp;
				curAtk += command[i][1];
			}
			else {
				long count = command[i][2]/curAtk-1;
				count += command[i][2]%curAtk != 0 ? 1 : 0;
				curHp -= command[i][1]*count;
			}
			if(curHp <= 0) return true;
		}
		return false;
	}
}
