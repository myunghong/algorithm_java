package Baekjoon;

import java.util.*;
import java.io.*;

public class boj_18808_스티커붙이기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		List<int[][]> papers = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] temp = new int[n][m];
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					temp[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			papers.add(temp);
		}
		for (int[][] temp : papers) {
			int n = temp.length;
			int m = temp[0].length;
			int startrow = 0, startcol = 0;
			boolean attach1 = false, attach2 = false, attach3 = false, attach4 = false;
			// 회전하지 않은 경우
			outer2: for (int p = 0; p <= N - n; p++) {
				for (int q = 0; q <= M - m; q++) {
					attach1 = true;
					outer1: for (int i = 0; i < n; i++) {
						for (int j = 0; j < m; j++) {
							if (board[p + i][q + j] == 1 && temp[i][j] == 1) {
								attach1 = false;
								break outer1;
							}
						}
					}
					if (attach1) {
						startrow = p;
						startcol = q;
						break outer2;
					}
				}
			}

			// 90도 회전 N = 5, M = 4, n = 2, m = 5
			if (!attach1) {
				outer2: for (int p = 0; p <= N-m; p++) {
					for (int q = 0; q <= M - n; q++) {
						attach2 = true;
						outer1: for (int i = 0; i < n; i++) {
							for (int j = 0; j < m; j++) {
								if (board[p + j][q + i] == 1 && temp[n-i-1][j] == 1) {
									attach2 = false;
									break outer1;
								}
							}
						}
						if (attach2) {
							startrow = p;
							startcol = q;
							break outer2;
						}
					}
				}
			}

			// 180도 회전 N = 5, M = 4, n = 2, m = 3
			if (!attach1 && !attach2) {
				outer2: for (int p = 0; p <= N - n; p++) {
					for (int q = 0; q <= M - m; q++) {
						attach3 = true;
						outer1: for (int i = 0; i < n; i++) {
							for (int j = 0; j < m; j++) {
								if (board[p + i][q + j] == 1 && temp[n-i-1][m-j-1] == 1) {
									attach3 = false;
									break outer1;
								}
							}
						}
						if (attach3) {
							startrow = p;
							startcol = q;
							break outer2;
						}
					}
				}
			}
			// 270도 회전 N = 5, M = 4, n = 2, m = 5
			if (!attach1 && !attach2 && !attach3) {
				outer2: for (int p = 0; p <= N - m; p++) {
					for (int q = 0; q <= M - n; q++) {
						attach4 = true;
						outer1: for (int i = 0; i < n; i++) {
							for (int j = 0; j < m; j++) {
								if (board[p + j][q + i] == 1 && temp[i][m-j-1] == 1) {
									attach4 = false;
									break outer1;
								}
							}
						}
						if (attach4) {
							startrow = p;
							startcol = q;
							break outer2;
						}
					}
				}
			}

//			System.out.println("n: " + n + "m: " + m);
			if (attach1) {
//				System.out.println("n: " + n + "m: " + m + " 그대로");
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if(board[startrow + i][startcol + j] == 0 && temp[i][j] == 1) board[startrow + i][startcol + j] = temp[i][j];
//						System.out.println(i + " " + j + " " + temp[i][j]);
					}
				}
			} else if (attach2) {
//				System.out.println("n: " + n + "m: " + m + " 90도");
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if(board[startrow + j][startcol + i] == 0 && temp[n-i-1][j] == 1) board[startrow + j][startcol + i] = temp[n-i-1][j];
//						System.out.println(i + " " + j + " " + temp[i][j]);
					}
				}
			} else if (attach3) {

//				System.out.println("n: " + n + "m: " + m + " 180도");
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if(board[startrow + i][startcol + j] == 0 && temp[n-i-1][m-j-1] == 1) board[startrow + i][startcol + j] = temp[n-i-1][m-j-1];
//						System.out.println(i + " " + j + " " + temp[i][j]);
					}
				}
			} else if (attach4) {
//				System.out.println("n: " + n + "m: " + m + " 270도");
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						if(board[startrow + j][startcol + i] == 0 && temp[i][m-j-1] == 1) board[startrow + j][startcol + i] = temp[i][m-j-1];
//						System.out.println(i + " " + j + " " + temp[i][j]);
					}
				}
			}
//			for(int i = 0; i<N; i++) {
//				for(int j = 0; j<M; j++) {
//					System.out.print(board[i][j]);
//				}
//				System.out.println("");
//			}
//			System.out.println("");
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1)
					ans++;
			}
		}
		System.out.println(ans);
	}
}
