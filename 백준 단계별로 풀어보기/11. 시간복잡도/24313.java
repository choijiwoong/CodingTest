import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            이해하기 조금 난해하다.
            예시를 통해 쉽게 이해해보자.
            이해는 안됐지만 예제의 규칙 상 g(n) = n이라고 가정했을 때,
            예시의 로직을 그대로 코드로 구현해보자.

            우선 수가 1~100이기에 int 사용

            나는 빅오 정의에 모든 n>=n0에 대하여 저 조건을 만족해야만 빅오정의를 만족하는 것이기에,
            조건을 어기는 경우를 n0부터 100까지 확인한 후 그 안에 하나라도 어기는게 있으면 false로 분류하겠다.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        int result = 0;

        result=1;
        for(int n=n0; n<=100; n++){
            if(a1*n+a0 > c * n){
                result=0;
                break;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}