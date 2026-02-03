package Baekjoon;
import java.util.*;
import java.io.*;
public class boj_1260_DFS와BFS {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		Deque<Integer> Q = new ArrayDeque<>();
		Deque<Integer> stk = new ArrayDeque<>();
		List<Integer>[] gr = new ArrayList[N+1];
		StringBuilder Qsb = new StringBuilder();
		StringBuilder stksb = new StringBuilder();
		for(int i = 1; i<=N; i++) {
			gr[i] = new ArrayList<>();
		}
		for(int i = 1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			gr[x].add(y);
			gr[y].add(x);
		}
		for(int i = 1; i<=N; i++) {
			gr[i].sort(null);
		}
		
		

		int[]stkvis = new int[N+1];
		stk.push(start);
//		stkvis[start] = 1;
		while (!stk.isEmpty()) {
		    int cur = stk.pop();
		    if (stkvis[cur] != 0) continue;
		    stkvis[cur] = 1;
		    stksb.append(cur).append(' ');

		    for (int i = gr[cur].size() - 1; i >= 0; i--) {
		        int nxt = gr[cur].get(i);
		        if (stkvis[nxt] ==0) stk.push(nxt);
		    }
		}
		System.out.println(stksb);
		
		int[]Qvis = new int[N+1];
		Q.offer(start); 
		Qvis[start] = 1;
		Qsb.append(start).append(" ");
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			for(int i = 0; i<gr[cur].size(); i++) {
				if(Qvis[gr[cur].get(i)] != 0) continue;
				Q.offer(gr[cur].get(i));
				Qvis[gr[cur].get(i)] = 1;
				Qsb.append(gr[cur].get(i)).append(" ");
			}
		}
		
		System.out.println(Qsb);
	}

}
