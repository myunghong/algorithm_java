package SWEA;
import java.util.*;
import java.io.*;
public class swea_2806_NQueen {

	static int[] vis;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			vis = new int[N];
			for(int i = 0; i<N; i++) {
				queen(0, i);
			}
		}
		System.out.println(sb);
	}
	
	static void queen(int row, int col) {
		
	}

}
