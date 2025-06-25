import java.util.*;
import java.io.*;

public class Main {
	static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;

		while (!(line = br.readLine()).equals("end")) {
			board = new char[3][3];
			int xCount = 0;
			int oCount = 0;


			for (int i = 0; i < 9; i++) {
				char c = line.charAt(i);
				board[i / 3][i % 3] = c;
				if (c == 'X') xCount++;
				else if (c == 'O') oCount++;
			}

			boolean xWin = isWin('X');
			boolean oWin = isWin('O');


			if (oCount > xCount || xCount - oCount > 1) {
				sb.append("invalid\n");
			} else if (xWin && oWin) {
				sb.append("invalid\n");
			} else if (xWin && xCount != oCount + 1) {
				sb.append("invalid\n");
			} else if (oWin && xCount != oCount) {
				sb.append("invalid\n");
			} else if (!xWin && !oWin && xCount + oCount != 9) {
				sb.append("invalid\n");
			} else {
				sb.append("valid\n");
			}
		}

		System.out.print(sb);
	}

	static boolean isWin(char player) {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
			if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
		}
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;

		return false;
	}
}