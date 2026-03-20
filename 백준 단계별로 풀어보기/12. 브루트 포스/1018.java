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
                if((i*WIN_SIZE+j)%2==0 && arr[a+i][b+j]!=1){
                    min1++;
                } else if((i*WIN_SIZE+j)%2==1 && arr[a+i][b+j]!=0){
                    min1++;
                }

                // case 기준점이 B(0)일 때
                if((i*WIN_SIZE+j)%2==0 && arr[a+i][b+j]!=0){
                    min2++;
                } else if((i*WIN_SIZE+j)%2==1 && arr[a+i][b+j]!=1){
                    min2++;
                }

                // 현재 %2를 이용한 홀짝 로직 잘못됨. 예제입력 보면 B줄바꿈 B임.
            }
        }
        System.out.println(min1 +", "+ min2);
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