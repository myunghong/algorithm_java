import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i<operations.length; i++){
            StringTokenizer st = new StringTokenizer(operations[i]);
            String first = st.nextToken();
            int next = Integer.parseInt(st.nextToken());
            if(first.equals("I")){
                map.put(next, map.getOrDefault(next, 0) + 1);
            }
            else if(first.equals("D") && !map.isEmpty()){
                if(next == 1){
                    Map.Entry<Integer, Integer> temp = map.lastEntry();
                    if(temp.getValue() == 1) map.remove(temp.getKey());
                    else map.put(temp.getKey(), temp.getValue() - 1);
                }
                else {
                    Map.Entry<Integer, Integer> temp = map.firstEntry();
                    if(temp.getValue() == 1) map.remove(temp.getKey());
                    else map.put(temp.getKey(), temp.getValue() - 1);
                }
                   
            }
        }
        if(!map.isEmpty() && !map.isEmpty()) {
            answer[0] = map.lastKey();
            answer[1] = map.firstKey();
        }
        // System.out.printf("%d, %d", PQ1.peek(), PQ2.peek());
        return answer;
    }
}