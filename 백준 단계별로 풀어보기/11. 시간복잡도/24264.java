import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            O(n^2)
            입력값 제곱.
            차수는 계수가 아니라 지수를 말하는거였나봄

            왜 틀렸나 생각해보니, 만약 n이 1이라면?
            예시의 코드가 의사코드여서 확실친 않지만 1 to n에서 n==1일 때 반복문이 수행되지 않는다면
            n==1이면 수행횟수가 2가 아닌 0이 될 것이다. 해당 부분만 if 로 빼보자.

            차수는 2고정이 맞을 것 같다. 예제출력1 밑에 부연설명으로  알고리즘 수행시간이 n^2에 비례한다고 한다.
            입력은 n이 500,000 즉 50만이다. 첫째줄의 답은 제곱. 그러면 250,000,000,000으로 2500억.
            int범위로 안담긴다. long을 사용해보자.
            long은 +-900경까지 가능하다고 한다.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Long input = Long.parseLong(br.readLine());
        bw.write(String.valueOf(input*input));
        bw.newLine();
        bw.write("2");
        bw.flush();
        br.close();
        bw.close();
    }
}