import java.lang.System;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = 1000001, max = -1000001;
        for(int i=0; i<length; i++){
            int number = Integer.parseInt(st.nextToken());
            if(number>max)
                max = number;
            if(number<min)
                min = number;
        }
        System.out.println(min+" "+max);
        br.close();
    }
}