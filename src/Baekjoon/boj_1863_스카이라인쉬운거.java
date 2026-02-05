package Baekjoon;
import java.util.*;
import java.io.*;
public class boj_1863_스카이라인쉬운거 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n+1][2];
		int ans = 0;
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			board[i][0] = Integer.parseInt(st.nextToken());
			board[i][1] = Integer.parseInt(st.nextToken());
		}
		board[n][0] = 1000001;
		Arrays.sort(board, (r1, r2) -> Integer.compare(r1[0], r2[0]));
		for(int i = 0; i<=n; i++) {
			System.out.println(board[i][0] + " " + board[i][1]);
		}
		for(int i = 1; i<=n; i++) {
			if(board[i - 1][1] > board[i][1]) ans++;
		}
		
		System.out.println(ans);
		
		
	}

}
