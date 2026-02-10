import java.util.*;

class Solution {
    int maxResult = 0;
    int[] answer = new int[11];
    int[] compare = new int[11];
    public int[] solution(int n, int[] info) {
        dfs(0, 0, info, n);
        if(maxResult == 0) return new int[] {-1};
        return answer;
    }
    
    void dfs(int depth, int number, int[] info, int n) {
        if(depth == n) {
            int lion = 0;
            for(int i=0; i<=10; i++) {
                if(compare[i] == 0 && info[i] == 0) continue;
                if(compare[i] > info[i]) lion += 10-i;    
                else lion -= 10-i;
            }
            if(lion <= 0) return;            
            if(maxResult < lion) {
                maxResult = lion;
                answer = Arrays.copyOf(compare, 11);
                return;
            }
            else if(maxResult == lion) {
                for(int i=10; i>=0; i--) {
                    if(answer[i] > compare[i]) return;
                    else if(answer[i] < compare[i]) {
                        answer = Arrays.copyOf(compare, 11);
                        return;
                    }
                }
            }
            return;
        }
        for(int i=number; i<=10; i++) {
            compare[i]++;
            dfs(depth+1, i, info, n);
            compare[i]--;
        }
        
    }
}


// 10 + 9 + 8 + 7 + 5 - 4 - 3 - 2 - 1 = 29
// 10 + 9 + 8 + 6 + 5 + 4 - 7 - 3 - 2 - 1 = 29