import java.util.*;
class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        int[] ans = new int[3000000];
        List<Integer> time = new ArrayList<>();
        int[] ytime = new int[signals.length];
        for(int i = 0; i<signals.length; i++){
            time.add(signals[i][0] + signals[i][2]);
            ytime[i] = signals[i][1];
        }
        
        for(int i = 0; i<signals.length; i++){
            int idx = 0;
            for(int k = 0; k<20; k++){
                System.out.printf(ans[k] + " ");
            }
            System.out.println("");
            for(int j = 0; j<signals[i][0]; j++){
                    ans[idx++] = 0;
                }
            while(idx<2900000){
                
                for(int j = 0; j<ytime[i]; j++){
                    if(ans[idx] == 1 || i == 0) ans[idx] = 1;
                    idx++;
                }
                for(int j = 0; j<time.get(i); j++){
                    ans[idx++] = 0;
                }
            }
            
        }
        
        for(int i = 0;i <3000000; i++){
            if(ans[i] == 1){
                answer = i+1;
                break;
            }
        }
        if(answer == 0) answer = -1;
        // for(int i = 0; i<20; i++){
        //     System.out.printf(ans[i] + " ");
        // }
        return answer;
    }
}