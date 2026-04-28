class Solution {
    int[] arr;
    int n1;
    int[][] q1;
    int[] ans1;
    int answer;
    public int solution(int n, int[][] q, int[] ans) { // 1부터 n까지의 수 중 오름차순 5개, q는 입력한 정수, ans는 시스템 응답
        arr = new int[n];
        answer = 0;
        q1 = q;
        n1 = n;
        ans1 = ans;
        backtracking(0,1);
        return answer;
    }
    
    public void backtracking(int idx, int num) {
        if(idx == 5){
            if(calc(arr)) answer++;
            return;
        }
        for(int i = num; i<=n1;i++){
            arr[idx] = i;
            backtracking(idx+1,i+1);
        }
    }
    
    public boolean calc(int[] arr) {
        for(int i = 0; i<q1.length; i++){
            int cnt = 0;
            for(int j = 0; j<5; j++){
                
                for(int k = 0; k<5; k++){
                    if(q1[i][j] == arr[k]) cnt++;
                    
                }
            }
            if(cnt != ans1[i]) return false;
        }
        return true;
    }
    
    
}