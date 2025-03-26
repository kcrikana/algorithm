import java.io.*;
import java.util.*;

public class Main {
	static char[][] display;
	static int s;
	static String n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		n = st.nextToken();
		display = new char[2*s+3][(s+2)*n.length()+n.length()-1];
		for(int i=0; i<display.length; i++) {
			for(int j=0; j<display[0].length; j++) display[i][j] = ' ';
		}
		for(int i=0; i<n.length(); i++) func(n.charAt(i)-'0', i);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<display.length; i++) {
			for(int j=0; j<display[0].length; j++) sb.append(display[i][j]);
			sb.append('\n');
		}
		System.out.println(sb);

	}

	static void func(int num, int idx) {
		int col = idx*(s+3);
		int row = 0;
		if(num == 1) {
			input(row, col, 1);
			input(row, col, 2);
		}
		else if(num == 2) {
			input(row, col, 1);
			input(row, col, 3);
			input(row, col, 4);
			input(row, col, 5);
			input(row, col, 7);
		}
		else if(num == 3) {
			input(row, col, 1);
			input(row, col, 2);
			input(row, col, 3);
			input(row, col, 4);
			input(row, col, 5);
		}
		else if(num == 4) {
			input(row, col, 1);
			input(row, col, 2);
			input(row, col, 4);
			input(row, col, 6);
		}
		else if(num == 5) {
			input(row, col, 2);
			input(row, col, 3);
			input(row, col, 4);
			input(row, col, 5);
			input(row, col, 6);
		}
		else if(num == 6) {
			input(row, col, 2);
			input(row, col, 3);
			input(row, col, 4);
			input(row, col, 5);
			input(row, col, 6);
			input(row, col, 7);
		}
		else if(num == 7) {
			input(row, col, 1);
			input(row, col, 2);
			input(row, col, 3);
		}
		else if(num == 8) {
			input(row, col, 1);
			input(row, col, 2);
			input(row, col, 3);
			input(row, col, 4);
			input(row, col, 5);
			input(row, col, 6);
			input(row, col, 7);
		}
		else if(num == 9) {
			input(row, col, 1);
			input(row, col, 2);
			input(row, col, 3);
			input(row, col, 4);
			input(row, col, 5);
			input(row, col, 6);
		}
		else if(num == 0) {
			input(row, col, 1);
			input(row, col, 2);
			input(row, col, 3);
			input(row, col, 5);
			input(row, col, 6);
			input(row, col, 7);
		}
	}

	static void input(int row, int col, int seq) {
		if(seq == 1) {
			for(int i=0; i<s; i++) {
				display[i+1][col+s+1] = '|';
			}
		}
		else if(seq == 2) {
			for(int i=0; i<s; i++) {
				display[i+s+2][col+s+1] = '|';
			}
		}
		else if(seq == 3) {
			for(int i=0; i<s; i++) {
				display[row][col+i+1] = '-';
			}
		}
		else if(seq == 4) {
			for(int i=0; i<s; i++) {
				display[row+s+1][col+i+1] = '-';
			}
		}
		else if(seq == 5) {
			for(int i=0; i<s; i++) {
				display[row+(2*s+2)][col+i+1] = '-';
			}
		}
		else if(seq == 6) {
			for(int i=0; i<s; i++) {
				display[row+i+1][col] = '|';
			}
		}
		else if(seq == 7) {
			for(int i=0; i<s; i++) {
				display[row+i+s+2][col] = '|';
			}
		}
	}
}
