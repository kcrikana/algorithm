import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BigInteger res = new BigInteger("1");
        for(String str : bf.readLine().split(" ")) res = res.multiply(new BigInteger(str));
        System.out.println(res);
    }
}