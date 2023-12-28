import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int num = 0;
            for(int j=0; j<4; j++) num += Integer.parseInt(st.nextToken());
            switch (num) {
                case 0 -> sb.append('D').append('\n');
                case 1 -> sb.append('C').append('\n');
                case 2 -> sb.append('B').append('\n');
                case 3 -> sb.append('A').append('\n');
                default ->  sb.append('E').append('\n');
            }
        }
        System.out.println(sb);
    }
}