package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_11559_PuyoPuyo {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static Deque<int[]> queue = new ArrayDeque<>();
	static Deque<int[]> pang = new ArrayDeque<>();
	static char[][] board = new char[12][6];
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			board[11 - i][0] = str.charAt(0);
			board[11 - i][1] = str.charAt(1);
			board[11 - i][2] = str.charAt(2);
			board[11 - i][3] = str.charAt(3);
			board[11 - i][4] = str.charAt(4);
			board[11 - i][5] = str.charAt(5);
		}
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (board[i][j] == '.')
						continue; // 비어있는 공간은 패스
					char cha = board[i][j]; // 이번에 만난 뿌요 종류 저장 (bfs에서 동일한거 찾기용)
					boolean[][] visited = new boolean[12][6];
					int num = 1; // 동일한 뿌요 몇개인가요?
					queue.addLast(new int[] { i, j });
					pang.addLast(new int[] { i, j });
					visited[i][j] = true;
					while (!queue.isEmpty()) {
						int[] temp = queue.pollFirst();
						for (int k = 0; k < 4; k++) {
							int nx = dx[k] + temp[0];
							int ny = dy[k] + temp[1];
							if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6)
								continue;
							if (visited[nx][ny])
								continue;
							if (board[nx][ny] == cha)
								num++;
							else
								continue;
							queue.addLast(new int[] { nx, ny });
							pang.addLast(new int[] { nx, ny });
							visited[nx][ny] = true;
						}
					}
					if (num >= 4) {
						puyo();
						flag = true;
					} else {
						while (!pang.isEmpty()) {
							int[] temp = pang.pollFirst();
						}
					}

				}
			}
			down();
			if(flag == true) ans++;
		}
		System.out.println(ans);
	}

	static void puyo() {
		while (!pang.isEmpty()) {
			int[] temp = pang.pollFirst();
			board[temp[0]][temp[1]] = '.';
		}
	}

	static void down() {
		for (int i = 0; i < 6; i++) {
			int cnt = 0;
			for (int j = 0; j < 12; j++) {
				if (board[j][i] != '.') {
					board[cnt][i] = board[j][i];
					if (cnt != j)
						board[j][i] = '.';
					cnt++;
				}
			}
			for (int j = cnt; j < 12; j++) {
				board[j][i] = '.';
			}
		}
//		for(int i = 0; i<12; i++) {
//			System.out.println(new String(board[i]));
//		}
	}
}
