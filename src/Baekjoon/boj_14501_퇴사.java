package Baekjoon;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
public class boj_14501_퇴사 {
	static int[] day = new int[16];
	static int[] money = new int[16];
	static int ans = 0;
	static int[] result = new int[16];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(tc + n > TC) {
				day[tc] = -1;
				money[tc] = -1;
				continue;
			}
			day[tc] = n;
			
			money[tc] = m;
		}
		
		for(int i = TC-1; i>=0; i--) {
			int temp = 0;
			if(day[i] == -1) {
				continue;
			} else {
				for(int j = i + day[i]; j<TC; j++) {
					temp = Math.max(temp, money[j]);
							
				}
				money[i] += temp;
			}
			
			
			
		}
		for(int i = 0; i<TC; i++) {
			
			ans = Math.max(ans,money[i]);
		}
		
		System.out.println(ans);
		return;
	}
}
