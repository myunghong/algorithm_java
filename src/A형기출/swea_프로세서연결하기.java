package A형기출;

import java.util.*;
import java.io.*;

public class swea_프로세서연결하기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			int[][] board = new int[N][N];
			
			StringTokenizer st;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			
		}
		
		System.out.println(sb);
	
	}
	

}
/**
최대한 많은 전원을 연결하고 전선의 길이는 최소가 된다
최대한 많은 전원을 연결하기 위해 N이 작으니까 완전탐색을 돌건데 각 core에서 어떻게 해야할까?
상하좌우 탐색을 하는데 상하좌우 가능한 곳을 확인하고 가능하면 가능한 루트의 값을 다 1로 바꾸고 다음것을 호출하고 ..

**/