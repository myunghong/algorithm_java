class Solution {
    static int vis1[], vis2[], vis3[], vis4[];
    static int ans;
    static int n1;
    public int solution(int n) {
        n1 = n;
        ans = 0;
        vis1 = new int[n]; // 열 방문여부
        vis2 = new int[2 * n - 1]; // 오른쪽 위 대각 방문여부
        vis3 = new int[2 * n - 1]; // 왼쪽 위 대각 방문여부
        backtracking(0);
        return ans;
    }
    public void backtracking(int idx) { // idx는 행 인덱스
        if(idx == n1){
            ans++;
            return;
        }
        
        for(int i = 0; i<n1; i++){ // i는 열 인덱스
            if(vis1[i] != 0 || vis2[idx + i] != 0 || vis3[i - idx + n1 - 1] != 0) continue;
            
            
            vis1[i] = 1;
            vis2[i + idx] = 1;
            vis3[i - idx + n1 - 1] = 1;
            backtracking(idx+1);
            vis1[i] = 0;
            vis2[i + idx] = 0;
            vis3[i - idx + n1 - 1] = 0;
        }
        
        
        return;
    }
    
}