import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
        int min = 10000001;
        for(int i = 0; i<scoville.length; i++){
            PQ.offer(scoville[i]);
            min = Math.min(min, scoville[i]);
        }
        while(min < K) {
            if(PQ.size() == 1) return -1;
            answer++;
            int temp = PQ.poll();
            int temp1 = PQ.poll();
            PQ.offer(temp + temp1 * 2);
            min = PQ.poll();
            PQ.offer(min);
        }
        return answer;
    }
}