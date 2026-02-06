import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] board = new boolean[100][100];
        int total_area = 0;

        while(N-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i=x; i<x+10; i++){
                for(int j=y; j<y+10; j++){
                    if(!board[i][j]){
                        board[i][j]=true;
                        total_area++;
                    }
                }
            }
        }
        System.out.println(total_area);
    }
}