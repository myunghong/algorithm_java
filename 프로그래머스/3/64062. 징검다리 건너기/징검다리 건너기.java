class Solution {
    public int solution(int[] stones, int k) {
        int answer = 1;
        int start = 1;
        int end = 0;
        for(int i = 0; i<stones.length; i++) {
            end = Math.max(end, stones[i]);
        }
        while(start <= end) {
            int mid = (start + end) / 2;
            int limit = 0;
            for(int i = 0; i<stones.length; i++) {
                if(stones[i] - mid <= 0) {
                    limit++;
                }
                else {
                    limit = 0;
                }
                if(limit >= k) break;
            }
            if(limit >= k) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
                answer = mid + 1;
            }
            
            // System.out.println(limit + "         " + answer);
        }
        return answer;
    }
}