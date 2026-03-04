import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            n^3회 실행된다.
            최고차항은 지수를 의미했고 3으로 고정.

            틀렸는데 범위 고려를 또 안했다. 상습법이다.
            Long으로 바꿔도 틀렸다.

            n은 500,000이 될 수 있고
            n^3은 125,000,000,000,000,000이다. 12경이다.
            922경까지 java Long이 담을 수 있다는데 뭐가 문제일까?

            문제를 다시 잘 읽어보자. 아.. 무생각없이 두번째 출력을 num으로 했었구나 3인데.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Long num = Long.parseLong(br.readLine());
        bw.write(String.valueOf(num*num*num));
        bw.newLine();
        bw.write(String.valueOf(3));
        bw.flush();
        bw.close();
        br.close();
    }
}