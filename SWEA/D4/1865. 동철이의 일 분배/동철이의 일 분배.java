import java.util.StringTokenizer;
import java.util.*;
import java.io.*;
public class Solution {
    static double ans = 0;
    static int[][] board = new int[20][20];
    static int[] vis = new int[20];
    static int N = 0;

    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for(int test = 1; test <= T; test++) {
            ans = 0;
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            vis = new int[N];
            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            backtracking(0, 100);


            sb.append("#").append(test).append(" ").append(String.format("%.6f", ans)).append("\n");

        }


        System.out.println(sb);
    }

    static void backtracking(int idx, double temp) {
        if(idx == N) {
            ans = Math.max(ans, temp);
            return;
        }
        if(temp <= ans) return;

        for(int i = 0; i<N; i++){
            if(vis[i] != 0) continue;
            vis[i] = 1;
            backtracking(idx+1, temp * board[idx][i] * 0.01);
            vis[i] = 0;
        }
        return;
    }




}