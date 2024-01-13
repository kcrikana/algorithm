import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int mid = 21;
        int last = 28;

        int charIdx = N-1;

        int jong = charIdx%last;
        charIdx /= last;

        int jung = charIdx % mid;
        charIdx /= mid;

        int cho = charIdx;

        char ch = (char)('가'+cho*21*28+jung*28+jong);
        System.out.println(ch);


    }
}
