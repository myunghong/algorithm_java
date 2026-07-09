import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long answer = Integer.MIN_VALUE;
        long[] arr1 = new long[500001];
        long[] arr2 = new long[500001];
        int maxidx1 = 0;
        int minidx1 = 0;
        long maxval1 = sequence[0];
        long minval1 = sequence[0];
        int maxidx2 = 0;
        int minidx2 = 0;
        long maxval2 = sequence[0];
        long minval2 = sequence[0];
        arr1[0] = sequence[0];
        arr2[0] = sequence[0] * -1;
        for(int i = 1; i<sequence.length; i++){
            if(i % 2 == 1) {
                arr1[i] = arr1[i-1] + sequence[i] * -1;
                arr2[i] = arr2[i-1] + sequence[i];
            }
            else {
                arr1[i] = arr1[i-1] + sequence[i];
                arr2[i] = arr2[i-1] + sequence[i] * -1;
            }
            if(maxval1 < arr1[i]) {
                maxval1 = arr1[i];
                maxidx1 = i;
            }
            if(minval1 > arr1[i]) {
                minval1 = arr1[i];
                minidx1 = i;
            }
            if(maxval2 < arr2[i]) {
                maxval2 = arr2[i];
                maxidx2 = i;
            }
            if(minval2 > arr2[i]) {
                minval2 = arr2[i];
                minidx2 = i;
            }
        }
        long temp1 = arr1[maxidx1];
        if(arr1[minidx1] < 0) {
            temp1 -= arr1[minidx1];
        }
        long temp2 = arr2[maxidx2];
        if(arr2[minidx2] < 0) {
            temp2 -= arr2[minidx2];
        }
        answer = Math.max(temp1, temp2);
        // System.out.println(arr1[maxidx1] + " " + arr1[minidx1] + "  ");
        // System.out.println(arr2[maxidx2] + " " + arr2[minidx2] + "  ");
        return answer;
    }
}