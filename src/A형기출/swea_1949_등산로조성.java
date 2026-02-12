package A형기출;

import java.util.*;
import java.io.*;

public class swea_1949_등산로조성 {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int K, N, ans, temp;
	static int[][] board, vis;
	static List<Integer> coord;
	static Deque<Integer> stk = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			coord = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new int[N][N];
			int maxval = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					maxval = Math.max(maxval, board[i][j]);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == maxval) {
						coord.add(i * N + j);
					}
				}
			}
			ans = 0;
			for(Integer a : coord) {
				vis = new int[N][N];
				temp = 1;
				vis[a/N][a % N] = 1;
				dfs(a, true, board[a / N][a % N], temp);
			}
//			for (Integer a : coord) {
//				stk.push(a);
//				vis[a / N][a % N] = 1;
//				while (!stk.isEmpty()) {
//					int temp = stk.pop();
//					int row = temp / N;
//					int col = temp % N;
//					for (int i = 0; i < 4; i++) {
//						int nrow = row + dx[i];
//						int ncol = col + dy[i];
//						if (nrow < 0 || nrow >= N || ncol < 0 || ncol >= N)
//							continue;
//						if (vis[nrow][ncol] != 0)
//							continue;
//						if(board[row][col] - board[nrow][ncol] <)
//							
//						vis[nrow][ncol] = 1;
//						
//					}
//				}
//			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	
	static void dfs(int idx, boolean flag, int val, int temp) { // idx는 인덱스, flag는 지형을 깎을 수 있는지, val은 이전 땅의 값
		int row = idx / N;
		int col = idx % N;
//		System.out.println(idx + " " + val + " " + temp);
		ans = Math.max(ans, temp);
		for(int i = 0; i<4; i++) {
			int nrow = row + dx[i];
			int ncol = col + dy[i];
			if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= N || vis[nrow][ncol] != 0) continue;
			if(board[nrow][ncol] - val >= 0) {
				if(!flag) continue;
				if(board[nrow][ncol] - val < K) {
					vis[nrow][ncol] = 1;
					dfs(nrow * N + ncol, false, val - 1, temp+1);
					vis[nrow][ncol] = 0;
				}
			}
			else {
				vis[nrow][ncol] = 1;
				dfs(nrow * N + ncol, flag, board[nrow][ncol], temp+1);
				vis[nrow][ncol] = 0;
			}
		}
	}
	
	
	
	
	
}


