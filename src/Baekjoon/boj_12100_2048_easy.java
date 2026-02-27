package Baekjoon;

import java.util.*;
import java.io.*;

public class boj_12100_2048_easy {
	static int N, ans = 0;
	static int[][] board;
	static int[] dx = { 0, 0, 1, -1 }, dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		backtracking(0, board);
		System.out.println(ans);
	}

	static void backtracking(int idx, int[][] arr) {
		if (idx == 5) {
			checkans(arr);
//			for(int i = 0; i<N; i++) {
//				for(int j = 0; j<N; j++) {
//					System.out.print(arr[i][j] + "\t");
//				}
//				System.out.println("");
//			}
//			System.out.println("");
			return;
		}
		int[][] temp = new int[N][N];
		for (int q = 0; q < N; q++) {
			temp[q] = arr[q].clone();
		}
		for (int i = 0; i < 4; i++) {
			int[][] temp1 = move(i, temp);
			backtracking(idx + 1, temp1);
		}

	}

	static void checkans(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (ans < arr[i][j])
					ans = arr[i][j];
			}
		}
	}

	static int[][] move(int dir, int[][] arr) {
		int[][] vis = new int[N][N];
		int[][] temp = new int[N][N];
		for (int q = 0; q < N; q++) {
			temp[q] = arr[q].clone();
		}
		switch (dir) {
		case 0: // 왼쪽으로 밀기
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < N; j++) {
					if (temp[i][j] == 0)
						continue;
					int nrow = i + dx[dir], ncol = j + dy[dir];
					while (temp[nrow][ncol] == 0 && ncol > 0) {
						nrow += dx[dir];
						ncol += dy[dir];
					}
					if (temp[i][j] == temp[nrow][ncol] && vis[nrow][ncol] == 0) {
						temp[i][j] = 0;
						temp[nrow][ncol] *= 2;
						vis[nrow][ncol] = 1;
					} else if (temp[i][j] != temp[nrow][ncol] && temp[nrow][ncol] == 0) {
						temp[nrow][ncol] = temp[i][j];
						temp[i][j] = 0;
					} else if (temp[i][j] != temp[nrow][ncol] && temp[nrow][ncol] != 0) {
						temp[nrow - dx[dir]][ncol - dy[dir]] = temp[i][j];
						if (ncol - dy[dir] != j)
							temp[i][j] = 0;
					} else if (temp[i][j] == temp[nrow][ncol] && vis[nrow][ncol] == 1) {
						temp[nrow - dx[dir]][ncol - dy[dir]] = temp[i][j];
						if (ncol - dy[dir] != j)
							temp[i][j] = 0;
					}
				}
			}
			break;
		case 1: // 오른쪽으로 밀기
			for (int i = 0; i < N; i++) {
				for (int j = N - 2; j >= 0; j--) {
					if (temp[i][j] == 0)
						continue;
					int nrow = i + dx[dir], ncol = j + dy[dir];
					while (temp[nrow][ncol] == 0 && ncol < N - 1) {
						nrow += dx[dir];
						ncol += dy[dir];
					}
					if (temp[i][j] == temp[nrow][ncol] && vis[nrow][ncol] == 0) {
						temp[i][j] = 0;
						temp[nrow][ncol] *= 2;
						vis[nrow][ncol] = 1;
					} else if (temp[i][j] != temp[nrow][ncol] && temp[nrow][ncol] == 0) {
						temp[nrow][ncol] = temp[i][j];
						temp[i][j] = 0;
					} else if (temp[i][j] != temp[nrow][ncol] && temp[nrow][ncol] != 0) {
						temp[nrow - dx[dir]][ncol - dy[dir]] = temp[i][j];
						if (ncol - dy[dir] != j)
							temp[i][j] = 0;
					} else if (temp[i][j] == temp[nrow][ncol] && vis[nrow][ncol] == 1) {
						temp[nrow - dx[dir]][ncol - dy[dir]] = temp[i][j];
						if (ncol - dy[dir] != j)
							temp[i][j] = 0;
					}
				}
			}
			break;
		case 2: // 아래로 밀기
			for (int i = N - 2; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					if (temp[i][j] == 0)
						continue;
					int nrow = i + dx[dir], ncol = j + dy[dir];
					while (temp[nrow][ncol] == 0 && nrow < N - 1) {
						nrow += dx[dir];
						ncol += dy[dir];
					}
					if (temp[i][j] == temp[nrow][ncol] && vis[nrow][ncol] == 0) {
						temp[i][j] = 0;
						temp[nrow][ncol] *= 2;
						vis[nrow][ncol] = 1;
					} else if (temp[i][j] != temp[nrow][ncol] && temp[nrow][ncol] == 0) {
						temp[nrow][ncol] = temp[i][j];
						temp[i][j] = 0;
					} else if (temp[i][j] != temp[nrow][ncol] && temp[nrow][ncol] != 0) {
						temp[nrow - dx[dir]][ncol - dy[dir]] = temp[i][j];
						if (nrow - dx[dir] != i)
							temp[i][j] = 0;
					} else if (temp[i][j] == temp[nrow][ncol] && vis[nrow][ncol] == 1) {
						temp[nrow - dx[dir]][ncol - dy[dir]] = temp[i][j];
						if (nrow - dx[dir] != i)
							temp[i][j] = 0;
					}
				}
			}
			break;
		case 3: // 위로 밀기
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (temp[i][j] == 0)
						continue;
					int nrow = i + dx[dir], ncol = j + dy[dir];
					while (temp[nrow][ncol] == 0 && nrow > 0) {
						nrow += dx[dir];
						ncol += dy[dir];
					}
					if (temp[i][j] == temp[nrow][ncol] && vis[nrow][ncol] == 0) {
						temp[i][j] = 0;
						temp[nrow][ncol] *= 2;
						vis[nrow][ncol] = 1;
					} else if (temp[i][j] != temp[nrow][ncol] && temp[nrow][ncol] == 0) {
						temp[nrow][ncol] = temp[i][j];
						temp[i][j] = 0;
					} else if (temp[i][j] != temp[nrow][ncol] && temp[nrow][ncol] != 0) {
						temp[nrow - dx[dir]][ncol - dy[dir]] = temp[i][j];
						if (nrow - dx[dir] != i)
							temp[i][j] = 0;
					} else if (temp[i][j] == temp[nrow][ncol] && vis[nrow][ncol] == 1) {
						temp[nrow - dx[dir]][ncol - dy[dir]] = temp[i][j];
						if (nrow - dx[dir] != i)
							temp[i][j] = 0;
					}
				}
			}
			break;
		}
		return temp;
	}

}
