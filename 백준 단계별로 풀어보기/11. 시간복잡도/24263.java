import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            i=1~n까지의 합을 계산하는 함수이다.
            O(n)의 시간복잡도를 갖는다.
            입력만큼 수행하고, 최고차항 차수는 O(n)이기에 1이 될 것 같다.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(br.readLine());
        bw.newLine();
        bw.write("1");
        bw.flush();
        br.close();
        bw.close();
    }
}