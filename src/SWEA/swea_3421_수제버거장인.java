package SWEA;
import java.io.*;
import java.util.*;
public class swea_3421_수제버거장인 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int ans = 0;
			int[] bitcheck = new int[N+1];
			for(int i = 0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				bitcheck[a] |= 1 << b-1;
				bitcheck[b] |= 1 << a-1;
			}
			for(int i = 1; i<= N; i++) {
				for(int j = 1; j<=N; j++) {
					if((bitcheck[i] & i) != 0) ans++;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}

}
