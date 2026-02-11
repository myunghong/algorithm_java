package SWEA;
import java.io.*;
import java.util.*;
public class swea_5648_원자소멸시뮬레이션 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc = 1; tc<= TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] board = new int[4000][4000];
			int[] dx = {0,0,-2,2};
			int[] dy = {2,-2,0,0};
			wonja[] wons = new wonja[N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				wons[i] = new wonja(Integer.parseInt(st.nextToken()) * 2, Integer.parseInt(st.nextToken()) * 2, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			for(wonja won : wons) {
				int nx = won.x + dx[won.dir];
				int ny = won.y + dy[won.dir];
				
			}
			
			
			
		}
		System.out.println(sb);
	}
	
	
	static class move{
		int wonnum;
		int time;
		int weight;
		move(int wonnum, int time, int weight){
			this.wonnum = wonnum;
			this.time = time;
			this.weight = weight;
		}
	}
	static class wonja{
		int x;
		int y;
		int dir;
		int energy;
		wonja(int x, int y, int dir, int energy){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.energy = energy;
		}
	}
}
