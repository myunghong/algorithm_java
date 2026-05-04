class Solution {
    public int solution(String s) {
        int answer = 10000;
        for(int i = 1; i<=(s.length()+1) / 2; i++) {
            int temp = s.length();
            for(int j = 0; j<s.length() - i; j += i){
                boolean flag = true;
                int cnt = 1;
                String str = s.substring(j,j+i);
                while(j + i + i <= s.length()){
                    String str1 = s.substring(j + i,j+i + i);
                    // String str1 = "";
                    if(!str.equals(str1)) break;
                    j += i;
                    temp -= i;
                    cnt++;
                    flag = false;
                    // System.out.println("기준문자열: " + str + " 비교문자열: " + str1);
                }
                if(!flag) temp += String.valueOf(cnt).length();
            }
            answer = Math.min(temp, answer);
        }
        return answer;
    }
}

// 이중 반복문. 겉 반복문: 기준이 되는 문자열(자른 문자열)
// 속 반복문: 기준 문자열과 동일한지 확인하는 문자열
// 속 반복문에서 길이를 줄인다. 모든 반복이 끝나면 자르는 길이를 증가시켜서 다시. (삼중 반복)
