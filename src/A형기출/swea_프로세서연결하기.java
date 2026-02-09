package A형기출;

import java.util.*;
import java.io.*;

// 0은 빈칸, 1은 core, -1은 전선
public class swea_프로세서연결하기 {
	static int[][] board;
	static int N, ans, corecnt, maxcorenum, bestans;
	static List<Integer>[] cores; // 각 코어별로 연결한 전선들의 좌표
	static List<Integer> corecoord = new ArrayList<>(); // 프로세서의 좌표

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			corecoord.clear();
			ans = 0;
			corecnt = 0;
			maxcorenum = 0;
			bestans = 200;
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];

			StringTokenizer st;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (i != 0 && j != 0 && i != N - 1 && j != N - 1) {
						if (board[i][j] == 1) {
							corecoord.add(i * N + j);
							corecnt++;
						}

					}
				}
			}
			cores = new ArrayList[corecnt];
			for (int i = 0; i < corecnt; i++) {
				cores[i] = new ArrayList<>();
			}
			dfs(0, 0);
			sb.append("#").append(tc).append(" ").append(bestans).append("\n");
		}

		System.out.println(sb);

	}

	
	
	
	static void dfs(int coreidx, int corenum) {
		if (coreidx == corecoord.size()) {
			if (corenum > maxcorenum || (corenum == maxcorenum && bestans > ans)) {
				maxcorenum = corenum;
				bestans = ans;
			}
			return;
		}
		if(corecnt - coreidx + corenum < maxcorenum) return;
		for (int i = 0; i < 5; i++) {
			int a = setpipe(coreidx, i) ? 1 : 0;
			dfs(coreidx + 1, corenum + a);
			returnPipe(coreidx);
		}

	}

	static boolean setpipe(int idx, int dir) {
		int nrow = corecoord.get(idx) / N, ncol = corecoord.get(idx) % N;
		switch (dir) {
		case 0: // 위쪽으로 전선 연결
			while (nrow > 0) {
				nrow--;
				if (board[nrow][ncol] == 0) {
					board[nrow][ncol] = -1;
					cores[idx].add(nrow * N + ncol);
					ans++;
				} else {
					returnPipe(idx);
					return false;
				}
			}
			break;

		case 1: // 오른쪽으로 전선 연결
			while (ncol < N - 1) {
				ncol++;
				if (board[nrow][ncol] == 0) {
					board[nrow][ncol] = -1;
					cores[idx].add(nrow * N + ncol);
					ans++;
				} else {
					returnPipe(idx);
					return false;
				}
			}
			break;
		case 2: // 아래로 전선 연결
			while (nrow < N - 1) {
				nrow++;
				if (board[nrow][ncol] == 0) {
					board[nrow][ncol] = -1;
					cores[idx].add(nrow * N + ncol);
					ans++;
				} else {
					returnPipe(idx);
					return false;
				}
			}
			break;
		case 3: // 왼쪽으로 전선 연결
			while (ncol > 0) {
				ncol--;
				if (board[nrow][ncol] == 0) {
					board[nrow][ncol] = -1;
					cores[idx].add(nrow * N + ncol);
					ans++;
				} else {
					returnPipe(idx);
					return false;
				}
			}
			break;
		case 4:
			return false;
		}
		return true;
	}

	static void returnPipe(int idx) {
		int sizes = cores[idx].size();
		while (!cores[idx].isEmpty()) {
			int temp = cores[idx].size();
			int index = cores[idx].remove(temp - 1);
			board[index / N][index % N] = 0;
		}
		ans -= sizes;
		return;
	}

}
/*
 * 최대한 많은 전원을 연결하고 전선의 길이는 최소가 된다 최대한 많은 전원을 연결하기 위해 N이 작으니까 완전탐색을 돌건데 각 core에서
 * 어떻게 해야할까? 상하좌우 탐색을 하는데 상하좌우 가능한 곳을 확인하고 가능하면 가능한 루트의 값을 다 1로 바꾸고 다음것을 호출하고 ..
 * 
 */