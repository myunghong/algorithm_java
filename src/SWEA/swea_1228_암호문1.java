package SWEA;
import java.util.*;
import java.io.*;
public class swea_1228_암호문1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc<11; tc++) {
			List<Integer> arr = new ArrayList<>();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			n = Integer.parseInt(br.readLine());
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int i = 0; i<n; i++) {
				st1.nextToken();
				int idx = Integer.parseInt(st1.nextToken());
				int end = Integer.parseInt(st1.nextToken());
				for(int j = 0; j < end; j++) {
					arr.add(idx + j, Integer.parseInt(st1.nextToken()));
				}
			}
			System.out.print("#" + tc + ' ');
			for(int i = 0; i < 10; i++) {
				System.out.print(arr.get(i) + " ");
			}
			System.out.println("");
		}

	}

}
