import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            O(n^2)
            입력값 제곱.
            차수는 계수가 아니라 지수를 말하는거였나봄
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(input*input));
        bw.newLine();
        bw.write("2");
        bw.flush();
        br.close();
        bw.close();
    }
}