import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            n==1, 0
            n==2, 0
            n==3, 1
            n==4, 2+1+(이전값) = 4
            n==5, 3+2+1+(이전값) = 10
            n==6, 4+3+2+1+(이전값) = 20
            n==7, 35
            일단 부분적으로 1부터 n-2까지의 모든 수에 대하여 1부터의 k까지의 합을 구해야한다.
            sigma k=1~n-2 (sigma j=1~k (j))이다.
            모양새로 보아 재귀 외에도 규칙성이 존재할 것 같다.

            수학적으로 검색해보았다.
            sigma 1~n k 은 n(n+1)/2 이고
            sigma 1~n k^2은 n(n+1)(2n+1)/6임을 알면 해결할 수 있다.
            이중시그마이지만, 외존적인 k를 n처럼 상수라고 가정하고 안쪽 시그마를 식으로 표현하면
            k(k+1)/2이다. 이제 이걸 1~n-2까지 시그마를 수행하면 다음과 같이 표현이 가능하다.
            1/2 * sigma k=1~n-2 (k^2) + 1/2 * sigma k=1~n-2 (k)
            이는 위 공식을 대입할 수 있다.
            1/2 * (n-2)(n-1)(2*n-3)/6 + 1/2 * (n-2)(n-1)/2
            = {(n-2)(n-1)(2*n-3)+3*(n-2)(n-1)}/12
            = { (n^2-3n+2)(2*n-3) + 3n^2-9n+6}/12
            = (n^3-3n^2+2n)/6

            예제인 7을 넣어 검증해보자.
            49*7 = 343, 49*3 = 147
            (343-147+14)/6 = (343-133)/6= 210/6 = 35 맞다.
            최고차항 지수(차수)는 3이니 코드로 구현하자. 수행횟수기에 자연수가 나와야 하니 Long을 사용하겠다.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Long num = Long.parseLong(br.readLine());
        bw.write(String.valueOf((num*num*num-3*num*num+2*num)/6));
        bw.newLine();
        bw.write("3");
        bw.flush();
        bw.close();
        br.close();
    }
}