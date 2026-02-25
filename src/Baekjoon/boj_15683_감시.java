package Baekjoon;
import java.io.*;
import java.util.*;
public class boj_15683_감시 {
	static int[][] board, vis;
	static int N, M, ans = Integer.MAX_VALUE;
	static List<Integer> coords;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		vis = new int[N][M];
		coords = new ArrayList<>();
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 0) continue;
				
				if(board[i][j] == 6) {
					vis[i][j] = -1;
					continue;
				}
				
				coords.add(i*M + j);
				vis[i][j] = 1;
			}
		}
		dfs(0);
		
		System.out.println(ans);
	}
	
	static void dfs(int idx) {
		if(idx == coords.size()) {
//			for(int i = 0; i<N; i++) {
//				for(int j = 0; j<M; j++) {
//					System.out.print(vis[i][j] + " ");
//				}
//				System.out.println("");
//			}
//			System.out.println("");
			int temp = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(vis[i][j] == 0) temp++;
				}
			}
			if(ans > temp) ans = temp;
			return;
		}
		int row = coords.get(idx) / M;
		int col = coords.get(idx) % M;
		switch (board[row][col]) {
		case 1:
			for(int i = 0; i<4; i++) {
				check1(row, col, i, 1);
				dfs(idx + 1);
				check1(row, col, i, -1);
			}
			break;
		case 2:
			for(int i = 0; i<2; i++) {
				check2(row, col, i, 1);
				dfs(idx + 1);
				check2(row, col, i, -1);
			}
			break;
		case 3:
			for(int i = 0; i<4; i++) {
				check3(row, col, i, 1);
				dfs(idx + 1);
				check3(row, col, i, -1);
			}
			break;
		case 4:
			for(int i = 0; i<4; i++) {
				check4(row, col, i, 1);
				dfs(idx + 1);
				check4(row, col, i, -1);
			}
			break;
		case 5:
			check5(row, col, 1);
			dfs(idx + 1);
			check5(row, col, -1);
			break;
		default:
			break;
		}
	}
	
	static void check1(int row, int col, int dir, int type) {
		int nrow = row + dx[dir];
		int ncol = col + dy[dir];
		if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= M ) return;
		while(nrow >= 0 && ncol >= 0 && nrow < N && ncol < M) {
			if(board[nrow][ncol] != 6) {
				vis[nrow][ncol] += type;
			}
			else {
				break;
			}
			nrow += dx[dir];
			ncol += dy[dir];
		}
		return;
	}
	static void check2(int row, int col, int dir, int type) {
		for(int i = 0; i<=2; i += 2) {
			int nrow = row + dx[dir + i];
			int ncol = col + dy[dir + i];
			if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= M ) continue;
			while(nrow >= 0 && ncol >= 0 && nrow < N && ncol < M) {
				if(board[nrow][ncol] != 6) {
					vis[nrow][ncol] += type;
				}
				else {
					break;
				}
				nrow += dx[(dir + i) % 4];
				ncol += dy[(dir + i) % 4];
			}
		}
		
		
		return;
	}
	static void check3(int row, int col, int dir, int type) {
		for(int i = 0; i<2; i++) {
			int nrow = row + dx[(dir + i) % 4];
			int ncol = col + dy[(dir + i) % 4];
			if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= M ) continue;
			while(nrow >= 0 && ncol >= 0 && nrow < N && ncol < M) {
				if(board[nrow][ncol] != 6) {
					vis[nrow][ncol] += type;
				}
				else {
					break;
				}
				nrow += dx[(dir + i) % 4];
				ncol += dy[(dir + i) % 4];
			}
		}
		return;
	}
	static void check4(int row, int col, int dir, int type) {
		for(int i = 0; i<3; i++	) {
			int nrow = row + dx[(dir + i) % 4];
			int ncol = col + dy[(dir + i) % 4];
			if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= M ) continue;
			while(nrow >= 0 && ncol >= 0 && nrow < N && ncol < M) {
				if(board[nrow][ncol] != 6) {
					vis[nrow][ncol] += type;
				}
				else {
					break;
				}
				nrow += dx[(dir + i) % 4];
				ncol += dy[(dir + i) % 4];
			}
		}
		return;
	}
	static void check5(int row, int col, int type) {
		for(int i = 0; i<4; i++	) {
			int nrow = row + dx[i];
			int ncol = col + dy[i];
			if(nrow < 0 || nrow >= N || ncol < 0 || ncol >= M ) continue;
			while(nrow >= 0 && ncol >= 0 && nrow < N && ncol < M) {
				if(board[nrow][ncol] != 6) {
					vis[nrow][ncol] += type;
				}
				else {
					break;
				}
				nrow += dx[i];
				ncol += dy[i];
			}
		}
		return;
	}
}
