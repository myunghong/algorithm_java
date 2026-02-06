package SWEA;
import java.util.*;
import java.io.*;

public class swea_8275_햄스터 {
	static int N, X;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 햄스터 우리의 수 N
			X = Integer.parseInt(st.nextToken()); // 우리에 있는 햄스터 수는 X마리 이하
			int M = Integer.parseInt(st.nextToken()); // 기록의 수는 M개
			for(int i = 0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken()); // l번 우리 (우리 시작 번호)
				int r = Integer.parseInt(st.nextToken()); // r번 우리 (우리 끝 번호)
				int s = Integer.parseInt(st.nextToken()); // 햄스터 마리 수 (s마리)
			}
			
			
		}
		
		System.out.println(sb);
	}
}
