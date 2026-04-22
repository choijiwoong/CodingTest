import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int[] arr = new int[40];
    public static int count_rec=0, count_dp=0;

    public static int fib_rec(int n){
        if(n==1 || n==2){
            count_rec++;
            return 1;
        }

        return fib_rec(n-1)+fib_rec(n-2);
    }


    public static int fib_dp(int n){
        arr[0]=arr[1]=1;
        for(int i=2; i<n; i++){
            arr[i]=arr[i-2]+arr[i-1];
            count_dp++;
        }
        return arr[n-1];
    }

    public static void main(String[] args) throws IOException{
        /*
            피보나치의 경우 재귀보다 DP가 빠르다. 프로그래밍의 꽃 DP 입문 문제.
            문제는 피보나치를 재귀로 실행했을 때의 수행 횟수, DP 수행횟수를 구하는 것이다.
            문제에서 아예 알고리즘을 보여준다. 우선 이해가 선행되어야 하니 자바로 구현해보자.
            로직은 쉽다. DP는 누적합처럼 전체 과정을 배열에 때려박고, 그값을 이용해 다음 값을 갱신해나가며 최종적으로 마지막에 저장된 값으로 정답을 도출하는 것이다.

            수행횟수를 static 변수로 카운트해보자.

        */
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        fib_rec(n);
        fib_dp(n);
        bw.write(count_rec+" "+count_dp);

        bw.flush();
        bw.close();
        br.close();
    }


}