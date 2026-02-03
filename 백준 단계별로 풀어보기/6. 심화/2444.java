import java.lang.*;
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){
            bw.write(" ".repeat(N-i));
            bw.write("*".repeat(2*i-1));
            bw.newLine();
        }

        for(int i=N-1; i>=1; i--){
            bw.write(" ".repeat(N-i));
            bw.write("*".repeat(2*i-1));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}