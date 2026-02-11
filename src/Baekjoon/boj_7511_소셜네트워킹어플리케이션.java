package Baekjoon;
import java.util.*;
import java.io.*;
public class boj_7511_소셜네트워킹어플리케이션 {
	static int[] arr;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			sb.append("Scenario ").append(tc).append(":").append("\n");
			int n = Integer.parseInt(br.readLine());
			int k = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			Arrays.fill(arr, -1);
			for(int i = 0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a,b);
				
				
			}
			int m = Integer.parseInt(br.readLine());
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(find(a) == find(b)) sb.append("1\n");
				else sb.append("0\n");
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static int find(int idx) {
		if(arr[idx] < 0) return idx;
		return arr[idx] = find(arr[idx]);
	}
	static boolean union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if(x == y) return true;
		if(arr[x] > arr[y]) {
			arr[x] = y;
		}
		else if(arr[x] < arr[y]) {
			arr[y] = x;
		}
		else {
			arr[x] = y;
			arr[y]--;
		}
		return false;
	}
}
