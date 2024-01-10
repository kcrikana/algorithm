import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String com = bf.readLine();
        int strSize = str.length();
        int comSize = com.length();
        str = str.replace(com, "");
        System.out.println((strSize-str.length())/comSize);
    }
}