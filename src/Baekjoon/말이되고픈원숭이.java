package Baekjoon;
import java.util.*;
import java.io.*;

public class 말이되고픈원숭이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dx = {0,0,-1,1}, dy = {-1,1,0,0};
		int[] jumpx = {1,1,-1,-1,2,2,-2,-2}, jumpy = {2,-2,2,-2,1,-1,1,-1};
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] board = new int[H][W];
		int[][][] vis = new int[H][W][K+1];
		for(int i = 0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j<W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Deque<Integer> Q = new ArrayDeque<>();
		Q.offer(0);
		vis[0][0][0] = 1;
		int cnt = 0;
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			int row = cur / W;
			int col = cur % W;
			
		}
	}
}
