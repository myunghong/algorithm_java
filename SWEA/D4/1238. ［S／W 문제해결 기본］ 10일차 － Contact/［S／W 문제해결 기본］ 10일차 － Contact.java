import java.io.*;
import java.util.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            Queue<Integer> Q = new ArrayDeque<>();
            List<Integer>[] board = new ArrayList[101];
            for(int i = 0; i<101; i++){
                board[i] = new ArrayList<>();
            }
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int[] vis = new int[101];
            int len = Integer.parseInt(st.nextToken());
            int startnode = Integer.parseInt(st.nextToken());
           	st = new StringTokenizer(br.readLine());
            for(int i = 0; i<len / 2; i++) {
            	int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                board[start].add(end);
            }
            Q.offer(startnode);
            vis[startnode] = 1;
            int maxnode = 0;
            while(!Q.isEmpty()){
                int size = Q.size();
                maxnode = 0;
            	for(int j = 0; j<size; j++){
                    int next = Q.poll();
                    maxnode = Math.max(maxnode, next);
                	for(int i = 0; i<board[next].size(); i++){
                		if(vis[board[next].get(i)] != 0) continue;
                    	Q.offer(board[next].get(i));
                    	vis[board[next].get(i)] = 1;
               		}
                }
                
            }
            
            answer = maxnode;
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        
        System.out.print(sb);
        
	}
}

