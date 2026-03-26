import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void counting_sort(int[] arr, int n){
        int max = arr[0];
        for(int i=1; i<n; i++)
            if (max<arr[i])
                max = arr[i];

        int[] count = new int[max+1];// max값이기에 0~max
        for(int i=0; i<n; i++)
            count[arr[i]]++;

        // 2 0 0 0 3 -> 2 2 2 2 5 식으로 누산하여, i값을 가지는 수가 최종적으로 들어갈 마지막 인덱스를 가리키게 함
        for(int i=1; i<=max; i++)
            count[i]+=count[i-1];

        int[] result = new int[n];
        for(int i=n-1; i>=0; i--){
            int value = arr[i];

            int position = count[value] - 1;

            output[position] = value;

            count[value]--;
        }
        return output;
    }

    public static void main(String[] args) {
        /*
            지난번에 자바의 Arrays.sort()를 제외한 구현했던 quick, merge, heap 정렬이 전부 TLE가 발생했었다.
            문제 하단을 자세히 보니 카운팅 정렬을 사용하라고 힌트가 나와있으니 해당 알고리즘을 공부해보자.

            일반적인 비교 기반 정렬이 아닌, 같은 수는 아예 비교하지 않는 정렬로 중복이 많을 때 효율이 최상이 된다.

        */

    }
}