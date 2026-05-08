class Solution {
    public long solution(long w, long h) {
        long answer = 1;
        long tempgcd = gcd(w,h);
        long tempw = w / tempgcd;
        long temph = h / tempgcd;
        long white = (tempw + temph) - 1;
        answer = w * h - tempgcd * white;
        return answer;
    }
    
    
    long gcd(long a, long b) {
        while(b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}