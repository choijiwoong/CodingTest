import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void selection_sort(int[] arr, int n){
        for(int i=0; i<n; i++){
            //여기 위치한 최소값을 찾을 것이다.
            for(int j=i+1; j<n; j++){
                if(arr[i]>arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        /*
            평균과 중앙값 구하기. 입력 크기는 무조건 5개.
            범위는 100미만의 10의 배수인 자연수 ex 10, 20, ..., 90

            연습용으로 모든 정렬알고리즘을 문제별로 하나씩 사용해보자.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 5;
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        selection_sort(arr, n);

        int sum=0;
        for(int i=0; i<n; i++)
            sum+=arr[i];
        int avg = sum/n;
        int mid = arr[n/2];

        bw.write(String.valueOf(avg));
        bw.newLine();
        bw.write(String.valueOf(mid));
        bw.flush();
        bw.close();
        br.close();
    }
}