class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int st = 0;
        int en = 0;
        int length = 10000000;
        int sum = 0;
        while(true) {
            if(sum < k) {
                if(en == sequence.length) break;
                sum += sequence[en++];
            }
            else {
                if(sum == k && en - st < length) {
                length = en - st;
                answer[0] = st;
                answer[1] = en - 1;
            }
                sum -= sequence[st++];
            }
            
            // System.out.println("st: " + st + "  en: " + en + "   sum: " + sum);
        }
        
        return answer;
    }
}