package Baekjoon;
import java.util.*;
import java.io.*;
public class boj_2110_공유기설치 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int C = Integer.parseInt(st1.nextToken());
		int[] board = new int[N];
		for(int i = 0; i<N; i++) {
			board[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(board);
		int[] distance = new int[N-1];
		for(int i = 0; i<N-1; i++) {
			distance[i] = board[i+1] - board[i];
		}
		int st = 0, ans = 0;
		int en = board[N-1];
		while(st <= en) {
			int mid = (st + en) / 2; //정답 후보
			int cnt = 1;
			int temp = 0;
			for(int i = 0; i<N-1; i++) {
				temp += board[i+1] - board[i];
				if(temp >= mid) {
					temp = 0;
					cnt++;
				}
			}
			if(cnt >= C) {
				ans = Math.max(mid, ans);
				st = mid + 1;
			}
			else {
				en = mid - 1;
			}
		}
		//board = 1, 2, 4, 8, 9
		//distance = 1, 2, 4, 1
		System.out.println(ans);
	}
}
