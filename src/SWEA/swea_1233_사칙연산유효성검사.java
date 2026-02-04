package SWEA;
import java.util.*;
import java.io.*;
public class swea_1233_사칙연산유효성검사 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int TC = 1; TC<=10; TC++) {
			int N = Integer.parseInt(br.readLine());
			int flag = 1;
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				char a = st.nextToken().charAt(0);
				if(num >=N - N/2) {
					if(a >= '0' && a <= '9') continue;
					else flag = 0;
				}
				else {
					if(a >= '0' && a <= '9') flag = 0;
				}
				
				
			}
			sb.append("#").append(TC).append(" ").append(flag).append("\n");
		}
		System.out.println(sb);

	}

}