import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		int num = 0;
		for(count=3; count>=1; count--) {
			String str = br.readLine();
			char ch = str.charAt(0);
			if(ch != 'F' && ch != 'B') {
				num = Integer.parseInt(str);
				break;
			}
		}
		num += count;
		if(num % 3 == 0) {
			if(num % 5 == 0) System.out.println("FizzBuzz");
			else System.out.println("Fizz");
		}
		else {
			if(num % 5 == 0) System.out.println("Buzz");
			else System.out.println(num);
		}
	}
}
