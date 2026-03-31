package Baekjoon;

import java.util.*;
import java.io.*;

public class 증가하는부분수열의개수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] board= new int[N];
		int[] ans = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			board[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(ans, 1);
		for(int i = 1; i<N; i++) {
			for(int j = 0; j<i; j++) {
				if(board[i] > board[j]) ans[i] += ans[j];
				ans[i] = ans[i] % 998244353;
			}
		}
		
		for(int i = 0 ;i<N; i++) {			
			System.out.print(ans[i] + " ");
		}
	}
}
