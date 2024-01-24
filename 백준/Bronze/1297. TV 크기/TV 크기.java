import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        double dia = Math.sqrt(Math.pow(H,2)+Math.pow(W,2));
        double len = D/dia;
        int height = (int)Math.floor(H*len);
        int width = (int)Math.floor(W*len);
        StringBuilder sb = new StringBuilder().append(height).append(' ').append(width);
        System.out.println(sb);
    }
}