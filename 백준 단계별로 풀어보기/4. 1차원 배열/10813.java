import java.lang.System;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] array = new int[N];
        for(int i=0; i<N; i++)
            array[i]=i+1;//실세계 순서는 1부터

        int temp;
        for(int i=0; i<M; i++){//공 바꾸는 순서 입력 인자는 M임!
            st = new StringTokenizer(br.readLine());
            int index1 = Integer.parseInt(st.nextToken())-1;//순서 주의
            int index2 = Integer.parseInt(st.nextToken())-1;
            temp = array[index1];
            array[index1]=array[index2];
            array[index2]=temp;
        }

        for(int i=0; i<N; i++)
            System.out.print(array[i]+" ");
        br.close();
    }
}