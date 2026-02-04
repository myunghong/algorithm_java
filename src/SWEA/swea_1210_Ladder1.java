package SWEA;

import java.util.*;
import java.io.*;

public class swea_1210_Ladder1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		int[][] board = new int[100][100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int TC = 1; TC <= 10; TC++) {
			br.readLine();
			int ans = 0;

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < 100; i++) {
				if (board[0][i] == 0) {
					continue;
				}
				boolean[][] vis = new boolean[100][100];
				int depth = 0, x = i;
				while(depth < 100) {
					if(x == 0) {
						if(board[depth][x+1] == 1 && !vis[depth][x+1]) {
							vis[depth][x] = true;
							x++;
						}
						else depth++;
					}
					else if(x == 99) {
						if(board[depth][x-1] == 1 && !vis[depth][x-1]) {
							vis[depth][x] = true;
							x--;
						}
						else depth++;
					}
					else {
						if(board[depth][x +1] == 1 && !vis[depth][x+1]) {
							vis[depth][x] = true;
							x++;
						}
						else if(board[depth][x-1] == 1 && !vis[depth][x-1]) {
							vis[depth][x] = true;
							x--;
						}
						else depth++;
					}
				}
				if(board[depth - 1][x] == 2) {
					ans = i;
					break;
				}
			}

			sb.append("#").append(TC).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);
	}

}
