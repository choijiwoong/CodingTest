import java.lang.System;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());// 바구니 개수
        int M = Integer.parseInt(st.nextToken());// 공 넣는 입력 개수
        int[] array = new int[N];//기본으로 0으로 초기화가 된다
        for(int count = 0; count<M; count++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for(int iter = i-1; iter<=j-1; iter++)//순서는1부터, 인덱스는0부터
                array[iter] = k;
        }
        for(int count = 0; count<N; count++)
            System.out.print(array[count]+" ");
        br.close();
    }
}