package Baekjoon;
import java.util.*;
import java.io.*;
public class boj_1717_집합의표현 {
	static int[] arr;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		Arrays.fill(arr, -1);
		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 0) union(b,c);
			else if(a == 1) {
				if(find(b) == find(c)) System.out.println("YES");
				else System.out.println("NO");
			}
		}

	}
	static int find(int idx) {
		if(arr[idx] < 0) return idx;
		return arr[idx] = find(arr[idx]);
	}
	static boolean union(int idxa, int idxb) {
		int a = find(idxa);
		int b = find(idxb);
		if(a == b) return true;
		if(arr[a] > arr[b]) {
			arr[a] = b;
		}
		else if(arr[a] < arr[b]) {
			arr[b] = a;
		}
		else {
			arr[a] = b;
			arr[b]--;
		}
		return false;
	}

}
