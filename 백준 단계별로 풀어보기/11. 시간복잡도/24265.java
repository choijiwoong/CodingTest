import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static void main(String[] args) throws IOException{
        /*
            i가 1부터 n-1이고 i+1부터 n까지 또 반복문이니
            평균적으로 O(n*n/2). 차수는 지수를 의미했으니 1/2 * n^2에서 2.

            수행횟수
            if n==1, 0
            if n==2, 1
            if n==3, 3
            if n==4, 3 2 1 6
            if n==7, 6+5+4+3+2+1=21
            등차수열 합공식 1~n-1까지 (n-1)*(n)/2

            입력크기 n이 500,000이면 int로 처리하지 못하고 Long에 담아야 한다.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Long n = Long.parseLong(br.readLine());
        Long result = (n-1)*n/2;
        bw.write(String.valueOf(result));
        bw.newLine();
        bw.write("2");
        bw.flush();
        bw.close();
        br.close();
    }
}