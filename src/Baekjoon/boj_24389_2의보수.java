package Baekjoon;
import java.io.*;
import java.util.*;

public class boj_24389_2의보수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 1;
		while(n % 2 == 0) {
			cnt++;
			n = n / 2;
		}
		System.out.println(32 - cnt);
	}
}
