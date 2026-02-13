package A형기출;
import java.util.*;
import java.io.*;
public class boj_게리맨더링 {
	static List<Integer>[] con;
	static int[] select, vis;
	static int N, ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		con = new ArrayList[N+1];
		select = new int[N+1];
		vis = new int[N+1];
		
		for(int i = 0; i<=N; i++) {
			con[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i<=N; i++) {
			con[i].add(Integer.parseInt(st.nextToken()));
		}
		
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			for(int j = 0; j< temp; j++) {
				con[i].add(Integer.parseInt(st.nextToken()));
			}
			
		}

		dfs(1);
		if(ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);

	}
	
	static void dfs(int idx) {
		if(idx == N+1) {
			check();
			return;
		}
		select[idx] = 1;
		dfs(idx+1);
		
		select[idx] = 0;
		dfs(idx + 1);
	}
	
	
	static void check() {
		int a = 0, b = 0, suma = 0, sumb = 0;
		for(int i = 1; i<= N; i++) {
			if(select[i] == 0) {
				suma += con[i].get(0);
				a++;
			}
			else{
				sumb += con[i].get(0);
				b++;
			}
		}
//		System.out.println("suma"+ suma);
//		System.out.println("sumb" + sumb);
		if(a == 0 || b == 0) return;
		if(!isFamily(0)) return;
		if(!isFamily(1)) return;
		if(Math.abs(suma - sumb) < ans) {
			ans = Math.abs(suma - sumb);
		}
	}
	
	
	
	static boolean isFamily(int idx) {
		int need = 0, parent = 0;
		for(int i = 1; i<=N; i++) {
			if(select[i] == idx) {
				need++;
				parent = i;
			}
		}
		Deque<Integer> Q = new ArrayDeque<>();
		int cnt = 1;
		vis = new int[N +1];
		Q.offer(parent);
		vis[parent] = 1;
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(int i = 1; i<con[cur].size(); i++) {
				if(vis[con[cur].get(i)] != 0) continue;
				if(select[con[cur].get(i)] != idx) continue;
				Q.offer(con[cur].get(i));
				vis[con[cur].get(i)] = 1;
				cnt++;
//				System.out.println(con[cur].get(i));
			}
			if(cnt == need) {
				Q.clear();
				return true;
			}
		}
		
		return false;
	}
}
