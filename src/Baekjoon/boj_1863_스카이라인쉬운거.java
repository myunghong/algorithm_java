package Baekjoon;
import java.util.*;
import java.io.*;
public class boj_1863_스카이라인쉬운거 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		Deque<Integer>stk = new ArrayDeque<>();
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			while(!stk.isEmpty()  && y < stk.peek()) {
				if(stk.poll() != 0) {
					ans++;
				}
			}
			
			
			
			if(stk.isEmpty() || stk.peek() < y) {
				stk.push(y);
			}
			
		}
		while(!stk.isEmpty()) {
			if(stk.poll() != 0) ans++;
		}
		System.out.println(ans);
		
		
	}

}
