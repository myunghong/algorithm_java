package Baekjoon;
import java.util.*;
import java.io.*;
public class boj_1780_종이의개수 {
	static int[][] board;
	static int[] ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		ans = new int[3];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recur(0,0,N);
		
		System.out.println(ans[0]);
		System.out.println(ans[1]);
		System.out.println(ans[2]);
	}
	static void recur(int row, int col, int size) {
		if(isTear(row, col, size) || size == 1) {
			ans[board[row][col]+1]++;
			return;
		}
		int resize = size / 3;
		recur(row,col,resize);
		recur(row + resize, col, resize);
		recur(row+resize+resize, col, resize);
		recur(row,col+resize,resize);
		recur(row + resize, col+resize, resize);
		recur(row+resize+resize, col+resize, resize);
		recur(row,col+resize+resize,resize);
		recur(row + resize, col+resize+resize, resize);
		recur(row+resize+resize, col+resize+resize, resize);
		
	}
	
	
	static boolean isTear(int row, int col, int size) {
		int temp = board[row][col];
		for(int i = row; i<row+size; i++) {
			for(int j = col; j<col+size; j++) {
				if(temp != board[i][j]) return false;
			}
		}
		return true;
	}
}
