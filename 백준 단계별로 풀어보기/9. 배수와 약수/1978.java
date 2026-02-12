import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        while(n-- > 0){
            int num = Integer.parseInt(st.nextToken());
            if(num==1)
                continue;
            if(num==2){
                count++;
                continue;
            }
            if(num%2==0)
                continue;

            boolean is_prime = true;
            for(int i=3; i*i<=num; i++){
                if(num%i==0){
                    is_prime=false;
                    break;
                }
            }
            if(is_prime)
                count++;
        }
        System.out.println(count);
        br.close();
    }
}