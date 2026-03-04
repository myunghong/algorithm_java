package Baekjoon;
import java.util.*;
import java.io.*;
public class boj_1992_쿼드트리 {
	static int[][] board;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		for(int i = 0; i<N; i++) {
			String str = br.readLine();
			for(int j = 0; j<N; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}
		recursion(0,0,N);
		System.out.println(sb);
	}
	static void recursion(int row, int col, int size) {
		if(size == 1 || isFull(row, col, size)) {
			sb.append(board[row][col]);
			return;
		}
		sb.append("(");
		int resize = size / 2;
		recursion(row, col, resize);
		recursion(row,col+resize,resize);
		recursion(row+resize, col, resize);
		recursion(row+resize, col+resize, resize);
		sb.append(")");
	}
	
	
	
	static boolean isFull(int row, int col, int size) {
		int mono = board[row][col];
		for(int i = row; i<row+size; i++) {
			for(int j = col; j<col+size; j++) {
				if(mono != board[i][j]) return false;
			}
		}
		return true;
	}
}
