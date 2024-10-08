import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long W = Long.parseLong(st.nextToken());
		long H = Long.parseLong(st.nextToken());
		long f = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
		long x1 = Long.parseLong(st.nextToken());
		long y1 = Long.parseLong(st.nextToken());
		long x2 = Long.parseLong(st.nextToken());
		long y2 = Long.parseLong(st.nextToken());

		long result = W * H;

		long overlap = Math.min(f, W - f);
		long coloredArea = (x2 - x1) * (y2 - y1) * (c + 1);

		if (x1 < overlap) {
			long overlapWidth = Math.min(x2, overlap) - x1;
			coloredArea += overlapWidth * (y2 - y1) * (c + 1);
		}

		System.out.println(result - coloredArea);
	}
}