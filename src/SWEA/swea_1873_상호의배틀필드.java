package SWEA;

import java.util.*;
import java.io.*;

public class swea_1873_상호의배틀필드 {
	static int row, col, H, W;
	static char[][] board;
	static char dir;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			row = 0;
			col = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			board = new char[H][W];
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					board[i][j] = str.charAt(j);
					if (board[i][j] == '^') {
						row = i;
						col = j;
						dir = 'u';
						
					}
					if (board[i][j] == 'v') {
						row = i;
						col = j;
						dir = 'd';
					}
					if (board[i][j] == '<') {
						row = i;
						col = j;
						dir = 'l';
					}
					if (board[i][j] == '>') {
						row = i;
						col = j;
						dir = 'r';
					}
				}
			}
			int N = Integer.parseInt(br.readLine());

			String str = br.readLine();

			for (int i = 0; i < N; i++) {
				char a = str.charAt(i);
//				for (int p = 0; p < H; p++) {
//					for (int q = 0; q < W; q++) {
//						sb.append(board[p][q]);
//					}
//					sb.append("\n");
//				}
				if (a == 'U') {
					up();
				} else if (a == 'D') {
					down();
				} else if (a == 'L') {
					left();
				} else if (a == 'R') {
					right();
				} else if (a == 'S') {
					shoot();
				}

			}
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	static void up() {
		if (row - 1 >= 0 && board[row - 1][col] == '.') {
			board[row - 1][col] = '^';
			board[row][col] = '.';
			row--;
		} else {
			board[row][col] = '^';
		}
		dir = 'u';
	}

	static void down() {
		if (row + 1 < H && board[row + 1][col] == '.') {
			board[row + 1][col] = 'v';
			board[row][col] = '.';
			row++;
		} else {
			board[row][col] = 'v';
		}
		dir = 'd';
	}

	static void left() {
		if (col - 1 >= 0 && board[row][col - 1] == '.') {
			board[row][col - 1] = '<';
			board[row][col] = '.';
			col--;
		} else {
			board[row][col] = '<';
		}
		dir = 'l';
	}

	static void right() {
		if (col + 1 < W && board[row][col + 1] == '.') {
			board[row][col + 1] = '>';
			board[row][col] = '.';
			col++;
		} else {
			board[row][col] = '>';
		}
		dir = 'r';
	}

	static void shoot() {
		int crow = row, ccol = col;
		if (dir == 'u') {
			while (crow > 0) {
				crow--;
				char at = board[crow][col];
				if (at == '*') {
					board[crow][col] = '.';
					break;
				} else if (at == '#') {
					break;
				}
			}
		} else if (dir == 'd') {
			while (crow < H - 1) {
				crow++;
				char at = board[crow][col];
				if (at == '*') {
					board[crow][col] = '.';
					break;
				} else if (at == '#') {
					break;
				}
			}
		} else if (dir == 'l') {
			while (ccol > 0) {
				ccol--;
				char at = board[row][ccol];
				if (at == '*') {
					board[row][ccol] = '.';
					break;
				} else if (at == '#') {
					break;
				}
			}
		} else if (dir == 'r') {
			while (ccol < W - 1) {
				ccol++;
				char at = board[row][ccol];
				if (at == '*') {
					board[row][ccol] = '.';
					break;
				} else if (at == '#') {
					break;
				}
			}
		}
	}

}
