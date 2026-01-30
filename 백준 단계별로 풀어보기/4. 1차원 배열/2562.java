import java.lang.System;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int index = 0;
        int LENGTH = 9;
        for(int i=0; i<LENGTH; i++){
            int number = Integer.parseInt(br.readLine());
            if(number > max){
                max = number;
                index = i;
            }
        }
        System.out.println(max+"\n"+(index+1));
        br.close();
    }
}