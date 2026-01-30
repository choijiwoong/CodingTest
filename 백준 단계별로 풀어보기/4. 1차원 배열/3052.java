import java.lang.System;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException{
        int STD = 42;
        int LENGTH = 10;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] is_summited = new boolean[STD];
        for(int i=0; i<LENGTH; i++){
            int number = Integer.parseInt(br.readLine());
            is_summited[(number-1)%STD]=true;
        }

        int result=0;
        for(int i=0; i<STD; i++)
            if(is_summited[i])
                result++;

        System.out.println(result);
        br.close();
    }
}