package Baekjoon;
import java.util.*;
import java.io.*;
public class boj_11286_절대값힙 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minpq = new PriorityQueue<>(); // 양수
		PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder()); //음수
		for(int i = 0; i<N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp < 0) maxpq.offer(temp);
			else if (temp > 0)minpq.offer(temp);
			if(temp == 0) {
				if(maxpq.isEmpty() && minpq.isEmpty()) {
					System.out.println("0");
				}
				else if(maxpq.isEmpty() && !minpq.isEmpty()) {
					System.out.println(minpq.poll());
				}
				else if(!maxpq.isEmpty() && minpq.isEmpty()) {
					System.out.println(maxpq.poll());
				}
				else {
					
					int a = Math.abs(maxpq.peek());
					int b = Math.abs(minpq.peek());
					if(a == b) System.out.println(maxpq.poll());
					else if(a > b) System.out.println(minpq.poll());
					else if(a < b) System.out.println(maxpq.poll());
				}
				
			}
		}
	}

}
