import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        long sum1 = 0l, sum2 = 0l;
        Queue<Integer> que1 = new ArrayDeque<>();
        Queue<Integer> que2 = new ArrayDeque<>();
        for(int i = 0; i<queue1.length; i++){
            sum1 += queue1[i];
            sum2 += queue2[i];
            que1.offer(queue1[i]);
            que2.offer(queue2[i]);
        }
        int cnt = 0;
        int limit = queue1.length * 8;
        while(cnt < limit){
            if(que1.isEmpty()) {
                return -1;
            } else if (que2.isEmpty()) {
                return -1;
            }
            if(sum1 > sum2) {
                sum1 -= que1.peek();
                sum2 += que1.peek();
                que2.offer(que1.poll());
            } else if (sum1 < sum2) {
                sum2 -= que2.peek();
                sum1 += que2.peek();
                que1.offer(que2.poll());
            } else {
                return cnt;
            }
            
            cnt++;
        }
        return answer;
    }
}