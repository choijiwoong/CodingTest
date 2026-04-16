import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        /*
            작성하던게 날라가서 빠르게 실행.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0)
                break;
            int count=0;
            for(int i=n+1; i<=2*n; i++)
                if(is_prime(i))
                    count++;
            bw.write(String.valueOf(count));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean is_prime(int num){
        if(num<2)
            return false;
        if(num==2 || num==3)
            return true;

        boolean result = true;
        for(int i=2; i*i<=num && result==true; i++)
            if(num%i==0)
                result=false;
        return result;
    }
}