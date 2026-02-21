import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String message;

        if(a+b+c != 180){
            message = "Error";
        } else if(a==60 && b==60 && c==60){
            message = "Equilateral";
        } else if(a!=b && a!=c && b!=c){
            message = "Scalene";
        } else{
            message = "Isosceles";
        }
        System.out.println(message);
        br.close();
    }
}