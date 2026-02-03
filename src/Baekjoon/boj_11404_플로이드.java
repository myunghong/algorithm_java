package Baekjoon;
import java.util.*;
import java.io.*;
public class boj_11404_플로이드 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int maxval = 100000000;
		int[][] board = new int[N+1][N+1];
		StringTokenizer st;
		for(int i = 0; i<board.length; i++) {
			Arrays.fill(board[i], maxval);
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
			if(board[a][b] != 0 )board[a][b] = Math.min(board[a][b], c);
			else board[a][b] = c;
			
		}
		

		for(int k = 1; k <= N; k++) {
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j <= N; j++) {
					if(i == j) board[i][j] = 0;
					board[i][j] = Math.min(board[i][j], board[i][k] + board[k][j]);
					
				}
			}
			
		}
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N;j++) {
				if(board[i][j] != maxval)sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
		
	}

}
