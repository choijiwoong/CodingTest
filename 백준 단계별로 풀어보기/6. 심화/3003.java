import java.lang.*;
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        int N = 6;
        int[] standard = {1,1,2,2,2,8};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++){
            bw.write(String.valueOf(standard[i]-Integer.parseInt(st.nextToken())));
            bw.write(" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}