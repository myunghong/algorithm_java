import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        List<Integer> arrlist = new ArrayList<>();
        if(stations[0] - w  - 1> 0) {
            arrlist.add(stations[0] - w - 1);
        }
        for(int i = 1; i<stations.length; i++) {
            int temp = stations[i] - stations[i-1] - 2*w - 1;
            if(temp > 0) arrlist.add(temp);
        }
        if(n - stations[stations.length - 1] - w> 0) {
            arrlist.add(n - stations[stations.length - 1] - w);
        }
        // System.out.println(arrlist);
        int temp = 2 * w + 1;
        for(int x : arrlist) {
            answer += x / temp;
            if(x % temp != 0) answer++;
        }
        return answer;
    }
}