import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int WINDOW_SIZE = 8;
        int min_count = 64;
        int[][] board = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                //White를 1로 저장
                String s = st.nextToken();
                board[i][j] = s.equals("W")?1:0;
            }
        }

        for(int i=0; i<N-WINDOW_SIZE; i++){
            for(int j=0; j<M-WINDOW_SIZE; j++){
                //i,j의 칸을 기준으로 판단 기준으로
                int count = 0;
                for(int ii=0; ii<WINDOW_SIZE; ii++){
                    for(int jj=0; jj<WINDOW_SIZE; jj++){
                        int std = board[i][j];
                        if(ii%2==0 && board[i+ii][j+jj]!=std){
                            count++;
                        } else if(ii%2!=0 && board[i+ii][j+jj]==std){
                            count++;
                        }
                    }
                }
                if(count<min_count){
                    min_count=count;
                }
            }
        }
        bw.write(String.valueOf(min_count));
        bw.flush();
        bw.close();
        br.close();
    }
}