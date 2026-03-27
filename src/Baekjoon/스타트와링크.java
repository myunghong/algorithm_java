package Baekjoon;
import java.util.*;
import java.io.*;
public class 스타트와링크 {
	static int[][] board;
	static int[] cnt, arr;
	static int ans, N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		ans = 10000000;
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = new int[N * (N-1) / 2];
		int idx = 0;
		for(int i = 0; i<N-1; i++) {
			for(int j = i+1; j<N; j++) {
				cnt[idx++] = board[i][j] + board[j][i];
			}
		}
			
		arr = new int[N * (N-1) / 2];
//		for(int i = 0; i<N * (N-1) / 2; i++) {
//			System.out.println(cnt[i] + " ");
//		}
		dfs(0);
		System.out.println(ans);
	}
	static void dfs(int idx) {
		if(idx == N * (N-1) / 2) {
			check();
			return;
		}
		dfs(idx + 1);
		arr[idx] = 1;
		dfs(idx + 1);
		
	}
	
	
	static void check() {
		int a = 0, b = 0;
		for(int i = 0; i<N*(N-1) / 2; i++) {
			if(arr[i] == 1) a += cnt[i];
			else b += cnt[i];
		}
		if(Math.abs(a - b) < ans) ans = Math.abs(a - b);
	}
	
}
