package SWEA;
import java.util.*;
import java.io.*;

public class swea_1249_보급로 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		int[] dx = {0,1};
		int[] dy = {1,0};
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] board = new int[N][N];
			int[][] score = new int[N][N];
			for(int i = 0; i<N; i++) {
				Arrays.fill(score[i], Integer.MAX_VALUE - 100);
			}
			int[][] vis = new int[N][N];
			Deque<Integer> queue = new ArrayDeque<>();
			for(int i = 0; i<N; i++) {
				String str = br.readLine();
				for(int j = 0; j<N; j++) {
					board[i][j] = str.charAt(j) - '0';
					
				}
			}
			queue.offer(0);
			vis[0][0] = 1;
			while(!queue.isEmpty()) {
				int now = queue.poll();
				int x = now / N;
				int y = now % N;
				for(int i = 0; i<2; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if(vis[nx][ny] != 0) continue;
					queue.offer(nx * N + ny);
					score[nx][ny] = Math.min(score[nx][ny], score[x][y]+board[nx][ny]);
					
//					vis[nx][ny] = 1;
					
					
				}
			
			
			
			}
			
			
			
			
			
			
			
			
			
			
			
			sb.append("#").append(tc).append(" ").append(score[N-1][N-1]);
		}
		
		
		
		System.out.println(sb);
	}

}
