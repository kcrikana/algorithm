import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int playTime = timeToInt(play_time);
        int advTime = timeToInt(adv_time);
        int len = playTime+1;
        long[] arr = new long[len];
        
        for(String log : logs) {
            String[] runningTime = log.split("-");
            int startTime = timeToInt(runningTime[0]);
            int endTime = timeToInt(runningTime[1]);
            arr[startTime]++;
            arr[endTime]--;
        }
        
        for(int i=1; i<len; i++) arr[i] += arr[i-1];
        for(int i=1; i<len; i++) arr[i] += arr[i-1];
        
        long max = arr[advTime];
        long startTime = 0;
        for(int i=1; i<len-advTime; i++) {
            long now = arr[advTime+i-1] - arr[i-1];
            if(now > max) {
                max = now;
                startTime = i;
            }
        }
        int hour = (int)(startTime/3600);
        startTime %= 3600l;
        int minute = (int)(startTime/60);
        startTime %= 60l;
        int sec = (int)startTime;
        return String.format("%02d:%02d:%02d", hour, minute, sec);
    }
    
    
    int timeToInt(String time) {
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0])*60*60;
        int min = Integer.parseInt(times[1])*60;
        int sec = Integer.parseInt(times[2]);
        return hour+min+sec;
    }
}