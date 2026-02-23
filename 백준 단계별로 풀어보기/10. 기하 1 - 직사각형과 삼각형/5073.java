import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String message;
        while(true){
            line = br.readLine();
            if(line.equals("0 0 0"))
                break;
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int max = a>b?(c>a?c:a):(c>b?c:b);
            boolean is_valid = false;
            switch(max){
                case a:
                    if(a==b+c)
                        is_valid = true;
                    break;
                case b:
                    if(b==a+c)
                        is_valid = true;
                    break;
                case c:
                    if(c==a+b)
                        is_valid = true;
                    break;
            }
            if(!is_valid){
                message = "Invalid";
            }else if(a==b && b==c){
                message = "Equilateral";
            } else if(a!=b && a!=c && b!=c){
                message = "Scalene";
            } else{
                message = "Isosceles";
            }
            System.out.println(message);
        }
        br.close();
    }
}