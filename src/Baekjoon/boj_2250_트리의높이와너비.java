package Baekjoon;
import java.io.*;
import java.util.*;
public class boj_2250_트리의높이와너비 {

	static int[][] check;
	static int[] tree;
	static int idx = 1;
	static int N;
	static Deque<Integer> stk = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int ans = 0, level = 0;
		tree = new int[N+1];
		check = new int[N+1][2];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			check[idx][0] = Integer.parseInt(st.nextToken());
			check[idx][1] = Integer.parseInt(st.nextToken());
		}

		inorder(1);
		
		for(int i = 1; i<=N; i++) {
			int idxa, idxb;
			for(int j = 1; j <= N; j++) {
//				if(check[i][0]
			}
		}
		
		for(int i = 1; i<=N; i++) {
			System.out.print(tree[i] + " ");
		}
		
	}
	
	
	static void inorder(int cur) {
		int prev = -1;
		if(idx == N) return;
		if(check[cur][0] == -1) { // 왼쪽 자식이 없음
			tree[idx++] = cur;
			if(check[cur][1] == -1) {
				return;
			}
			else {
				cur = check[cur][1];
				inorder(cur);
			}
		}
		
		else { // 왼쪽 자식이 존재함 -> cur을 왼쪽 자식으로 변경한 후 왼쪽 자식에서 inorder 다시 시작
			prev = cur;
			cur = check[cur][0];
			inorder(cur);
			
			tree[idx++] = prev; // 본인 왼쪽의 inorder가 끝나면 본인을 tree에 넣고 오른쪽 자식이 존재하나 확인
			
			if(check[prev][1] == -1) {
				return;
			}
			else {
				prev = check[prev][1];
				inorder(prev);
			}
			
		}
		return;
	}

}
