import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        Queue<Integer>Q = new ArrayDeque<>();
        Q.offer(0);
        int[] dx = {0,-1,0,1};
        int[] dy = {-1,0,1,0};
        int[][] vis = new int[maps.length][maps[0].length];
        vis[0][0] = 1;
        while(!Q.isEmpty()){
            int cur = Q.poll();
            int curx = cur % maps[0].length;
            int cury = cur / maps[0].length;
            for(int i = 0; i<4; i++){
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                if(nx >= maps[0].length || nx < 0 || ny >= maps.length || ny < 0) continue;
                if(vis[ny][nx] != 0 || maps[ny][nx] == 0) continue;
                if(nx == maps[0].length - 1 && ny == maps.length - 1) {
                    if(answer == -1) answer = vis[cury][curx] + 1;
                    else answer = Math.min(vis[cury][curx] + 1, answer);
                }
                if(vis[ny][nx] < vis[cury][curx] + 1) vis[ny][nx] = vis[cury][curx] + 1;
                Q.offer(ny * maps[0].length + nx);
            }
        }
        return answer;
    }
}