class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int level = 0;
        int st = 1;
        int en = 100000;
        while(st <= en){
            long time = 0l;
            level = (st + en) / 2;
            time += times[0];
            for(int i = 1; i<diffs.length; i++){
                int timeprev = times[i-1];
                int timecur = times[i];
                if(level >= diffs[i]) {
                    time += timecur;
                } else {
                    time += (timecur + timeprev) * (diffs[i] - level);
                    time += timecur;
                }
                if(time > limit) break;
            }
            if(time <= limit) {
                answer = level;
                en = level - 1;
            } else {
                st = level + 1;
            }
        }
        return answer;
    }
}