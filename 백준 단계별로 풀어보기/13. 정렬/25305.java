import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void insertion_sort(int[] arr, int n){
        // 삽입 정렬은 0~1 즉 에서 i=1로 시작했을 때,
        // 0~i중에서 i가 어디에 들어가야하는지를 삽입하는 정렬이다.
        // i의 값을 일단 변수에 저장 후, while을 돌며 해당 값보다 작은 값이 나오는 순간까지
        // shift를 진행한다. 그 후 발견 시 발견 index+1이 해당 key값이 들어갈 자리이다.
        // 이 때 범위를 조심해야하는데, 삽입정렬이기에 기준 인덱스는 1부터 시작하며
        // 내부 반복문은 그렇기에 i-1부터 0까지 탐색한다.
        // 그러나 내부 반복문의 인덱스가 -1이 되면, 차피 다음 자리가 들어갈 자리이기에 +1하여
        // index 0에 딱 키값이 들어가게 된다.
        for(int i=1; i<n; i++){
            int key = arr[i];// 삽입할 기준 값
            int j= i-1;// 기준 -1부터 시작하여
            while(j>=0 && key<arr[j]){ // 앞의 배열 범위에서 작아지는 값이 나올 때 까지(기준 값이 들어가야 하는 위치-1 탐색)
                arr[j+1]=arr[j];//shift
                j--;
            }
            arr[j+1]=key;//insert
        }
    }

    public static void main(String[] args) throws IOException{
        /*
            N개의 성적 중, k번째 고득점가까지만 상을 받음.
            배열 기준 n-k 인덱스의 성적이 커트라인.
            n은 1000개 이하, k는 n이하, 점수는 10000이하.
            int로 처리 가능

            정렬은 삽입정렬을 사용해보자.
            삽입정렬은 두번째 인덱스부터 시작해서, 앞의 수를 shift하다가 여기다! 하는 곳에 넣는것이다.
            직관적으로 제일 별로인 듯 하다.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        insertion_sort(arr, n);
        System.out.println(arr[n-k]);
        br.close();
        bw.close();
    }
}