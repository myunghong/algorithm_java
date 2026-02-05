package SWEA;

import java.util.*;
import java.io.*;

public class swea_4130_특이한자석_노재귀 {

	static Deque<Integer>[] magnets = new ArrayDeque[4];
	static int[] check = new int[4];
	static int[][] arr = new int[4][8];
	static int right0 = 2, right1 = 2, right2 = 2, left1 = 6, left2 = 6, left3 = 6;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int ans = 0;
			right0 = 2; right1 = 2; right2 = 2; left1 = 6; left2 = 6; left3 = 6;
			for (int i = 0; i < 4; i++) {
				magnets[i] = new ArrayDeque<>();
			}
			sb.append("#").append(tc).append(" ");
			int K = Integer.parseInt(br.readLine());
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					int temp = Integer.parseInt(st.nextToken());
					magnets[i].offer(temp);
					arr[i][j] = temp;
				}
			}

			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				checkRotation(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
			}

			if (magnets[0].getFirst() == 1)
				ans += 1;
			if (magnets[1].getFirst() == 1)
				ans += 2;
			if (magnets[2].getFirst() == 1)
				ans += 4;
			if (magnets[3].getFirst() == 1)
				ans += 8;
			sb.append(ans).append("\n");

		}
		System.out.println(sb);

	}

	static void checkRotation(int idx, int rotate) {

		if (idx == 0) {
			if (arr[0][right0] != arr[1][left1]) {
				if (arr[1][right1] != arr[2][left2]) {
					if (arr[2][right2] != arr[3][left3]) {
						Rotation(3, rotate * -1);
					}
					Rotation(2, rotate);
				}
				Rotation(1, rotate * -1);
			}
			Rotation(idx, rotate);
		} else if (idx == 1) {
			if (arr[0][right0] != arr[1][left1]) {
				Rotation(0, rotate * -1);
			}
			if (arr[1][right1] != arr[2][left2]) {
				if (arr[2][right2] != arr[3][left3]) {
					Rotation(3, rotate);
				}
				Rotation(2, rotate * -1);
			}
			Rotation(idx, rotate);
		} else if (idx == 2) {
			if (arr[1][right1] != arr[2][left2]) {
				if (arr[0][right0] != arr[1][left1]) {
					Rotation(0, rotate);
				}
				Rotation(1, rotate * -1);
			}
			if (arr[2][right2] != arr[3][left3]) {
				Rotation(3, rotate * -1);
			}
			Rotation(idx, rotate);

		} else if (idx == 3) {
			if (arr[2][right2] != arr[3][left3]) {
				if (arr[1][right1] != arr[2][left2]) {
					if (arr[0][right0] != arr[1][left1]) {
						Rotation(0, rotate * -1);
					}
					Rotation(1, rotate);
				}
				Rotation(2, rotate * -1);
			}
			Rotation(idx, rotate);
		}

	}

	static void Rotation(int idx, int rotate) {
		if (rotate == 1) {
			magnets[idx].offerFirst(magnets[idx].pollLast());
			if (idx == 0)
				right0 = (right0 + 7) % 8;
			else if (idx == 1) {
				right1 = (right1 + 7) % 8;
				left1 = (left1 + 7) % 8;
			} else if (idx == 2) {
				right2 = (right2 + 7) % 8;
				left2 = (left2 + 7) % 8;
			} else if (idx == 3) {
				left3 = (left3 + 7) % 8;
			}

		} else {
			magnets[idx].offerLast(magnets[idx].pollFirst());
			if (idx == 0)
				right0 = (right0 + 1) % 8;
			else if (idx == 1) {
				right1 = (right1 + 1) % 8;
				left1 = (left1 + 1) % 8;
			} else if (idx == 2) {
				right2 = (right2 + 1) % 8;
				left2 = (left2 + 1) % 8;
			} else if (idx == 3) {
				left3 = (left3 + 1) % 8;
			}

		}
	}

}
