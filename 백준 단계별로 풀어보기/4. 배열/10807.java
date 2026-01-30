import java.lang.System;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        int[] array = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i=0; i<length; i++){
            int number = Integer.parseInt(st.nextToken());
            if (number == target)
                result++;
        }

        System.out.println(result);
        br.close();
    }
}