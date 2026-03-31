import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] board= new int[5001];
		Long[] ans = new Long[N];
		Long[] ans1 = new Long[5001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			board[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.fill(ans, 1l);
		Arrays.fill(ans1, 0l);
		for(int i = 1; i<N; i++) {
			for(int j = 0; j<i; j++) {
				if(board[i] > board[j]) ans[i] += ans[j];
				ans[i] = ans[i] % 998244353;
			}
		}
		
//		for(int i = 0; i<N; i++) {
//			ans1[board[i]] = ans[i];
//		}
		for(int i = 0 ;i<N; i++) {
//			if(ans1[board[i]] != 0) {				
				System.out.print(ans[i] + " ");
//			}
		}
	}
}
