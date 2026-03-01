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
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(input*input));
        bw.newLine();
        if (input!=1)
            bw.write("2");
        else
            bw.write("0");
        bw.flush();
        br.close();
        bw.close();
    }
}