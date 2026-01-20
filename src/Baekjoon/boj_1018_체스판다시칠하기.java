package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1018_체스판다시칠하기 {
	static char[][] board = new char[51][51];
	static char[][] ans1 = {{'W','B','W','B','W','B','W','B'}, {'B','W','B','W','B','W','B','W'}, {'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'}};
	static char[][] ans2 = {{'B','W','B','W','B','W','B','W'}, {'W','B','W','B','W','B','W','B'}, {'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'},{'B','W','B','W','B','W','B','W'},{'W','B','W','B','W','B','W','B'}};
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int i = 0; i<n; i++) {
			String str = br.readLine();
			for(int j = 0; j<m; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i<n-7; i++) {
			for(int j = 0; j<m-7; j++) {
				int temp1 = 0, temp2 = 0;
				for(int q = i; q<i+8; q++) {
					for(int p = j; p<j+8; p++) {
						if(board[q][p] != ans1[q-i][p-j]) {
							temp1++;
						}
						if(board[q][p] != ans2[q-i][p-j]) {
							temp2++;
						}
					}
				}
				ans = Math.min(ans, Math.min(temp1, temp2));
			}
		}
		System.out.println(ans);
		
		
	}

}
