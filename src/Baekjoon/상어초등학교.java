package Baekjoon;

import java.util.*;
import java.io.*;

public class 상어초등학교 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> ordering = new ArrayList<>();
		int[][]board = new int[N+1][N+1];
		List<Integer>[] friends = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			friends[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for(int i = 0; i<N*N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			friends[idx].add(Integer.parseInt(st.nextToken()));
			friends[idx].add(Integer.parseInt(st.nextToken()));
			friends[idx].add(Integer.parseInt(st.nextToken()));
			friends[idx].add(Integer.parseInt(st.nextToken()));
			ordering.add(idx);
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				
			}
		}
		
		
		
	}
}

