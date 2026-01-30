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

        int[] buckets = new int[N];
        for(int i=0; i<N; i++)
            buckets[i] = i+1;
        int temp;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start_index = Integer.parseInt(st.nextToken())-1;
            int end_index = Integer.parseInt(st.nextToken())-1;
            for(int j=0; j<=(end_index-start_index)/2; j++){
                temp = buckets[start_index+j];
                buckets[start_index+j] = buckets[end_index-j];
                buckets[end_index-j] = temp;
            }
        }

        for(int i=0; i<N; i++)
            System.out.print(buckets[i]+" ");
        br.close();
    }
}