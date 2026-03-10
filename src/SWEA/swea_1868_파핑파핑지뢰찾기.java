package SWEA;
import java.util.*;
import java.io.*;
public class swea_1868_파핑파핑지뢰찾기 {
	static int[][] board;
	static int N;
	static int[] dx = {-1,-1,-1,1,1,1,0,0}, dy = {1,-1,0,1,-1,0,1,-1}, bfsx = {0,0,-1,1}, bfsy = {-1,1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			int ans = 0;
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			int[][] vis = new int[N][N];
			for(int i = 0; i<N; i++) {
				String str = br.readLine();
				for(int j = 0; j<N; j++) {
					if(str.charAt(j) == '.') board[i][j] = 0;
					else {
						vis[i][j] = 1;
						board[i][j] = -1;
					}
				}
			}
			Deque<Integer> Q = new ArrayDeque<>();
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					if(board[i][j] == 0 && vis[i][j] == 0) {
						if(isSafe(i,j) == 0) {
//							System.out.println(i + " " + j);
							ans++;
							vis[i][j] = 1;
							Q.offer(i * N + j);
							while(!Q.isEmpty()) {
								int cur = Q.poll();
								int row = cur / N;
								int col = cur % N;
								for(int p = 0; p<8; p++) {
									int nrow = row + dx[p];
									int ncol = col + dy[p];
									if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= N) continue;
									if(vis[nrow][ncol] != 0 || board[nrow][ncol] != 0) continue;
									if(isSafe(nrow, ncol) == 0) Q.offer(nrow * N + ncol);
									vis[nrow][ncol] = 1;
								}
							}
						}
					}
				}
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
//					System.out.print(vis[i][j] + " ");
					if(vis[i][j] == 0) ans++;
				}
//				System.out.println();
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	static int isSafe(int row, int col) {
		int cnt = 0;
		for(int i = 0; i<8; i++) {
			int nrow = row + dx[i];
			int ncol = col + dy[i];
			if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= N) continue;
			if(board[nrow][ncol] != 0) cnt++;
		}
		return cnt;
	}
	
	
	
}


