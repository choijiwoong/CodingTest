import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static int WIN_SIZE = 8;

    public static int calc_window(int[][] arr, int a, int b){
        // gemini 조언 따라 왼쪽 위 기준이 w일때 b일 때 2값 전부 계산
        int std = arr[a][b];
        int min1=0, min2=0;
        for(int i=0; i<WIN_SIZE; i++){
            for(int j=0; j<WIN_SIZE; j++){
                // case 기준점이 W(1)일 때
                //W: 00 02 04 06 11 13 15 17 20 22
                //B: 01 03 05
                //W는 i와 j 모두 짝수 혹은 홀수.
                if( (i%2==j%2) && arr[a+i][b+j]==0 ){
                    //W기준, W여야하는 위치가 B일 때
                    min1++;
                } else if( (i%2!=j%2) && arr[a+i][b+j]==1 ){
                    //W기준, B여야하는 위치가 W일 때
                    min1++;
                }

                // case 기준점이 B(0)일 때
                // W: 01 03 05
                // B: 00 02 04
                // B는 i와 j 모두 짝수 혹은 홀수
                if( (i%2==j%2) && arr[a+i][b+j]==1 ){
                    //B기준, B여야하는 위치가 W일 때
                    min2++;
                } else if( (i%2!=j%2) && arr[a+i][b+j]==0 ){
                    //B기준, W여야하는 위치가 B일 때
                    min2++;
                }
            }
        }
        return min1>min2?min2:min1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++){
            int j=0;
            for(char c : br.readLine().toCharArray()){
                if(c=='W')
                    arr[i][j]=1;
                else
                    arr[i][j]=0;
                j++;
            }
        }

        int result = 100;
        for(int i=0; i<N-WIN_SIZE+1; i++){
            for(int j=0; j<M-WIN_SIZE+1; j++){
                int min = calc_window(arr, i, j);
                if(min<result)
                    result = min;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}