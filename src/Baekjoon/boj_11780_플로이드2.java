package Baekjoon;
import java.util.*;
import java.io.*;
public class boj_11780_플로이드2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] board = new int[N+1][N+1];
		int[][] nxt = new int[N+1][N+1];
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int maxval = 1000000000;
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				board[i][j] = maxval;
				if(i == j) board[i][j] = 0;
			}
		}
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			if (c < board[a][b]) {
			    board[a][b] = c;
			    nxt[a][b] = b;
			}
		}
		
		for(int k = 1; k<=N; k++) {
			for(int i = 1; i<=N; i++) {
				for(int j = 1; j<= N; j++) {
					if(board[i][k] == maxval || board[k][j] == maxval) continue;
					if(board[i][j] > board[i][k] + board[k][j]) {
						board[i][j] = board[i][k] + board[k][j];
						nxt[i][j] = nxt[i][k];
					}
				}
			}
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if(board[i][j] == maxval) sb.append("0 ");
				else sb.append(board[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if(nxt[i][j] == 0)sb.append("0");
				else {
					int cnt = 2;
					int r = i, c = j;
					Deque<Integer> arr = new ArrayDeque<>();
					arr.offer(r);
					while(true) {
						if(nxt[r][c] == c) {
							break;
						}
						else {
							arr.offer(nxt[r][c]);
							r = nxt[r][c];
							cnt++;
						}
					}
					arr.offer(j);
					sb.append(cnt).append(" ");
					while(!arr.isEmpty()) sb.append(arr.poll()).append(" ");
				}
				sb.append("\n");
			}
		}
		
		
		
		
		System.out.println(sb);
		
	}

}
