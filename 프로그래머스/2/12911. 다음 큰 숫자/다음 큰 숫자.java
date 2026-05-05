class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = 0;
        int goal = n+1;
        while(n > 0) {
            if(n%2 == 1) cnt++;
            n = n/2;
        }
        // System.out.println(cnt);
        while(true){
            int temp = goal++;
            int cnt1 = 0;
            while(temp > 0) {
                if(temp%2 == 1) cnt1++;
                temp = temp / 2;
            }
            if(cnt1 == cnt) {
                answer = goal-1;
                break;
            }
        }
        return answer;
    }
}