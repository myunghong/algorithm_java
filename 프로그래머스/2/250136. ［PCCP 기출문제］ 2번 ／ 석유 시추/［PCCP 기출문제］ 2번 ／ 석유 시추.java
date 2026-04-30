import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        List<Integer> arr = new ArrayList<>();
        int idx = 2;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        Deque<Integer> Q = new ArrayDeque<>();
        for(int i = 0; i<land.length; i++){
            for(int j = 0; j<land[0].length; j++){
                if(land[i][j] != 1) continue;
                Q.offer(i * land[0].length + j);
                land[i][j] = idx;
                int cnt = 0;
                while(!Q.isEmpty()){
                    int cur = Q.poll();
                    int row = cur / land[0].length;
                    int col = cur % land[0].length;                        
                    cnt++;
                    for(int k = 0; k<4; k++){
                        int nrow = row + dx[k];
                        int ncol = col + dy[k];
                        if(nrow < 0 || nrow >= land.length || ncol < 0 || ncol >= land[0].length) continue;
                        if(land[nrow][ncol] != 1) continue;
                        land[nrow][ncol] = idx;
                        Q.offer(nrow * land[0].length + ncol);
 
                    }
                    
                }
                arr.add(cnt);
                idx++;
            }
        }
        for(int i = 0; i<land[0].length; i++){
            int temp = 0;
            HashSet<Integer> vis = new HashSet<>();
            for(int j = 0; j<land.length; j++){
                if(land[j][i] <= 1) continue;
                vis.add(land[j][i]);
            }
            for(int j : vis){
                temp += arr.get(j-2);
            }
            answer = Math.max(temp, answer);
        }
        
        // for(int i = 0; i<land.length; i++){
        //     System.out.println(Arrays.toString(land[i]));
        // }
        // for(int i = 0; i<arr.size(); i++){
        //     System.out.print(arr.get(i) + "\t");
        // }
        return answer;
    }
}