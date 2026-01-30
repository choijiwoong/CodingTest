import java.lang.System;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        int index = Integer.parseInt(br.readLine());
        System.out.println(text.charAt(index-1));
        br.close();
    }
}