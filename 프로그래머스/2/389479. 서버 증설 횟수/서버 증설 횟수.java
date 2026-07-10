import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[26];
        for(int i = 0; i<players.length; i++) {
            int temp = server[i];
            if(server[i] < players[i] / m){
                for(int j = 0; j<k; j++) {
                    if(j + i == server.length) break;
                    for(int q = 0; q<players[i] / m - temp; q++){
                        server[j+i]++;   
                    }
                }
                answer += players[i] / m - temp;
                // System.out.println("i번째 시간: " + i + "    answer: " + answer);
            }
        }
        // for(int i = 1; i<26; i++) {
        //     if(server[i] > server[i-1]) {
        //         answer += server[i] - server[i-1];
        //     }
        // }
        // System.out.println(Arrays.toString(server));
        return answer;
    }
}