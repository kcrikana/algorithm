import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] com1 = bf.readLine().split(" ");
        String[] com2 = bf.readLine().split(" ");
        String[] com3 = bf.readLine().split(" ");

        String x = null,y=null;
        if(com1[0].equals(com2[0])) x= com3[0];
        if(com1[0].equals(com3[0])) x= com2[0];
        if(com3[0].equals(com2[0])) x= com1[0];
        if(com1[1].equals(com2[1])) y= com3[1];
        if(com1[1].equals(com3[1])) y= com2[1];
        if(com3[1].equals(com2[1])) y= com1[1];
        System.out.println(x+ " "+y);
    }
}
