import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int[][] board = new int[100][100];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            fill_square(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        System.out.println(get_area());
        br.close();
    }

    public static void fill_square(int x, int y){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(board[x+i][y+j]==0){
                    board[x+i][y+j]=1;
                }
            }
        }
    }

    public static int get_area(){
        int sum=0;
        for(int i=0; i<100; i++)
            for(int j=0; j<100; j++)
                if(board[i][j]==1)
                    sum++;
        return sum;
    }
}