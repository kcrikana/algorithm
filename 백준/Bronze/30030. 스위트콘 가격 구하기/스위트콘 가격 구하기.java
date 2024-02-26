import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int B = Integer.parseInt(bf.readLine());
        System.out.println(B/11*10);
    }
}