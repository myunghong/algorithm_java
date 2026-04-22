import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        int idx = 0;
        while(st.hasMoreTokens()){
            String str3 = st.nextToken();
            String str1 = str3.substring(0,1);
            String str2 = str3.substring(1,str3.length());
            idx += str3.length();
            str1 = str1.toUpperCase();
            str2 = str2.toLowerCase();
            sb.append(str1).append(str2);
            if(idx < s.length()) {
                while(idx < s.length() && s.charAt(idx) == ' '){
                    sb.append(' ');
                    idx++;
                }
            }
        }
        return sb.toString();
    }
}