package SWEA;
import java.io.*;
import java.util.*;

public class swea_1289_원재의메모리복구하기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			sb.append("#").append(tc).append(" ");
			char base = '0';
			String str = br.readLine();
			int cnt = 0;
			if(str.charAt(0) != base) cnt++;
			for(int i = 1; i<str.length(); i++) {
				if(str.charAt(i) != str.charAt(i-1)) cnt++;
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

}
