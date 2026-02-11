package A형기출;

import java.util.*;
import java.io.*;

public class boj_다리만들기2 {
	static int[][] board;
	static int N, M;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] weight;
	static List<Edge> edges = new ArrayList<>();
	static int[] arr;

	static class Edge {
		int v1;
		int v2;
		int w;

		Edge(int v1, int v2, int w) {
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		int[][] vis = new int[N][M];
		int nodecnt = 0, ans = 0;
		Deque<Integer> Q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0 || vis[i][j] != 0)
					continue;
				vis[i][j] = 1;
				Q.offer(i * M + j);
				cnt++;
				board[i][j] = cnt;
				while (!Q.isEmpty()) {
					int x = Q.poll();
					int y = x % M;
					x = x / M;
					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if (nx < 0 || nx >= N || ny < 0 || ny >= M)
							continue;
						if (vis[nx][ny] == 1)
							continue;
						if (board[nx][ny] == 0)
							continue;
						vis[nx][ny] = 1;
						Q.offer(nx * M + ny);
						board[nx][ny] = cnt;
					}
				}
			}
		}
		weight = new int[cnt + 1][cnt + 1];
		arr = new int[cnt + 1];
		Arrays.fill(arr, -1);
		for (int i = 0; i <= cnt; i++) {

			Arrays.fill(weight[i], 100);
		}
		
//		for(int i = 0; i<N; i++) {
//			for(int j = 0; j<M; j++) {
//				System.out.print(board[i][j] + " ");
//			}
//			System.out.println("");
//		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0)
					continue;
				int temp = board[i][j];
				cal(temp, i, j);
			}
		}
		for (int i = 1; i <= cnt; i++) {
			for (int j = i + 1; j <= cnt; j++) {
				if(weight[i][j] != 100)edges.add(new Edge(i, j, weight[i][j]));
			}
		}
		int flag = 0;
		Collections.sort(edges, (x, y) -> Integer.compare(x.w, y.w));
		for (Edge edge : edges) {

			if(find(edge.v1) != find(edge.v2)) {
				
				union(edge.v1, edge.v2);
				nodecnt++;
				ans += edge.w;
			}

			if (nodecnt == cnt - 1) {
				flag = 1;
				break;
			}
		}
		if (flag == 0)
			ans = -1;
//		for(int i = 1; i<=cnt; i++) {
//			for(int j = 1; j<=cnt; j++) {
//				System.out.print(weight[i][j] + "\t");
//			}
//			System.out.println("");
//		}
		
		System.out.println(ans);
	}

	static void cal(int v, int row, int col) {
		for (int i = 0; i < 4; i++) {
			int cnt = 0;
			int x = row;
			int y = col;

			x += dx[i];
			y += dy[i];
			if (x < 0 || x >= N || y < 0 || y >= M)
				continue;
			if(board[x][y] == v) continue;
			cnt++;
			while (board[x][y] == 0) {
				x += dx[i];
				y += dy[i];
				
				if (x < 0 || x >= N || y < 0 || y >= M) break;
				if(board[x][y] != 0) break;
				cnt++;
			}
			if (x < 0 || x >= N || y < 0 || y >= M) continue;
			if (board[x][y] != v && cnt >= 2) {
				weight[v][board[x][y]] = Math.min(weight[v][board[x][y]], cnt);
				weight[board[x][y]][v] = Math.min(weight[board[x][y]][v], cnt);

			}
		}
	}

	static int find(int idx) {
		if (arr[idx] < 0)
			return idx;
		return arr[idx] = find(arr[idx]);
	}

	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		if (x == y)
			return;

		if (arr[x] > arr[y])
			arr[x] = y;
		else if (arr[x] < arr[y])
			arr[y] = x;
		else {
			arr[x] = y;
			arr[y]--;
		}
		return;
	}

}
