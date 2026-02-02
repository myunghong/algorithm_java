package Baekjoon;
import java.util.*;
import java.io.*;
public class boj_11724_연결요소의개수 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] arr = new ArrayList[N+1];
		Deque<Integer> Q = new ArrayDeque<>();
		for(int i = 0; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i = 0; i<M; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st1.nextToken());
			int q = Integer.parseInt(st1.nextToken());
			arr[p].add(q);
			arr[q].add(p);
		}
		int ans = 0;
		int[] vis = new int[N+1];
		
		for(int i = 1; i<=N; i++) {
			
			if(vis[i] !=0) continue;
			Q.offer(i);
			vis[i] = 1;
			ans++;
			while(!Q.isEmpty()) {
				int cur = Q.poll();
				for(int j = 0; j<arr[cur].size(); j++) {
					if(vis[arr[cur].get(j)] != 0) continue;
					Q.offer(arr[cur].get(j));
					vis[arr[cur].get(j)] = 1;
				}
			}
			
			
			
			
			
		}
		System.out.println(ans);
	}

}
