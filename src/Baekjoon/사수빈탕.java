package Baekjoon;

import java.util.*;
import java.io.*;

public class 사수빈탕 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); //사탕의 개수
		int[][] board = new int[301][301];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			board[a][b] = 1;
		}

		for(int i = 1; i<301; i++) {
			if(board[i][0] == 1 && M - i >= 0) {
				board[i][0] = M - i + board[i-1][0];
			}
			else {
				board[i][0] = board[i-1][0];
			}
			if(board[0][i] == 1 && M - i >= 0) {
				board[0][i] = M - i + board[0][i-1];
			}
			else {
				board[0][i] = board[0][i-1];
			}
		}
		
		for(int i = 1; i<301; i++) {
			for(int j = 1; j<301; j++) {
				if(board[i][j] == 1 && M - i - j >= 0) {
					board[i][j] = Math.max(board[i-1][j] + M -i - j,  board[i][j-1] + M - i -j);
				}
				else {
					board[i][j] = Math.max(board[i-1][j] , board[i][j-1]);
				}
			}
		}
		System.out.println(board[300][300]);
		
	}
}
