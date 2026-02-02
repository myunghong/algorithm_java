package SWEA;
import java.util.*;
import java.io.*;

public class swea_1226_미로1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		for(int tc = 1; tc <= 10; tc++) {
			Deque<Integer> Q = new ArrayDeque<>();
			br.readLine();
			int[][] board = new int[16][16];
			int ans = 0;
			boolean[][] vis = new boolean[16][16];
			for(int i = 0; i<16; i++) {
				String str = br.readLine();
				for(int j = 0; j<16; j++) {
					board[i][j] = str.charAt(j) - '0';
					if(board[i][j] == 2) {
						Q.offer(i * 16 + j);
						vis[i][j] = true;
					}
					else if(board[i][j] == 1) {
						vis[i][j] = true;
					}
				}
			}
			while(!Q.isEmpty()) {
				int num = Q.poll();
				int x = num / 16;
				int y = num % 16;
				for(int i = 0; i<4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(nx < 0 || nx >= 16 || ny < 0 || ny >= 16) continue;
					if(vis[nx][ny]) continue;
					vis[nx][ny] = true;
					if(board[nx][ny] == 3) ans = 1;
					Q.offer(nx * 16 + ny);
				}
				if(ans == 1) break;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		
		}
		System.out.println(sb);
	}
}
