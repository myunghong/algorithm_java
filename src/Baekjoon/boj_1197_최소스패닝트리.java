package Baekjoon;
import java.util.*;
import java.io.*;
public class boj_1197_최소스패닝트리 {
	static int[] arr;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Edge[] edges = new Edge[E];
		int ans = 0;
		arr = new int[V+1];
		Arrays.fill(arr, -1);
		int nodes = 0;
		for(int i = 0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a,b,c);
		}
		Arrays.sort(edges, (x,y) -> Integer.compare(x.w, y.w));
		for(int i = 0; i<E; i++) {
			int a = edges[i].v1;
			int b = edges[i].v2;
			int c = edges[i].w;
			if(find(a) != find(b)) {
				union(a,b);
				ans += c;
				nodes++;
			}
			if(nodes == V-1) break;
		}
		
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
		else if(arr[y] < arr[x]) arr[y] = x;
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
