package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_14510_나무높이 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc<TC; tc++) {
			int max = 0;
			int ans = 0;
			int[] board = new int[101];
			int[] tree = new int[4];
			sb.append('#').append(tc).append(' ');
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				board[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, board[i]);
			}
			
			for(int i = 0; i<n; i++) {
				int temp = Math.abs(board[i] - max);
				if(temp >= 3) {
					int k = temp / 3;
					tree[1] += k;
					tree[2] += k;
					
					if (temp % 3 == 1) {
						tree[1]--;
						tree[2]++;
					} else if (temp % 3 == 2) {
						tree[2]++;
					}
					
				} else if (temp == 1) {
					tree[1]++;
				} else if (temp == 2) {
					tree[2]++;
				}
			
			
			}
			
		
				if(tree[1] == tree[2]) {
					ans = 2 * tree[1];
				} else if(tree[1] > tree[2]) {
					tree[1] -= tree[2];
					int temp = tree[1];
					ans = 2 * tree[2];
					ans += 2*temp - 1;
				} else if(tree[1] < tree[2]) {
					tree[2] -= tree[1];
					 int temp = tree[2];
					 ans = 2 * tree[1];
					 ans += (temp+1) + ((temp-1)/3);
				}
				
				
			
			
			
			sb.append(ans).append('\n');
			System.out.println(sb);
		}
		
	}

}
