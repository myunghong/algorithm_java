package SWEA;
import java.util.*;
import java.io.*;

public class swea_1861_정사각형방 {
	static int[][] board;
	static int[][] vis;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			int[] dx = {0,0,-1,1};
			int[] dy = {-1,1,0,0};
			Deque<Integer> Q = new ArrayDeque<>();
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int ans = 0, maxvis = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					vis = new int[N][N];
					Q.offer(i * N + j);
					vis[i][j] = 1;
					while(!Q.isEmpty()) {
						int temp = Q.poll();
						int x = temp / N;
						int y = temp % N;
						for(int k = 0; k < 4; k++) {
							int nx = x + dx[k];
							int ny = y + dy[k];
							if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
							if(vis[nx][ny] != 0)continue;
							if(board[x][y] - board[nx][ny] != -1) continue;
							vis[nx][ny] = vis[x][y] + 1;
							Q.offer(nx * N + ny);
							if(vis[nx][ny] > maxvis) {
								maxvis = vis[nx][ny];
								ans = board[i][j];
							}
						}
						
					}
						
				}
			}
			
			
			sb.append(ans).append(" ").append(maxvis).append("\n");
		}
		System.out.println(sb);
	}	

}
