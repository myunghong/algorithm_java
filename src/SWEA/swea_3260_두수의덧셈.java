package SWEA;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class swea_3260_두수의덧셈 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			BigInteger a = new BigInteger(st.nextToken());

			BigInteger b = new BigInteger(st.nextToken());
			a = a.add(b);
			
			
			
			
			
			
			
			sb.append("#").append(tc).append(" ").append(a).append('\n');
		}
		System.out.println(sb);
	}

}
