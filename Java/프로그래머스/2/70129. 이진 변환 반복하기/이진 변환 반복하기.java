class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0;
        answer[0]++;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1') cnt++;
            else answer[1]++;
        }
        while(cnt > 1) {
            int temp = cnt;
            cnt = 0;
            while(temp >= 1) {
                if(temp % 2 == 1) {
                    cnt++;
                }
                else {
                    answer[1]++;
                }
                temp = temp / 2;
            }
            answer[0]++;
        }
        return answer;
    }
    
}