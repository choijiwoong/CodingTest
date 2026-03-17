import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void print_board(int[][] board, int N, int M){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int WINDOW_SIZE = 8;
        int min_count = 64;
        int[][] board = new int[N][M];

        for(int i=0; i<N; i++){
            // StringTokenizer는 공백으로 구분된 문자열을 분해한다.
            // 공백이 없는 문자열을 분해하려면 toCharArray()로 직접 접근해야함.
            char[] line = br.readLine().toCharArray();
            for(int j=0; j<line.length; j++){
                board[i][j] = line[j]=='W'?1:0;
            }
        }

        print_board(board, N, M);

        for(int i=0; i<N-WINDOW_SIZE; i++){
            for(int j=0; j<M-WINDOW_SIZE; j++){
                //i,j의 칸을 기준으로 판단 기준으로
                int count = 0;
                int std = board[i][j];
                //일단 아래에서 오류가 발생하는데 0,1 이면 합으로 한번에 계산도 가능할듯?
                for(int ii=0; ii<WINDOW_SIZE; ii++){
                    for(int jj=0; jj<WINDOW_SIZE; jj++){
                        //
                        if(((ii%2==0 && jj%2==0) || (ii%2==1 && jj%2==1)) && board[i+ii][j+jj]!=std){
                            count++;
                        } else if(board[i+ii][j+jj]==std){
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