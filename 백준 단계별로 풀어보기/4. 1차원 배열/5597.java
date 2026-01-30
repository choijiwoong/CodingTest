import java.lang.System;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int LENGTH = 30;
        int MISSED_COUNT = 2;
        int missed_index1, missed_index2;
        boolean[] is_summited = new boolean[LENGTH];
        for(int i=0; i<LENGTH-MISSED_COUNT; i++){
            int number = Integer.parseInt(br.readLine());
            is_summited[number-1] = true;
        }
        for(int i=0; i<LENGTH; i++){
            if(!is_summited[i])
                System.out.println(i+1);
        }
        br.close();
    }
}