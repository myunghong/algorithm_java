package Baekjoon;
import java.util.*;
import java.io.*;
public class boj_카드정렬하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		while(!pq.isEmpty()) {
			int a = pq.poll();
			if(pq.isEmpty()) {
				break;
			}
			int b = pq.poll();
			pq.offer(a+b);
			ans += a+b;
		}
		System.out.println(ans);
	}
}
