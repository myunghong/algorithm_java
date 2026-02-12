package SWEA;
import java.util.*;
import java.io.*;

public class swea_2382_미생물격리 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 배열 크기
			int M = Integer.parseInt(st.nextToken()); // M시간 후
			int K = Integer.parseInt(st.nextToken()); // 군집 수
			sangmul[][] board = new sangmul[N][N];
			for(int i = 0; i<K; i++	) {
				st = new StringTokenizer(br.readLine());
				board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = new sangmul(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
		}

	}
	static class sangmul{
		int amount;
		int dir;
		sangmul(int amount, int dir){
			this.amount = amount;
			this.dir = dir;
		}
	}
}
