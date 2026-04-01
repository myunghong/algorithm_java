import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		int[]dx = {0,0,-1,1}, dy = {-1,1,0,0};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> ordering = new ArrayList<>();
		int[][]board = new int[N+1][N+1];
		HashSet<Integer>[][] score = new HashSet[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				score[i][j] = new HashSet<>();
			}
		}
		List<Integer>[] friends = new ArrayList[N*N + 1];
		for(int i = 1; i<= N * N; i++) {
			friends[i] = new ArrayList<>();
		}
		StringTokenizer st;
		for(int i = 0; i<N*N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			friends[idx].add(Integer.parseInt(st.nextToken()));
			friends[idx].add(Integer.parseInt(st.nextToken()));
			friends[idx].add(Integer.parseInt(st.nextToken()));
			friends[idx].add(Integer.parseInt(st.nextToken()));
			ordering.add(idx);
		}
		int cnt = 0, x = 2, y = 2;
		board[x][y] = ordering.get(cnt);
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx <= 0 || nx > N || ny > N || ny <= 0) continue;
			score[nx][ny].add(ordering.get(cnt));
		}
		cnt++;
		int ans = 0;
		while(cnt < N * N) {
			
			int nxt = ordering.get(cnt);
			int maxscore = 0;
			int maxplace = -1;
			int flag = 0;
			
			
			for(int i = 1; i<= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(board[i][j] != 0) continue;
					int tmpscore = 0;
					int tmpplace = 0;
					for(int k = 0; k < 4; k++) {
						int cur = friends[nxt].get(k);
						if(score[i][j].contains(cur)) {
							tmpscore++;
						}
					}
					for(int q = 0; q<4; q++) {
						int nx = i + dx[q];
						int ny = j + dy[q];
						if(nx <= 0 || nx > N || ny > N || ny <= 0) continue;
						if(board[nx][ny] == 0) {
							tmpplace++;
						}
					}
					
					if(tmpscore >= maxscore) {
						if(tmpscore > maxscore) {
							x = i;
							y = j;
							maxscore = tmpscore;
							maxplace = tmpplace;
							
						}
						else if(tmpplace > maxplace) {
							x = i;
							y = j;
							maxplace = tmpplace;
						}

					}
					
				}
			}
			
//			if(maxscore == 0 && maxplace == 0) {
//				int tempplace1 = 0;
//				for(int i = 1; i<=N; i++) {
//					for(int j = 1; j<=N; j++) {
//						int tempplace2 = 0;
//						for(int q = 0; q<4; q++) {
//							int nx = i + dx[q];
//							int ny = j + dy[q];
//							if(nx <= 0 || nx > N || ny > N || ny <= 0) continue;
//							if(board[nx][ny] == 0) {
//								tempplace2++;
//							}
//						}
//						
//						if(tempplace2 > tempplace1)
//						
//					}
//				}
//			}
			board[x][y] = nxt;
			for(int i = 0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx <= 0 || nx > N || ny > N || ny <= 0) continue;
				score[nx][ny].add(nxt);
			}
			
			
//			for(int i = 1; i<=N; i++) {
//				System.out.println(Arrays.toString(board[i]));
//			}
//			System.out.println();
			
			cnt++;
		}
		
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				int temp = 0;
//				if(board[i][j] == 0) continue;
				for(int k = 0; k<4; k++) {
					int cur = friends[board[i][j]].get(k);
					if(score[i][j].contains(cur)) temp++;
				}
				
				
				if(temp == 1) ans += 1;
				else if(temp == 2) ans += 10;
				else if(temp == 3) ans += 100;
				else if(temp == 4) ans += 1000;
			}
		}
		System.out.println(ans);
		
//		for(int i = 1; i<=N; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
//		for(int i = 1; i<=N; i++) {
//			for(int j = 1; j<=N; j++) {
//				System.out.println(score[i][j]);
//			}
//		}
		
	}
}

