import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            n개의 수열이 주어지고, 합이 x면서 순서를 지키는 값 구하기.
            그냥 전부 돌려보며 합 되는 것 찾고 /2하면 순서상관있게되어 ㄱㅊ할듯
        */
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(br.readLine());

        int count=0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(x==arr[i]+arr[j]){
                    count++;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}