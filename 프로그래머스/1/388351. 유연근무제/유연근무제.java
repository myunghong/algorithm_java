import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i = 0; i<timelogs.length; i++){
            int sche = schedules[i];
            int temp = 0;
            for(int j = startday - 1; j<startday + 6; j++){
                if(j % 7 == 5 || j % 7 == 6) continue;
                int time = timelogs[i][j - startday + 1];
                if(check(sche, time)) temp++;
            }
            if(temp == 5) answer++;
            // System.out.println("직원: " + i + "   출근일: " + temp);
        }
        return answer;
    }
    
    public boolean check(int sche, int time) {
        int deadline = sche + 10;
        if(deadline % 100 >= 60) {
            deadline += 40;
        }
        if(deadline >= time) return true;
        else return false;
    }
}