package A형기출;

import java.util.*;
import java.io.*;

public class 사과먹기게임 {
	static int[][] board;
	static int dir, ans;
	static List<Apple> apples;
	static int[][] dirandcoord = {{0,1,2,3},
									{3,0,1,2},
									{2,3,0,1},
									{1,2,3,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			ans = 1;
			dir = 0;
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			apples = new ArrayList<>();
			board = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] != 0)
						apples.add(new Apple(board[i][j], i, j, 0));
				}
			}
			
			
			Collections.sort(apples, (x, y) -> Integer.compare(x.num, y.num));
			
			
			for (int i = 1; i < apples.size(); i++) {
				if(apples.get(i-1).row - apples.get(i).row > 0 && apples.get(i-1).col - apples.get(i).col > 0) {
					apples.get(i).coord = 1;
				}
				else if(apples.get(i-1).row - apples.get(i).row > 0 && apples.get(i-1).col - apples.get(i).col < 0) {
					apples.get(i).coord = 0;
				}
				else if(apples.get(i-1).row - apples.get(i).row < 0 && apples.get(i-1).col - apples.get(i).col > 0) {
					apples.get(i).coord = 2;
				}
				else if(apples.get(i-1).row - apples.get(i).row < 0 && apples.get(i-1).col - apples.get(i).col < 0) {
					apples.get(i).coord = 3;
				}
			}
			
			for(int i = 1; i<apples.size(); i++) {
				turn(dirandcoord[apples.get(i).coord][dir]);
			}
			
			sb.append(ans).append("\n");
		}
		
		
		
		System.out.println(sb);
	}

	static void turn(int turn) {
		switch (turn) {
		case 0:
			ans += 3;
			dir = (dir + 1)%4;
			break;
		case 1:
			ans += 3;
			dir = (dir + 1) % 4;
			break;
			
		case 2:
			ans += 1;
			dir = (dir + 3) % 4;
			break;
		case 3:
			ans += 2;
			dir = (dir + 2) % 4;
			break;
		default:
			break;
		}
	}
	
	static class Apple {
		int num;
		int row;
		int col;
		int coord;

		Apple(int num, int row, int col, int coord) {
			this.num = num;
			this.row = row;
			this.col = col;
			this.coord = coord;
		}
	}
}
