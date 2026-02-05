package SWEA;
import java.io.*;
import java.util.*;

public class swea_2115_벌꿀채취 {
	static int N, M, C;
	static int[][] board, score;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 벌통의 크기
			M = Integer.parseInt(st.nextToken()); // 가로로 선택하는 벌통 개수
			C = Integer.parseInt(st.nextToken()); // 최대로 채취 가능한 꿀의 양
			board = new int[N][N];
			score = new int[N-M+1][N-M+1];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N - M+1; j++) {
					if(cal(i,j) > C) {
						
					}
					else {
						score[i][j] = powcal(i,j);
					}
				}
			}
			
			
			
		}

	}
	static int cal(int row, int col) {
		int sum = 0;
		for(int i = 0; i<M; i++) {
			sum += board[row][col + i];
		}
		return sum;
	}
	static int powcal(int row, int col) {
		int sum = 0;
		for(int i = 0; i<M; i++) {
			sum += board[row][col + i] * board[row][col + i];
		}
		return sum;
	}
	static int twoPointer(int row, int col) {
		int[] temp = new int[M];
		for(int i = 0; i<M; i++) {
			temp[i] = board[row][col + i];
		}
		Arrays.sort(temp);
		int st = 0, en = M-1;
		while( st < en) {
			
		}
	}
}
