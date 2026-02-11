package Baekjoon;
import java.util.*;
import java.io.*;
public class boj_1368_물대기 {
	static int[][] non;
	static int[] cost;
	static int[] arr;
	static List<Edge> edges;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		non = new int[N+1][N+1];
		cost = new int[N+1];
		arr = new int[N+1];
		edges = new ArrayList<>();
		int ans = 0, nodes = 0;
		Arrays.fill(arr, -1);
		for(int i = 1; i<=N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 1; i<=N; i++) {
			non[0][i] = cost[i];
			non[i][0] = cost[i];
		}
		for(int i = 1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j<=N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				non[i][j] = temp;
			}
		}
		
		for(int i = 0; i<=N; i++) {
			for(int j = i+1; j<=N; j++) {
				edges.add(new Edge(i,j,non[i][j]));
			}
		}
		Collections.sort(edges, (x,y) -> Integer.compare(x.w, y.w));
		for(Edge edge : edges) {
			int x = edge.v1;
			int y = edge.v2;
			int w = edge.w;
			if(find(x) != find(y)) {
				union(x,y);
				ans += w;
				nodes++;
			}
			if(nodes == N) break;
		}
//		for(int i = 0; i<= N; i++) {
//			for(int j = 0; j<=N; j++) {
//				System.out.print(non[i][j]);
//			}
//			System.out.println("");
//		}
		System.out.println(ans);
		
	}
	static int find(int idx) {
		if(arr[idx] < 0) return idx;
		return arr[idx] = find(arr[idx]);
	}
	static boolean union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x == y) return true;
		if(arr[x] > arr[y]) arr[x] = y;
		else if(arr[y] > arr[x]) arr[y] = x;
		else {
			arr[x] = y;
			arr[y]--;
		}
		return false;
	}
	static class Edge{
		int v1;
		int v2;
		int w;
		Edge(int v1, int v2, int w){
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}
	}
	
}
