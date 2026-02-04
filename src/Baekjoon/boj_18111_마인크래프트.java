package Baekjoon;
import java.util.*;
import java.io.*;
public class boj_18111_마인크래프트 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int maxheight = 0;
		int minheight = 256;
		int[][] board = new int[N][M];
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				maxheight = Math.max(maxheight, board[i][j]);
				minheight = Math.min(minheight, board[i][j]);
			}
		}
		int time = Integer.MAX_VALUE;
		int ans = 0;
		for(int k = minheight; k <= maxheight; k++) {
			int inven = B;
			int cnt = 0;
			boolean flag = true;
			
			
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					if(board[i][j] > k) {
						inven += board[i][j] - k;
					}
				}
			}
			
			
			
			for(int i = 0; i<N; i++) {
				for(int j = 0 ;j < M; j++) {
					if(board[i][j] > k) {
						cnt += (board[i][j] - k) * 2;
					}
					else if(board[i][j] < k) {
						if(inven < k - board[i][j]) {
							flag = false;
							continue;
						}
						else {
							cnt += k - board[i][j];
							inven -= k - board[i][j];
						}
					}
					
				}
			}
			
			if(flag && time >= cnt) {
				ans = k;
				time = cnt;
			}
			
			
			
		}
		System.out.println(time + " " + ans);
		
		
		
		
		
	}

}
