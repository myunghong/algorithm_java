import java.util.*;
class Solution {
    public long solution(int m, int n, int[][] puddles) {
        long answer = 0;
        long [][] arr = new long[n][m];
        for(int i = 0; i<puddles.length; i++){
            arr[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        for(int i = 0; i<n; i++){
            if(arr[i][0] == -1) break;
            arr[i][0] = 1l;
        }
        for(int i = 0; i<m; i++){
            if(arr[0][i] == -1) break;
            arr[0][i] = 1l;
        }

        
        // for(int i = 0; i<n; i++){
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        for(int i = 1; i<n; i++){
            for(int j = 1; j<m; j++){
                if(arr[i][j] == -1) continue;
                long nrow = arr[i-1][j];
                long ncol = arr[i][j-1];
                if(nrow != -1 && ncol != -1) {
                    arr[i][j] = (nrow + ncol) % 1000000007;
                } else if(nrow != -1 && ncol == -1) {
                    arr[i][j] = nrow % 1000000007;
                } else {
                    arr[i][j] = ncol % 1000000007;
                }
            }
        }
        // System.out.println("");
        // for(int i = 0; i<n; i++){
        //     System.out.println(Arrays.toString(arr[i]));
        // }
        answer = arr[n-1][m-1];
        return answer;
    }
}