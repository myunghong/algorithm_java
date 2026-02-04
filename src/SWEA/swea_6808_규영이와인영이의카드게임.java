package SWEA;
import java.util.*;
import java.io.*;
public class swea_6808_규영이와인영이의카드게임 {
	static int[] board = new int[9];
	static int[] vis = new int[9];
	static int[] boarda = new int[9];
	static int[] boardb = new int[9];
	static int win = 0;
	static int lose = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=TC; tc++) {
			win = 0;
			lose = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[19];
			for(int i = 0; i<9; i++) {
				boarda[i] = Integer.parseInt(st.nextToken());
				arr[boarda[i]] = 1;
			}
			int cnt = 0;
			for(int i = 1; i<19; i++) {
				
				if(arr[i] == 0) {
					boardb[cnt] = i;
					cnt++;
				}
			}
			foo(0);
			
			sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
		}
		
		
		System.out.println(sb);
		
	}
	
	
	static void foo(int a) {
		int wina = 0;
		int winb = 0;
		if(a == 9) {
			for(int i = 0; i<9; i++) {
				for(int j = 0; j<9; j++) {
					if(board[i] > boardb[j]) wina++;
					else if(board[i] < boardb[j]) winb++;
				}
			}
			if(wina > winb) lose++;
			else if(wina < winb) win++;
			return;
		}
		
		for(int i = a; i<9; i++) {
			if(vis[i] == 1) continue;
			board[a] = boarda[i];
			vis[i] = 1;
			foo(a+1);
			vis[i] = 0;
		}
		
		return;
		
		
	}
	
	
	
	
	
}
