package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5643_키순서 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int TC;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		for (int tc = 1; tc < TC+1; tc++) {
			
			sb.append('#').append(tc).append(' ');
			
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			boolean[][] board = new boolean[n + 1][n + 1];
			
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int q = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				board[q][p] = true;
			}
			
			for(int i = 1; i<=n; i++) {
				for(int j = 1; j<=n; j++) {
					if(!board[j][i]) continue;
					for(int k = 1; k<=n; k++) {
						if(board[i][k]) board[j][k] = true;
					}
				}
			}
			int ans = 0;
			for (int i = 1; i <= n; i++) {
                int tall = 0, small = 0;
                for (int j = 1; j <= n; j++) {
                    if (board[i][j]) tall++;
                    if (board[j][i]) small++;
                }
                if (tall + small == n - 1) ans++;
            }
			
			sb.append(ans).append('\n');
			
		}
		System.out.println(sb);
	}

}
