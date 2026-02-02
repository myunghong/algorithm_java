package SWEA;

import java.util.*;
import java.io.*;

public class swea_3499_퍼펙트셔플 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCase; tc++) {
			int cardNum = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Deque<String> upQue = new ArrayDeque<>();

			Deque<String> downQue = new ArrayDeque<>();
			for (int i = 0; i < cardNum; i++) {
				if (cardNum % 2 == 0) {
					if (i < cardNum / 2) {
						upQue.offer(st.nextToken());
					} else {
						downQue.offer(st.nextToken());
					}
				} else {
					if (i <= cardNum / 2) {
						upQue.offer(st.nextToken());
					} else {
						downQue.offer(st.nextToken());
					}
				}
			}

			sb.append("#").append(tc).append(" ");
			while (!upQue.isEmpty() || !downQue.isEmpty()) {

				if (!upQue.isEmpty())
					sb.append(upQue.poll()).append(' ');
				if (!downQue.isEmpty())
					sb.append(downQue.poll()).append(' ');

			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
