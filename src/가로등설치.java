import java.util.*;
import java.io.*;
public class 가로등설치{
	static Light[] lights;
	static PriorityQueue<Light> lightPQ;
	static int num, N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Q = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int garbage = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); // 거리의 크기
		lights = new Light[100001];	// 삭제된 가로등을 확인하기 위한 버전관리
		int M = Integer.parseInt(st.nextToken()); // 초기 가로등 개수
		lightPQ = new PriorityQueue<>();
		int[] arr = new int[M];
		for(int i = 0; i<M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left, right, coord, dis, ver; // 초기화 부분
		lights[0] = new Light(0, -1, 1, 1, 0, 0);
		for(int i = 0; i<M; i++) {
			num = i+1;
			if(i == 0) {
				left = 1;
				right = arr[i+1];
			}
			else if(i == M-1) {
				left = arr[i-1];
				right = N;
			}
			else {
				left = arr[i-1];
				right = arr[i+1];
			}
			coord = arr[i];
			dis = right - left;
			ver = 0;
			Light light = new Light(num, num-1, num+1, coord, dis, ver);
			lightPQ.add(light);
			lights[num] = light;
		}
//		System.out.println(lightPQ);
		for(int i = 1; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			if(type == 200) {
				addLight();
			}
			else if(type == 300) {
				removeLight(Integer.parseInt(st.nextToken()));
			}
			else if(type == 400) {
				System.out.println(checkAns());
			}
		}
	}
	static void addLight() {
		// 기존꺼를 poll할때 버전 check 필요
		Light light = lightPQ.peek();
		while(light.ver == -1) {
			light = lightPQ.poll();
		}
		num++;
		int prev = light.prev;
		int next = light.num;
		int coord = (lights[prev].coord + light.coord + 1) / 2;
		light.dis = light.coord - coord;
		light = new Light(num, prev, next, coord, coord - lights[prev].coord, 0);
		
		
	}
	static void removeLight(int D) {
		Light light = lights[D];
		light.ver = -1;
		int temp = light.next;
		if(D == 0) {
			
		}
		else if(temp == num) {
			
		} // coord가 1인 가로등과 N인 가로등을 추가해야함. 맨 앞 가로등과 맨 끝 가로등 처리 어캐해야할까? 5 위치에 가로등이 있으면 전력은 1~5를 모두 비춰야하니 4의 전력이 필요하고 그럼 8 출력해야하는거 아닌
		lights[temp].ver = -1;
		light = new Light(lights[light.next].num, light.prev, lights[light.next].next, lights[light.next].coord, lights[light.next].coord - lights[light.prev].coord, 0);
		lights[temp] = light;
		lightPQ.add(light);
	}
	static int checkAns() {
		while(lightPQ.peek().ver == -1) {
			lightPQ.poll();
		}
		return lightPQ.peek().dis;
	}
	static class Light implements Comparable<Light>{
		int num;
		int prev;
		int next;
		int coord;
		int dis;
		int ver;
		Light(int num, int prev, int next, int coord, int dis, int ver) {
			this.num = num;
			this.prev = prev;
			this.next = next;
			this.coord = coord;
			this.dis = dis;
			this.ver = ver;
		}
		@Override
		public int compareTo(Light o){
			if(o.dis == this.dis) {
				return this.coord - o.coord;
			}
			return o.dis - this.dis;
		}
//		@Override
//		public String toString() {
//			return "num:" + num + " left:" + left + " right:" + right + " dis:" + dis;
//		}
	}
}