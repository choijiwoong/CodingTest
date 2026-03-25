import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void bubble_sort(int[] arr, int n){
        //전달 인자가 포인터기에 반환없이 변환.
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        /*
            입력 개수 N, 오름차순 정렬. ~1000<=x<=+1000
            기본적 정렬 bubble sort 구현, java Arrays.sort() 이용
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr); // 사용 시 120 ms
        // bubble_sort(arr, n); // 사용 시 124ms
        for(int i=0; i<n; i++){
            bw.write(String.valueOf(arr[i]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}