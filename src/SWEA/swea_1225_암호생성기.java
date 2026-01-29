package SWEA;

import java.util.*;
import java.io.*;

public class swea_1225_암호생성기{

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			sb.append("#").append(Integer.parseInt(st.nextToken())).append(" ");

			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int cycle = 1;
			Deque<Integer> queue = new ArrayDeque<>();
			for(int i = 0; i<8; i++) {
				queue.offer(Integer.parseInt(st1.nextToken()));
			}
			while(queue.peekLast() > 0) {
				int val = queue.poll();
				queue.offer(val - cycle < 0 ? 0 : val - cycle );
				cycle = cycle%5 + 1;
			}
			
			
			while(!queue.isEmpty()) {
				sb.append(queue.poll()).append(' ');
			}
			sb.append('\n');
		}
		
		
		System.out.println(sb);
	}

}
