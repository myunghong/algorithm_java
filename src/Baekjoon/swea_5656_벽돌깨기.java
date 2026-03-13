package Baekjoon;
import java.util.*;
import java.io.*;
public class swea_5656_벽돌깨기 {
	static int[][] board;
	static int[] dx = {0,0,-1,1}, dy = {-1,1,0,0};
	static int N, W, H, ans = 0;
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			board = new int[H][W];
			for(int i = 0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					ans += board[i][j];
				}
			}
			
			dfs(0,board);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	static void dfs(int cnt, int[][] temp) {
		if(cnt == N) {
			ans = Math.min(ans, checkans(temp));
			return;
		}
		
		for(int i = 0; i<W; i++) {
			int[][] temp1 = choicebomb(i, temp);
			dfs(cnt+1, temp1);
		}
		return;
		
	}
	
	static int checkans(int[][] temp) {
		int cnt = 0;
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				if(temp[i][j] != 0) cnt++;
			}
		}
		return cnt;
	}
	
	static int[][] choicebomb(int col, int[][] temp) {
		int[][] temp1 = new int[H][W];
		for(int i = 0; i<H; i++) {
			for(int j = 0; j<W; j++) {
				temp1[i][j] = temp[i][j];
			}
		}
		int row = 0;
		while(temp1[row][col] == 0) {
			row++;
			if(row >= H -1) break;
		}
		if(temp1[row][col] != 0) bomb(row, col, temp1[row][col], temp1);
		
		getdown(temp1);
		
		return temp1;
	}
	
	
	static void bomb(int row, int col, int power, int[][] temp) {
		temp[row][col] = 0;
		for(int i = 0; i<4; i++) {
			int nrow = row;
			int ncol = col;
			if(nrow >= H || nrow < 0 || ncol >= W || ncol < 0) continue;
			for(int j = 0; j<power-1; j++) {
				nrow += dx[i];
				ncol += dy[i];
				if(nrow >= H || nrow < 0 || ncol >= W || ncol < 0) break;
				if(temp[nrow][ncol] == 0) continue;
				else bomb(nrow,ncol,temp[nrow][ncol], temp);
				temp[nrow][ncol] = 0;
			}
		}
	}
	
	static void getdown(int[][] temp) {
		for(int i = 0; i<W; i++) {
			for(int j = H-1; j> 0; j--) {
				if(temp[j][i] == 0) {
					int cnt = j - 1;
					while(cnt > 0) {
						if(temp[cnt][i] != 0) break;
						cnt--;
					}
					if(cnt == 0 && temp[cnt][i] ==0) continue;
					temp[j][i] = temp[cnt][i];
					temp[cnt][i] = 0;
				}
			}
		}
	}
	
}
