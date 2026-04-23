import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            n개의 수열이 주어지고, 합이 x면서 순서를 지키는 값 구하기.
            그냥 전부 돌려보며 합 되는 것 찾고 /2하면 순서상관있게되어 ㄱㅊ할듯
            TLE발생.

            시도2. gemini
            n이 최대 100,000인 지금 연산 횟수가 100억번에 달하여 TLE가 발생할 수 밖에 없는 구조이다.
            먼저, 순서가 고정되어있다면 정렬 후 접근해도 된다.
            이 때 양 끝에 포인터를 두어 범위를 좁혀나가는 과정에서 L과 R의 포인터가 필요하다.
            합을 키우고자하면 L++을, 합을 줄이고자 하면 R--를, 정답인 경우 다음 탐색을 위해 L++ R--를 수행하면 해결된다.

            혹은 다른 방법으로 set을 넣고 a, x-a의 방문 유무를 확인하며 진행하는 방식도 있다.
        */
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(br.readLine());

        int count=0;
        Arrays.sort(arr);
        int L=0, R=n-1;
        while(L<R){
            int sum = arr[L]+arr[R];
            if(sum==x){
                count++;
                L++;
                R--;
            } else if(sum>x){
                R--;
            } else if(sum<x){
                L++;
            }
        }

        System.out.println(count);
        br.close();
    }
}