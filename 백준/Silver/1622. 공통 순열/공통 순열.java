import java.io.*;
import java.util.*;

public class Main {

    static int[] getCntArr(String s) {
        int[] cnt = new int['z'-'a'+1];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)-'a']++;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String str = bf.readLine();
            if (str == null) break;
            String com = bf.readLine();
            int[] cntA = getCntArr(str);
            int[] cntB = getCntArr(com);
            for(int i=0; i<cntA.length; i++) {
                for(int j=0; j<Math.min(cntA[i],cntB[i]); j++) {
                    sb.append((char)('a'+i));
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}