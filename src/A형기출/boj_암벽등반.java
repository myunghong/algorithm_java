package A형기출;
import java.util.*;
import java.io.*;
public class boj_암벽등반 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		int[] xs = new int[n+1];
		int[] ys = new int[n+1];
		Deque<coord> Q = new ArrayDeque<>();
		int ans = 0;
		List<Integer>[] ylist = new ArrayList[goal+1];
		
		for(int i = 1; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x  = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			xs[i] = x;
			ys [i] = y;
			ylist[y].add(x);
		}
		ylist[0].add(0);
		Q.offer(new coord(0,0));
		while(!Q.isEmpty()) {
			coord temp = Q.poll();
			int x = temp.x;
			int y = temp.y;
			for(int i = y-2; i<=y+2; i++) {
				if(i < 0 || i > n) continue;
				
			}
		}
		
		System.out.println(ans);
	}
	
	
	
	static class coord{
		int x;
		int y;
		coord(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
