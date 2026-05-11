import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> wordset = new HashSet<>();
        char lastword = words[0].charAt(words[0].length() - 1);
        wordset.add(words[0]);
        for(int i = 1; i<words.length; i++){
            char lastword2 = words[i].charAt(0);
            // System.out.println(lastword + " " + lastword2);
            if(wordset.contains(words[i]) || lastword != lastword2) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
                
            } else {
                wordset.add(words[i]);
            }
            lastword = words[i].charAt(words[i].length() - 1);
            
        }

        return answer;
    }
}