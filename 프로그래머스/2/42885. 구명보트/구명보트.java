import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int en = people.length - 1;
        int st = 0;
        while(st <= en) {
            if(st == en) {
                answer++;
                break;
            }
            if(people[st] + people[en] <= limit) {
                answer++;
                st++;
                en--;
            }
            else {
                answer++;
                en--;
            }
        }

        return answer;
    }
}