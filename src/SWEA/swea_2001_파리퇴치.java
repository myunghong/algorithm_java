package SWEA;
import java.util.*;
import java.io.*;

public class swea_2001_파리퇴치 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 1; tc<=TC; tc++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] board = new int[N+1][N+1];
			int[][] sum = new int[N+1][N+1];
			for(int i = 1; i<=N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j<=N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<=N; j++) {
					sum[i][j] = sum[i-1][j] + sum[i][j-1] + board[i][j] - sum[i-1][j-1];
					
				}
			}
			for(int i =M; i<=N; i++) {
				for(int j=M; j<=N; j++) {
					ans = Math.max(ans, sum[i][j] - sum[i-M][j] - sum[i][j-M] + sum[i-M][j-M]);
				}
			}
			
			
			sb.append("#").append(tc).append(" ").append(ans).append('\n');
		}
		System.out.println(sb);
	}

}
