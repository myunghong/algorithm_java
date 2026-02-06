package SWEA;
import java.io.*;
import java.util.*;
public class swea_5215_햄버거다이어트 {
	static int[][] board;
	static int ans, N, L;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken()); // 칼로리 총합 제한
			board = new int[N][2];
			ans = 0;
			for(int i = 0 ;i<N; i++) {
				st = new StringTokenizer(br.readLine());
				board[i][0] = Integer.parseInt(st.nextToken()); // 맛에 대한 점수 (높을수록 good)
				board[i][1] = Integer.parseInt(st.nextToken()); // 칼로리 (제한 넘으면 안됨)
			}
			
			dfs(0,0,0);
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void dfs(int idx, int cal, int happy) {
		if(cal > L) return;
		ans = Math.max(happy, ans);
		
		if(idx == N) return;
		dfs(idx+1, cal, happy);
		
		if(cal + board[idx][1] <= L) {
			dfs(idx + 1, cal + board[idx][1], happy + board[idx][0]);
		}
	}
	
}
