import java.util.*;
import java.io.*;

class Solution {
    static int n, answer;
    static int[][] board;
    static int[] vis;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int T;
    	T=Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

    	for(int test_case = 1; test_case <= T; test_case++) {

    		n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            board = new int[12][12];
            vis = new int[12];
            board[0][0] = Integer.parseInt(st.nextToken());
            board[0][1] = Integer.parseInt(st.nextToken());
            board[n+1][0] = Integer.parseInt(st.nextToken());
            board[n+1][1] = Integer.parseInt(st.nextToken());
    
            for(int i = 1; i<n + 1; i++) {
                board[i][0] = Integer.parseInt(st.nextToken());
                board[i][1] = Integer.parseInt(st.nextToken());
            }
            answer = Integer.MAX_VALUE;
            backtracking(0,0,0);
    		sb.append("#").append(test_case).append(" ").append(answer).append("\n");
    	}
        System.out.println(sb);
    }

    static int backtracking(int st, int idx, int dis) {
    	if(idx == n){
            answer = Math.min(answer, dis + calcDis(board[st][0], board[st][1], board[n+1][0], board[n+1][1]));
            return dis;
        }
        if(dis >= answer){
            return 0;
        }
        vis[st] = 1;
    	for(int i = 0; i<n+1; i++){
        	if(vis[i] != 0) continue;
            idx++;
            backtracking(i, idx, dis + calcDis(board[st][0], board[st][1], board[i][0], board[i][1]));
            idx--;
        }
        vis[st] = 0;
        return 0;
    }

    static int calcDis(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

}