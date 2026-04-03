import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
		int[][][] board = new int[21][21][21];
		for(int i = 0; i<21; i++) {
			for(int j = 0; j<21; j++) {
				board[0][i][j] = 1;
				board[i][0][j] = 1;
				board[i][j][0] = 1;
			}
		}
		for(int i = 1; i<21; i++) {
			for(int j = 1; j<21; j++) {
				for(int k = 1; k<21; k++) {
					if(i < j && j < k) {
						board[i][j][k] = board[i][j][k-1] + board[i][j-1][k-1] - board[i][j-1][k];
					}
					else {
						board[i][j][k] = board[i-1][j][k] + board[i-1][j-1][k] + board[i-1][j][k-1] - board[i-1][j-1][k-1];
					}
				}
			}
		}
		
		while(a != -1 || b != -1 || c != -1) {
			
			if(a <= 0 || b <= 0 || c <= 0) {
				sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append("1").append("\n");
			}
			else if(a > 20 || b > 20 || c > 20) {
				sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(board[20][20][20]).append("\n");
			}
			else if(a < b && b < c) {
				sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(board[a][b][c - 1] + board[a][b - 1][c - 1] - board[a][b - 1][c]).append("\n");
			}
			else {
				sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(board[a-1][b][c] + board[a-1][b-1][c] + board[a-1][b][c-1] - board[a-1][b-1][c-1]).append("\n");
			}
			
			
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}
		
		
		System.out.println(sb);
	}
	
	
}
