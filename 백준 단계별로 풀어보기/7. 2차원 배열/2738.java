import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] sum = new int[N][M];
        for(int repeat=0; repeat<2; repeat++){
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    sum[i][j]+=Integer.parseInt(st.nextToken());
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                bw.write(String.valueOf(sum[i][j]));
                bw.write(" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}